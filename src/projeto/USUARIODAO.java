package projeto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class USUARIODAO {
	private Connection connection;
	private List<USUARIOMODEL> UsuarioLista;
	
	//construtor ------------------------------------------------------------------------------
	public USUARIODAO() {
	// abre uma conexão com o banco de dados
	this.connection = new BANCO().getConnection();}	
	
		
	// método de logar no banco ------------------------------------------------------------
		public boolean Loga(USUARIOMODEL Usuario) {	
		boolean variavel = false;
		try {
		String sql = "select * from USUARIO where (LOGIN=? and SENHA=?)";	
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, Usuario.getLogin()); 
		st.setString(2, Usuario.getSenha());
		ResultSet rs = st.executeQuery();
		if(rs.next()){ System.out.println("Usuário conectado!");
	        variavel = true;
		      } else { System.out.println("Nenhum usuario!");
	            variavel = false;}
		    st.close();
		    rs.close();
	   		}catch (SQLException e) {
			throw new RuntimeException(e);	
			}
		return variavel;
		}
		
		public USUARIOMODEL Obter(String login, String senha) {
			USUARIOMODEL UsuarioObj = new USUARIOMODEL();  
			try {
				String sql = "select * from USUARIO where (LOGIN=? and SENHA=?)";	
				PreparedStatement st = connection.prepareStatement(sql);
				st.setString(1, login); 
				st.setString(2, senha);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {	
					UsuarioObj.setIDusuario(rs.getString("IDUSUARIO"));
					UsuarioObj.setNome(rs.getString("NOME"));
					UsuarioObj.setLogin(rs.getString("LOGIN"));		
					UsuarioObj.setSenha(rs.getString("SENHA"));
					UsuarioObj.setTipo(rs.getString("TIPO"));
					}
				st.close();
				rs.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
					}
			return UsuarioObj;
		}
	
		// método de adicionar ao banco ------------------------------------------------------------
		public void adiciona(USUARIOMODEL Usuario) {	
			try {			
			
				String sql = "EXECUTE PROCEDURE GRAVAR_USUARIO(?,?,?,?)";		
				//String sql = "insert into PRODUTO" + "(IDPRODUTO, CODIGO, DESCRICAO, QUANTIDADE, VALOR, IMAGEM)" + " values (?,?,?,?,?,?)";	
				PreparedStatement st = connection.prepareStatement(sql);	
				//st.setString(1, Produto.getIDproduto());
				st.setString(1, Usuario.getNome());
				st.setString(2, Usuario.getLogin());
				st.setString(3, Usuario.getSenha());
				st.setString(4, Usuario.getTipo());
				st.execute();
				st.close();
				} catch (SQLException e) {
			throw new RuntimeException(e);	}
			}
	//Exclusão por registro-----------------------------------------------------------------------------------------------------
	public boolean apaga(USUARIOMODEL usuario) {
		boolean retorno = false;
		try {
		PreparedStatement st = this.connection.prepareStatement("DELETE FROM USUARIO WHERE IDUSUARIO = ?;");
		st.setString(1, usuario.getIDusuario());
		st.execute();
		st.close();
		retorno = true;
		} catch (SQLException e) {
		throw new RuntimeException(e);	}
	return retorno;
	}
	
	//Exclusão todos -----------------------------------------------------------------------------------------------------
	public void apagatodos(USUARIOMODEL usuario) {
	try {
		// prepared statement para inserção
		PreparedStatement st = this.connection.prepareStatement("DELETE FROM USUARIO;");
		st.execute();
		st.close();
		} catch (SQLException e) {
		throw new RuntimeException(e);	}
		}
	
	//Alteração -----------------------------------------------------------------------------------------------------
	public boolean altera(USUARIOMODEL usuario) {
		boolean retorno = false;
		try {
			PreparedStatement st = this.connection.prepareStatement("UPDATE USUARIO SET NOME = ?, LOGIN = ?, SENHA = ?, TIPO =? WHERE IDUSUARIO = ?;");
			st.setString(1, usuario.getNome());
			st.setString(2, usuario.getLogin());
			st.setString(3, usuario.getSenha());
			st.setString(4, usuario.getTipo());
			st.setInt(5, Integer.parseInt(usuario.getIDusuario()));
			st.execute();
			st.close();
			retorno = true;
			} catch (Exception e) {
				e.printStackTrace();}
		return retorno;	
	}
	
	//Listagem ----------------------------------------------------------------------------------------------
	public List<USUARIOMODEL> getLista() {
		try {
			this.UsuarioLista = new ArrayList<USUARIOMODEL>();
			PreparedStatement st = this.connection.prepareStatement("select * from USUARIO");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				USUARIOMODEL UsuarioObj = new USUARIOMODEL(); 
				UsuarioObj.setIDusuario(rs.getString("IDUSUARIO"));
				UsuarioObj.setNome(rs.getString("NOME"));
				UsuarioObj.setLogin(rs.getString("LOGIN"));		
				UsuarioObj.setSenha(rs.getString("SENHA"));
				UsuarioObj.setTipo(rs.getString("TIPO"));
				this.UsuarioLista.add(UsuarioObj);	// adicionando o objeto à lista
				}
			rs.close();
			st.close();
						} catch (SQLException e) {
				throw new RuntimeException(e);
				}
		return UsuarioLista;
	}
	
}
