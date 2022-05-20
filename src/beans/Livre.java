package beans;

public class Livre {
	private int numero;
	private String titre,date;
	private int num_edition,stock;
	
	public Livre(int num , String titre, String date, int num_edition, int stock) {
		super();
		this.numero = num;
		this.titre = titre;
		this.date = date;
		this.num_edition = num_edition;
		this.stock = stock;
	}

	public void setNumero(int num) {
		this.numero = num;
	}

	public int getNumero() {
		return numero;
	}
	
	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getNum_edition() {
		return num_edition;
	}

	public void setNum_edition(int num_edition) {
		this.num_edition = num_edition;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return numero + " : " + titre + " - " + date + " - " + num_edition + " - " + stock + " ;";
	}
	
}
