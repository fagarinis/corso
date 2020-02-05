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
 * Servlet implementation class ExecuteModificaAbitanteServlet
 */
@WebServlet("/ExecuteModificaAbitanteServlet")
public class ExecuteModificaAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExecuteModificaAbitanteServlet() {
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
		
		//mantengo i parametri di ricerca
		String nomeDaPagina = request.getParameter("nomeInput");
		String cognomeDaPagina = request.getParameter("cognomeInput");
		
		request.setAttribute("nomeInput", nomeDaPagina);
		request.setAttribute("cognomeInput", cognomeDaPagina);
		
		//creo l'oggetto abitante da inserire nel metodo aggiorna del service dai parametri
		//passati da modifica.jsp
		Abitante abitanteAggiornato = new Abitante();
		abitanteAggiornato.setIdAbitante(Long.parseLong(request.getParameter("id")));
		abitanteAggiornato.setNome(request.getParameter("nomeMod"));
		abitanteAggiornato.setCognome(request.getParameter("cognomeMod"));
		abitanteAggiornato.setEta(Integer.parseInt(request.getParameter("etaMod")));
		abitanteAggiornato.setMottoDiVita(request.getParameter("mottodivitaMod"));
		abitanteAggiornato.setCodiceFiscale(request.getParameter("codicefiscaleMod"));
		
		try {
			MyServiceFactory.getAbitanteServiceInstance().aggiorna(abitanteAggiornato);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//rigenera la lista aggiornata per result.jsp
		List<Abitante> listaAbitantiRisultatoRicerca = MyServiceFactory.getAbitanteServiceInstance().cercaPerNomeECognome(nomeDaPagina, cognomeDaPagina);
		request.setAttribute("listAbitantiAttributeName", listaAbitantiRisultatoRicerca);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("results.jsp");
		rd.forward(request, response);
	}

}
