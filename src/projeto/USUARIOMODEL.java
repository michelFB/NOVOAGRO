package projeto;


public class USUARIOMODEL{
	private String IDusuario;  // atributos privados
	private String Nome;  // atributos privados
	private String login;
	private String senha;
	private String Tipo;  // atributos privados
	
	public USUARIOMODEL() {	//construtor vazio
	}
	public USUARIOMODEL(String iDusuario, String nome, String login, String senha, String tipo) {
		super();
		IDusuario = iDusuario;
		Nome = nome;
		this.login = login;
		this.senha = senha;
		Tipo = tipo;
	}

	
	// métodos de acesso aos atributos privados
	public String getIDusuario() { 
		return IDusuario;
	}
	public void setIDusuario(String iDusuario) {
		IDusuario = iDusuario;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
	
