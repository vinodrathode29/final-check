package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.dao.ConnectionHandler;

public class MovieDaoSqlImp implements MovieDao {

	@Override
	public List<Movie> getMovieListAdmin() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement preparedStatement = null;

		List<Movie> movieList = new ArrayList<Movie>();

		ResultSet resultSet;
		boolean active, hasTeaser;

		try {
			conn = ConnectionHandler.getConnection();

			String sql = ("select * from movie");
			if (conn != null) {
				preparedStatement = conn.prepareStatement(sql);

				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {

					int id = rs.getInt("mo_id");
					String title = rs.getString("mo_title");
					long boxOffice = rs.getLong("mo_box_office");
					String isActive = rs.getString("mo_active");
					Date dateOfLaunch = rs.getDate("mo_date_of_launch");
					
					String genre = rs.getString("mo_genre");

					String isHasTeaser = rs.getString("mo_has_teaser");

					if (isHasTeaser != null && isHasTeaser.equalsIgnoreCase("Yes")) {
						hasTeaser = true;
					} else {
						hasTeaser = false;
					}
					if (isActive != null && isActive.equalsIgnoreCase("Yes")) {
						active = true;
					} else {
						active = false;
					}

					Movie movie = new Movie(id, title, boxOffice, active, dateOfLaunch, genre, hasTeaser);
					
					System.out.println(movie);
					movieList.add(movie);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return movieList;
	}
	@Override
	public List<Movie> getMovieListCustomer() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		List<Movie> movieList = new ArrayList<Movie>();
		ResultSet resultSet;
		boolean active, hasTeaser;
		try {
			conn = ConnectionHandler.getConnection();

			String sql = ("select * from movie "
					+ "where mo_date_of_launch <= curdate()"
					+ " and mo_active='Yes'");

			if (conn != null) {

				preparedStatement = conn.prepareStatement(sql);
				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {

					int id = rs.getInt(1);

					String title = rs.getString(2);

					Date dateOfLaunch = rs.getDate(5);

					String isActive = rs.getString(4);

					long boxOffice = rs.getLong(3);

					String genre = rs.getString(6);

					String isHasTeaser = rs.getString(7);

					if (isHasTeaser != null && isHasTeaser.equalsIgnoreCase("Yes")) {
						hasTeaser = true;

					} else {
						hasTeaser = false;
					}

					if (isActive != null && isActive.equalsIgnoreCase("Yes")) {
						active = true;

					} else {
						active = false;
					}

					Movie movie = new Movie(id, title, boxOffice, active, dateOfLaunch, genre, hasTeaser);

					System.out.println(movie);

					movieList.add(movie);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			try {

				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return movieList;

	}
	

	@Override
	public void modifyMovie(Movie movie) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionHandler.getConnection();
		try {

		String sql = "update movie set mo_title=?, mo_box_office=?, mo_active=?, mo_date_of_launch=?, mo_genre=?, mo_has_teaser=? where mo_id=?";

	
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, movie.getTitle());

			ps.setLong(2, movie.getBoxOffice());

			if (movie.isActive()) {
				ps.setString(3, "Yes");
			} else {
				ps.setString(3, "No");
			}
			ps.setDate(4, new java.sql.Date(movie.getDateOfLaunch().getTime()));
			
			ps.setString(5, movie.getGenre());

			if (movie.isHasTeaser()) {
				ps.setString(6, "Yes");

			} else {
				ps.setString(6, "No");
			}

			ps.setLong(7, movie.getId());

			ps.executeUpdate();

		} catch (SQLException sq) {
			sq.printStackTrace();

		} finally {
			try {
				conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	@Override
	public Movie getMovie(long movieId) {
		// TODO Auto-generated method stub
		Connection con = ConnectionHandler.getConnection();

		ResultSet rs;

		Movie movie = null;

		if (con != null) {

			try {

				String sql = "select * from movie where mo_id=?";

				PreparedStatement ps = con.prepareStatement(sql);

				ps.setLong(1, movieId);

				rs = ps.executeQuery();

				boolean active, hasTeaser;

				Date date_of_launch;

				if (rs.next()) {

					String name = rs.getString(2);

					Long boxOffice = rs.getLong(3);

					String isActive = rs.getString(4);

					date_of_launch = rs.getDate(5);

					String genre = rs.getString(6);

					String isHasTeaser = rs.getString(7);

					if (isActive != null && isActive.equalsIgnoreCase("Yes"))

						active = true;

					else

						active = false;

					if (isHasTeaser != null && isHasTeaser.equalsIgnoreCase("Yes"))

						hasTeaser = true;

					else

						hasTeaser = false;

					movie = new Movie(movieId, name, boxOffice,active, date_of_launch, genre,hasTeaser);

				}

			} catch (SQLException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			} finally {

				try {

					con.close();

				} catch (SQLException e) {

					// TODO Auto-generated catch block

					e.printStackTrace();

				}

			}

		}

		return movie;

	}

}