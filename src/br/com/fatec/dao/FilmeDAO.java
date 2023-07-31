package br.com.fatec.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.fatec.dominio.EntidadeDominio;
import br.com.fatec.dominio.Filme;
import br.com.fatec.dominio.Sala;
import br.com.fatec.dominio.Sessao;

import java.sql.Date;


public class FilmeDAO extends AbstractJdbcDAO{
 public FilmeDAO() {
        super("filme", "id_fil");
    }

    public void Inserir(EntidadeDominio entidade) {
        openConnection();
        PreparedStatement pst = null;
        Filme fil = (Filme) entidade;

        try {
            connection.setAutoCommit(false);

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO filme (titulo, estreia, duracao, diretor, elenco, sinopse) VALUES (?, ?, ?, ?, ?, ?)");

            pst = connection.prepareStatement(sql.toString(),Statement.RETURN_GENERATED_KEYS);

            pst.setString(1, fil.getTitulo());
            pst.setString(2, fil.getEstreia());
            pst.setString(3,fil.getDuracao());
            pst.setString(4, fil.getDiretor());
            pst.setString(5, fil.getElenco());
            pst.setString(6, fil.getSinopse());
            
            pst.executeUpdate();
            
            
            ResultSet generatedKeys = pst.getGeneratedKeys();
            if (generatedKeys.next()) {
            	int last_inserted_id = generatedKeys.getInt(1);
                fil.setId(last_inserted_id);
            }
            
            connection.commit();
            
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
            	e1.printStackTrace();
            }
        } finally {
            try {
                pst.close();
                connection.close();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
        }

    }

    public void Alterar(EntidadeDominio entidade) {
        openConnection();
        PreparedStatement pst = null;
        Filme fil = (Filme) entidade;

        try {
            connection.setAutoCommit(false);

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE filme SET titulo=?, estreia=?, duracao=?, diretor=?, elenco=?, sinopse=?");
            sql.append("WHERE id_filme=?");

            pst = connection.prepareStatement(sql.toString());
            pst.setString(1, fil.getTitulo());
            pst.setString(2, fil.getEstreia());
            pst.setString(3, fil.getDuracao());
            pst.setString(4, fil.getDiretor());
            pst.setString(5, fil.getElenco());
            pst.setString(6, fil.getSinopse());
            pst.setInt(7, fil.getId());
            
            pst.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
            }
        } finally {
            try {
                pst.close();
                connection.close();
            } catch (SQLException e) {
            }
        }

    }

    @Override
    public void excluir(EntidadeDominio entidade) {
    	openConnection();
        PreparedStatement pst = null;
        Filme filme = (Filme) entidade;

        try {
            connection.setAutoCommit(false);

            StringBuilder sql = new StringBuilder();
            sql.append("DELETE FROM filme ");
            sql.append("WHERE id_filme=?");

            pst = connection.prepareStatement(sql.toString());
            pst.setInt(1, filme.getId());

            pst.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
            }
        } finally {
            try {
                pst.close();
                connection.close();
            } catch (SQLException e) {
            }
        }
    }
    
    

    @Override
    public List<EntidadeDominio> Consultar(EntidadeDominio entidade) {
    	openConnection();
        PreparedStatement pst = null;
        Filme fil = (Filme) entidade;
        List<EntidadeDominio> list = null;
        
        try {
            connection.setAutoCommit(false);
            list = new ArrayList<EntidadeDominio>();
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM filme");
            
            pst = connection.prepareStatement(sql.toString());
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
            	Filme filme = new Filme();
            	
            	filme.setId(rs.getInt("id_filme"));
            	filme.setTitulo(rs.getString("titulo"));
            	filme.setEstreia(rs.getString("estreia"));
            	filme.setDuracao(rs.getString("duracao"));
            	filme.setDiretor(rs.getString("diretor"));
            	filme.setElenco(rs.getString("elenco"));
            	filme.setSinopse(rs.getString("sinopse"));
	            
	            list.add(filme);
            }
            
            return list;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
            }
        } finally {
            try {
                pst.close();
                connection.close();
            } catch (SQLException e) {
            }
        }
        return null;
    }
    
}
