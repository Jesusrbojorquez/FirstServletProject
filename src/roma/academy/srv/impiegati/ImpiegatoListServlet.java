package roma.academy.srv.impiegati;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import roma.academy.dao.ImpiegatoDao;

/**
 * Servlet implementation class ImpiegatoListServlet
 */
@WebServlet("/ImpiegatoListServlet")
public class ImpiegatoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ImpiegatoDao impiegatoDao = new ImpiegatoDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImpiegatoListServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = "ciao";
		request.getSession().setAttribute("miaVar", msg);
		request.getSession().setAttribute("myListImpiegato", impiegatoDao.getList() );
 		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/impiegato/impiegato-list.jsp");
 		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
