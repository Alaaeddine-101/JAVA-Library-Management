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

import beans.Etudiant;
import beans.Livre;

public class EtudiantDao {
	
	public static ArrayList<Etudiant> listerE() throws ClassNotFoundException, SQLException {
		ArrayList<Etudiant> EtudiantSet = new ArrayList<Etudiant>() ;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblio", "root", "");
		Statement st = conn.createStatement();
		String query = "select * from Etudiants";
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			EtudiantSet.add(new Etudiant(rs.getInt(0), rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
		}
		conn.close();
		return EtudiantSet;
		
	}
	
	
	
	public static void ajouterEtudiant(Etudiant e) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblio", "root", "");
		Statement st = conn.createStatement();
		String query = "insert into etudiants values (NULL, '" + e.getNom() + "', '" + e.getPrenom() + "', '" + e.getFiliere() +"', " + e.getCin() + ")";
		int rs = st.executeUpdate(query);
		conn.close();
	}
	public static void afficherEtudiant(Etudiant e) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblio", "root", "");
		Statement st = conn.createStatement();
		String query = "select * from etudiants where id =";
		int rs = st.executeUpdate(query);
		conn.close();
	}
	
	public static void modifierEtudiantNom( String ancNom, String nvNom) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblio", "root", "");
		Statement st = conn.createStatement();
		String query = "update etudiants set  nom = " + nvNom + " where nom = " + ancNom;
		int rs = st.executeUpdate(query);
		conn.close();
	}
	
	public static void modifierEtudiantPrenom(String ancPrenom, String nvPrenom) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblio", "root", "");
		Statement st = conn.createStatement();
		String query = "update etudiants set  prenom = " + nvPrenom + " where prenom = " + ancPrenom;
		int rs = st.executeUpdate(query);
		conn.close();
	}
	
	public static void modifierEtudiantFiliere(String ancFiliere, String nvFiliere) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblio", "root", "");
		Statement st = conn.createStatement();
		String query = "update etudiants set  filiere = " + nvFiliere + " where filiere = " + ancFiliere;
		int rs = st.executeUpdate(query);
		conn.close();
	}
	
	public static void modifierEtudiantCin(int ancCin, int nvCin) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblio", "root", "");
		Statement st = conn.createStatement();
		String query = "update etudiants set  cin = " + nvCin + " where cin = " + ancCin;
		int rs = st.executeUpdate(query);
		conn.close();
	}
	
	public static void supprimerEtudiant(int cin) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblio", "root", "");
		Statement st = conn.createStatement();
		String query = "delete from etudiants where cin = " + cin;
		int rs = st.executeUpdate(query);
		conn.close();
	}
	
	public static Etudiant  readEtudiant() throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n \t entrer le nom :");
		String nom = sc.nextLine();
		
		System.out.println("\n \t entrer le prenom :");
		String prenom = sc.nextLine();
		
		System.out.println("\n \t entrer la filiere :");
		String filiere = sc.nextLine();
		
		System.out.println("\n \t entre le cin :");
		int cin = sc.nextInt(); 
		sc.nextLine();
		
		return new Etudiant(0,nom, prenom, filiere, cin);
	}
	
	public static void enregistreCSVEtudiant(String nomRep) throws ClassNotFoundException, SQLException{
		File f = new File(nomRep + "\\etudiants.csv");
		ArrayList<Etudiant> liste = listerE();
		if(f.exists()) {
  			System.out.println("Le fichier existe deja, veuillez le supprimer avant !!" );
  		}else {
			try {
			  	PrintWriter out = new PrintWriter(f);
			  	for (Etudiant e : liste) {
					out.println(e);
				}
			  	out.close();
			  	
			}catch(Exception e) {
				e.printStackTrace();
			}
  		}
	}

}
