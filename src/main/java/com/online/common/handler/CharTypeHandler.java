package com.online.common.handler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.apache.log4j.Logger;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: liyuanliu
 * Date: 13-11-25
 * Time: 下午3:40
 * To change this template use File | Settings | File Templates.
 */
public class CharTypeHandler implements TypeHandler{
    private Logger logger = Logger.getLogger(CharTypeHandler.class);
    @Override
    public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        String charType = null;
        try{
            charType = ((Integer)parameter).toString();
        }catch (ClassCastException e){
             logger.error("Type Convert Error:",e);
            throw new SQLException("Type Convert Error", e);
        }
        ps.setString(i, charType);
    }

    @Override
    public Object getResult(ResultSet rs, String columnName) throws SQLException {
        Integer resultInt = null;
        try{
           String resultChar = rs.getString(columnName);
            resultInt = Integer.parseInt(resultChar);
        }catch (ClassCastException e){
            logger.error("Get result from ResultSet error:",e);
            throw new SQLException("Get result from ResultSet error",e);
        }
        return resultInt;
    }

    @Override
    public Object getResult(ResultSet rs, int columnIndex) throws SQLException {
        Integer resultInt = null;
        try{
            String resultChar = rs.getString(columnIndex);
            resultInt = Integer.parseInt(resultChar);
        }catch (ClassCastException e){
            logger.error("Get result from ResultSet error:",e);
            throw new SQLException("Get result from ResultSet error",e);
        }
        return resultInt;
    }

    @Override
    public Object getResult(CallableStatement cs, int columnIndex) throws SQLException {
        Integer resultInt = null;
        try{
            String resultChar = cs.getString(columnIndex);
            resultInt = Integer.parseInt(resultChar);
        }catch (ClassCastException e){
            logger.error("Get result from CallableStatement error:",e);
            throw new SQLException("Get result from CallableStatement error",e);
        }
        return resultInt;
    }
}
