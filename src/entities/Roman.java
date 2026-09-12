package entities;

public class Roman extends Livre {
    private String prixLitteraire;

    public Roman(String titre, String auteur, int nbPages, String prixLitteraire) {
        super(titre, auteur, nbPages);
        this.prixLitteraire = prixLitteraire;
    }

    public String getPrixLitteraire() {
        return prixLitteraire;
    }

    public void setPrixLitteraire(String prixLitteraire) {
        this.prixLitteraire = prixLitteraire;
    }

    @Override
    public String toString() {
        return super.toString() + " [Roman - Prix: " + prixLitteraire + "]";
    }
}