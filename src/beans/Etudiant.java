package beans;

public class Etudiant {
	private int num_etd;
	private String nom, prenom, filiere;
	private int cin;
	
	public Etudiant(int num, String nom, String prenom, String filiere, int cin) {
		this.num_etd = num;
		this.nom = nom;
		this.prenom = prenom;
		this.filiere = filiere;
		this.cin = cin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getFiliere() {
		return filiere;
	}

	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}

	public int getCin() {
		return cin;
	}

	public void setCin(int cin) {
		this.cin = cin;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return num_etd + " : " + nom + " - " + prenom + " - " + filiere + " - " + cin + " ;";
	}
}
