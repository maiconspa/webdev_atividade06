package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pais;
import service.PaisService;;

/**
 * 
 * @author maicon
 *
 */
@WebServlet("/ManterPais.do")
public class ManterPaisController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
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
        String nome = request.getParameter("nome");
        long populacao = Integer.parseInt(request.getParameter("populacao"));
        double area = Double.parseDouble(request.getParameter("area"));
        
        Pais pais = new Pais();
        PaisService ps = new PaisService();
        
        
        pais.setId(0);
        pais.setNome(nome);
        pais.setPopulacao(populacao);
        pais.setArea(area);
        
        
        ps.criar(pais);
        
        pais = ps.carregarUltimo();
        
        System.out.println(pais.toString());
        // Definir atributo
        request.setAttribute("pais", pais);
        
        
        // Redirecionar página depois do processamento de dados
        RequestDispatcher view =  request.getRequestDispatcher("Pais.jsp");
        view.forward(request, response);
        
    }
    
}
