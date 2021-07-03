package com.skilldistillery.film.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public class FilmDAO implements FilmAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";
	private String user = "student";
	private String pass = "student";
	private Film film;

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Film findFilmById(int filmId) throws SQLException {
		Film film = new Film();
		Connection conn = DriverManager.getConnection(URL, user, pass);
		String sql = "SELECT * FROM film WHERE film.id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmId);
		ResultSet filmResult = stmt.executeQuery();

		if (filmResult.next()) {
			int id = filmResult.getInt(1);
			String title = filmResult.getString(2);
			String desc = filmResult.getString(3);
			String releaseYear = filmResult.getString(4);
			String language = findLanguageByFilmId(filmId);
			int rentDur = filmResult.getInt(6);
			double rate = filmResult.getDouble(7);
			String length = filmResult.getString(8);
			double repCost = filmResult.getDouble(9);
			String rating = filmResult.getString(10);
			String features = filmResult.getString(11);
			List<Actor> actors = findActorsByFilmId(filmId);
			film = new Film(id, title, desc, releaseYear, language, rentDur, rate, length, repCost, rating, features,
					actors);
		}
		filmResult.close();
		stmt.close();
		conn.close();
		return film;
	}

	public List<Film> findFilmByKeyword(String keyword) throws SQLException {
		List<Film> films = new ArrayList<>();
		Connection conn = DriverManager.getConnection(URL, user, pass);
		String sql = "SELECT * FROM film WHERE film.title LIKE ? OR film.description LIKE ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, "%" + keyword + "%");
		stmt.setString(2, "%" + keyword + "%");
		ResultSet filmResult = stmt.executeQuery();

		while (filmResult.next()) {
			int id = filmResult.getInt(1);
			String title = filmResult.getString(2);
			String desc = filmResult.getString(3);
			String releaseYear = filmResult.getString(4);
			String language = findLanguageByFilmId(id);
			int rentDur = filmResult.getInt(6);
			double rate = filmResult.getDouble(7);
			String length = filmResult.getString(8);
			double repCost = filmResult.getDouble(9);
			String rating = filmResult.getString(10);
			String features = filmResult.getString(11);
			List<Actor> actors = findActorsByFilmId(id);
			film = new Film(id, title, desc, releaseYear, language, rentDur, rate, length, repCost, rating, features,
					actors);
			films.add(film);
		}
		filmResult.close();
		stmt.close();
		conn.close();
		return films;
	}

	public Actor findActorById(int actorId) throws SQLException {
		Actor actor = null;
		Connection conn = DriverManager.getConnection(URL, user, pass);
		// ...
		String sql = "SELECT id, first_name, last_name FROM actor WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, actorId);
		ResultSet actorResult = stmt.executeQuery();
		if (actorResult.next()) {
			actor = new Actor();
			actor.setId(actorResult.getInt(1));
			actor.setFirstName(actorResult.getString(2));
			actor.setLastName(actorResult.getString(3));
		}
		return actor;
	}

	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actors = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT actor.id, actor.first_name, actor.last_name "
					+ " FROM actor JOIN film_actor ON actor.id = film_actor.actor_id JOIN film ON film_actor.film_id = film.id "
					+ " WHERE film.id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int actorId = rs.getInt(1);
				String fName = rs.getString(2);
				String lName = rs.getString(3);

				Actor actor = new Actor(actorId, fName, lName);
				actors.add(actor);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actors;
	}

	public String findLanguageByFilmId(int filmId) {
		String language = "";
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT language.name " + " FROM language JOIN film ON language.id = film.language_id "
					+ " WHERE film.id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next())
				language = rs.getString(1);

			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return language;
	}

	public Film createFilm(Film film) throws SQLException {
		String sql = "INSERT INTO film (title, description, release_year, language_id, " + " rental_duration,"
				+ " rental_rate, length, replacement_cost, rating, " + "special_features) "
				+ " VALUES (?, ?, ?, 1, ?, ?, ?, ?, 'PG', 'Trailers')";

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false); // Start transaction
			PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setString(1, film.getTitle());
			st.setString(2, film.getDesc());
			st.setString(3, film.getReleaseYear());
			st.setInt(4, film.getRentalDuration());
			st.setDouble(5, film.getRentalRate());
			st.setString(6, film.getLength());
			st.setDouble(7, film.getReplaceCost());
//			st.setString(9, film.getRating());
//			st.setString(10, film.getSpecialFeatures());
			int uc = st.executeUpdate();
//			System.out.println(uc + " film record created.");
			if (uc != 1) {
				System.err.println("Error!!");
				conn.rollback();
				return null;
			}
			// Now get the auto-generated actor ID:
			ResultSet keys = st.getGeneratedKeys();
			int filmId = 0;
			if (keys.next()) {
				filmId = keys.getInt(1);
//				System.out.println("New film ID: " + filmId);
			}
			film.setId(filmId);
			conn.commit();
			st.close();
			conn.close();
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
		}
		return film;
	}

	public void deleteFilmByID(int filmID) throws SQLException {
		String sql = "DELETE FROM film WHERE film.id = ? ";

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false); // Start transaction
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, filmID);
			
			int uc = st.executeUpdate();
			System.out.println(uc + " film record deleted.");
			if (uc != 1) {
				System.err.println("Record could not be deleted!");
				conn.rollback();
			}
			else {
				System.out.println("Record has been deleted.");
			}
			
			conn.commit();
			st.close();
			conn.close();
		} catch (SQLException e) {
			conn.rollback();
			System.err.println("Record could not be deleted!");
			e.printStackTrace();
		}
	}
	public void updateFilmByID(int filmID, String title, String desc, String releaseYear, int langID, 
			int rentDur, double rentRate, int length, double repCost) throws SQLException {
		String sql = "UPDATE film SET title=?, description=?, release_year=?, language_id=?, "
				+ " rental_duration=?,"+" rental_rate=?, length=?, replacement_cost=? "
				+ " WHERE film.id=? ";
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false); // Start transaction
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, title);
			st.setString(2, desc);
			st.setString(3, releaseYear);
			st.setInt(4, langID);
			st.setInt(5, rentDur);
			st.setDouble(6, rentRate);
			st.setInt(7, length);
			st.setDouble(8, repCost);
			st.setInt(9, filmID);
			
			int uc = st.executeUpdate();
			System.out.println(uc + " film record updated.");
			if (uc != 1) {
				System.err.println("Record could not be updated!");
				conn.rollback();
			}
			else {
				System.out.println("Record has been updated.");
			}
			
			conn.commit();
			st.close();
			conn.close();
		} catch (SQLException e) {
			conn.rollback();
			System.err.println("Record could not be deleted!");
			e.printStackTrace();
		}
	}
}
