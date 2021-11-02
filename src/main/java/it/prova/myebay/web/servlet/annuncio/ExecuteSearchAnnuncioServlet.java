package it.prova.myebay.web.servlet.annuncio;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.myebay.model.Annuncio;
import it.prova.myebay.service.MyServiceFactory;
import it.prova.myebay.utility.UtilityForm;

@WebServlet("/ExecuteSearchAnnuncioServlet")
public class ExecuteSearchAnnuncioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteSearchAnnuncioServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String testoAnnuncioParam = request.getParameter("testoAnnuncio");
		String prezzo = request.getParameter("prezzo");
		String[] categoriaInputParam = request.getParameterValues("categoriaInput");

		int prezzoint;

		if (prezzo == "")
			prezzoint = 0;
		else
			prezzoint = Integer.parseInt(prezzo);

		Annuncio example = new Annuncio(testoAnnuncioParam, prezzoint);

		try {
			request.setAttribute("annunci_list_attribute",
					MyServiceFactory.getAnnuncioServiceInstance().findByExampleEager(example, categoriaInputParam));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore nella ricerca.");
			request.getRequestDispatcher("/home").forward(request, response);
			return;
		}
		request.getRequestDispatcher("annuncio/list.jsp").forward(request, response);

	}

}
