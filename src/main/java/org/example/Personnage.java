package org.example;

public class Personnage {

    // Définition des attributs du Personnage
    int pv;
    float defense;
    String forceAttaque;
    int position;

    public Personnage(int pv, float defense, String forceAttaque, int position) {
        this.pv = pv;
        this.defense = defense;
        this.forceAttaque = forceAttaque;
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
}
