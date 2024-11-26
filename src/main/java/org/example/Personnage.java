package org.example;

public class Personnage {

    // Définition des attributs du Personnage
    int pv;
    float defense;
    String forceAttaque;
    int position;
    int degatsForceAttaque;

    public Personnage(int pv, float defense, String forceAttaque, int position, int degatsForceAttaque) {
        this.pv = pv;
        this.defense = defense;
        this.forceAttaque = forceAttaque;
        this.position = position;
        this.degatsForceAttaque = degatsForceAttaque;
    }

    // Liste des getters et setters
    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public float getDefense() {
        return defense;
    }

    public void setDefense(float defense) {
        this.defense = defense;
    }

    public String getForceAttaque() {
        return forceAttaque;
    }

    public void setForceAttaque(String forceAttaque) {
        this.forceAttaque = forceAttaque;
    }

    public int getDegatsForceAttaque() {
        return degatsForceAttaque;
    }

    public void setDegatsForceAttaque(int degatsForceAttaque) {
        this.degatsForceAttaque = degatsForceAttaque;
    }



    @Override
    public String toString() {
        return "Personnage{" +
                "pv=" + pv +
                ", defense=" + defense +
                ", forceAttaque='" + forceAttaque + '\'' +
                ", position=" + position +
                ", degatsForceAttaque=" + degatsForceAttaque +
                '}';
    }
}