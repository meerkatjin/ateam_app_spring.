<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
var message = '${message}';
var returnPath = '${returnPath}';
alert(message);
document.location.href = returnPath;
</script>