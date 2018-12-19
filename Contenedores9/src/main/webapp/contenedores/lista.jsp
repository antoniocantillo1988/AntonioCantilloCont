<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

	<table class="table table-bordered">
		<thead class="thead-dark">
			<tr>
				<th><spring:message code="contenedor.id"/></th>
				<th><spring:message code="contenedor.tamanyo"/></th>
				<th><spring:message code="contenedor.disponibilidad"/></th>
				
				<c:if test="${sessionUser.privilegios.idprivilegios==3}">
					<th><spring:message code="accion.modificar"/></th>
					<th><spring:message code="accion.eliminar"/></th>
				</c:if>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${lista}" var="item">
				<tr>
					<td>${item.idcontenedor}</td>
					<td>${item.tamanyo}</td>
					<td>${item.disponibilidad}</td>
					
					<c:if test="${sessionUser.privilegios.idprivilegios==3}">
						<td><a href="../contenedor/buscar?idcontenedor=${item.idcontenedor}"><img src="../images/editar.jpg" height="24"></a>
						<td><a href="../contenedor/borrar?idcontenedor=${item.idcontenedor}" onclick="return confirm('<spring:message code="accion.confirmar" />')"><img src="../images/borrar.jpg" height="24"></a></td>			
					</c:if>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	${msg}
	<c:if test="${sessionUser.privilegios.idprivilegios==3}">
		<a href="../contenedor/guardarContenedor"><spring:message code="accion.nuevo.contenedor" /></a>
	</c:if>
