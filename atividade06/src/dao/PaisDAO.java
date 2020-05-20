package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Pais;

public class PaisDAO {
	Pais pais = new Pais();

	// Criar
	public void criar(Pais pais) {
		String sqlInsert = "INSERT INTO pais (nome, populacao, area) VALUES (?, ?, ?)";
		
		try (Connection c = ConnectionFactory.obtemConexao();
				PreparedStatement stm = c.prepareStatement(sqlInsert);) {
			stm.setString(1, pais.getNome());
			stm.setLong(2, pais.getPopulacao());
			stm.setDouble(3, pais.getArea());
			stm.execute();
			System.out.println("deu certo criar");
		} catch (SQLException e) {
			System.out.println("problema criar");
			e.printStackTrace();
		}
	}

	// Atualizar
	public int atualizar(Pais pais) {
		String sqlUpdate = "UPDATE pais SET nome=?, populacao=?, area=? WHERE id=?";
		try (Connection c = ConnectionFactory.obtemConexao();
				PreparedStatement stm = c.prepareStatement(sqlUpdate);) {
			stm.setString(1, pais.getNome());
			stm.setLong(2, pais.getPopulacao());
			stm.setDouble(3, pais.getArea());
			stm.setInt(4, pais.getId());
			stm.execute();
			
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = c.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					pais.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pais.getId();
	}

	public void deletar(int id) {
		String sqlDelete = "DELETE FROM pais WHERE id='" +id +"'";
		try (Connection c = ConnectionFactory.obtemConexao();
				PreparedStatement stm = c.prepareStatement(sqlDelete);) {
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//Carregar
	public Pais carregarUltimo() {
		String sqlSelect = "SELECT id, nome, populacao, area FROM pais WHERE id = (SELECT id FROM pais order by id desc limit 1)";
		try (Connection c = ConnectionFactory.obtemConexao(); 
				PreparedStatement stm = c.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					pais.setId(rs.getInt("id"));
					pais.setNome(rs.getString("nome"));
					pais.setPopulacao(rs.getLong("populacao"));
					pais.setArea(rs.getDouble("area"));
					
					System.out.println("DAO:" +pais.toString());
					
					return pais;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return pais;
	}
	
	//Carregar
	public Pais carregar(int id) {
		String sqlSelect = "SELECT nome, populacao, area FROM pais WHERE id = ?";
		try (Connection c = ConnectionFactory.obtemConexao(); 
				PreparedStatement stm = c.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					pais.setNome(rs.getString("nome"));
					pais.setPopulacao(rs.getLong("populacao"));
					pais.setArea(rs.getDouble("area"));
					
					System.out.println("DAO:" +pais.toString());
					
					return pais;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return pais;
	}

	public ArrayList<Pais> listarPaises() {
		ArrayList<Pais> lista = new ArrayList<>();
		String sqlSelect = "SELECT id, nome, populacao, area FROM pais";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					Pais p = new Pais();
					p.setId(rs.getInt("id"));
					p.setNome(rs.getString("nome"));
					p.setPopulacao(rs.getLong("populacao"));
					p.setArea(rs.getDouble("area"));
					lista.add(p);
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} catch (SQLException ex) {
			System.out.print(ex.getStackTrace());
		}
		return lista;
	}

	public ArrayList<Pais> listarPaises(String chave) {
		ArrayList<Pais> lista = new ArrayList<>();
		String sqlSelect = "SELECT id, nome, populacao, area FROM pais WHERE upper(nome) like ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			
			stm.setString(1, "%" + chave.toUpperCase() + "%");
			
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					Pais p = new Pais();
					p.setId(rs.getInt("id"));
					p.setNome(rs.getString("nome"));
					p.setPopulacao(rs.getLong("populacao"));
					p.setArea(rs.getDouble("area"));
					lista.add(p);
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} catch (SQLException ex) {
			System.out.print(ex.getStackTrace());
		}
		return lista;
	}
	
}
