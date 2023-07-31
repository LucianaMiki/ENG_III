import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;

	public static Connection getConnectionPostgres() throws ClassNotFoundException, SQLException {
		driver = "org.postgresql.Driver";
		url = "jdbc:postgresql://localhost:8080/ENGIII";
		user = "postgres";
		password = "12e45";
		return getConnection();
	}

	public static Connection getConnectionH2() throws ClassNotFoundException, SQLException {
		driver = "org.h2.Driver";
		url = "jdbc:h2:~/test";	
		user = "sa";
		password = "";
		return getConnection();

	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {

		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, password);

		return conn;

	}

}

-----------------------------

package br.com.dragon.util.conexao;
import java.sql.*;
/**
*
* @author mayron
*/
public class Conexao {
	private String local;
	private String user;
	private String senha;
	private Connection c;
	private Statement statment;
	private String str_conexao;
	private String driverjdbc;

	public Conexao(String bd, String local, String porta,
	String banco, String user, String senha) {
		if (bd.equals("PostgreSql")){
  			setStr_conexao("jdbc:postgresql://"+ local +":" + porta +"/"+ banco);
  			setLocal(local);
  			setSenha(senha);
  			setUser(user);
  			setDriverjdbc("org.postgresql.Driver");
  		 }else {
  			if (bd.equals("MySql")) {
     				setStr_conexao("jdbc:mysql://"+ local +":" + porta +"/"+ banco);
     				setLocal(local);
     				setSenha(senha);
     				setUser(user);
     				setDriverjdbc("com.mysql.jdbc.Driver");
 			}
		}
  	}

	public void configUser(String user, String senha) {
		setUser(user);
		setSenha(senha);
	}

	public void configLocal(String banco) {
		setLocal(banco);
	}

	//Conexão com o Banco de Dados
	public void conect(){
		try {
			Class.forName(getDriverjdbc());
			setC(DriverManager.getConnection(getStr_conexao(), getUser(), getSenha()));
			setStatment(getC().createStatement());
		}catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}

	public void disconect(){
		try {
			getC().close();
		}catch (SQLException ex) {
			System.err.println(ex);
			ex.printStackTrace();
		}
	}

	public ResultSet query(String query){
		try {
			return getStatment().executeQuery(query);
		}catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	// GETs AND SETs
	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Connection getC() {
		return c;
	}

	public void setC(Connection c) {
		this.c = c;
	}

	public Statement getStatment() {
		return statment;
	}

	public void setStatment(Statement statment) {
		this.statment = statment;
	}

	public String getStr_conexao() {
		return str_conexao;
	}

	public void setStr_conexao(String str_conexao) {
		this.str_conexao = str_conexao;
	}

	public String getDriverjdbc() {
		return driverjdbc;
	}

	public void setDriverjdbc(String driverjdbc) {
		this.driverjdbc = driverjdbc;
	}

}

----------------------
Conexao("BANCO","LOCAL/IP","PORTA","MEU DB","USUARIO","SENHA");
----------------------
Conexao c = new Conexao("PostgreSql","localhost","5432","db1","us","123");
c.conect();
//...
c.disconect();
--------------------------
https://www.devmedia.com.br/classe-generica-para-conexao-com-postgresql-e-mysql/5492
--------------------------
https://jdbc.postgresql.org/download.html
--------------------------




