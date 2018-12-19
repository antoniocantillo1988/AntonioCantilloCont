<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

	<form:form class="form-signin" modelAttribute="usuario" method="POST" action="../usuario/login">
		
		<label for="dni" class="sr-only"><spring:message code="usuario.dni" var="labUsuario"/></label>
		<form:input path="dni" class="form-control" placeholder="${labUsuario}"/>
		<form:errors path="dni" cssClass="error" />
		
		<label for="contrasenya" class="sr-only"><spring:message code="usuario.contrasenya" var="labClave"/></label>
		<form:password path="contrasenya" class="form-control" placeholder="${labClave}"/>
		<form:errors path="contrasenya" cssClass="error" />
		
		<input type="submit" class="btn btn-lg btn-primary btn-block" value="<spring:message code="accion.login"/>"/>
		<form:errors path="*" cssClass="error" element="div" />
	</form:form>
	<br>
	${msg}
	<a href="../usuario/registrar"><spring:message code="accion.registrar"/></a>
