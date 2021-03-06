<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Movie List Customer Notification</title>
		<link rel="stylesheet" type="text/css" href="./style/style.css"/>
	</head>             
	<body>
		<header><span id="head">Movie Cruiser</span>
			<img class="img" src="./images/logo.png" / > 
			<a id="movies" href="./favorites.html"/>Favourites</a>
			<a id="movies" href="./movie-list-customer.html"/>Movies</a>
		</header>
	<div class="content">
		<h2>Movies</h2>
		<p class="txtcolor"> Movie Added to Favorites Successfully</p>
		<table class="table">
			<tr>
				<th class="title-name">Titleitle</th>
				<th class="title-gross">Box office</th>
				<th class="title-txt">Genre</th>
				<th class="title-txt">Has Teaser</th>
				<th class="title-txt">Action</th>
			</tr>
			<tr>
				<td class="title-name">Avatar</td>
				<td class="title-gross">$2,787,965,087</td>
				<td class="title-txt">Science Fiction</td>
				<td class="title-txt">Yes</td>
				<td class="title-txt"><a href="./movie-list-customer-notification.html"/>Add to Favourite</a></td>
			</tr>
			<tr>
				<td class="title-name">The Avengers</td>
				<td class="title-gross">$1,518,812,988</td>
				<td class="title-txt">Superhero</td>
				<td class="title-txt">No</td>
				<td class="title-txt"><a href="./movie-list-customer-notification.html"/>Add to Favourite</a></td>
			</tr>
			<tr>
				<td class="title-name">Titanic</td>
				<td class="title-gross">$2,187,463,944</td>
				<td class="title-txt">Romance</td>
				<td class="title-txt">No</td>
				<td class="title-txt"><a href="./movie-list-customer-notification.html"/>Add to Favourite</a></td>
			</tr>	
		</table>
	</div>
	<footer>
		<span>Copyright@2019</span>
	</footer>
	</body>
</html>


