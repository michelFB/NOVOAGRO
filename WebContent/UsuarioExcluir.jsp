<%@ include file="verificaSessao.jsp" %>
<%if(!("1".equals(session.getAttribute("tipo")))){%><jsp:forward page="sair.jsp"/><%}else{ %>
<%@ page import="Dao.USUARIODAO" import="Model.USUARIOMODEL" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
 <% String msg = null;
 if(request.getParameter("IDusuario")==null)
 {	 msg = "Registro não encontrado"; }else
 {	 Model.USUARIOMODEL usuario = new Model.USUARIOMODEL();
	 Dao.USUARIODAO dao = new Dao.USUARIODAO();
	 usuario.setIDusuario(request.getParameter("IDusuario"));
 	 boolean ret = dao.apaga(usuario);
 	 if(ret==true){
 		msg = "Registro Excluido com sucesso!";
 		// Define parametros para a sessão
        request.setAttribute("msg", msg);
 	 }else{
 		msg = "Não foi possivel excluir registro.";
 		// Define parametros para a sessão
        request.setAttribute("msg", msg);
 	 }
 }	   %>
 <jsp:forward page="UsuarioListar.jsp"/>
<%}%>