<%--
  Created by IntelliJ IDEA.
  User: zzp
  Date: 2017/3/25
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <body onload="getData()"></body>
</html>
<script language="JavaScript">
    function getData() {
        window.open("<c:url value="/ProductServlet"/> ", "get");
    }
</script> 