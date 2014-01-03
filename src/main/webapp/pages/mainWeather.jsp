<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title></title>
</head>
<body>
     <table border="1" draggable="true">
         <tbody draggable="true">
            <tr draggable="true">
               <td>实时温度：</td><td>${temperMap.current_temp}</td>
            </tr>
            <tr draggable="true">
                <td>最低气温：</td><td>${temperMap.min_temp}</td>
            </tr>
            <tr draggable="true">
                <td>最高气温：</td><td>${temperMap.max_temp}</td>
            </tr>
            <tr draggable="true">
                <td>气压：</td><td>${temperMap.pressure}</td>
            </tr>
            <tr draggable="true">
                <td>风速：</td><td>${temperMap.wind_speed}</td>
            </tr>
            <tr draggable="true">
                <td>天气状况：</td><td>${temperMap.main_weather}</td>
            </tr>
            <tr draggable="true">
                <td>天气描述：</td><td>${temperMap.weather_desc}</td>
            </tr>
            <tr draggable="true">
                <td>日出时间：</td><td>${temperMap.sunrise}</td>
            </tr>
            <tr draggable="true">
                <td>日落时间：</td><td>${temperMap.sunset}</td>
            </tr>
         </tbody>

     </table>
</body>
</html>