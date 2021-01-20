<%@ import="javax.servlet.http.HttpSession,java.util.ArrayList" %>
<div>
	<% HttpSession session = request.getSession();
		ArrayList<String> listimages = (ArrayList) session.getAttribute("list");
	%>
	<ul>
		<% for( String img : listimages) {%>
		<li><img src="<%= "../uploads/"+img %>" /></li>
		<% } %>
	</ul>
</div>