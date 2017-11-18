package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Editorial;

public class EditorialDAOImpl implements EditorialDAO {
	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	public EditorialDAOImpl() {
		getConnetion();
	}
	
	public Connection getConnetion() {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/testdb", "postgres", "juanmeme");
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	@Override
	public void createEditorial(Editorial editorial) {
		try {
		if(connection != null) {
			preparedStatement = connection.prepareStatement("INSERT INTO editoriales (nombre, email,"
									+ "pais,tipo)values (?,?,?,?);");
			preparedStatement.setString(1,editorial.getNombre() );
			preparedStatement.setString(2,editorial.getEmail() );
			preparedStatement.setString(3,editorial.getPais());
			preparedStatement.setString(4,editorial.getTipo());
			preparedStatement.execute();
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Editorial readEditorial(Long id) {
		Editorial editorial = null;
		try {
			if(connection != null) {
				preparedStatement = connection.prepareStatement("SELECT id, nombre, email, pais, tipo FROM editoriales WHERE id=?");
				
				preparedStatement.setLong(1, id);
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {
					editorial = new Editorial(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3),
											resultSet.getString(4),resultSet.getString(5));
				}
				
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return editorial;
	}

	@Override
	public List<Editorial> readAllEditoriales() {
		List<Editorial> editorial = new ArrayList<Editorial>();
		try {
		
				preparedStatement = connection.prepareStatement("SELECT id, nombre, email, pais, tipo FROM editoriales");
				resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					Editorial Editorial = new Editorial(
									resultSet.getLong(1), 
									resultSet.getString(2), 
									resultSet.getString(3),
									resultSet.getString(4),
									resultSet.getString(5));
					editorial.add(Editorial);
				}
				
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return editorial;
	}

	@Override
	public void updateEditorial(Editorial editorial) {
		try {
			if(connection != null) {
				preparedStatement = connection.prepareStatement("UPDATE editoriales SET nombre=?, "
											+ "email=?,"
										+ "pais=?, tipo=? WHERE id=?;");
				preparedStatement.setString(1,editorial.getNombre() );
				preparedStatement.setString(2,editorial.getEmail() );
				preparedStatement.setString(3,editorial.getPais());
				preparedStatement.setString(4,editorial.getTipo());
				preparedStatement.setLong(5, editorial.getId());
				preparedStatement.execute();
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		
	}

	@Override
	public void deleteEditorial(Long id) {
		if(connection!=null) {
			try {
				preparedStatement = connection.prepareStatement("DELETE FROM editoriales WHERE id=?;");
				preparedStatement.setLong(1, id);
				preparedStatement.execute();
				
			}catch(SQLException e){
				e.printStackTrace();
				
			}
		}
		
	}
	
	

}
