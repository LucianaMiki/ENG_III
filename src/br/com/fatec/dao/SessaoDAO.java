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

public class SessaoDAO extends AbstractJdbcDAO {

    public SessaoDAO() {
        super("sessao", "id_ses");
    }

    public void Inserir(EntidadeDominio entidade) {
        openConnection();
        PreparedStatement pst = null;
        Sessao ses = (Sessao) entidade;

        try {
            connection.setAutoCommit(false);

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO sessao (valor_meia, valor_inteira, dt_inicio, dt_fim, id_fxe_ses, id_sal, id_filme) VALUES (?, ?, ?, ?, ?, ?, ?)");

            pst = connection.prepareStatement(sql.toString(),Statement.RETURN_GENERATED_KEYS);

            pst.setFloat(1, ses.getValor_meia());
            pst.setFloat(2, ses.getValor_inteira());
            pst.setString(3, ses.getDt_incio());
            pst.setString(4, ses.getDt_fim());
            pst.setInt(5, ses.getFxe());
            pst.setInt(6, ses.getSalaId());
            pst.setInt(7, ses.getFilmeId());
            pst.executeUpdate();
            
            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()){
                int last_inserted_id = rs.getInt(1);
                ses.setId(last_inserted_id);
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
        Sessao ses = (Sessao) entidade;

        try {
            connection.setAutoCommit(false);

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE sessao SET valor_meia=?, valor_inteira=?, dt_inicio=?, dt_fim=?, id_fxe_ses=?");
            sql.append("WHERE id_sal=?");

            pst = connection.prepareStatement(sql.toString());
            pst.setFloat(1, ses.getValor_meia());
            pst.setFloat(2, ses.getValor_inteira());
            pst.setString(3, ses.getDt_incio());
            pst.setString(4, ses.getDt_fim());
            pst.setInt(5, ses.getFxe());
            pst.setInt(6, ses.getSalaId());

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
        Sessao sessao = (Sessao) entidade;

        try {
            connection.setAutoCommit(false);

            StringBuilder sql = new StringBuilder();
            sql.append("DELETE FROM sessao ");
            sql.append("WHERE id_sal=?");

            pst = connection.prepareStatement(sql.toString());
            pst.setInt(1, sessao.getSalaId());

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
        Sessao ses = (Sessao) entidade;
        
        List<EntidadeDominio> list = null;
        
        try {
            connection.setAutoCommit(false);
            list = new ArrayList<EntidadeDominio>();
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM sessao");
            
            pst = connection.prepareStatement(sql.toString());
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
            	Sessao sess = new Sessao();
            	Filme filme = new Filme();
            	Sala sala = new Sala();
            	
            	sess.setId(rs.getInt(1));
            	Integer id = rs.getInt(1);
            	sess.setValor_meia(rs.getFloat("valor_meia"));
            	Float ValorM = rs.getFloat(2);
            	sess.setValor_inteira(rs.getFloat("valor_inteira"));
            	Float ValorI = rs.getFloat(3);
            	sess.setDt_incio(rs.getString("dt_inicio"));
            	String DtI = rs.getString(4);
            	sess.setDt_fim(rs.getString("dt_fim"));
            	String DtF = rs.getString(5);
            	sess.setFxe(rs.getInt("id_fxe_ses"));
            	Integer Fxe= rs.getInt(6);
            	
            	sala.setId(rs.getInt("id_sal"));
            	Integer salaID = rs.getInt(7);
            	filme.setId(rs.getInt("id_filme"));
            	Integer filmeID = rs.getInt(8);
            	
            	sess.setSalaId(salaID);
	            sess.setFilmeId(filmeID);
	            
	            list.add(sess);
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
