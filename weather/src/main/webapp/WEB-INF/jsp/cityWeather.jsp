<%--
  Created by IntelliJ IDEA.
  User: 15104
  Date: 2021/7/28
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cityWeather</title>
</head>
<body>
 <table>
     <tr>
        <td>City</td>
        <td>${city}</td>
      </tr>
      <tr>
          <td>Updated time</td>
          <td>${cityWeather.hours}</td>
      </tr>
      <tr>
          <td>Weather</td>
          <td>${cityWeather.wea}</td>
      </tr>
      <tr>
          <td>Temperature</td>
          <td>${cityWeather.tem}</td>
      </tr>
      <tr>
          <td>Wind</td>
           <td>${cityWeather.win}</td>
       </tr>
      </table>
</body>
</html>
