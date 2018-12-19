<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


	<form:form class="form-signin" modelAttribute="contenedor" method="POST" action="../contenedor/registrar">
		
		<label for="tamanyo" class="sr-only"><spring:message code="contenedor.tamanyo" var="labTamanyo"/></label>
		<form:input path="tamanyo" class="form-control" placeholder="${labTamanyo}"/>
		<form:errors path="tamanyo" cssClass="error" />
				
		<label for="disponibilidad" class="sr-only"><spring:message code="contenedor.disponibilidad" var="labDisponibilidad"/></label>
		<form:input path="disponibilidad" class="form-control" placeholder="${labDisponibilidad}"/>
		<form:errors path="disponibilidad" cssClass="error" />
		
		<input type="submit" class="btn btn-lg btn-primary btn-block" value="<spring:message code="accion.guardar"/>"/>
		<form:errors path="*" cssClass="error" element="div" />
	</form:form>
