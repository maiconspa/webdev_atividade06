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
import service.PaisService;;

/**
 * @author maicon
 */
@WebServlet("/ManterPais.do")
public class ManterPaisController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		ArrayList<Pais> lista = new ArrayList<Pais>();
		PaisService ps = new PaisService();
		Pais p = new Pais();
		
        if (request.getParameter("id") != null) {
            int id = Integer.parseInt(request.getParameter("id"));
            p.setId(id);
    	}
        
        if (request.getParameter("populacao") != null) {
            long populacao = Integer.parseInt(request.getParameter("populacao"));
            p.setPopulacao(populacao);
    	}
        
        if (request.getParameter("area") != null) {
        	double area = Double.parseDouble(request.getParameter("area"));
        	p.setArea(area);
    	}
        
        if (sessao.getAttribute("lista") != null) {
        	lista = (ArrayList<Pais>)sessao.getAttribute("lista");
        }
        
        String nome = request.getParameter("nome");
        p.setNome(nome);
        
        String acao = request.getParameter("acao");
        
    	switch(acao) {
    	case "criar":
            ps.criar(p);
            p = ps.carregarUltimo();
            request.setAttribute("pais", p);
            request.getRequestDispatcher("visualizarPais.jsp").forward(request, response);
    	break;
    	
    	case "excluir":
    		ps.excluir(p.getId());
			lista.remove(busca(p, lista));
			sessao.setAttribute("lista", lista);
			request.getRequestDispatcher("listarPaises.jsp").forward(request, response);    		
		break;
    	
    	case "alterar":
    		ps.atualizar(p);
			request.setAttribute("pais", p);
			request.getRequestDispatcher("visualizarPais.jsp").forward(request, response);
		break;
    		
    	case "visualizar":
    		p = ps.carregar(p.getId());
			request.setAttribute("pais", p);
			request.getRequestDispatcher("visualizarPais.jsp").forward(request, response);
		break;
    	
    	case "editar":
    		p = ps.carregar(p.getId());
			request.setAttribute("pais", p);
			request.getRequestDispatcher("alterarPais.jsp").forward(request, response);
    	break;
    	}
    }
    
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    
    
    /**
     * 
     * @param cliente
     * @param lista
     * @return
     */
	public int busca(Pais p, ArrayList<Pais> lista) {
		Pais pl; // pl: pais da lista
		for(int i = 0; i < lista.size(); i++){
			pl = lista.get(i);
			
			if(pl.getId() == p.getId()) return i;
		}
		return -1;
	}
    
}
