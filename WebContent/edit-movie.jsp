<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Edit Movie </title>
           <link rel="stylesheet" type="text/css" href="./style/style.css"/>
		   <script src="./js/script.js" type="text/javascript"></script>
    </head>
	<body>
		<header><span id="head">Movie Cruiser</span>
			<img class="img" src="./images/logo.png"/> 
			<a id="movies" href="ShowMovieListAdmin">Movies</a>
		</header>
	<div>
		<h2>Edit Movie</h2>
			<form class="content" name="myform" onSubmit="return validation()" method="post" action="EditMovie?id=${movie.id }">
				<table class="table">
					<tr>
						<td colspan="4"><label for="title"> Title</label></td>
					</tr>
					<tr>
						<td colspan="4"><input type="text" id="title" name="title" size="80" value="${movie.title}"></td>
					</tr>
					<tr>
						<td><label for="gross">Gross($)</label></td>
						<td>Active</td>
						<td><label for="dolaunch">Date of Launch</label></td>
						<td><label for="genre">Genre</label></td>
					</tr>
					<tr>
						<td><input type="textbox" class="title-gross" id="gross" name="gross" value="${movie.boxOffice}"></td>
						
						<td><label for="rdyes"><input type="radio" id ="rdyes" name="rdyes"  value="Yes"<c:if test="${ movie.active eq 'true'}"> checked="checked"</c:if>>Yes</label>
						
							<label for="rdno"><input type="radio" id="rdno" name="rdyes" value="No"<c:if test="${ movie.active eq 'false'}"> checked="checked"</c:if>>No</label></td>
							
						<td><fmt:formatDate type="date" pattern = "dd/MM/yyyy" value= "${movie.dateOfLaunch}" var="format" /><input type="text" id="txtDoB" name="txtDoB"  value="${format }"></td>
						
						
						<td><select name="genre" id="genre">
					
							<option  <c:if test="${movie.genre eq 'ScienceFiction'}">selected</c:if>>Science Fiction</option>
							<option  <c:if test="${movie.genre eq 'Superhero'}">selected</c:if>>Superhero</option>
							<option  <c:if test="${movie.genre eq 'Romance'}">selected</c:if>>Romance</option>
							<option  <c:if test="${movie.genre eq 'Comedy'}">selected</c:if>>Comedy</option>
							<option  <c:if test="${movie.genre eq 'Adventure'}">selected</c:if>>Adventure</option>
							<option  <c:if test="${movie.genre eq 'Thriller'}">selected</c:if>>Thriller</option>
							</select>
						</td>
					</tr>
					<tr>
						
						<td colspan="2"><label for="hasteaser">	<input type="checkbox" id="hasteaser" name="hasteaser" value="hasteaser"
							<c:if test="${movie.hasTeaser eq 'true'}">Checked</c:if>
							<c:if test="${movie.hasTeaser eq 'false'}"> </c:if>>Has Teaser</label></td>
					</tr>
					<tr>
						<td  colspan="2"><input class="svbtn" type="submit" value="Save"></td>
					</tr>
				</table>
			</form>
	</div>	
	<footer>
		<span>Copyright@2019<span>
	</footer>
	</body>
</html>


