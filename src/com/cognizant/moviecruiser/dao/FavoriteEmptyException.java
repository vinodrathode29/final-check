package com.cognizant.moviecruiser.dao;

public class FavoriteEmptyException extends Exception {

	public FavoriteEmptyException() {
		super("Favorites Empty");

	}

	public FavoriteEmptyException(String message) {
		super(message);

	}

}
