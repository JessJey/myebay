package it.prova.myebay.web.servlet.annuncio;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.myebay.model.Annuncio;
import it.prova.myebay.model.Utente;
import it.prova.myebay.service.MyServiceFactory;
import it.prova.myebay.utility.UtilityForm;

@WebServlet("/user/ExecuteInsertAnnuncioServlet")
public class ExecuteInsertAnnuncioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;

		String testoAnnuncioParam = request.getParameter("testoAnnuncio");
		String prezzoParam = request.getParameter("prezzo");
		String[] idCategorieParam = request.getParameterValues("categoriaInput");

		try {

			Annuncio annuncioInstance = new Annuncio(testoAnnuncioParam, Integer.parseInt(prezzoParam), new Date(),
					true, (Utente) httpRequest.getSession().getAttribute("userInfo"));
			
			if (!UtilityForm.validateAnnuncioBean(annuncioInstance)) {
				request.setAttribute("insert_annuncio_attr", annuncioInstance);

				request.setAttribute("categoria_list_attribute",
						MyServiceFactory.getCategoriaServiceInstance().listAll());
				request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
				request.getRequestDispatcher("/annuncio/insertAnnuncio.jsp").forward(request, response);
				return;
			}

			MyServiceFactory.getAnnuncioServiceInstance().inserisciAnnuncioConCategoria(annuncioInstance,
					idCategorieParam);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/annuncio/insertAnnuncio.jsp").forward(request, response);
			return;
		}

		// andiamo ai risultati
		// uso il sendRedirect con parametro per evitare il problema del double save on
		// refresh
		response.sendRedirect("ExecuteListAnnuncioServlet?operationResult=SUCCESS");

	}

}