<%@ include file="verificaSessao.jsp" %>
<%@ page import="Dao.PRODUTODAO" import="Model.PRODUTOMODEL" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1" import="java.util.List"%>
 <%  Dao.PRODUTODAO dao = new Dao.PRODUTODAO();
	 List<Model.PRODUTOMODEL> lista;
	 lista = dao.getLista();
  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="pt-BR">
<jsp:include page="publica/header.jspf" />
<body>
	 <div class="container-fluid text-center">    
	 <div class="row content">
	  	<jsp:include page="publica/barra_lateral_esquerda.jsp" />
	    <div class="col-sm-7 text-left"> 
	      <h1>SISTEMA NOVOAGRO WEB</h1>  
	      <h4><label class="label label-info"> <%if(request.getAttribute("msg")==null){}else{out.println(request.getAttribute("msg"));}%></label></h4>	<br />
		   	<br/> 
		   	
		   	<%	for(Model.PRODUTOMODEL registro: lista){ %>
			   	<table class="table-bordered" border="2" align="left" >
					<tr >	<th colspan="3" style="width: 100px; height: 100px" align="center"><%=registro.getImagem()%></th></tr>
					<tr>	<td style="width: 100px;">Código</td>		<td  style="width: 250px;" align="center"><%=registro.getCodigo()%></td></tr>				
					<tr>	<td style="width: 100px;">Descrição</td>	<td style="width: 250px;" align="center"><%=registro.getDescricao()%></td></tr>
					<tr>	<td style="width: 100px;">Quantidade</td>	<td style="width: 250px;" align="center"><%=registro.getQuantidade()%></td></tr>
					<tr>	<td style="width: 100px;">Valor</td>		<td style="width: 250px;" align="center"><%=registro.getValor()%></td></tr>
					<tr>
					<td colspan="3" style="width: 100px;">
					<%if(!("3".equals(session.getAttribute("tipo")))){	%>	
						<a href="ProdutoAlterar.jsp?IDproduto=<%=registro.getIDproduto()%>
					&descricao=<%=registro.getDescricao()%>	&codigo=<%=registro.getCodigo()%>&quantidade=<%=registro.getQuantidade()%>
					&valor=<%=registro.getValor()%>&imagem=<%=registro.getImagem()%>">Editar </a>
					<a href="ProdutoExcluir.jsp?IDproduto=<%=registro.getIDproduto()%>">Excluir</a><%}else{%>
					<a href="#">Comprar</a>
					<%}%>
					</td>		
					</tr>					
				</table>  <%}%>	
					
	    </div>
	    <jsp:include page="publica/barra_lateral_direita.jspf" />
	 </div>
	 </div>
	<jsp:include page="publica/barra_inferior.jspf" />
</body>
</html>
