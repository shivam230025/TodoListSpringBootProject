<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

	<div class="container">
		<h2>Welcome to login page</h2>
		<pre>${errorMessage}</pre>
		<form method="post">
			name: <input type="text" name="name"><br> password: <input
				type="password" name="password"><br> <input
				type="submit">
		</form>

	</div>
	
<%@ include file="common/footer.jspf" %>