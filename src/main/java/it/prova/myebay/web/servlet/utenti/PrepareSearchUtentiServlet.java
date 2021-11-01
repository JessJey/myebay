package it.prova.myebay.web.servlet.utenti;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/PrepareSearchUtentiServlet")
public class PrepareSearchUtentiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PrepareSearchUtentiServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/utenti/search.jsp").forward(request, response);
	}
}
