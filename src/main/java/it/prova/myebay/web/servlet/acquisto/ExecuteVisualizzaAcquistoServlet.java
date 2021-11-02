package it.prova.myebay.web.servlet.acquisto;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.myebay.model.Acquisto;
import it.prova.myebay.service.MyServiceFactory;

@WebServlet("/user/ExecuteVisualizzaAcquistoServlet")
public class ExecuteVisualizzaAcquistoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ExecuteVisualizzaAcquistoServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idAcquistoParam = request.getParameter("idAcquisto");

		if (!NumberUtils.isCreatable(idAcquistoParam)) {
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/home").forward(request, response);
			return;
		}

		try {
			Acquisto acquistoInstance = MyServiceFactory.getAcquistoServiceInstance()
					.caricaSingoloElemento(Long.parseLong(idAcquistoParam));


			request.setAttribute("show_acquisto_attr", acquistoInstance);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/home").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/acquisto/visualizzaAcquisto.jsp").forward(request, response);
	}


}
