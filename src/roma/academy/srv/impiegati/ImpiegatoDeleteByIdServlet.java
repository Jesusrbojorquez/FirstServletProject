package roma.academy.srv.impiegati;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import roma.academy.dao.ImpiegatoDao;



/**
 * Servlet implementation class ImpiegatoDeleteServlet
 */
@WebServlet("/ImpiegatoDeleteByIdServlet")
public class ImpiegatoDeleteByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImpiegatoDeleteByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ImpiegatoDao impDao = new ImpiegatoDao();
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		try {
			impDao.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("miaVar", "delete-success");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/impiegato/impiegato-list.jsp");
 		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
