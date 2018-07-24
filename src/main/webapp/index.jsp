<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<title>smartsoft case</title>
</head>

<body>
	<nav class="navbar navbar-default">
	    <div class="container" id="navbar">
	        <div class="navbar-header">
	            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
	                    aria-expanded="false" aria-controls="navbar">
	                <span class="sr-only">Toggle navigation</span>
	                <span class="icon-bar"></span>
	                <span class="icon-bar"></span>
	                <span class="icon-bar"></span>
	            </button>
	            <a class="navbar-brand" href="/Chess_tournament">smartsoft case</a>
	        </div>
	        <div class="navbar-collapse collapse">
	            <ul class="nav navbar-nav">
	                <li><a href="/smartsoft/Parser?type=UsersAndForms">Информация за последний час</a></li>
	                <li><a href="/smartsoft/Parser?type=NotFinishedForms">Незавершенная активность</a></li>
	                <li><a href="/smartsoft/Parser?type=Top5Forms">Топ 5 форм</a></li>
	            </ul>
	        </div>
	    </div>
	</nav>
	
</body>
</html>