<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="pt-BR">
<jsp:include page="publica/header.jspf" />
<body>
 <jsp:include page="publica/barra_superior_publica.jspf" />
 
 <div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
    </div>
    <div class="col-sm-7 text-left"> 
      <h1>SISTEMA NOVOAGRO WEB</h1>   
      <p/>
   	  <h4><label class="label label-info"> <%if(request.getAttribute("msg")==null){}else{out.println(request.getAttribute("msg"));}%></label></h4>
	                <br />                            
                    
                    <form class="form-horizontal" action="autenticacao"  method="post">
                       <div class="form-group">
                            <label for="email" class="col-sm-3 control-label">Login</label>
                            <div class="col-sm-5">
                                <input type="text" onkeypress="soLetras()" class="form-control"  id="login" name="login" placeholder="Digite aqui seu Login"  />
                            </div>
                        </div>
                       <div class="form-group">
                            <label for="email" class="col-sm-3 control-label">Senha</label>
                            <div class="col-sm-5">
                                <input type="password" onkeypress="sonumeros()" class="form-control" id="senha" name="senha" placeholder="Digite aqui sua senha"/>
                            </div>
                        </div>
                       <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-10">
                                 <button type="submit" class="btn btn-default">Logar Usuário</button>
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