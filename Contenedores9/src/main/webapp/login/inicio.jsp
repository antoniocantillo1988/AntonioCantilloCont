<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	<c:choose>
		<c:when test="${sessionUser.privilegios.idprivilegios==1}">
			<spring:message code="mensaje.bienvenida.cliente"/>
		</c:when>
		<c:when test="${sessionUser.privilegios.idprivilegios==2}">
			<spring:message code="mensaje.bienvenida.trabajador"/>
		</c:when>
		<c:when test="${sessionUser.privilegios.idprivilegios==3}">
			<spring:message code="mensaje.bienvenida.administrador"/>
		</c:when>
		<c:otherwise>		
			<spring:message code="mensaje.bienvenida"/>
		</c:otherwise>
	</c:choose>
