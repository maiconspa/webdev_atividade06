package service;

import model.Pais;
import dao.PaisDAO;


public class PaisService {
	PaisDAO dao = new PaisDAO();
	
	public void criar(Pais pais) {
		dao.criar(pais);
		System.out.println("deu certo a criacao, id = "+pais.getId());
	}
	
	public void atualizar(Pais pais){
		dao.atualizar(pais);
	}
	
	public void excluir(Pais pais){
		dao.deletar(pais);
	}
	
	public Pais carregar(int id){
		return dao.carregar(id);
	}
	
	public Pais carregarUltimo() {
		return dao.carregarUltimo();
	}

}
