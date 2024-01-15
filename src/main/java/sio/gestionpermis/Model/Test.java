package sio.gestionpermis.Model;

public class Test
{
    private String nomTest;
    private int nbFautes;
    private boolean estTermine;

    public Test(String nomTest, int nbFautes, boolean estTermine) {
        this.nomTest = nomTest;
        this.nbFautes = nbFautes;
        this.estTermine = estTermine;
    }

    public String getNomTest() {
        return nomTest;
    }

    public int getNbFautes() {
        return nbFautes;
    }

    public boolean isEstTermine() {
        return estTermine;
    }

    public void setEstTermine(boolean estTermine) {
        this.estTermine = estTermine;
    }

    public void setNbFautes(int nbFautes) {
        this.nbFautes = nbFautes;
    }

}
