<%@ include file="verificaSessao.jsp" %>
<%if(!("1".equals(session.getAttribute("tipo")))){%><jsp:forward page="sair.jsp"/><%}else{ %>
<%@ page import="Dao.USUARIODAO" import="Model.USUARIOMODEL"  import="java.util.List"%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="dao" class="Dao.USUARIODAO"/>

 <%	 String  mensagem  = (String)  request.getAttribute("msg"); // vem do servlet altera
 	 USUARIODAO USdao = new USUARIODAO();
	 List<USUARIOMODEL> lista;
	 lista = USdao.getLista();
  %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include page="publica/header.jspf" />
<body>
	 <div class="container-fluid text-center">    
	  <div class="row content">
	    <jsp:include page="publica/barra_lateral_esquerda.jsp" />
    <div class="col-sm-7 text-left"> 
      <h1>SISTEMA NOVOAGRO WEB</h1>   
	<p>LISTAGEM DE USUÁRIOS CADASTRADOS</p>	 	<br />
 	<h4><label class="label label-info"> <%if(mensagem==null){}else{out.println(mensagem);}%></label></h4>	<br />
	<table class="table table-striped" border="1" align="center" >
		<tr><td>IDusuario</td><td>nome</td><td>login</td><td>senha</td><td>tipo</td></tr>
	<%
	for(USUARIOMODEL registro: lista)
	{
	%>		<tr>
			<td style="width: 100px;"><%=registro.getIDusuario()%></td>
			<td  style="width: 200px;"><%=registro.getNome()%></td>
			<td style="width: 100px;"><%=registro.getLogin()%></td>
			<td style="width: 100px;"><%=registro.getSenha()%></td>
			<td style="width: 50px;"><%=registro.getTipo()%></td>
			<td><a href="UsuarioAlterar.jsp?IDusuario=<%=registro.getIDusuario()%>&nome=<%=registro.getNome()%>
			&login=<%=registro.getLogin()%>&senha=<%=registro.getSenha()%>&tipo=<%=registro.getTipo()%>">Editar</a>
			<a href="UsuarioExcluir.jsp?IDusuario=<%=registro.getIDusuario()%>"> Excluir</a></td>	
		</tr>	<% 
	}
	%>
	</table>
   </div> 
    <jsp:include page="publica/barra_lateral_direita.jspf" />
     </div> 
  </div>
<jsp:include page="publica/barra_inferior.jspf" />
</body>
</html>
<%}%>