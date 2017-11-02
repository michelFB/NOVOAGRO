package Model;


public class PRODUTOMODEL{
	
	
	private String IDproduto;  // atributos privados
	private String Codigo;  // atributos privados
	private String Descricao;
	private String Quantidade;
	private String Valor;
	private String Imagem;// atributos privados
	
	public PRODUTOMODEL() {	//construtor vazio
	}
	
	
	public PRODUTOMODEL(String iDproduto, String codigo, String descricao, String quantidade, String valor,
			String imagem) {
		super();
		IDproduto = iDproduto;
		Codigo = codigo;
		Descricao = descricao;
		Quantidade = quantidade;
		Valor = valor;
		Imagem = imagem;
	}
	

	
	public String getIDproduto() {
		return IDproduto;
	}

	public void setIDproduto(String iDproduto) {
		IDproduto = iDproduto;
	}

	public String getCodigo() {
		return Codigo;
	}

	public void setCodigo(String codigo) {
		Codigo = codigo;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public String getQuantidade() {
		return Quantidade;
	}

	public void setQuantidade(String quantidade) {
		Quantidade = quantidade;
	}

	public String getValor() {
		return Valor;
	}

	public void setValor(String valor) {
		Valor = valor;
	}

	public String getImagem() {
		return Imagem;
	}

	public void setImagem(String imagem) {
		Imagem = imagem;
	}
	
	
}
	
