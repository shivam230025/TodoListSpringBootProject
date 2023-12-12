<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">

	<h3>Enter the todo details</h3>
	<hr>
	<form:form method="post" modelAttribute="todo">

		<fieldset class="mb-3">
			<form:label path="description">Enter description: </form:label>
			<form:input type="text" path="description" required="required" />
			<form:errors path="description" cssClass="text-danger" />
			<br>
		</fieldset>

		<fieldset class="mb-3">
			<form:label path="targetDate">Enter Date: </form:label>
			<form:input id="datepicker" type="text" path="targetDate"
				required="required" />
			<form:errors path="targetDate" cssClass="text-danger" />
			<br>
		</fieldset>

		<form:input type="hidden" path="username" />

		<form:input type="hidden" path="id" />

		<form:input type="hidden" path="isDone" />

		<input type="submit" class="btn btn-success">

	</form:form>

</div>

<%@ include file="common/footer.jspf"%>

<script type="text/javascript">
	$('#datepicker').datepicker({
		format : 'yyyy-mm-dd'
	});
</script>

