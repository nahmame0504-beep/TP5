package entities;

public class Bibliotheque {
    private Document[] documents;
    private int nbDocuments;

    public Bibliotheque(int capacite) {
        this.documents = new Document[capacite];
        this.nbDocuments = 0;
    }

    public void afficherDocuments() {
        if (nbDocuments == 0) {
            System.out.println("La bibliothèque est vide.");
            return;
        }
        System.out.println("\n--- Liste des documents (" + nbDocuments + "/" + documents.length + ") ---");
        for (int i = 0; i < nbDocuments; i++) {
            System.out.println(documents[i]);
        }
    }

    public boolean ajouter(Document doc) {
        if (nbDocuments < documents.length) {
            documents[nbDocuments++] = doc;
            return true;
        }
        return false;
    }

    public boolean supprimer(Document doc) {
        if (doc == null) return false;
        for (int i = 0; i < nbDocuments; i++) {
            if (documents[i].getNumEnreg() == doc.getNumEnreg()) {
                // Décalage pour combler le vide
                for (int j = i; j < nbDocuments - 1; j++) {
                    documents[j] = documents[j + 1];
                }
                documents[--nbDocuments] = null;
                return true;
            }
        }
        return false;
    }

    public Document document(int numEnrg) {
        for (int i = 0; i < nbDocuments; i++) {
            if (documents[i].getNumEnreg() == numEnrg) {
                return documents[i];
            }
        }
        return null;
    }

    public void afficherAuteurs() {
        System.out.println("\n--- Liste des auteurs ---");
        boolean trouve = false;
        for (int i = 0; i < nbDocuments; i++) {
            if (documents[i] instanceof Livre) {
                Livre livre = (Livre) documents[i];
                System.out.println("• " + livre.getAuteur() + " (Ouvrage : " + livre.getTitre() + ")");
                trouve = true;
            }
        }
        if (!trouve) {
            System.out.println("Aucun auteur trouvé.");
        }
    }
}