package br.unincor.connection;

import java.sql.Connection;
import java.sql.DriverManager;

import br.unincor.view.Usuario;


public class ConexaoBD {

	private String DB_HOST_IP;
	private String DB_PORT;
	private String DB_NAME;
	private String DB_USER;
	private String DB_PASSWD;

	public Connection CON;
	
	private Usuario usuario;
	
	public ConexaoBD() {
		super();
		DB_HOST_IP = "localhost";
		DB_PORT = "3306";
		DB_NAME = "va3_3";
		DB_USER = "root";
		DB_PASSWD = "root";
		
		CON = null;
		
		usuario = new Usuario();
	}

	public void dbOpenConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			CON = DriverManager.getConnection(getDBURL());
		} catch (Exception e) {
			usuario.exibeMsgErro("Erro ao estabelecer conexão com o BD: " + e.getMessage()); 
		}
	}

	public void dbCloseConnection() {
		if (CON != null) {
			try {
				CON.close();
			} catch (Exception e) {
				usuario.exibeMsgErro("Erro ao fechar conexão com o banco: " + e.getMessage());
			}
		}
	}

	private final String getDBURL() {
		return "jdbc:mysql://" + DB_HOST_IP + ":" +
						DB_PORT + "/" + DB_NAME +
						"?user=" + DB_USER + "&password="
						+ DB_PASSWD + "&autoReconnect=true&useSSL=false";
	}
}
