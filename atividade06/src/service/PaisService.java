package service;

import model.Pais;

import java.util.ArrayList;

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
	
	public void excluir(int id){
		dao.deletar(id);
	}
	
	public Pais carregar(int id){
		return dao.carregar(id);
	}
	
	public Pais carregarUltimo() {
		return dao.carregarUltimo();
	}
	
	public ArrayList<Pais> listarPaises(){
		return dao.listarPaises();
	}
	
	public ArrayList<Pais> listarPaises(String chave){
		return dao.listarPaises(chave);
	}

}
