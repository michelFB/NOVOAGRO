package Controler.servlets.usuarios;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.USUARIODAO;
import Model.USUARIOMODEL;


@WebServlet("/adicionaUsuario")
public class USUARIO_SERVLET_ADICINAR extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
		protected void service(HttpServletRequest request,
								HttpServletResponse response)	throws IOException, ServletException {
		
		String msg;
			// pegando os parâmetros do request
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		String login = request.getParameter("login");
		String tipo = request.getParameter("tipo");
		
		if(nome==""||senha==""||login==""||tipo==""){
		 	msg = "Preencha todos os campos!";
	        request.setAttribute("msg", msg);
	 		getServletContext().getRequestDispatcher("/UsuarioCadastrar.jsp").forward(request, response);	 		
		} 
		
		
		// monta um objeto Usuario
		USUARIOMODEL usuario = new USUARIOMODEL();
		usuario.setNome(nome);
		usuario.setSenha(senha);
		usuario.setLogin(login);
		usuario.setTipo(tipo);

		// salva o contato
		USUARIODAO dao = new USUARIODAO();
		dao.adiciona(usuario);
		
		// Define parametros para a sessão
        msg =  "Usuário " + nome + " cadastrado com sucesso!";
        request.setAttribute("msg", msg);
        // Chama pagina de resposta
        getServletContext().getRequestDispatcher("/UsuarioListar.jsp").forward(request, response); 
        
		
		}
}
		


