package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import classes.Argument.Type1;
import classes.Argument.Type2;
import exceptions.LenghtArgumentException;
import exceptions.NameException;

public class ConnectionBD {
	
	private Connection conn; 
	
	
	/**
	 * Constructor of this class
	 */
	public ConnectionBD() {
		
		this.conn = null;

		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/diogenes"
					,"root","1234");
		} catch (Exception e) {
			System.err.println("La conexion a bd ha fallado");
		}
		
	}
	

	/**
	 * Function that saves a game
	 * @param game
	 */
	public void saveGame(Game game) {
		try {
			
			deleteTable("Argument");
			deleteTable("Message");
			deleteTable("Actions");
			deleteTable("Game");
			deleteTable("Philosopher");
			
			insertPhilosopher(game.getCharacter());
		
			insertGame(game, game.getCharacter());
			for (int i = 0; i <game.getStory().size(); i++) {
				Actions act = game.getStory().get(i);
				insertActions(act, i);
			}
			 
			

		} catch (SQLException ex) {

			System.err.println("SQL exception");
			ex.printStackTrace();       
		}

	}
	
	
	/**
	 * Function that inserts a philosopher in the DB
	 * @param philo
	 * @throws SQLException
	 */
	
	private void insertPhilosopher(Philosopher philo) throws SQLException {

		Statement registerStatement = conn.createStatement();
		registerStatement.executeUpdate(
				"insert into Philosopher (name,timesLost) values('" + philo.getName() + "',"
						+ "'" + philo.getTimesLost() + "')");
		
		for (int i = 0; i < philo.getArguments().size(); i++) {
			
			Argument arg = philo.getArguments().get(i);
			insertArgument(arg, philo);
			
		}
	
	}
	
	/**Function that inserts an argument in the DB
	 * 
	 * @param arg
	 * @param phi
	 * @throws SQLException
	 */
	private void insertArgument(Argument arg, Philosopher phi) throws SQLException {

		Statement registerStatement = conn.createStatement();
		registerStatement.executeUpdate(
			"insert into Argument (weapon,text,strength,timesLost,type1,type2,philosopher_name) values('" + arg.getWeapon() + "',"
				+ "'" + arg.getText() + "',"
				+ "'" + arg.getStrength()+ "',"
				+ "'" +arg.getTimesLost()+ "',"
				+ "'" +arg.getType1()+ "',"
				+ "'" +arg.getType2()+ "',"
				+ "'" +phi.getName()+ "')");

	}
	
	
	/**
	 * Function that inserts a game in the DB
	 * @param gm
	 * @param phi
	 * @throws SQLException
	 */
	private void insertGame(Game gm, Philosopher phi) throws SQLException {
		
		String command = 
				"insert into Game (Game.index,Philosopher_name) values("
						+ "'" + gm.getIndex() + "',"
						+ "'" + phi.getName()+  "')";
		System.out.println(command);
		Statement registerStatement = conn.createStatement();
		registerStatement.executeUpdate(command);
	}
	
	/**
	 * Function that inserts an actions in the DB
	 * @param action
	 * @param index
	 * @throws SQLException
	 */
	private void insertActions(Actions action, int index) throws SQLException {
		Statement registerStatement = conn.createStatement();
		Boolean bool = true;

		if (action instanceof Sequence ) {
			Sequence seq = (Sequence) action;
			
			registerStatement.executeUpdate(
					"insert into Actions (tipo,action_index) values('" + (bool ? 1 : 0) + "',"
							+ "'"+index + "')");
			for (int i = 0; i < seq.getMessages().size(); i++) {
				Message mesg = seq.getMessages().get(i);
				insertMessage(index,mesg);
			}
			 
			
		} else if(action instanceof Fight){
			Fight fig = (Fight) action;
			bool = false;
			insertPhilosopher(fig.getPhilosopher());
			registerStatement.executeUpdate(
					"insert into Actions (tipo,Philosopher_name, action_index) values('" + (bool ? 1 : 0) + "',"
							+ "'" +fig.getPhilosopher().getName() + "',"
									+ "'" +index + "')");			
		}		
	}
	
	/**
	 * Function that inserts a message in the DB	
	 * @param action
	 * @param ms
	 * @throws SQLException
	 */
	private void insertMessage(int action, Message ms) throws SQLException {
		Statement registerStatement = conn.createStatement();
	
		registerStatement.executeUpdate(
				"insert into Message (link,txt, Actions_action_index) values('" + ms.getLink() + "',"
						+ "'" + ms.getLink() + "',"
								+ "'" +action+ "')");	
	}
	
	
	/**
	 * Function that returns a game witch is going to be load
	 * @return game
	 */
	public Game loadGame() {
		Game game = new Game();
		
		try {
			Statement loadStatement = conn.createStatement();
			ResultSet query = loadStatement.executeQuery(
					"select * from Game where Philosopher_name = 'Diogenes' ");
			query.next();
			int index = query.getInt("Game.index");
			game.setIndex(index);
			
			String name = query.getString("Philosopher_name");
			
			game.setCharacter(getMainCharacterQuery(name));
			
			ArrayList<Actions> story = loadStory();
			for (int i = 0; i < story.size(); i++) {
				game.getStory().add(story.get(i));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LenghtArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return game;
	}
	
	
	/**
	 * Function that gets a MainCharacter from the DB
	 * @param name
	 * @return
	 * @throws SQLException
	 * @throws LenghtArgumentException
	 * @throws NameException
	 */
	public MainCharacter getMainCharacterQuery(String name) throws SQLException, LenghtArgumentException, NameException {
		
		MainCharacter ph = new MainCharacter();
		Statement loadStatement = conn.createStatement();
		ResultSet query = loadStatement.executeQuery(
				"select * from Philosopher where name = '" + name  + "'");
		query.next();
		int timesLost = query.getInt("timesLost");
		
		 ph.setArguments(getArgument(name));
		 ph.setTimesLost(timesLost);
		 ph.setName(name);

		return ph;
	}
	
	/**
	 * Function that gets a Philosopher from the DB
	 * @param name
	 * @return
	 * @throws SQLException
	 * @throws LenghtArgumentException
	 * @throws NameException
	 */
	public Philosopher getPhilosopherQuery(String name) throws SQLException, LenghtArgumentException, NameException {
		
		Philosopher ph = new Philosopher();
		Statement loadStatement = conn.createStatement();
		ResultSet query = loadStatement.executeQuery(
				"select * from Philosopher where name = '" + name  + "'");
		query.next();
		int timesLost = query.getInt("timesLost");
		
		 ph.setArguments(getArgument(name));
		 ph.setTimesLost(timesLost);
		 ph.setName(name);

		return ph;
	}
	
	
	/**
	 * Function that gets an ArrayList if Arguments from the DB
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Argument> getArgument(String name) throws SQLException {
		ArrayList<Argument> list = new ArrayList<Argument>();
		
		Statement loadStatement = conn.createStatement();
		ResultSet query = loadStatement.executeQuery(
				"select * from Argument where Philosopher_name = '" + name  + "'");
		while (query.next()) {
			Argument arg = new Argument();
			
			String weapon = query.getString("weapon");
			String text = query.getString("text");
			int strength = query.getInt("strength");
			int timesLost = query.getInt("timesLost");
			String type1 = query.getString("type1");
			String type2 = query.getString("type2");

			arg.setStrength((byte)strength);
			arg.setType1(Type1.valueOf(type1));
			arg.setType2(Type2.valueOf(type2));
			arg.setTimesLost(timesLost);
			arg.setWeapon(weapon);
			arg.setText(text);
			
			list.add(arg);
		}
		
		return list;
	}
	
	
	/**
	 * Function that gets an Array of Actions from the DB
	 * @return
	 * @throws SQLException
	 * @throws LenghtArgumentException
	 * @throws NameException
	 */
	public ArrayList<Actions> loadStory() throws SQLException, LenghtArgumentException, NameException {
		
		ArrayList<Actions> list = new ArrayList<Actions>();
		
		Statement loadStatement = conn.createStatement();
		ResultSet query = loadStatement.executeQuery(
				"select * from Actions order by action_index");
		while (query.next()) {

			Actions act = null;
			
			if (query.getInt("tipo") == 0) {
				Fight fight = new Fight();	
				String name = query.getString("Philosopher_name");
				fight.setPhilosopher( getPhilosopherQuery(name));
				act = fight;
				
				
			}
			else {
				int index = query.getInt("action_index");
				Sequence seq = new Sequence();
				ArrayList <Message> mess = messageQuery(index);
				act = seq;
			}

			list.add(act);
		}
		return list;
	}
	
	/**
	 * Function that gets an Array of Messages from the DB
	 * @param index
	 * @return
	 * @throws SQLException
	 */
	public ArrayList <Message> messageQuery(int index) throws SQLException{
		
		ArrayList <Message> mess = new ArrayList<Message>();
		
		Statement loadStatement = conn.createStatement();
		ResultSet query = loadStatement.executeQuery(
				"select * from Message where Actions_action_index = '" + index  + "'");
		while (query.next()) {
			Message arg = new Message();
			
			String link = query.getString("link");
			String text = query.getString("txt");
			

			arg.setLink(link);;
			arg.setTxt(text);
			
			mess.add(arg);
		}
		
		return mess;
	}
	
	/**
	 * Function that delete a table
	 * @param tableName
	 * @throws SQLException
	 */
	
	private void deleteTable(String tableName) throws SQLException {

		Statement deleteStatement = conn.createStatement();
		deleteStatement.executeUpdate("delete from " + tableName);
		
	}
	
	/**
	 * This function delete the row times lost
	 * @throws SQLException
	 */
	
	public void deleteTimesLost() throws SQLException {
		
		Statement deleteStatement = conn.createStatement();
		deleteStatement.executeUpdate("delete from philosopher where timesLost >0;");
		
	}
}



