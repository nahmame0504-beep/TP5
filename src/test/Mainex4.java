package test;

import entities.*;
import java.util.Scanner;

public class Mainex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez la capacité maximale de la bibliothèque (n) : ");
        int n = scanner.nextInt();
        scanner.nextLine();

        Bibliotheque biblio = new Bibliotheque(n);

        // Initialisation avec deux documents
        Roman r1 = new Roman("L'Étranger", "Albert Camus", 185, "Prix Nobel");
        Dictionnaire d1 = new Dictionnaire("Larousse", "Français");
        
        biblio.ajouter(r1);
        biblio.ajouter(d1);
        System.out.println("Bibliothèque initialisée avec 2 documents.");

        int choix;
        do {
            System.out.println("\n========== MENU BIBLIOTHÈQUE ==========");
            System.out.println("1. Afficher tous les documents");
            System.out.println("2. Ajouter un document");
            System.out.println("3. Supprimer un document");
            System.out.println("4. Rechercher un document par N° d'enregistrement");
            System.out.println("5. Afficher la liste des auteurs");
            System.out.println("6. Quitter");
            System.out.print("Choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    biblio.afficherDocuments();
                    break;

                case 2:
                    System.out.println("\nTypes de document : 1- Roman, 2- Manuel, 3- Revue, 4- Dictionnaire");
                    System.out.print("Type : ");
                    int type = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Titre : ");
                    String titre = scanner.nextLine();

                    Document doc = null;

                    if (type == 1) {
                        System.out.print("Auteur : ");
                        String auteur = scanner.nextLine();
                        System.out.print("Pages : ");
                        int pages = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Prix littéraire : ");
                        String prix = scanner.nextLine();
                        doc = new Roman(titre, auteur, pages, prix);
                    } else if (type == 2) {
                        System.out.print("Auteur : ");
                        String auteur = scanner.nextLine();
                        System.out.print("Pages : ");
                        int pages = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Niveau scolaire : ");
                        String niveau = scanner.nextLine();
                        doc = new Manuel(titre, auteur, pages, niveau);
                    } else if (type == 3) {
                        System.out.print("Mois (1-12) : ");
                        int mois = scanner.nextInt();
                        System.out.print("Année : ");
                        int annee = scanner.nextInt();
                        scanner.nextLine();
                        doc = new Revue(titre, mois, annee);
                    } else if (type == 4) {
                        System.out.print("Langue : ");
                        String langue = scanner.nextLine();
                        doc = new Dictionnaire(titre, langue);
                    }

                    if (doc != null) {
                        if (biblio.ajouter(doc)) {
                            System.out.println("Document ajouté avec succès.");
                        } else {
                            System.out.println("Échec de l'ajout : la bibliothèque est pleine.");
                        }
                    } else {
                        System.out.println("Type invalide.");
                    }
                    break;

                case 3:
                    System.out.print("Numéro d'enregistrement du document à supprimer : ");
                    int numSuppr = scanner.nextInt();
                    scanner.nextLine();
                    Document docSuppr = biblio.document(numSuppr);
                    if (biblio.supprimer(docSuppr)) {
                        System.out.println("Document supprimé.");
                    } else {
                        System.out.println("Impossible de supprimer (document introuvable).");
                    }
                    break;

                case 4:
                    System.out.print("Numéro d'enregistrement recherché : ");
                    int numRech = scanner.nextInt();
                    scanner.nextLine();
                    Document docTrouve = biblio.document(numRech);
                    if (docTrouve != null) {
                        System.out.println("Trouvé : " + docTrouve);
                    } else {
                        System.out.println("Aucun document trouvé avec ce numéro.");
                    }
                    break;

                case 5:
                    biblio.afficherAuteurs();
                    break;

                case 6:
                    System.out.println("Fermeture du programme.");
                    break;

                default:
                    System.out.println("Option invalide.");
            }
        } while (choix != 6);

        scanner.close();
    }
}