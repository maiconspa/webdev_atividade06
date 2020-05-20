package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Pais;
import service.PaisService;

/**
 * @author maicon
 */
@WebServlet("/Listar_paises.do")
public class ListarPaisesControler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		String chave = request.getParameter("chave");
		String acao = request.getParameter("acao");
		PaisService ps = new PaisService();
		
		ArrayList<Pais> lista = null;
		
		switch(acao) {
		
		case "buscar":
			if (chave != null && chave.length() > 0)
				lista = ps.listarPaises(chave);
			else
				lista = ps.listarPaises();
			session.setAttribute("lista", lista);
		break;
		
		case "reiniciar":
			session.setAttribute("lista", null);
		break;
		}
		
		if (acao.equals("buscar")) {
			if (chave != null && chave.length() > 0) {
				lista = ps.listarPaises(chave);
			} else {
				lista = ps.listarPaises();
			}
			session.setAttribute("lista", lista);
		} else if (acao.equals("reiniciar")) {
			session.setAttribute("lista", null);
		}

		request.getRequestDispatcher("ListarPaises.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
