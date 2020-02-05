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
 * Servlet implementation class PrepareCancellaAbitanteServlet
 */
@WebServlet("/PrepareCancellaAbitanteServlet")
public class PrepareCancellaAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrepareCancellaAbitanteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parametroIdDellAbitanteDaCancellare = request.getParameter("idDaInviareComeParametro");
		
		Abitante abitanteDaPresentarePerCancella = null;
		try {
			abitanteDaPresentarePerCancella = MyServiceFactory.getAbitanteServiceInstance().caricaSingolo(Long.parseLong(parametroIdDellAbitanteDaCancellare));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("abitantepreparatoperlacancellazione", abitanteDaPresentarePerCancella);
		request.setAttribute("nomeInput", request.getParameter("nomeInput"));
		request.setAttribute("cognomeInput", request.getParameter("cognomeInput"));
		
		RequestDispatcher rd = request.getRequestDispatcher("cancella.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
