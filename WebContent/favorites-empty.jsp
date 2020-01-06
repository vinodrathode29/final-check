<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Favorites Empty </title>
			<link rel="stylesheet" type="text/css" href="./style/style.css"/>
	</head>
	<body>
		<header><span id="head">Movie Cruiser</span>
			<img class="img" src="./images/logo.png" / >
				<a id="movies" href="ShowFavorite">Favorites</a>
				<a id="movies" href="ShowMovieListCustomer"/>Movies</a>
		</header>
	<div class="content">
		<h2>Favorites</h2>
		<h3>No items in Favorites. Use 'Add to Favorite' option in <a  class="itemcolor" href="ShowMovieListCustomer"/>Movie List.</a></h3>
	</div>
	<footer>
		<span>Copyright@2019</span>
	</footer>
	</body>
</html>


