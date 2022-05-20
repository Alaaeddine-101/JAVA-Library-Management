import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import beans.Etudiant;
import beans.Livre;
import view.Menu;

public class Main {

	public static void main(String[] args) throws Exception {
		
		int choix;
		while(true) {
			 choix = Menu.menu();
			if(choix == 6) {
				System.out.println("Au revoir!!\n");
				break;
			}
			switch (choix) {
			
			case 1: {
				int choix1;
				while(true) {
					 choix1 = Menu.menu1();
					if(choix1 == 6) {
						
						break;
					}
					switch (choix1) {
					
					case 1: {
						ArrayList<Livre> liste = dao.LivreDao.listerL();
						System.out.println("\t\tLa liste des livres : ");
						for (Livre l : liste) {
							System.out.println(l);
						}
						System.out.println("--------------------------------------------------------\n");
						break;
					}
					
					case 2: {
						
						break;
					}
					
					case 3: {
						System.out.println("\t\tEntrer les informations du livre : ");
						Livre l = dao.LivreDao.readLivre();
						dao.LivreDao.ajouterLivre(l);;
						break;
					}
					
					case 4: {
						int choix2;
						while(true) {
							 choix2 = Menu.menu1_1();
							if(choix2 == 4) {
								
								break;
							}
							switch (choix2) {
								case 1: {
									
									break;
								}
								case 2: {
									
									break;
								}
								case 3: {
									
									break;
								}
								
								default : {
									System.out.println("votre choix est invalide, essayer une autre fois\n");
									break;
								}
							}
						}
						break;
					}
					
					case 5: {
						Scanner sc = new Scanner(System.in);
						System.out.println("Entrer le titre du livre :");
						String titre = sc.nextLine();
						dao.LivreDao.supprimerLivre(titre);
						sc.close();
						break;
					}
					
					default : {
						System.out.println("votre choix est invalide, essayer une autre fois\n");
						break;
					}
				  }
				}
				break;
			}
			
			case 2: {
				int choix2;
				while(true) {
					 choix2 = Menu.menu2();
					if(choix2 == 5) {
						
						break;
					}
					switch (choix2) {
					
					case 1: {
						ArrayList<Etudiant> liste = dao.EtudiantDao.listerE();
						System.out.println("\t\tLa liste des etudiants : ");
						for (Etudiant e : liste) {
							System.out.println(e);
						}
						System.out.println("--------------------------------------------------------\n");
						break;
					}
					
					case 2: {
						
						break;
					}
					
					case 3: {
						System.out.println("\t\tEntrer les informations d'etudiant : ");
						Etudiant e = dao.EtudiantDao.readEtudiant();
						dao.EtudiantDao.ajouterEtudiant(e);;
						break;
					}
					
					case 4: {
						Scanner sc = new Scanner(System.in);
						System.out.println("Entrer le cin de l'etudiant :");
						int cin = sc.nextInt();
						sc.nextLine();
						dao.EtudiantDao.supprimerEtudiant(cin);
						sc.close();	
						break;
					}
					
					default : {
						System.out.println("votre choix est invalide, essayer une autre fois\n");
						break;
					}
				  }
				}
				break;
			}
			
			case 3: {
				ArrayList<Livre> listeL = dao.LivreDao.listerL();
				System.out.println("\t\tLa liste des livres : ");
				for (Livre l : listeL) {
					System.out.println(l);
				}
				System.out.println("--------------------------------------------------------\n");
				Scanner sc = new Scanner(System.in);
				System.out.println("Entrer le numero du livre a emprunter :");
				int num_livre = sc.nextInt();
				sc.nextLine();
				
				
				ArrayList<Etudiant> listeE = dao.EtudiantDao.listerE();
				System.out.println("\t\tLa liste des etudiants : ");
				for (Etudiant e : listeE) {
					System.out.println(e);
				}
				System.out.println("--------------------------------------------------------\n");
				System.out.println("Entrer le nemuero de l'etudiant :");
				int num_etd = sc.nextInt();
				sc.nextLine();
				if(dao.EmpruntDao.nombre_emprunt(num_etd) < 3) {
					if(dao.LivreDao.is_dispo(num_livre)) {
						if(dao.EmpruntDao.not_duplicate(num_etd ,num_livre)) {
							System.out.println("Entrer la date de l'emprunt :");
							String date  = sc.nextLine();
							dao.EmpruntDao.nvEmprunt(num_etd, num_livre, date);
						}else {
						System.out.println("vous avez deja emprunte ce livre!!");	
						}
					}else {
						System.out.println("Ce livre n'est pas desponible pour le moment!!");
					}
				}else {
					System.out.println("Tu ne peux pas enprunter plus de 3 livres!!");
				}
				break;
			}
			
			case 4: {
				ArrayList<Etudiant> listeE = dao.EtudiantDao.listerE();
				System.out.println("\t\tLa liste des etudiants : ");
				for (Etudiant e : listeE) {
					System.out.println(e);
				}
				System.out.println("--------------------------------------------------------\n");
				System.out.println("Entrer le nemuero de l'etudiant :");
				Scanner sc = new Scanner(System.in);
				int num_etd = sc.nextInt();
				sc.nextLine();
				System.out.println("\t\tLa liste des emprunts par l'etudiant : ");
				dao.EmpruntDao.liste_emp_etd(num_etd);
				System.out.println("--------------------------------------------------------\n");
				System.out.println("Entrer le nemuero de l'etudiant :");
				int num_emp = sc.nextInt();
				sc.nextLine();
				break;
			}
			
			case 5: {
				Scanner sc = new Scanner(System.in);
				System.out.println("Entrer le repertoire dans le quelle vous voulez placez les fichiers :");
				String  rep = sc.nextLine();
				dao.LivreDao.enregistreCSVLivre(rep);
				dao.EmpruntDao.enregistreCSVEmprunt(rep);
				dao.EtudiantDao.enregistreCSVEtudiant(rep);
				break;
			}
			
			default : {
				System.out.println("votre choix est invalide, essayer une autre fois\n");
				break;
			}
		  }
		}
	}

}
