<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

	<table class="table table-bordered">
		<thead class="thead-dark">
			<tr>
				<th><spring:message code="factura.idfactura"/></th>
				<th><spring:message code="usuario.id"/></th>
				<th><spring:message code="factura.pagado"/></th>
				<th><spring:message code="factura.fechaactual"/></th>
				
				<c:if test="${sessionUser.privilegios.idprivilegios==3}">
					<th><spring:message code="accion.modificar"/></th>
					<th><spring:message code="accion.eliminar"/></th>
				</c:if>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${lista}" var="item">
				<tr>
					<td>${item.idfactura}</td>
					<td>${item.idusuario}</td>
					<td>${item.pagado}</td>
					<td>${item.fechaactual}</td>
					
					<c:if test="${sessionUser.privilegios.idprivilegios==3}">
						<td><a href="../factura/buscar?idfactura=${item.idfactura}"><img src="../images/editar.jpg" height="24"></a>
						<td><a href="../factura/borrar?idfactura=${item.idfactura}" onclick="return confirm('<spring:message code="accion.confirmar" />')"><img src="../images/borrar.jpg" height="24"></a></td>			
					</c:if>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	${msg}
	<c:if test="${sessionUser.privilegios.idprivilegios==3}">
		<a href="/guardarFactura"><spring:message code="factura.nuevo" /></a>
	</c:if>
