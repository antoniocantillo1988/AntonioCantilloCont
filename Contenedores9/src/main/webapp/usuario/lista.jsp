<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

	<table class="table table-bordered">
		<thead class="thead-dark">
			<tr>
				<th><spring:message code="usuario.id"/></th>
				<th><spring:message code="usuario.dni"/></th>
				<th><spring:message code="usuario.nombre"/></th>
				<th><spring:message code="usuario.apellidos"/></th>
				<th><spring:message code="usuario.fechaalta"/></th>
				<th><spring:message code="usuario.direccion"/></th>
				<th><spring:message code="usuario.telefono"/></th>
				<th><spring:message code="usuario.correoelectronico"/></th>
				<th><spring:message code="usuario.contrasenya"/></th>
				
				
				<c:choose>
					<c:when test="${sessionUser.privilegios.idprivilegios==3}">
						<th><spring:message code="accion.modificar"/></th>
						<th><spring:message code="accion.eliminar"/></th>
						
						<th><spring:message code="accion.crear.alquilar"/></th>
						<th><spring:message code="accion.crear.factura"/></th>
					</c:when>
					<c:when test="${sessionUser.privilegios.idprivilegios==2}">
						<th><spring:message code="accion.crear.alquilar"/></th>
						<th><spring:message code="accion.crear.factura"/></th>
					</c:when>
					<c:otherwise>		
								
					</c:otherwise>
				</c:choose>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${lista}" var="item">
				<tr>
					<td>${item.idusuarios}</td>
					<td>${item.dni}</td>
					<td>${item.nombre}</td>
					<td>${item.apellidos}</td>
					<td>${item.fechaalta}</td>
					<td>${item.direccion}</td>
					<td>${item.telefono}</td>
					<td>${item.correoelectronico}</td>
					<td>${item.contrasenya}</td>		
			
					
					<c:choose>
							<c:when test="${item.privilegios.idprivilegios==1}">		
								<td><a href="../usuario/buscar?idusuarios=${item.idusuarios}"><img src="../images/editar.jpg" height="24"></a>
								<td><a href="../usuario/borrar?idusuarios=${item.idusuarios}" onclick="return confirm('<spring:message code="accion.confirmar" />')"><img src="../images/borrar.jpg" height="24"></a></td>										
							
								<td><a href="../alquilar/registrar?idusuarios=${item.idusuarios}"><img src="../images/cart.jpg" height="24"></a></td>
								<td><a href="../factura/registrar?idusuarios=${item.idusuarios}"><img src="../images/cart.jpg" height="24"></a></td>							
							</c:when>
							
							<c:when test="${item.privilegios.idprivilegios==2}">		
								<td><a href="../usuario/buscar?idusuarios=${item.idusuarios}"><img src="../images/editar.jpg" height="24"></a>
								<td><a href="../usuario/borrar?idusuarios=${item.idusuarios}" onclick="return confirm('<spring:message code="accion.confirmar" />')"><img src="../images/borrar.jpg" height="24"></a></td>										
							</c:when>
						
							<c:otherwise>		
								
							</c:otherwise>
					</c:choose>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	${msg}
	<c:if test="${sessionUser.privilegios.idprivilegios==3}">
		<a href="../usuario/registrar"><spring:message code="accion.nuevo.usuario" /></a>
	</c:if>
