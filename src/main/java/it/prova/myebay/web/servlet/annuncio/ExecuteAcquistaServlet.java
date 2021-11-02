package it.prova.myebay.web.servlet.annuncio;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.myebay.exception.CreditoIns;
import it.prova.myebay.exception.ElementNotFoundException;
import it.prova.myebay.model.Utente;
import it.prova.myebay.service.MyServiceFactory;

/**
 * Servlet implementation class ExecuteAcquistaServlet
 */
@WebServlet("/user/ExecuteAcquistaServlet")
public class ExecuteAcquistaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExecuteAcquistaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idParam = request.getParameter("idAnnuncio");
		
		if (!NumberUtils.isCreatable(idParam)) {
			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore. (id)");
			request.getRequestDispatcher("/home").forward(request, response);
			return;
		}
			try {
				HttpServletRequest httpRequest = (HttpServletRequest) request;
				
				MyServiceFactory.getAnnuncioServiceInstance().acquista(idParam, (Utente)httpRequest.getSession().getAttribute("userInfo"));				
				
			} catch (ElementNotFoundException e) {
				request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
				request.getRequestDispatcher("/home").forward(request, response);
				return;
			}catch (CreditoIns e) {
				request.setAttribute("errorMessage", "Attenzione, il tuo credito è insufficiente.");
				request.getRequestDispatcher("/annuncio/acquista.jsp").forward(request, response);
				return;
			} catch (Exception e) {
				// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
				e.printStackTrace();
				request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
				request.getRequestDispatcher("/home").forward(request, response);
				return;
			}

			response.sendRedirect("ExecuteListAcquistoServlet?operationResult=SUCCESS");
		}

}
