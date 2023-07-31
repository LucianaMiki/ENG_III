package br.com.fatec.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.fatec.dominio.EntidadeDominio;
import br.com.fatec.dominio.Filme;
import br.com.fatec.dominio.Sala;

import java.sql.ResultSet;

public class SalaDAO extends AbstractJdbcDAO {

    public SalaDAO() {
        super("sala", "id_sal");
    }

    public void Inserir(EntidadeDominio entidade) {
        openConnection();
        PreparedStatement pst = null;
        Sala sala = (Sala) entidade;

        try {
            connection.setAutoCommit(false);

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO sala (id_cd_sal, id_tp_sal,id_cap_sal) VALUES (?, ?, ?) ");

            pst = connection.prepareStatement(sql.toString(),Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, Integer.parseInt(sala.getCodigo()));
            pst.setInt(2, Integer.parseInt(sala.getTipo()));
            pst.setInt(3, sala.getCapacidade());
            
            pst.executeUpdate();
            
            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()){
                int last_inserted_id = rs.getInt(1);
                sala.setId(last_inserted_id);
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
        Sala sala = (Sala) entidade;

        try {
            connection.setAutoCommit(false);

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE sala SET id_tp_sal=?, id_cap_sal=?");
            sql.append("WHERE id_cd_sal=?");

            pst = connection.prepareStatement(sql.toString());
            pst.setInt(1, Integer.parseInt(sala.getTipo()));
            pst.setInt(2, sala.getCapacidade());
            pst.setInt(3, Integer.parseInt(sala.getCodigo()));

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
        Sala sala = (Sala) entidade;

        try {
            connection.setAutoCommit(false);

            StringBuilder sql = new StringBuilder();
            sql.append("DELETE FROM sala ");
            sql.append("WHERE id_cd_sal=?");

            pst = connection.prepareStatement(sql.toString());
            pst.setInt(1, Integer.parseInt(sala.getCodigo()));

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
        Sala sal = (Sala) entidade;
        List<EntidadeDominio> list = null;
        try {
            connection.setAutoCommit(false);
            list = new ArrayList<EntidadeDominio>();
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM sala");
            
            pst = connection.prepareStatement(sql.toString());
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
            	Sala sala = new Sala();
            	sala.setId(rs.getInt("id_sal"));
            	sala.setCodigo(rs.getString("id_cd_sal"));
            	sala.setTipo(rs.getString("id_tp_sal"));
            	sala.setCapacidade(rs.getInt("id_cap_sal"));
	            
	            list.add(sala);
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
