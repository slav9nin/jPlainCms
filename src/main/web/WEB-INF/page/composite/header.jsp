<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/static/bootstrap/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/static/bootstrap/css/bootstrap-theme.min.css"/>">
    <script src="<c:url value="/static/bootstrap/js/bootstrap.min.js"/>"></script>
    <title><c:out value="${requestScope.title}"/></title>
</head>
<body id="">
