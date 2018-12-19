<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
	<a class="navbar-brand" href="inicio"><spring:message
			code="app.name" /></a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarsExampleDefault"
		aria-controls="navbarsExampleDefault" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarsExampleDefault">


		<ul class="navbar-nav mr-auto">
			<!-- tabla USUARIOS -->
			<!-- esta opcion solo la era el cliente -->
			<c:if test="${empty sessionUser}">

				<li class="nav-item"><a class="nav-link" href="usuario/login"><spring:message
							code="accion.login" /></a></li>

				<li class="nav-item"><a class="nav-link"
					href="usuario/registrar"><spring:message
							code="accion.registrar" /></a></li>

			</c:if>


			<!-- esta opcion solo la vera el trabajador -->
			<c:if test="${sessionUser.privilegios.idprivilegios==2}">

				<li class="nav-item"><a class="nav-link"
					href="usuario/listarClientes"><spring:message
							code="accion.listar.clientes" /></a></li>

				<li class="nav-item"><a class="nav-link"
					href="usuario/registrar"><spring:message
							code="accion.registrar" /></a></li>

			</c:if>


			<!-- esta opcion solo la vera el administrador -->
			<c:if test="${sessionUser.privilegios.idprivilegios==3}">

				<li class="nav-item"><a class="nav-link"
					href="../usuario/listarUsuarios"><spring:message
							code="accion.listar.usuarios" /></a></li>


			</c:if>

			<!-- tabla alquilar -->
			<!-- esta opciones solo la vera el cliente -->
			<c:if test="${sessionUser.privilegios.idprivilegios==1}">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" id="dropdown01"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><spring:message
							code="accion.menu" /></a>
					<div class="dropdown-menu" aria-labelledby="dropdown01">

						<a class="dropdown-item" href="/listarMiAlquiler"><spring:message
								code="accion.listar.alquilar" /></a> <a class="dropdown-item"
							href="/listarMiFactura"><spring:message
								code="accion.listar.factura" /></a>

					</div></li>
			</c:if>

			<!-- TABLA CONTENEDORES -->
			<!-- esta opcion solo la verá el administrador -->

			<c:if test="${sessionUser.privilegios.idprivilegios==3}">

				<li class="nav-item"><a class="nav-link"
					href="../contenedor/listar"><spring:message
							code="accion.listar.contenedores" /></a></li>
			</c:if>


			<!-- esta opcion la vera todo el mundo -->
			<li class="nav-item"><a class="nav-link"
				href="../contenedor/listarDisponibilidad"><spring:message
						code="accion.listar.contenedorDisponible" /></a></li>

			<c:if test="${not empty sessionUser}">
				<li class="nav-item active"><a class="nav-link"
					href="../usuario/logout"><spring:message code="accion.logout" /></a></li>
			</c:if>
			
				
				<li class="nav-item active" style="text-align:right"><a class="nav-link"
						href="inicio?lang=es"><spring:message code="idioma.es"/></a></li>
			
				<li class="nav-item active" style="text-align:right"><a class="nav-link"
						href="inicio?lang=en"><spring:message code="idioma.en" /></a></li>
				
				
		</ul>
	</div>
</nav>