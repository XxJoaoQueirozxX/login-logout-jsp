package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.fiap.bean.Usuario;
import br.com.fiap.connection.ConnectionFactory;

public class UsuarioDAO {

	private Connection con;

	public UsuarioDAO() {
		ConnectionFactory cf = new ConnectionFactory();
		try {
			this.con = cf.DBConnectionManager();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	
	public int insert(Usuario u) {
		PreparedStatement stmt = null;
		int res = 0;
		try {
			stmt = con.prepareStatement("INSERT INTO TBL_LOGIN (ID_USER, NOME, NM_USER, PASS_USER, URL_AVATAR) VALUES (SEQ_LOGIN.NEXTVAL, ?, ?, ?, ?)");
			
			stmt.setNString(1, u.getNome());
			stmt.setNString(2, u.getNomeUser());
			stmt.setNString(3, u.getPassUser());
			stmt.setNString(4, u.getUrlAvatar());
			res = stmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}
	
	public Usuario selectByUsername(String username) {
		Usuario u = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			
			stmt = con.prepareStatement("SELECT * FROM TBL_LOGIN WHERE NM_USER = ?");
			stmt.setString(1, username);			
			
			rs = stmt.executeQuery();


			while (rs.next()) {
				u = new Usuario();
				u.setId(rs.getInt("id_user"));
				u.setNome(rs.getNString("nome"));
				u.setNomeUser(rs.getNString("nm_user"));			
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return u;
	}
	
	public Usuario select(Usuario up) {
		Usuario u = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			
			ps = con.prepareStatement("SELECT * FROM TBL_LOGIN WHERE NM_USER = ? AND PASS_USER = ?");
			
			ps.setString(1, up.getNomeUser());
			ps.setString(2, up.getPassUser());

			rs = ps.executeQuery();


			while (rs.next()) {
				// A cada iteração, será criado um novo Objeto e este será populado
				// com os dados oriundos da base de dados.
				u = new Usuario();
				u.setId(Integer.parseInt(rs.getNString("id_user")));
				u.setNome(rs.getNString("nome"));
				u.setNomeUser(rs.getNString("nm_user"));
				u.setPassUser(rs.getNString("pass_user"));
				u.setUrlAvatar(rs.getNString("url_avatar"));				
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return u;
	}
}
