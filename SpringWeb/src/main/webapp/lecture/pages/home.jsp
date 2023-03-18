<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title>Car Store</title>
</head>
<body>

<sp:message code="label.title"/> <sp:message code="label.name"/>

<sf:form action="/car" method="post" modelAttribute="car">

    <sf:input path="number"/><br/>
    <sf:input path="password"/><br/>
    <input type="submit" value="Saved">

</sf:form>


<%--${test}--%>

<%--<form action="/car" method="post">--%>
<%--    <input type="text" name="number"> ${err_number}<br/>--%>
<%--    <input type="password" name="password">${err_password}<br/>--%>
<%--    <input type="submit" value="Saved">--%>
<%--</form>--%>
</body>
</html>
