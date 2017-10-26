<%@ include file="verificaSessao.jsp" %>
<%if(!("1".equals(session.getAttribute("tipo")))&&!("2".equals(session.getAttribute("tipo"))))
{%><jsp:forward page="sair.jsp"/><%}else{ %>
<%@ page import="projeto.PRODUTODAO" import="projeto.PRODUTOMODEL" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
 <% String msg = null;
 if(request.getParameter("IDproduto")==null)
 {	 msg = "Registro não encontrado"; }else
 {	 PRODUTOMODEL produto = new PRODUTOMODEL();
	 PRODUTODAO dao = new PRODUTODAO();
	 produto.setIDproduto(request.getParameter("IDproduto"));
 	 boolean ret = dao.apaga(produto);
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
 <jsp:forward page="Index.jsp"/>
 <%}%>
