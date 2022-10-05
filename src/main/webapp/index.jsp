<%@ page import="java.util.ArrayList" %>
<%@ page import="utils.Result" %>
<%@ page import="beans.ClientData" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% ClientData data;
    if(getServletContext().getAttribute("data")!=null){
        data = (ClientData)getServletContext().getAttribute("data");
    } else {data = new ClientData();}
%>
<% ArrayList<Result> results = data.getData();%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lab Work #2</title>
    <link href="css/style.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script defer src="js/validation.js"></script>
    <script defer src="js/script.js"></script>

</head>
<body>
    <script>
        const POINTS = [
            <% for (Result result : results) { %>
            {
                x: <%= result.getX() %>,
                y: <%= result.getY() %>,
                r: <%= result.getR() %>
            },
            <%
                }
            %>
        ]
    </script>
    <table class="main-panel-table" cellpadding="0" cellspacing="0" height="100%" width="100%" border="0">
        <tr  style="background-image: url(img/bg2.gif);background-repeat: no-repeat; background-position: top center;background-size: 100% 100%;">
            <td>
                <table border="0" cellpadding="0" cellspacing="0" height="100%" width="100%">
                    <tr>
                        <td colspan="4">
                            <header>
                                <h2 class="headText">Кириллов Андрей</h2>
                                <h3 class="headText">Группа P32311 | Вариант 3453</h3>
                            </header>
                        </td>
                    </tr>
                    <main>
                        <tr>
                            <td class="sidePanel" width="20%" rowspan="2"></td>
                            <td>
                                <table class="forms" border="0">
                                    <form id="form"  method="POST" action="controller">
                                        <tr>
                                            <td colspan="2">
                                                <div class="taskText">
                                                    Введите данные на проверку вхождения в область значений данного графика:
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <!-- X panel -->
                                            <td width="50%">
                                                <div class="taskRect">
                                                    <h3 class="letter">X:</h3>
                                                    <select name="x" id="xValue" class="selectField">
                                                        <option value="-4">-4</option>
                                                        <option value="-3">-3</option>
                                                        <option value="-2">-2</option>
                                                        <option value="-1">-1</option>
                                                        <option id="defaultX" value="0">0</option>
                                                        <option value="1">1</option>
                                                        <option value="2">2</option>
                                                        <option value="3">3</option>
                                                        <option value="4">4</option>
                                                    </select>
                                                </div>
                                            </td>
                                            <!-- R panel -->
                                            <td>
                                                <div class="taskRect">
                                                    <h3 class="letter">R:</h3>
                                                    <select name="r" id="rValue" class="selectField">
                                                        <option value="1">1</option>
                                                        <option value="2">2</option>
                                                        <option value="3">3</option>
                                                        <option value="4">4</option>
                                                        <option value="5">5</option>
                                                    </select>
                                                </div>
                                            </td>
                                        </tr>
                                        <!-- Y panel -->
                                        <tr>
                                            <td colspan="2" style="text-align: center;">
                                                <div class="YtaskRect">
                                                    <!-- <span class="Y-letter">Y</span> -->
                                                    <h3 for="y" class="letter">Введите Y:</h3>
                                                    <input autocomplete="off" class="inputY" id="y" maxlength="8" name="y"
                                                        placeholder="Введите число от -3 до 3"
                                                        style="border: 2px solid #d0d1c7; text-align: center;  position: relative;"
                                                        title="Введите число" type="text">
                                                </div>
                                            </td>
                                        </tr>
                                        <!-- Submit  -->
                                        <tr>
                                            <td colspan="2" style="text-align: center;">
                                                <input id="submitButton" disabled="true" type="submit">
                                            </td>
                                        </tr>
                                    </form>
                                </table>
                            </td>
                            <td class="sidePanel" width="20%" rowspan="2"></td>
                        </tr>
                        <!-- Canvas and sexy tyanka -->
                        <tr>
                            <td>
                                <div class="imgTyanPanel">
                                    <canvas id="graph" width="300" height="300"></canvas>
                                    <script src="js/graph.js"></script>
                                    <img class="tyanImg" src="img/mainGirl.webp" onmouseover="this.src = 'img/girlOnMouseMove.webp'" onmouseout="this.src = 'img/mainGirl.webp'" alt="tyan" width="300" height="300" align="right">
                                </div>
                            </td>
                        </tr>
                    </main>
                </table>
            </td>
        </tr>
            <tr>
                <td colspan="3">
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
                            <c:forEach items="${data.getData()}" var="result">
                                <tr>
                                    <td>${result.getX()}</td>
                                    <td>${result.getY()}</td>
                                    <td>${result.getR()}</td>
                                    <td>${result.getCurrentTime()}</td>
                                    <td>${result.getExecutionTime()}</td>
                                    <td>${result.getHitFact()}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </td>
            </tr>
    </table>
</body>
</html>