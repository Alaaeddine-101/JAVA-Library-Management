package dao;

import java.io.File;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;


import beans.Livre;

public class LivreDao {
	
	public static ArrayList<Livre> listerL() throws ClassNotFoundException, SQLException {
		ArrayList<Livre> livreSet = new ArrayList<Livre>() ;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblio", "root", "");
		Statement st = conn.createStatement();
		String query = "select * from livres";
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			livreSet.add(new Livre(rs.getInt(0),rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
		}
		conn.close();
		return livreSet;
		
	}
	
	public static void alimenterStock(String titre, int nvStock) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblio", "root", "");
		Statement st = conn.createStatement();
		String query = "update livres set  stock = " + nvStock + " where titre = " + titre;
		int rs = st.executeUpdate(query);
		conn.close();
	}
	
	public static void ajouterLivre(Livre l) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblio", "root", "");
		Statement st = conn.createStatement();
		String query = "insert into livres values (NULL,'" + l.getTitre() + "', '" + l.getDate() + "', "+ l.getNum_edition() + ", " + l.getStock() + ")";
		int rs = st.executeUpdate(query);
		conn.close();
	}
	
	public static void modifierLivreTitre( String ancTitre, String nvtitre) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblio", "root", "");
		Statement st = conn.createStatement();
		String query = "update livres set  titre = " + nvtitre + " where titre = " + ancTitre;
		int rs = st.executeUpdate(query);
		conn.close();
	}
	
	public static void modifierLivreDate(String ancDate, String nvDate) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblio", "root", "");
		Statement st = conn.createStatement();
		String query = "update livres set  date = " + nvDate + " where date = " + ancDate;
		int rs = st.executeUpdate(query);
		conn.close();
	}
	
	public static void modifierLivreNumEdition(int ancNumEdition, int nvNumEdition) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblio", "root", "");
		Statement st = conn.createStatement();
		String query = "update livres set  numEdition = " + nvNumEdition + " where numEdition = " + ancNumEdition;
		int rs = st.executeUpdate(query);
		conn.close();
	}
	
	public static void supprimerLivre(String titre) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblio", "root", "");
		Statement st = conn.createStatement();
		String query = "delete from livres where titre = " + titre;
		int rs = st.executeUpdate(query);
		
		conn.close();
	}
	
	public static Livre  readLivre() throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n \t entre le titre :");
		String titre = sc.nextLine();
		
		System.out.println("\n \t entre la date  [yyyy-MM-dd]:");
		String date = sc.nextLine();
		
		System.out.println("\n \t entre le numer d'edition :");
		int num_edition = sc.nextInt(); 
		sc.nextLine();
		
		return new Livre(0,titre, date, num_edition, 0);
	}
	
	public static boolean is_dispo(int num_livre) throws SQLException, ClassNotFoundException {
		boolean dispo = false;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblio", "root", "");
		Statement st = conn.createStatement();
		String query = "select stock from livre where num_livre = " + num_livre;
		int rs = st.executeUpdate(query);
		if(rs >= 1) {
			dispo = true;
		}
		conn.close();
		return dispo;
	}
	
	
	public static void enregistreCSVLivre(String nomRep) throws ClassNotFoundException, SQLException{
		File f = new File(nomRep + "\\livres.csv");
		ArrayList<Livre> liste = listerL();
		if(f.exists()) {
  			System.out.println("Le fichier existe deja, veuillez le supprimer avant !!" );
  		}else {
			try {
			  	PrintWriter out = new PrintWriter(f);
			  	for (Livre l : liste) {
					out.println(l);
				}
			  	out.close();
			  	
			}catch(Exception e) {
				e.printStackTrace();
			}
  		}
	}

}
