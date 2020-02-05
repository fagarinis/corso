package it.helloabitante.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.helloabitante.model.Abitante;
import it.helloabitante.service.MyServiceFactory;

/**
 * Servlet implementation class ExecuteCancellaAbitanteServlet
 */
@WebServlet("/ExecuteCancellaAbitanteServlet")
public class ExecuteCancellaAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExecuteCancellaAbitanteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//ricevo l'id da cancella.jsp
		String idAbitanteDaCancellare = request.getParameter("idabitantedacancellare");
		
		//creo l'abitante da inserire nel cancella()
		Abitante abitanteDaCancellare = new Abitante();
		abitanteDaCancellare.setIdAbitante(Long.parseLong(idAbitanteDaCancellare));
		
		try {
			MyServiceFactory.getAbitanteServiceInstance().cancella(abitanteDaCancellare);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String nomeDaPagina = request.getParameter("nomeInput");
		String cognomeDaPagina = request.getParameter("cognomeInput");
		
		//mantengo i parametri di ricerca iniziali
		request.setAttribute("nomeInput", nomeDaPagina);
		request.setAttribute("cognomeInput", cognomeDaPagina);
		
		//rigenero la lista di ricerca
		request.setAttribute("listAbitantiAttributeName",
				MyServiceFactory.getAbitanteServiceInstance().cercaPerNomeECognome(nomeDaPagina, cognomeDaPagina));
		
		RequestDispatcher rd = request.getRequestDispatcher("results.jsp");
		rd.forward(request, response);
	}

}
