<!doctype html>
<html lang="it" class="h-100" >
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
	 <head>
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="./header.jsp" />
		<!-- Custom styles per le features di bootstrap 'Columns with icons' -->
	   <link href="./assets/css/features.css" rel="stylesheet">
	   
	   <title>Raccolta Film</title>
	 </head>
	   <body class="d-flex flex-column h-100">
	   		
	   		<!-- #####################################  -->
	   		<!-- elementi grafici per le features in basso  -->
	   		<!-- #####################################  -->
	   		<svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
			  <symbol id="people-circle" viewBox="0 0 16 16">
			    <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
			    <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
			  </symbol>
			  <symbol id="collection" viewBox="0 0 16 16">
			    <path d="M2.5 3.5a.5.5 0 0 1 0-1h11a.5.5 0 0 1 0 1h-11zm2-2a.5.5 0 0 1 0-1h7a.5.5 0 0 1 0 1h-7zM0 13a1.5 1.5 0 0 0 1.5 1.5h13A1.5 1.5 0 0 0 16 13V6a1.5 1.5 0 0 0-1.5-1.5h-13A1.5 1.5 0 0 0 0 6v7zm1.5.5A.5.5 0 0 1 1 13V6a.5.5 0 0 1 .5-.5h13a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-.5.5h-13z"/>
			  </symbol>
			  <symbol id="toggles2" viewBox="0 0 16 16">
			    <path d="M9.465 10H12a2 2 0 1 1 0 4H9.465c.34-.588.535-1.271.535-2 0-.729-.195-1.412-.535-2z"/>
			    <path d="M6 15a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm0 1a4 4 0 1 1 0-8 4 4 0 0 1 0 8zm.535-10a3.975 3.975 0 0 1-.409-1H4a1 1 0 0 1 0-2h2.126c.091-.355.23-.69.41-1H4a2 2 0 1 0 0 4h2.535z"/>
			    <path d="M14 4a4 4 0 1 1-8 0 4 4 0 0 1 8 0z"/>
			  </symbol>
			  <symbol id="chevron-right" viewBox="0 0 16 16">
			    <path fill-rule="evenodd" d="M4.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L10.293 8 4.646 2.354a.5.5 0 0 1 0-.708z"/>
			  </symbol>
			</svg>
			<!-- ############## end ###################  -->
	   
	   
	   
	   		<!-- Fixed navbar -->
	   		<jsp:include page="./navbar.jsp"></jsp:include>
	    
			
			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">
			  
			  	<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none':'' }" role="alert">
				  ${errorMessage}
				  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
				</div>
				
				<div class="alert alert-danger alert-dismissible fade show ${messaggio==null?'d-none':'' }" role="alert">
				  ${messaggio}
				  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
				</div>
			  </div>
			  <div class="p-5 mb-4 bg-light rounded-3">
				      <div class="container-fluid py-5">
				       
				        <div class='card'>
				    <div class='card-header'>
				        <h7 class="display-5 fw-bold">Ricerca Annunci</h7>
				        </div>
				        
				         <div class='card-body'>
						<form method="post" action="${pageContext.request.contextPath}/ExecuteSearchAnnuncioServlet" class="row g-3">

							<div class="col-md-6 ">
								<label>Cerca per Testo:</label> <input type="text"
									name="testoAnnuncio" id="testoAnnuncio"
									class="form-control custom-form-box"
									placeholder="Inserire testo"
									value="${annuncio_attr.testoAnnuncio }">

							</div>
							<hr class="custom-line-index">
							<div class="col-md-6 ">
								<label>Ricerca per prezzo</label> <input type="number"
									class="form-control custom-form-box" name="prezzo" value="0" id="prezzo"
									placeholder="Inserire il prezzo minimo">
							</div>
							<div class="col-md-6">
							<label> Categorie</label>
							<br>
								<c:forEach items="${categoria_list_attribute }"
									var="categoriaItem">
									<label> <input type="checkbox" name="categoriaInput" class="form-check-input"
										value="${categoriaItem.id}"> ${categoriaItem.descrizione}
									</label>
									<br>
								</c:forEach>
							</div>
							<div class="col-12">
							<div class="col-12">
								<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>
								<input class="btn btn-outline-warning" type="reset" value="Ripulisci">
							</div>
									</div>	
									</form>
							</div>
							</div>
				      </div>
			    </div>
			  </div>
						
			  <!--  features di bootstrap 'Columns with icons'  -->
			  <div class="container px-4 py-5" id="featured-3">
			    <div class="row g-4 py-5 row-cols-1 row-cols-lg-3">
			    
			    <div class="feature col">
			        <div class="feature-icon bg-primary bg-gradient">
			          <svg class="bi" width="1em" height="1em"><use xlink:href="#collection"/></svg>
			        </div>
			         
			        <h2>Visualizza Acquisti effettuati</h2>
			        <p>Paragraph of text beneath the heading to explain the heading. We'll add onto it with another sentence and probably just keep going until we run out of words.</p>
			        <c:if test="${userInfo.isAdmin() || userInfo.isUser() }">
			        <a href="${pageContext.request.contextPath}/user/PrepareSearchAcquistoServlet" class="icon-link">
			          Vai alla funzionalità
			          <svg class="bi" width="1em" height="1em"><use xlink:href="#chevron-right"/></svg>
			        </a>
			          </c:if>
			      </div>
			      
			      <div class="feature col">
			        <div class="feature-icon bg-primary bg-gradient">
			          <svg class="bi" width="1em" height="1em"><use xlink:href="#people-circle"/></svg>
			        </div>
			         
			        <h2>Gestione Annunci</h2>
			        <p>Paragraph of text beneath the heading to explain the heading. We'll add onto it with another sentence and probably just keep going until we run out of words.</p>
			        <c:if test="${userInfo.isAdmin() || userInfo.isUser() }">
			        <a href="${pageContext.request.contextPath}/user/PrepareSearchUtenteAnnuncioServlet" class="icon-link">
			          Vai alla funzionalità
			          <svg class="bi" width="1em" height="1em"><use xlink:href="#chevron-right"/></svg>
			        </a>
			          </c:if>
			      </div>
			      
			       <div class="feature col">
			        <div class="feature-icon bg-primary bg-gradient">
			          <svg class="bi" width="1em" height="1em"><use xlink:href="#toggles2"/></svg>
			        </div>
			         
			        <h2>Gestione Utenti</h2>
			        <p>Paragraph of text beneath the heading to explain the heading. We'll add onto it with another sentence and probably just keep going until we run out of words.</p>
			        <c:if test="${userInfo.isAdmin() }">
			        <a href="${pageContext.request.contextPath}/admin/PrepareSearchUtentiServlet" class="icon-link">
			          Vai alla funzionalità
			          <svg class="bi" width="1em" height="1em"><use xlink:href="#chevron-right"/></svg>
			        </a>
			          </c:if>
			      </div>
			      
			    
			    </div>
			  </div>
			  
			</main>
			
			<!-- Footer -->
			<jsp:include page="./footer.jsp" />
	  </body>
</html>