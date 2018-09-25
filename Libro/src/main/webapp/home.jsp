<!-- Cabecera -->
<%@ include file="/include/header.jsp" %>

<!-- Navegador -->
<%@ include file="/include/navbar.jsp" %>

<main class="container mt-5" role="main">
	
	<!-- Gestión de alertas -->
	<c:if test="${alert != null }">
		<div class="row align-center">
	        <div class="col color-primary">
				<%@include file="include/alert.jsp" %>
			</div>
		</div>
	</c:if>
	
	<!-- Formulario de Acceso -->
	 <c:if test="${empty sessionScope.usuario}">
		<div class="row align-center">
	        <div class="col color-primary">
				<%@ include file="include/modal-login-form.jsp" %>
			</div>
		</div>
	</c:if>	
	
	<div class="row align-center">
		<div class="col color-primary">
		<c:forEach items="${paginas}" var="pagina">
			<div class="cardBox">
				<div class="card">
			    	<div class="front">
				        <h2>${pagina.titulo}</h2>
				        <p>Hover to flip</p>
				        <strong>&#x21bb;</strong>
			      	</div>
			      
				   	<div class="back">
				        <h3>${pagina.autor}</h3>
				        <p align="justify">${pagina.contenidoCorto}</p>
				        <a href="leer?id=${pagina.id}">Leer más</a>
					</div>
					
	    		</div> <!-- /.card -->
	  		</div>	<!-- /.card-box -->
	 	</c:forEach>
		
		</div>	<!-- /.col -->
	</div>	<!-- /.row -->
	
</main>

<!-- Pie de Página -->
<div class="row align-center fixed-bottom">
	<div class="col">
		
		
	</div>
</div>