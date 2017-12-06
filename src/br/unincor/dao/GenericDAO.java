package br.unincor.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.unincor.connection.ConexaoBD;
import br.unincor.view.Usuario;

public class GenericDAO {
	
	protected Usuario usuario;
	protected ConexaoBD conexaoBD;
	
	
	public GenericDAO(Usuario usuario, ConexaoBD conexaoBD) {
		super();
		this.usuario = new Usuario();
		this.conexaoBD = new ConexaoBD();
	}
	
	protected Long executarInsert(String strQuery) {
		Long id = null;
		usuario.exibeMsgDebug("[SQL] " + strQuery);

		PreparedStatement ps;
		try {
			ps = conexaoBD.CON.prepareStatement(strQuery, Statement.RETURN_GENERATED_KEYS);
			ps.executeUpdate(); 
			
			ResultSet rs = ps.getGeneratedKeys(); //getGeneratedKeys vai pegar a PK criada
			if (rs.next()) {
			    id = rs.getLong(1);
			}			
		} catch (SQLException e) {
			usuario.exibeMsgErro("Erro ao inserir postagem. " + e.getMessage());
			usuario.exibeMsgDebug("Erro ao inserir postagem. " + e.getMessage());
		}
		
		return id;
	}
	
	protected Integer executarUpdate(String strQuery) {
		usuario.exibeMsgDebug("[SQL] " + strQuery);

		PreparedStatement ps;
		try {
			ps = conexaoBD.CON.prepareStatement(strQuery);
			return ps.executeUpdate();
		} catch (SQLException e) {
			usuario.exibeMsgErro("Erro ao executar UPDATE: " + e.getMessage());
			usuario.exibeMsgDebug("Erro ao executar UPDATE: " + e.getMessage());
		}
		
		return null;
	}
	
	
	
}
