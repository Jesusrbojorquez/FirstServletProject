package roma.academy.srv.storici;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import roma.academy.dao.StoricoDao;
import roma.academy.model.Storico;

/**
 * Servlet implementation class StoricoUpdateServlet
 */
@WebServlet("/StoricoUpdateServlet")
public class StoricoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoricoUpdateServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StoricoDao sDao = new StoricoDao();
		Storico storico = new Storico();
		storico.setId(Integer.parseInt(request.getParameter("id")));
		storico.setIdImpiegato(Integer.parseInt(request.getParameter("idimpiegato")));
		storico.setIdRuolo(Integer.parseInt(request.getParameter("idruolo")));
		storico.setMatricola(Integer.parseInt(request.getParameter("matricola")));
		storico.setDataInizio(Date.valueOf(request.getParameter("datainizio")));
		storico.setDataFine(Date.valueOf(request.getParameter("datafine")));
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			sDao.update(storico);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
