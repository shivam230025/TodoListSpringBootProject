<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

	<div class="container">
	
		<h2>Welcome to toDo page ${name}</h2>
		your todos are

		<table class="table">
			<thead>
				<tr>
					<th>Description</th>
					<th>Date</th>
					<th>is Done?</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.getDescription()}</td>
						<td>${todo.getTargetDate()}</td>
						<td>${todo.getIsDone()}</td>
						<td> <a href="delete-todo?id=${todo.getId()}" class="btn btn-warning">Delete</a> </td>
						<td> <a href="update-todo?id=${todo.getId()}" class="btn btn-success">Update</a> </td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<!-- <input type="submit"  class="btn-success"> -->
		<!-- <button type="submit" class="btn-success">Add to do</button> -->
		<a href="add-todo" class="btn btn-success">Add todo</a>
		
	</div>
	
<%@ include file="common/footer.jspf" %>