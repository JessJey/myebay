package it.prova.myebay.web.servlet.annuncio;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.myebay.model.Annuncio;
import it.prova.myebay.service.MyServiceFactory;

@WebServlet("/user/PrepareInsertAnnuncioServlet")
public class PrepareInsertAnnuncioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PrepareInsertAnnuncioServlet() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("insert_annuncio_attr", new Annuncio());
		 	request.setAttribute("categoria_list_attribute",
					MyServiceFactory.getCategoriaServiceInstance().listAll());
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("home").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/annuncio/insertAnnuncio.jsp").forward(request, response);
	}

}
