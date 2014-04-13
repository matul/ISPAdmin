<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <c:set var="req" value="${pageContext.request}" />
        <c:set var="http_base" value="${req.scheme}://${req.serverName}:${req.serverPort}${req.contextPath}/"/>
        <base href="${pageContext.request.secure ? fn:replace(http_base, ':443/', '/') : fn:replace(http_base, ':80/', '/')}"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link href="resources/media/siteAdmin.css" rel="stylesheet" type="text/css" /> 
        <link href="resources/media/images.css" rel="stylesheet" type="text/css" />
        <title>Přihlášení</title>
    </head>
    <body id="login">
        <div class="all">        
            <div class="loginheader">          
                <div class="logindiv">            
                    <div class="in">