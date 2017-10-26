<%@ include file="verificaSessao.jsp" %>
<%if(!("1".equals(session.getAttribute("tipo")))){%><jsp:forward page="sair.jsp"/><%}else{ %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include page="publica/header.jspf" />
<body>
 <div class="container-fluid text-center">    
	  <div class="row content">
<jsp:include page="publica/barra_lateral_esquerda.jsp" />
    <div class="col-sm-7 text-left"> 
      <h1>SISTEMA NOVOAGRO WEB</h1>   
 		<p>ALTERAÇÃO DE USUÁRIO</p>
                    <br />        
                    <form class="form-horizontal" action="alteraUsuario" method="post">
                        <div class="form-group">
                            <label for="email" class="col-sm-3 control-label">Código</label>
                            <div class="col-sm-5">
                            <input type="text" class="form-control" name="IDusuario" readonly="true" value="<%=request.getParameter("IDusuario")%>" />
                            </div>
                        </div>
                       <div class="form-group">
                            <label for="email" class="col-sm-3 control-label">Nome</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" name="nome" value="<%=request.getParameter("nome")%>" />
                            </div>
                        </div>
                       <div class="form-group">
                            <label for="email" class="col-sm-3 control-label">Login</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" name="login" value="<%=request.getParameter("login")%>" />
                            </div>
                        </div>
                       <div class="form-group">
                            <label for="email" class="col-sm-3 control-label">Senha</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control"  name="senha" value="<%=request.getParameter("senha")%>" />
                            </div>
                        </div>
                       <div class="form-group">
                            <label for="email" class="col-sm-3 control-label">Tipo</label>
                            <div class="col-sm-5">
                              	<select name="tipo" class="form-control" value="<%=request.getParameter("tipo")%>" >
							    <option value="1">administrador</option>
							    <option value="2">funcionario</option>
							    <option value="3">Cliente</option>
							    </select>
                            </div>
                        </div>                      
                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-10">
                                <button type="submit" class="btn btn-default">Atualizar Usuário</button>
                                <button  type="reset"  class="btn btn-default"  onclick="location.href='UsuarioListar.jsp'">Cancelar</button>
                            </div>
                        </div>
                    </form>
   </div>
    <jsp:include page="publica/barra_lateral_direita.jspf" />
  </div>
</div>
<jsp:include page="publica/barra_inferior.jspf" />
</body>
</html>
<%}%>
