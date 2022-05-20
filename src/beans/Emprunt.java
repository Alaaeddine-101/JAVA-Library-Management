package beans;

public class Emprunt {
	private int num_emprunt;
	private int num_etud, num_livre;
	private String date_emp;
	
	public Emprunt(int num, int num_etud, int num_livre, String date_emp) {
		super();
		this.num_emprunt = num;
		this.num_etud = num_etud;
		this.num_livre = num_livre;
		this.date_emp = date_emp;
	}

	public int getNum_emprunt() {
		return num_emprunt;
	}

	public void setNum_emprunt(int num_emprunt) {
		this.num_emprunt = num_emprunt;
	}

	public int getNum_etud() {
		return num_etud;
	}

	public void setNum_etud(int num_etud) {
		this.num_etud = num_etud;
	}

	public int getNum_livre() {
		return num_livre;
	}

	public void setNum_livre(int num_livre) {
		this.num_livre = num_livre;
	}

	public String getDate_emp() {
		return date_emp;
	}

	public void setDate_emp(String date_emp) {
		this.date_emp = date_emp;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return num_emprunt + " : " + num_etud + " - " + num_livre + " - " + date_emp + ";";
	}
}
