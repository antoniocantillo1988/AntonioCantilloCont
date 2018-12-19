<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


	<form:form class="form-signin" modelAttribute="alquilar" method="POST" action="../guardarAlquilar">
		
		<form:hidden path="idalquilar"/>
		<form:hidden path="idusuario"/>
		
		<label for="contenedor.idcontenedor" class="sr-only" ><spring:message code="contenedor.tamanyo" var="labContenedor.idcontenedor"/></label>
		<form:select path="contenedor.idcontenedor" items="${lista}" itemLabel="tamanyo" itemValue="idcontenedor" 
		class="form-control" placeholder="${labContenedor.idcontenedor}"/>
		<form:errors path="contenedor.idcontenedor" cssClass="error" />
		
		<label for="duracion" class="sr-only"><spring:message code="alquilar.duracion" var="labDuracion"/></label>
		<form:input path="duracion" class="form-control" placeholder="${labDuracion}"/>
		<form:errors path="duracion" cssClass="error" />
				
		<label for="precio" class="sr-only"><spring:message code="alquilar.precio" var="labPrecio"/></label>
		<form:input path="precio" class="form-control" placeholder="${labPrecio}"/>
		<form:errors path="precio" cssClass="error" />
		
		<input type="submit" class="btn btn-lg btn-primary btn-block" value="<spring:message code="accion.guardar"/>"/>
		<form:errors path="*" cssClass="error" element="div" />
	</form:form>