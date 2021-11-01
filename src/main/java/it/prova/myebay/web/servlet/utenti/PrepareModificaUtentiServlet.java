package it.prova.myebay.web.servlet.utenti;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.myebay.service.MyServiceFactory;

@WebServlet("/admin/PrepareModificaUtentiServlet")
public class PrepareModificaUtentiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public PrepareModificaUtentiServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long idUtenteInput = Long.parseLong(request.getParameter("idUtente"));

		try {
			request.setAttribute("update_utente_attr",
					MyServiceFactory.getUtenteServiceInstance().caricaSingoloElemento(idUtenteInput));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("home").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/utenti/update.jsp").forward(request, response);
	}

}
