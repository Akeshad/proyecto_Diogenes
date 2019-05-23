package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConnectionBD {

	public Connection connecting(){

		Connection conn = null;
		String url = "";
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://85.214.120.213:3306/pokemonbattle1dam"
					,"1dam","1dam");
		} catch (Exception e) {
			System.err.println("La conexion a bd ha fallado");
		}

		return conn;
	}

	public static void saveGame(Game game, Connection conn){
		try {

			/**
			 * Lo que tenemos que hacer ahora es guardar del juego el index y el mainCharacter
			 */
		
			//2 - Create an statement object and insert into pokemon table.  (you can skip id , as it is auto-incremented)
			Statement registerStatement = conn.createStatement();

			/**	boolean pokeGenreBoolean = true;
			if(pokemonGenre == 'm'||pokemonGenre == 'M'){
				pokeGenreBoolean = false;
			}

			registerStatement.executeUpdate("INSERT INTO pokemon "
					+ "(name, genre, description, type, species, level, lifePoints, xp) "
					+ "VALUES ('" + pokemonName + "', " + pokeGenreBoolean + ", '"
					+ description + "', '" + pokemonType + "', '" + pokemonSpecies + "', '"
					+ level + "', '" + lifePoints + "', '" + xp + "');");


			//3 - Query the newly created pokemon id (query max id from pokemon table)
			ResultSet querySelect = registerStatement.executeQuery("select max(ID) id from pokemon");
			querySelect.next();

			//4 - Create a java Pokemon object with the read data and the queried id
			int id2 = querySelect.getInt("id");
			Pokemon pokemon = new Pokemon (id2, pokemonName, pokemonGenre, description, pokemonType, lifePoints, pokemonSpecies);

			//5 - User setPokemon in User class to Link the pokemon to the user in java
			user.setPokemon(pokemon);

			//6 - Reuse Statement or create a new one to insert into pokemonUser table, where you link pokemon and user.
			String consultaInsertarPU = "INSERT INTO pokemonUser (user, pokemonId) "
					+ "VALUES ('" + user.getName() + "', '" + pokemon.getId() + "');";
			System.out.println(consultaInsertarPU);
			registerStatement.executeUpdate(consultaInsertarPU);
			registerStatement.close();

		} catch (InvalidGenreException ex) {

			System.err.println(ex.getMessage());
			registerPokemon(sc, conn, user);

			 **/
		} catch (SQLException ex) {

			System.err.println("SQL exception");
			ex.printStackTrace();       
		}

	}

}



