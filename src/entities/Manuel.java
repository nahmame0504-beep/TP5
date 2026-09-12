package entities;

public class Manuel extends Livre {
    private String niveauScolaire;

    public Manuel(String titre, String auteur, int nbPages, String niveauScolaire) {
        super(titre, auteur, nbPages);
        this.niveauScolaire = niveauScolaire;
    }

    public String getNiveauScolaire() {
        return niveauScolaire;
    }

    public void setNiveauScolaire(String niveauScolaire) {
        this.niveauScolaire = niveauScolaire;
    }

    @Override
    public String toString() {
        return super.toString() + " [Manuel - Niveau: " + niveauScolaire + "]";
    }
}