package com.online.auth.service.impl;

import com.online.auth.service.IMainService;
import com.online.common.Constant;
import com.online.common.exception.AppException;
import com.online.common.exception.SysException;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: liyuanliu
 * Date: 13-12-5
 * Time: 下午1:58
 * To change this template use File | Settings | File Templates.
 */
@Service(value="mainService")
public class MainServiceImpl implements IMainService{

    private static Logger logger = Logger.getLogger(MainServiceImpl.class);

    @Override
    public Map<String, Object> getCurrentWeather(String areaCode) throws AppException, SysException {
        Map<String,Object> resultMap = null;
        String remoteUri = Constant.GOOGLE_WEATHER_URI+areaCode+",cn";
        Map<String,Object> callbackMap = this.callRemoteService(remoteUri);
        Integer status = (Integer)callbackMap.get("status");
        if(status == 0){
            String remoteStr = (String)callbackMap.get("responseMsg");
            if(remoteStr != null && !"".equals(remoteStr)){
              resultMap = this.parseRemoteResp(remoteStr);
            }
        }

        return resultMap;
    }

    private Map<String, Object> parseRemoteResp(String remoteMsg){
        Map<String,Object> resultMap = new HashMap<String, Object>();
        try{
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES,true);
            Map<String,Object> parsedMap = mapper.readValue(remoteMsg,new TypeReference<Map<String,Object>>(){});
            if(!parsedMap.isEmpty()){
                Map<String,Object> sysMap = (LinkedHashMap<String,Object>)parsedMap.get("sys");
                if(!sysMap.isEmpty()){
                    resultMap.put("sunrise",sysMap.get("sunrise"));
                    resultMap.put("sunset",sysMap.get("sunset"));
                }
                List<LinkedHashMap<String,Object>> weatherList = (List<LinkedHashMap<String,Object>>)parsedMap.get("weather");
                if(weatherList != null && weatherList.size() >0){
                    Map<String,Object> weatherMap = weatherList.get(0);
                    if(!weatherMap.isEmpty()){
                        resultMap.put("main_weather",weatherMap.get("main"));
                        resultMap.put("weather_desc",weatherMap.get("description"));
                    }
                }
                Map<String,Object> mainMap = (LinkedHashMap<String,Object>)parsedMap.get("main");
                if(!mainMap.isEmpty()){
                    resultMap.put("current_temp",mainMap.get("temp"));
                    resultMap.put("min_temp",mainMap.get("temp_min"));
                    resultMap.put("max_temp",mainMap.get("temp_max"));
                    resultMap.put("pressure",mainMap.get("pressure"));
                }
                Map<String,Object> windMap = (LinkedHashMap<String,Object>)parsedMap.get("wind");
                if(!windMap.isEmpty()){
                    resultMap.put("wind_speed",windMap.get("speed"));
                }
            }
        }catch(JsonMappingException mapping){
            logger.error("json映射到map转换异常",mapping);
        }catch(JsonParseException parse){
            logger.error("json解析异常",parse);
        }catch(IOException io){
            logger.error("IO异常",io);
        }
        return resultMap;
    }

    private Map<String,Object> callRemoteService(String uri) {
        logger.info("调用远程服务启动...");
        logger.info("远程服务地址:"+uri);
        if(uri == null || "".equals(uri))
            return null;
        Map<String, Object> responseMap = new HashMap<String, Object>(2);
        HttpClient httpClient = null;
        PostMethod postMethod = null;
        try{
            httpClient = new HttpClient(new HttpClientParams(),new SimpleHttpConnectionManager());
            postMethod = new PostMethod(uri);
            postMethod.setRequestHeader("Content-Type","text/html;charset=UTF-8");
            postMethod.getParams().setContentCharset("utf-8");
            httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(30*1000);
            httpClient.executeMethod(postMethod);

            String responseBody = postMethod.getResponseBodyAsString();
            logger.info("远程服务返回参数为："+ responseBody);
            responseMap.put("status",new Integer(0));
            responseMap.put("responseMsg",responseBody);
        }catch (IOException e){
             logger.error("调用远程服务异常终止",e);
            responseMap.put("status",new Integer(30000));
            responseMap.put("responseMsg","error:"+e.getMessage());
        }finally {
            postMethod.releaseConnection();
        }
        return responseMap;
    }

    public static void main(String[] args){
        MainServiceImpl service = new MainServiceImpl();
        try{
            Map<String,Object> map = service.getCurrentWeather("Beijing");
            if(!map.isEmpty()){
                Set<String> keySet = map.keySet();
                Iterator<String> keyIt = keySet.iterator();
                while(keyIt.hasNext()) {
                    String key = keyIt.next();
                    System.out.println("key:"+key+",value:"+map.get(key));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
