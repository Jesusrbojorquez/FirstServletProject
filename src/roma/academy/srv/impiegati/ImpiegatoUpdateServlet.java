package roma.academy.srv.impiegati;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import roma.academy.dao.ImpiegatoDao;
import roma.academy.model.Impiegato;

/**
 * Servlet implementation class ImpiegatoUpdateServlet
 */
@WebServlet("/ImpiegatoUpdateServlet")
public class ImpiegatoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImpiegatoUpdateServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("begin ImpiegatoUpdateServlet: ");
		System.out.println("RECEIVED PARAMETER: " + request.getParameter("nome"));
		ImpiegatoDao impDao = new ImpiegatoDao();
		Impiegato impiegato = new Impiegato();
		impiegato.setNome(request.getParameter("nome"));
		impiegato.setCognome(request.getParameter("cognome"));
		impiegato.setId(Integer.parseInt(request.getParameter("id")));
		System.out.println(impiegato.toString());
		try {
			impDao.update(impiegato);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getSession().setAttribute("miaVar", "update-success");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/impiegato/impiegato-list.jsp");
 		dispatcher.forward(request,response);
	}

}
