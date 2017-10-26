<%@page import="java.util.Date, java.text.*" %>	   
	    <div class="col-sm-2 sidenav">
	   
	    <h3 align="center">Seja bem vindo(a)</h3> 
	    <h4 align="center"> <% out.println(request.getSession().getAttribute("nome"));%> </h4>
	    <br/>
	    <%=new Date()%>
	    <br/><br/>
		<div id="countdown-1"></div>
		<br/><br/>
	   
	    </div>
	    