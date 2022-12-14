<%@ page import="java.util.ArrayList" %>
<%@ page import="utils.Result" %>
<%@ page import="beans.ClientData" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% ArrayList<Result> data;
    if(getServletContext().getAttribute("data")!=null){
        data = (ArrayList<Result>)getServletContext().getAttribute("data");
    } else {data = new ArrayList<>();}
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Lab Work #1</title>
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
    <table class='resultTable' border="1" width="100%">
        <thead>
        <tr>
            <th class="coords-column">X</th>
            <th class="coords-column">Y</th>
            <th class="coords-column">R</th>
            <th class="time-column">Current time</th>
            <th class="time-column">Execution time</th>
            <th>Hit fact</th>
        </tr>
        </thead>
        <tbody>
            <c:if test="${data!=null}">
                <c:forEach items="${data}" var="result">
                    <tr>
                        <td>${result.getX()}</td>
                        <td>${result.getY()}</td>
                        <td>${result.getR()}</td>
                        <td>${result.getCurrentTime()}</td>
                        <td>${result.getExecutionTime()}</td>
                        <td>${result.getHitFact()}</td>
                    </tr>
                </c:forEach>
            </c:if>
        </tbody>
    </table>
    <a href="index.jsp">вернуться назад</a>
    </body>
</html>