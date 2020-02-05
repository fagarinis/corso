package it.helloabitante.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.helloabitante.model.Abitante;
import it.helloabitante.service.MyServiceFactory;

/**
 * Servlet implementation class ExecuteInsertAbitanteServlet
 */
@WebServlet("/ExecuteInsertAbitanteServlet")
public class ExecuteInsertAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExecuteInsertAbitanteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// mantengo i parametri di ricerca
		String nomeDaPagina = request.getParameter("nomeInput");
		String cognomeDaPagina = request.getParameter("cognomeInput");

		request.setAttribute("nomeInput", nomeDaPagina);
		request.setAttribute("cognomeInput", cognomeDaPagina);

		
		// creo l'oggetto abitante da inserire nel metodo inserisci del service dai
		// parametri
		// passati da modifica.jsp
		Abitante abitanteInsert = new Abitante();
		abitanteInsert.setNome(request.getParameter("nomeIns"));
		abitanteInsert.setCognome(request.getParameter("cognomeIns"));
		abitanteInsert.setEta(Integer.parseInt(request.getParameter("etaIns")));
		abitanteInsert.setMottoDiVita(request.getParameter("mottodivitaIns"));
		abitanteInsert.setCodiceFiscale(request.getParameter("codicefiscaleIns"));

		try {
			MyServiceFactory.getAbitanteServiceInstance().inserisciNuovo(abitanteInsert);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// rigenera la lista aggiornata per result.jsp
		List<Abitante> listaAbitantiRisultatoRicerca = MyServiceFactory.getAbitanteServiceInstance()
				.cercaPerNomeECognome(nomeDaPagina, cognomeDaPagina);
		request.setAttribute("listAbitantiAttributeName", listaAbitantiRisultatoRicerca);

		RequestDispatcher rd = request.getRequestDispatcher("results.jsp");
		rd.forward(request, response);
	}

}
