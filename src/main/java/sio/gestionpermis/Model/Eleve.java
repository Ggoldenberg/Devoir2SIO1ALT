package sio.gestionpermis.Model;

import java.util.ArrayList;

public class Eleve
{
    private String nomEleve;
    private ArrayList<Test> lesTests;

    public Eleve(String nomEleve) {
        this.nomEleve = nomEleve;
        this.lesTests = new ArrayList<>();
    }

    public String getNomEleve() {
        return nomEleve;
    }

    public ArrayList<Test> getLesTests() {
        return lesTests;
    }

    public void ajouterTest(Test unTest)
    {
        lesTests.add(unTest);
    }

    // Cette méthode permet de vérifier si le test
    // dont le nom passé en paramètre est terminé ou pas
    // S'il l'est alors on retourne true et on supprime le test
    // puisqu'un nouveau sera ajouté à la place
    public boolean verifierSiTestTermine(String nomTest)
    {
        boolean trouve = false;

        // A vous de jouer

        return trouve;
    }
}
