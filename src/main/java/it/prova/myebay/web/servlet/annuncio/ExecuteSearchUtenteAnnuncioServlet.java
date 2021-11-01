package it.prova.myebay.web.servlet.annuncio;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.myebay.model.Annuncio;
import it.prova.myebay.model.Utente;
import it.prova.myebay.service.MyServiceFactory;

@WebServlet("/user/ExecuteSearchUtenteAnnuncioServlet")
public class ExecuteSearchUtenteAnnuncioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ExecuteSearchUtenteAnnuncioServlet() {
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String testoAnnuncioParam = request.getParameter("testoAnnuncio");
		String prezzoParam = request.getParameter("prezzo");
		String[] categoriaInputParam = request.getParameterValues("categoriaInput");
		
		
		try {
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			Utente utenteSession = (Utente)httpRequest.getSession().getAttribute("userInfo");
			Annuncio example = new Annuncio( testoAnnuncioParam, Integer.parseInt(prezzoParam), utenteSession);
			
			
			request.setAttribute("annunci_list_attribute",
					MyServiceFactory.getAnnuncioServiceInstance().findByExampleEager(example));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/annuncio/searchutente.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/annuncio/listutente.jsp").forward(request, response);
	}


}
