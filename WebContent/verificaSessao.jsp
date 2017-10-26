<%//verifica se a sessao do usuario é válida
if (request.getSession().getAttribute("contAcessos") == null){
	 response. sendRedirect("/NOVOAGRO/Login.jsp"); }
%>
	<%if("1".equals(session.getAttribute("tipo"))){
	%><jsp:include page="publica/barra_superior_admin.jspf" />
	<%}if("2".equals(session.getAttribute("tipo"))){
	%><jsp:include page="publica/barra_superior_funcionario.jspf" />
	<%}if("3".equals(session.getAttribute("tipo"))){
	%><jsp:include page="publica/barra_superior_clientes.jspf" />
	<%}%>
	
	