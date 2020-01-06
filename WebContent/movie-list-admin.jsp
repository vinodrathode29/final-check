<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<title>Admin Movie List</title>
	<link rel="stylesheet" type="text/css" href="./style/style.css"/>
	</head>
	<body>
		<header>
			<span id="head">
				Movie Cruiser
			</span>
		<img class="img" src="./images/logo.png"/>
		<a id="movies" href="ShowMovieListAdmin">Movies</a>
		</header>
	<div class="content">
		<h2>Movies</h2>
		<table class="table">
			<tr>
				<th class="title-name">Title</th>
				<th class="title-gross">Box Office</th>
				<th class="title-txt">Active</th>
				<th class="title-txt">Date Of Launch</th>
				<th class="title-txt">Genre</th>
				<th class="title-txt">Has Teaser</th>
				<th class="title-txt">Action</th>
			</tr>
			<c:forEach items="${movieList}" var="movie">
				<tr>
					<td class="title-name">${movie.title}</td>
					<td class="title-gross"> <fmt:formatNumber type="currency" maxFractionDigits="0"  value="${movie.boxOffice}" var="formatNumber" />${formatNumber}</td> 
					<td class="title-txt"><c:if test="${movie.active}">Yes</c:if>
										  <c:if test="${!movie.active}">No</c:if></td>

					<td class="title-text"><fmt:formatDate pattern="dd/MM/yyyy" value="${movie.dateOfLaunch}" /></td>

					<td class="title-txt">${movie.genre}</td>
					<td class="title-txt"><c:if test="${movie.hasTeaser}">Yes</c:if>
											<c:if test="${!movie.hasTeaser}">No</c:if></td>

					<td class="title-txt"><a href="ShowEditMovie?id=${movie.id }">Edit</a></td>
				</tr>
			</c:forEach>
		</table>		
	</div >
	<footer>
		<span>Copyright @ 2019</span>
	</footer>
	</body>
</html>



