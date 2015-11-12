package bd;

import hexagone.Joueur;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class DB {

	private static Connection conn;
	String url = "jdbc:mysql://localhost:3306/hexagone";

	public DB() throws SQLException {
		this.conn = DriverManager.getConnection(url, "root", "");
	}

	public void insert_Joueur(int num, String nom, int score, int perdu,
			int actif, int idPartie) {

		PreparedStatement ps;
		try {
			ps = (PreparedStatement) conn
					.prepareStatement("INSERT INTO `hexagone`.`joueur` (`id`, `num`, `nom`, `score`, `perdu`, `actif`,`idPartie`) "
							+ "VALUES (?, ?, ?, ?, ?, ?,?)");
			ps.setString(1, null);
			ps.setInt(2, num);
			ps.setString(3, nom);
			ps.setInt(4, score);
			ps.setInt(5, perdu);
			ps.setInt(6, actif);
			ps.setInt(7, idPartie);
			
			ps.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public ResultSet getScore() {

		Statement statement;
		ResultSet resultats = null;
		try {
			statement = (Statement) conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			resultats = statement
					.executeQuery("SELECT * FROM `joueur` ORDER BY `score` DESC Limit 0 , 5");
		} catch (SQLException ex) {
			Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
		}
		return resultats;

	}

	public int getIdPartie() {

		int id = 0;

		Statement statement;
		ResultSet resultats = null;
		try {
			statement = (Statement) conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			resultats = statement
					.executeQuery("SELECT * FROM `partie` ORDER BY `datesave` DESC Limit 0 , 1");
		} catch (SQLException ex) {
			Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
		}

		try {
			while (resultats.next()) {
				id = resultats.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return id;
	}

	
	public ResultSet getPartie() {

		int id = 0;

		Statement statement;
		ResultSet resultats = null;
		try {
			statement = (Statement) conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			resultats = statement
					.executeQuery("SELECT * FROM `partie` ORDER BY `datesave` DESC Limit 0 , 1");
		} catch (SQLException ex) {
			Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
		}
		return resultats; 
	}
	
	
	public ResultSet getJoueurs() {

		int id = 0;

		Statement statement;
		ResultSet resultats = null;
		try {
			statement = (Statement) conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			resultats = statement
					.executeQuery("SELECT * FROM `joueur` where  `idPartie`="+this.getIdPartie()
							+ "");
		} catch (SQLException ex) {
			Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
		}
		return resultats; 
	}
	
	public ResultSet getHexagons() {

		int id = 0;

		Statement statement;
		ResultSet resultats = null;
		try {
			statement = (Statement) conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			resultats = statement
					.executeQuery("SELECT * FROM `hexagon` where `idPartie`="+this.getIdPartie()
							+ "");
		} catch (SQLException ex) {
			Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
		}
		return resultats; 
	}
	
	public void insert_Partie(int longjeu, int nbjoueur, int nbclick,
			int ptclickX, int ptclickY, int iteration, int nbhexagone) {

		PreparedStatement ps;
		try {
			ps = (PreparedStatement) conn
					.prepareStatement("INSERT INTO `partie`(`id`, `datesave`, `longjeu`, `nbjoueur`, `nbclick`, "
							+ "`ptclickX`, `ptclickY`, `iteration`, `nbhexagone`) "
							+ "VALUES (?, ?, ?, ?, ?, ?,?,?,?)");
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			
			ps.setString(1, null);
			ps.setString(2, dateFormat.format(cal.getTime()));
			ps.setInt(3, longjeu);
			ps.setInt(4, nbjoueur);
			ps.setInt(5, nbclick);
			ps.setInt(6, ptclickX);
			ps.setInt(7, ptclickY);
			ps.setInt(8, iteration);
			ps.setInt(9, nbhexagone);

			ps.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public void insert_Hexagone(int cenrtreX, int centreY,  int couleur, int numjoueur,
			int radius, int col, int row, int rotation, int sides, int idPartie) {

		PreparedStatement ps;
		try {
			ps = (PreparedStatement) conn
					.prepareStatement("INSERT INTO `hexagon`(`id` ,`cenrtreX`, `centreY`,`couleur`, `numjoueur`, "
							+ "`radius`, `col`, `row`, `rotation`, `sides`,  `idPartie`) "
							+ "VALUES (?, ?, ?, ?, ?, ?,?,?,?,?,?)");
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			Date date = new Date(0);
			
			ps.setString(1, null);
			ps.setInt(2, cenrtreX);
			ps.setInt(3, centreY);
			ps.setInt(4, couleur);
			ps.setInt(5, numjoueur);
			ps.setInt(6, radius);
			ps.setInt(7, col);
			ps.setInt(8, row);
			ps.setInt(9, rotation);
			ps.setInt(10, sides);
			ps.setInt(11, idPartie);

			ps.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
	
	
	

}
