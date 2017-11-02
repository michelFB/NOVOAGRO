package Controler.servlets.usuarios;
import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.USUARIODAO;
import Model.USUARIOMODEL;


@WebServlet("/excluirUsuario")
public class USUARIO_SERVLET_EXCLUIR extends HttpServlet {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
		protected void service(HttpServletRequest request,
								HttpServletResponse response)	throws IOException, ServletException {
		
	 		String msg = null;
	 		 if(request.getParameter("IDusuario")==null)
	 		 {
	 			 msg = "Registro não encontrado";
	 		 }else
	 		 {
	 			 USUARIOMODEL usuario = new USUARIOMODEL();
	 			 USUARIODAO dao = new USUARIODAO();
	 			 usuario.setIDusuario(request.getParameter("IDusuario"));
	 		 	 boolean ret = dao.apaga(usuario);
	 		 	 if(ret==true){
	 		 		msg = "Registro Excluido com sucesso!";
	 		 	 }else{
	 		 		msg = "Não foi possivel excluir registro.";
	 		 	 }
	 		 }
		
		// Define parametros para a sessão
        request.setAttribute("msg", msg);
		// Chama pagina de resposta
        getServletContext().getRequestDispatcher("/UsuarioListar.jsp").forward(request, response); 
        
		
		}
}
		


