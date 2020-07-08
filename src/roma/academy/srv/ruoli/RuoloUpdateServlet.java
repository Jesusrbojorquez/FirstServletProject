package roma.academy.srv.ruoli;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import roma.academy.dao.RuoloDao;
import roma.academy.model.Ruolo;

/**
 * Servlet implementation class RuoloUpdateServlet
 */
@WebServlet("/RuoloUpdateServlet")
public class RuoloUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RuoloUpdateServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RuoloDao rDao = new RuoloDao();
		Ruolo ruolo = new Ruolo();
		ruolo.setDescrizione(request.getParameter("descrizione"));
		ruolo.setStipendio(Integer.parseInt(request.getParameter("stipendio")));
		ruolo.setId(Integer.parseInt(request.getParameter("id")));
		try {
			rDao.update(ruolo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
