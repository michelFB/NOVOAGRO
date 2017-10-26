package projeto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//çççççç
public class PRODUTODAO {
	private Connection connection;
	private List<PRODUTOMODEL> ProdutoLista;
	
	//construtor ------------------------------------------------------------------------------
	public PRODUTODAO() {
	// abre uma conexão com o banco de dados
	this.connection = new BANCO().getConnection();}	
	
		

		// método de adicionar ao banco ------------------------------------------------------------
	public void adiciona(PRODUTOMODEL Produto) {	
	try {
	// prepared statement para inserção
	//String sql = "insert into produto " +  "(IDproduto,NOME,LOGIN,SENHA,TIPO)" + " values (" + produto.getIDproduto() + ", '" + produto.getNome() + "', '" + 
	//	produto.getLogin() + "',  " + 	produto.getSenha() + ","+ produto.getTipo() +")";
		
	String sql = "EXECUTE PROCEDURE GRAVAR_PRODUTO(?,?,?,?,?)";		
	//String sql = "insert into PRODUTO" + "(IDPRODUTO, CODIGO, DESCRICAO, QUANTIDADE, VALOR, IMAGEM)" + " values (?,?,?,?,?,?)";	
	PreparedStatement st = connection.prepareStatement(sql);	
	//st.setString(1, Produto.getIDproduto());
	st.setString(1, Produto.getCodigo());
	st.setString(2, Produto.getDescricao());
	st.setString(3, Produto.getQuantidade());
	st.setString(4, Produto.getValor());
	st.setString(5, Produto.getImagem());
	st.execute();
	st.close();
	} catch (SQLException e) {
	throw new RuntimeException(e);	}
	}

	//Exclusão por registro-----------------------------------------------------------------------------------------------------
	public boolean apaga(PRODUTOMODEL Produto) {
		boolean retorno = false;
		try {
		PreparedStatement st = this.connection.prepareStatement("DELETE FROM PRODUTO WHERE IDPRODUTO = ?;");
		st.setString(1, Produto.getIDproduto());
		st.execute();
		st.close();
		retorno = true;
		} catch (SQLException e) {
		throw new RuntimeException(e);	}
	return retorno;
	}
	
	//Alteração -----------------------------------------------------------------------------------------------------
	public boolean altera(PRODUTOMODEL produto) {

		boolean retorno = false;
		try {
			PreparedStatement st = this.connection.prepareStatement("UPDATE PRODUTO SET CODIGO = ?, DESCRICAO = ?, QUANTIDADE = ?, VALOR = ?, IMAGEM = ? WHERE IDPRODUTO = ?;");
			st.setString(1, produto.getCodigo());
			st.setString(2, produto.getDescricao());
			st.setString(3, produto.getQuantidade());
			st.setString(4, produto.getValor());
			st.setString(5, produto.getImagem());
			st.setInt(6, Integer.parseInt(produto.getIDproduto()));
			st.execute();
			st.close();
			retorno = true;
			} catch (Exception e) {
				e.printStackTrace();}
		return retorno;	
	}
	
	//Listagem ----------------------------------------------------------------------------------------------
	public List<PRODUTOMODEL> getLista() {
		try {
			this.ProdutoLista = new ArrayList<PRODUTOMODEL>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from PRODUTO");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				PRODUTOMODEL ProdutoObj = new PRODUTOMODEL();  // criando o objeto Contato
				ProdutoObj.setIDproduto(rs.getString("IDPRODUTO"));
				ProdutoObj.setCodigo(rs.getString("CODIGO"));
				ProdutoObj.setDescricao(rs.getString("DESCRICAO"));		
				ProdutoObj.setQuantidade(rs.getString("QUANTIDADE"));
				ProdutoObj.setValor(rs.getString("VALOR"));
				ProdutoObj.setImagem(rs.getString("IMAGEM"));
				this.ProdutoLista.add(ProdutoObj);					// adicionando o objeto à lista
				}
			rs.close();
			stmt.close();
						} catch (SQLException e) {
				throw new RuntimeException(e);
				}
		return ProdutoLista;
	}
	
}
