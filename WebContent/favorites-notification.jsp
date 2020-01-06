<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Favourites Empty </title>
			<link rel="stylesheet" type="text/css" href="./style/style.css"/>
	</head>
	<body>
		<header><span id="head">Movie Cruiser</span>
			<img class="img" src="./images/logo.png" / >
				<a id="movies" href="./favorites.html"/>Favorites</a>
				<a id="movies" href="./movie-list-customer.html"/>Movies</a>
		</header>
	<div class="content">
	<h2> Favourites</h2>
	<p class="txtcolor"> Movie removed from Favourites successfully</p>
		<table class="table">
			<tr>
				<th class="title-name">Title</th>
				<th class="title-gross">Box Office</th>
				<th class="title-txt">Genre</th>
				<th></th>
			</tr>
			<tr>
				<td class="title-name">Avatar</td>
				<td class="title-gross">$2,787,965,087</td>
				<td class="title-txt">Science Fiction</td>
				<td><a href="./favorites-notification.html"/>Delete</td>
			</tr>
			<tr>
				<td class="title-name">The Avengers</td>
				<td class="title-gross">$1,518,812,988</td>
				<td class="title-txt">Superhero</td>
				<td><a href="./favorites-notification.html"/>Delete</td>
			</tr>
		</table>
		<p class="favmar"><b>No. of Favorites:2</b></p>
	</div>
	<footer>
		<span>Copyright@2019</span>
	</footer>
	</body>
</html>