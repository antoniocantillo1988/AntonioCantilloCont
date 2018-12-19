<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


	<form:form class="form-signin" modelAttribute="usuario" method="POST" action="../usuario/registrar">
				
		<label for="dni" class="sr-only"><spring:message code="usuario.dni" var="labDni"/></label>
		<form:input path="dni" class="form-control" placeholder="${labDni}"/>
		<form:errors path="dni" cssClass="error" />
				
		<label for="nombre" class="sr-only"><spring:message code="usuario.nombre" var="labNombre"/></label>
		<form:input path="nombre" class="form-control" placeholder="${labNombre}"/>
		<form:errors path="nombre" cssClass="error" />
		
		<label for="apellidos" class="sr-only"><spring:message code="usuario.apellidos" var="labApellidos"/></label>
		<form:input path="apellidos" class="form-control" placeholder="${labApellidos}"/>
		<form:errors path="apellidos" cssClass="error" />
		
		<label for="direccion" class="sr-only"><spring:message code="usuario.direccion" var="labDireccion"/></label>
		<form:input path="direccion" class="form-control" placeholder="${labDireccion}"/>
		<form:errors path="direccion" cssClass="error" />
		
		<label for="telefono" class="sr-only"><spring:message code="usuario.telefono" var="labTelefono"/></label>
		<form:password path="telefono" class="form-control" placeholder="${labTelefono}"/>
		<form:errors path="telefono" cssClass="error" />
		
		<label for="correoelectronico" class="sr-only"><spring:message code="usuario.correoelectronico" var="labCorreoelectronico"/></label>
		<form:password path="correoelectronico" class="form-control" placeholder="${labCorreoelectronico}"/>
		<form:errors path="correoelectronico" cssClass="error" />
		
		<label for="contrasenya" class="sr-only"><spring:message code="usuario.contrasenya" var="labContrasenya"/></label>
		<form:password path="contrasenya" class="form-control" placeholder="${labContrasenya}"/>
		<form:errors path="contrasenya" cssClass="error" />
		
		<label for="claveRepetida" class="sr-only"><spring:message code="usuario.claveRepetida" var="labClaveRepetida"/></label>
		<form:password path="claveRepetida" class="form-control" placeholder="${labClaveRepetida}"/>
		<form:errors path="claveRepetida" cssClass="error" />
		
		<input type="submit" class="btn btn-lg btn-primary btn-block" value="<spring:message code="accion.guardar"/>"/>
		<form:errors path="*" cssClass="error" element="div" />
	</form:form>
