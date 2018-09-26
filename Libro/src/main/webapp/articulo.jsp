<!-- Cabecera -->
<%@ include file="include/header.jsp" %>

<!-- Navbar -->
<%@ include file="include/navbar.jsp" %>

<main class="container" role="main">
	
	<div class="row align-center">
        <div class="col color-primary">
			<!-- Gestión de alertas -->
			<%@include file="include/alert.jsp" %>
		</div>
	</div>
	
	<div class="row align-center">
        <div class="col color-primary">
			<!-- Formulario de Acceso -->
			<%@ include file="include/modal-login-form.jsp" %>
		</div>
	</div>
	
	<div class="row align-center m-2">
        <div class="col">
            <div class="articulo-header text-center">
                <h1><u>${pagActual.titulo}</u></h1>
                <h2><i>${pagActual.autor }</i></h2>
            </div>
            <div class="articulo-body text-center">
                <p align="justify">${pagActual.contenido }</p>
            </div>
        </div>
    </div>
    
    <div class="row align-center m-2">
    	<div class="col">
	        <nav class="col articulo-nav text-center">
	        	<a href="leer?op=prev&id=${pagActual.id}" class="previous">&#8249;</a>
				<a href="leer?op=next&id=${pagActual.id}" class="next round">&#8250;</a>
	        </nav>  
        </div>
     </div>
    
</main>

<!-- Pie de Página -->
<div class="row align-center fixed-bottom">
	<div class="col-md-12 color-primary">
		<%@ include file="include/footer.jsp" %>
	</div>
</div>