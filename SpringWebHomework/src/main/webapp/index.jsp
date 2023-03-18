<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>DanilaBET</title>
</head>
<body>

<h1>Add pair</h1>

<form action="/index" method="post">
    Horse name: <input type="text" name="horseName"><br/>
    Rider name: <input type="text" name="riderName"><br/>
    <input type="submit" value="Saved">
</form>

Available pairs: ${pairs} <br/>

Your balance: ${balance} <br/>

<form action="/pairList" method="post">
    Bet: <input type="number" name="bet"><br/>
    Pair: <input type="number" name="pairNumber"><br/>
    <input type="submit" value="Go">
</form>

</body>
</html>
