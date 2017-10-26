<%@ include file="verificaSessao.jsp" %>
<%if(!("1".equals(session.getAttribute("tipo")))&&!("2".equals(session.getAttribute("tipo"))))
{%><jsp:forward page="sair.jsp"/><%}else{ %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%	 String  mensagem  = (String)  request.getAttribute("msg");  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include page="publica/header.jspf" />

<body>

	 <div class="container-fluid text-center">    
	  <div class="row content">
	   <jsp:include page="publica/barra_lateral_esquerda.jsp" />
    <div class="col-sm-7 text-left"> 
      <h1>SISTEMA NOVOAGRO WEB</h1>   
                    <p>FORMULÁRIO DE CADASTRO DE PRODUTOS</p>                  
                    <h4><label class="label label-info"> <%if(mensagem==null){}else{out.println(mensagem);}%></label></h4>
                    <br />                    
                    <form class="form-horizontal" action="adicionaProduto" method="post" >
                       <div class="form-group">
                            <label for="email" class="col-sm-3 control-label">Código</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" id="Codigo" name="Codigo" />
                            </div>
                        </div>
                       <div class="form-group">
                            <label for="email" class="col-sm-3 control-label">Descrição</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" id="Descricao" name="Descricao"/>
                            </div>
                        </div>
                       <div class="form-group">
                            <label for="email" class="col-sm-3 control-label">Quantidade</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" id="Quantidade" name="Quantidade" />
                            </div>
                        </div>
                       <div class="form-group">
                            <label for="email" class="col-sm-3 control-label">Valor</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" id="Valor" name="Valor"  />
                            </div>
                        </div>                  
                        <div class="form-group">
                            <label for="email" class="col-sm-3 control-label">Imagem</label>
                            <div class="col-sm-5">
                                <input type="file" class="form-control" id="Imagem" name="Imagem"  />
                            </div>
                        </div>                      
                           
                        <div class="form-group">       
                            <div class="col-sm-offset-3 col-sm-10">
                                <button type="submit" class="btn btn-default">Inserir Produto</button>
                              	<button  type="reset"  class="btn btn-default"  onclick="location.href='Index.jsp'">Cancelar</button>
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