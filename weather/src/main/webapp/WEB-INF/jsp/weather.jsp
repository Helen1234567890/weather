<%--
  Created by IntelliJ IDEA.
  User: 15104
  Date: 2021/7/28
  Time: 9:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>weather</title>

</head>
<body>
    <div>
        <label style="width: 140px;">City</label>
        <div style = "float:left">
                <select id="city" onchange="cityChange()" >
                    <c:forEach var="a" varStatus="i" items="${citylist}">
                        <option id="${i}" value="${a.city}">${a.city}</option>
                    </c:forEach>
                </select>
        </div>
        <div id = "cityWeather"></div>
    </div>
    <script >
    function cityChange() {

        var city = document.getElementById("city").value;;
        alert(city)
        $.ajax({
            url:'/weather',
            type:'get',
            async:false,
            contentType:'application/json;charset=UTF-8',
            data:"city=" + encodeURI(encodeURI(city)),
            dataType:'html',
            success:function (data) {
                alert(data)
                $("#cityWeather").html(data);
            }
        })
    }


    </script>
    <script type="text/javascript" src="webjars/jquery/jquery.js"></script>
</body>

</html>
