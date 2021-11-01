package it.prova.myebay.web.servlet.utenti;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.myebay.model.Utente;


@WebServlet("/admin/PrepareInsertUtentiServelt")
public class PrepareInsertUtentiServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public PrepareInsertUtentiServelt() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// metto un bean 'vuoto' in request perché per la pagina risulta necessario
				
				try {
					request.setAttribute("insert_utente_attr", new Utente());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.getRequestDispatcher("/utenti/insert.jsp").forward(request, response);
			}
	}

	
