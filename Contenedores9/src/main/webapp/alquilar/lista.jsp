<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

	<table class="table table-bordered">
		<thead class="thead-dark">
			<tr>
				<th><spring:message code="alquilar.id"/></th>
				<th><spring:message code="usuario.id"/></th>
				<th><spring:message code="contenedor.idcontenedor"/></th>
				<th><spring:message code="alquilar.fechaalquiler"/></th>
				<th><spring:message code="alquilar.duracion"/></th>
				<th><spring:message code="alquilar.precio"/></th>
				
				<c:if test="${sessionUser.privilegios.idprivilegios==3}">
					<th><spring:message code="accion.modificar"/></th>
					<th><spring:message code="accion.eliminar"/></th>
				</c:if>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${lista}" var="item">
				<tr>
					<td>${item.idalquilar}</td>
					<td>${item.idusuarios}</td>
					<td>${item.idcontenedor}</td>
					<td>${item.fechaalquiler}</td>
					<td>${item.duracion}</td>
					<td>${item.precio}</td>
					
					<c:if test="${sessionUser.privilegios.idprivilegios==3}">
						<td><a href="../alquilar/buscar?idalquilar=${item.idalquilar}"><img src="../images/editar.jpg" height="24"></a>
						<td><a href="../alquilar/borrar?idalquilar=${item.idalquilar}" onclick="return confirm('<spring:message code="accion.confirmar" />')"><img src="../images/borrar.jpg" height="24"></a></td>			
					</c:if>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	${msg}
	<c:if test="${sessionUser.privilegios.idprivilegios==3}">
		<a href="/guardarAlquilar"><spring:message code="alquilar.nuevo" /></a>
	</c:if>
