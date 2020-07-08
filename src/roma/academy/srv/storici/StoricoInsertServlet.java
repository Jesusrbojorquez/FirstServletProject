package roma.academy.srv.storici;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import roma.academy.dao.ImpiegatoDao;
import roma.academy.dao.StoricoDao;
import roma.academy.model.Storico;

/**
 * Servlet implementation class StoricoInsertServlet
 */
@WebServlet("/StoricoInsertServlet")
public class StoricoInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoricoInsertServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StoricoDao sDao = new StoricoDao();
		Storico storico = new Storico();
		storico.setIdImpiegato(Integer.parseInt(request.getParameter("idimpiegato")));
		storico.setIdRuolo(Integer.parseInt(request.getParameter("idruolo")));
		storico.setMatricola(Integer.parseInt(request.getParameter("matricola")));
		storico.setDataInizio(Date.valueOf(request.getParameter("datainizio")));//"yyyy-[m]m-[d]d". The leading zero for mm and dd may also be omitted.
		storico.setDataFine(Date.valueOf(request.getParameter("datafine")));
		try {
			sDao.insert(storico);
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
