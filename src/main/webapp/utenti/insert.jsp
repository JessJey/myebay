<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="it" class="h-100">
<head>

<!-- Common imports in pages -->
<jsp:include page="../header.jsp" />

<title>Inserisci Nuovo Utente</title>
</head>
<body class="d-flex flex-column h-100">

	<!-- Fixed navbar -->
	<jsp:include page="../navbar.jsp"></jsp:include>


	<!-- Begin page content -->
	<main class="flex-shrink-0">
		<div class="container">

			<div
				class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none':'' }"
				role="alert">
				${errorMessage}
				<button type="button" class="btn-close" data-bs-dismiss="alert"
					aria-label="Close"></button>
			</div>
			<div class="alert alert-danger alert-dismissible fade show d-none"
				role="alert">
				Esempio di operazione fallita!
				<button type="button" class="btn-close" data-bs-dismiss="alert"
					aria-label="Close"></button>
			</div>
			<div class="alert alert-info alert-dismissible fade show d-none"
				role="alert">
				Aggiungere d-none nelle class per non far apparire
				<button type="button" class="btn-close" data-bs-dismiss="alert"
					aria-label="Close"></button>
			</div>

			<div class='card'>
				<div class='card-header'>
					<h5>Inserisci nuovo utente</h5>
				</div>
				<div class='card-body'>

					<h6 class="card-title">
						I campi con <span class="text-danger">*</span> sono obbligatori
					</h6>


				
							<form method="post" action="${pageContext.request.contextPath}/admin/ExecuteInsertUtentiServlet" class="row g-3" >
							
							
								<div class="col-md-6">
									<label>Nome <span class="text-danger">*</span></label>
									<input type="text" name="nome" id="nome" class="form-control" placeholder="Inserire il nome" value="${insert_utente_attr.nome}" >
								</div>
								
								<div class="col-md-6">
									<label>Cognome <span class="text-danger">*</span></label>
									<input type="text" name="cognome" id="cognome" class="form-control" placeholder="Inserire il cognome" value="${insert_utente_attr.cognome }" >
								</div>
							
								<div class="col-md-6">
									<label>Username <span class="text-danger">*</span></label>
									<input type="text" class="form-control" name="username" id="username" placeholder="Inserire l'username" value="${insert_utente_attr.username }" >
								</div>
								
								<div class="col-md-6">
									<label>Password <span class="text-danger">*</span></label>
									<input type="password" class="form-control" name="password" id="password" placeholder="Inserire la password" value="${insert_utente_attr.password }" >
								</div>
								
								<div class="col-md-6">
									<label>Conferma Password <span class="text-danger">*</span></label>
									<input type="password" class="form-control" name="confermapassword" id="confermapassword" placeholder="Conferma la password" value="${insert_utente_attr.password }" >
								</div>
								
								<div class="col-md-6">
									<label>Credito <span class="text-danger">*</span></label>
									<input type="text" class="form-control" name="creditoResiduo" id="creditoResiduo" placeholder="Inserire il credito" value="${insert_utente_attr.creditoResiduo }" >
								</div>



						<div class="col-12">
							<button type="submit" name="submit" value="submit" id="submit"
								class="btn btn-primary">Conferma</button>
						</div>

					</form>



					<!-- end card-body -->
				</div>
				<!-- end card -->
			</div>


			<!-- end container -->
		</div>

	</main>

	<!-- Footer -->
	<jsp:include page="../footer.jsp" />
</body>
</html>