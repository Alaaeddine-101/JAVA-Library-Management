package dao;

import java.io.File;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Emprunt;
import beans.Livre;

public class EmpruntDao {
	
	public static ArrayList<Emprunt> listerEmp() throws ClassNotFoundException, SQLException {
		ArrayList<Emprunt> empruntSet = new ArrayList<Emprunt>() ;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblio", "root", "");
		Statement st = conn.createStatement();
		String query = "select * from emprunt";
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			empruntSet.add(new Emprunt(rs.getInt(0), rs.getInt(1),rs.getInt(2), rs.getString(3)));
		}
		conn.close();
		return empruntSet;
		
	}
	
	
	 public static int nombre_emprunt(int num_etd) throws ClassNotFoundException, SQLException {
		 int nb = 0;
		 ArrayList<Emprunt> liste = listerEmp();
		 for (Emprunt emprunt : liste) {
			if(emprunt.getNum_etud() == num_etd) {
				nb++;
			}
		}
		return nb;
	 }
	 public static void liste_emp_etd(int num_etd) throws ClassNotFoundException, SQLException {
		 ArrayList<Emprunt> liste = listerEmp();
		 for (Emprunt emprunt : liste) {
			if(emprunt.getNum_etud() == num_etd) {
				System.out.println(emprunt);
			}
		}
	 }
	 
	 public static boolean not_duplicate(int num_etd, int num_livre) throws ClassNotFoundException, SQLException {
		 boolean deplicate = false;
		 ArrayList<Emprunt> liste = listerEmp();
		 for (Emprunt emprunt : liste) {
			if(emprunt.getNum_etud() == num_etd) {
				if(emprunt.getNum_livre() == num_livre) {
					deplicate = true;
				}
			}
		}
		 return deplicate;
	 }
	 public static void remise(int num_etd, int num_livre) throws SQLException, ClassNotFoundException {
		 Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblio", "root", "");
			Statement st = conn.createStatement();
			String query = "update emprunt set remise = true where num_etd ='" + num_etd + "' and num_emp'" + num_livre;
			int rs = st.executeUpdate(query);
	 }
	 public static void nvEmprunt(int num_etd, int num_livre, String date) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblio", "root", "");
		Statement st = conn.createStatement();
		String query = "insert into emprunt values ( '" + num_etd + "', '" + num_livre + "', '" + date + "')";
		int rs = st.executeUpdate(query);
		 
	 }
	 
	 public static void enregistreCSVEmprunt(String nomRep) throws ClassNotFoundException, SQLException{
			File f = new File(nomRep + "\\livres.csv");
			ArrayList<Emprunt> liste = listerEmp();
			if(f.exists()) {
	  			System.out.println("Le fichier existe deja, veuillez le supprimer avant !!" );
	  		}else {
				try {
				  	PrintWriter out = new PrintWriter(f);
				  	for (Emprunt e : liste) {
						out.println(e);
					}
				  	out.close();
				  	
				}catch(Exception e) {
					e.printStackTrace();
				}
	  		}
		}

}
