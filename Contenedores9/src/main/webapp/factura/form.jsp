<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


	<form:form class="form-signin" modelAttribute="factura" method="POST" action="../guardarFactura">
		
		<form:hidden path="idusuarios"/>
		<form:hidden path="idalquilar"/>
		
		<%-- TO DO
		<label class="sr-only"><%= new java.util.Date().getMonth() %></label> --%>
		
		<%-- <label for="pagado" class="sr-only" ><spring:message code="factura.pagado" var="labPagado"/></label> --%>
		<%-- <form:select path="contenedor.id" items="${lista}" itemLabel="tamanyo" itemValue="idcontenedor" 
		class="form-control" placeholder="${labContenedor.id}"/>
		<form:errors path="contenedor.id" cssClass="error" /> --%>
		
		<label for="pagado" class="sr-only" ><spring:message code="factura.pagado" var="labPagado"/></label>
		<select id="dropdown">
  			<option value="0"><spring:message code="factura.NoPagado" var="labPagado"/></option>
  			<option value="1" selected><spring:message code="factura.pagado" var="labPagado"/></option>
		</select>
		
		<input type="submit" class="btn btn-lg btn-primary btn-block" value="<spring:message code="accion.guardar"/>"/>
		<form:errors path="*" cssClass="error" element="div" />
	</form:form>