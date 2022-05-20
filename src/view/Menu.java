package view;

import java.util.Scanner;

	public class Menu {
		public static int menu() {
			System.out.println("\n# MENU #\n");
			System.out.println("\t 1- 	Gerer les livres\n");
			System.out.println("\t 2- 	Gerer les etudiants\n");
			System.out.println("\t 3- 	Emprunter un livre\n");
			System.out.println("\t 4- 	Remettre un livre\n");
			System.out.println("\t 5-	Enregistrer les données dans des fichiers CSV\n");
			System.out.println("\n\t 6-    Quitter l'application\n");
			
			System.out.println("Quel est votre choix :");
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			sc.nextLine();
			
			return n;
			
		}
		
		
		public static int menu1() {
			System.out.println("\n# MENU 1 #\n");
			System.out.println("\t 1- 	Lister les livres\n");
			System.out.println("\t 2- 	Alimenter le stock d’un livre\n");
			System.out.println("\t 3- 	Ajouter un livre\n");
			System.out.println("\t 4- 	Modifier un livre \n");
			System.out.println("\t 5-	Supprimer un livre\n");
			System.out.println("\n\t 6-    retour au menu principale\n");
			
			System.out.println("Quel est votre choix :");
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			sc.nextLine();
			
			return n;
			
		}
		
				public static int menu1_1() {
					System.out.println("\n# MENU 1 #\n");
					System.out.println("\t 1- 	Modifier Par Titre\n");
					System.out.println("\t 2- 	Modifier Par Date\n");
					System.out.println("\t 3- 	Modifier Par Numero d'Edition\n");
					System.out.println("\t\t 4- 	Retour au menu \n");
					
					System.out.println("Quel est votre choix :");
					Scanner sc = new Scanner(System.in);
					int n = sc.nextInt();
					sc.nextLine();
					
					return n;
				}
		
		public static int menu2() {
			System.out.println("\n# MENU 2 #\n");
			System.out.println("\t 1- 	Lister les étudiants\n");
			System.out.println("\t 2- 	Ajouter un étudiant\n");
			System.out.println("\t 3- 	Modifier un étudiant\n");
			System.out.println("\t 4- 	Supprimer un étudiant\n");
			
			System.out.println("\n\t 5-    retour au menu principale\n");
			
			System.out.println("Quel est votre choix :");
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			sc.nextLine();
			
			return n;
			
		}
		
}
	

