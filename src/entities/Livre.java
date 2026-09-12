package entities;

public class Livre extends Document {
    private String auteur;
    private int nbPages;

    public Livre(String titre, String auteur, int nbPages) {
        super(titre);
        this.auteur = auteur;
        this.nbPages = nbPages;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public int getNbPages() {
        return nbPages;
    }

    public void setNbPages(int nbPages) {
        this.nbPages = nbPages;
    }

    @Override
    public String toString() {
        return super.toString() + " [Livre - Auteur: " + auteur + ", Pages: " + nbPages + "]";
    }
}