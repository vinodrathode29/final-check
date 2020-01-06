<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Favorites</title>
			<link rel="stylesheet" type="text/css" href="./style/style.css"/>
	</head>
	<body>
		<header><span id="head">Movie Cruiser</span>
				<img class="img" src="./images/logo.png"/>
				<a id="movies" href="ShowFavorite">Favorites</a>
				<a id="movies" href="ShowMovieListCustomer">Movies</a>
	</header>
	<div class="content">
		<h2> Favourites</h2>
		<h4 class="txtcolor">${msg}</h4>
			<table class="table">
				<tr>
					<th class="title-name">Title</th>
					<th class="title-gross">Box Office</th>
					<th class="title-txt">Genre</th>
					<th></th>
				</tr>
				<c:forEach items="${favorites}" var="movie">
				<tr>
					<td class="title-name">${movie.title}</td>
					
					<td class="title-gross"><fmt:formatNumber type="currency" maxFractionDigits	="0" value="${movie.boxOffice}" var="formatNumber" />${formatNumber}</td> 
					
					
					<td class="title-txt">${movie.genre}</td>
				
					<td class="title-txt"><a href="RemoveFavorite?id=${movie.id }">Delete</a></td>
				</tr>
			</c:forEach>
			</table>
			<p class="favmar"><b> No of Favorites:${fn:length(favorites)} </b></p>
	</div>
	<footer>
		<span>Copyright@2019</span>
	</footer>
	</body>
</html>


