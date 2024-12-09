package org.example;

/**
 * La classe Personnage représente un personnage dans le jeu avec des points de vie (pv), une défense, une force d'attaque, une position et des dégâts de force d'attaque.
 */
public class Personnage {

    // Définition des attributs du Personnage
    int pv; // Points de vie du personnage
    float defense; // Défense du personnage
    String forceAttaque; // Force d'attaque du personnage
    int position; // Position du personnage
    int degatsForceAttaque; // Dégâts de la force d'attaque du personnage

    /**
     * Constructeur de la classe Personnage.
     *
     * @param pv                Points de vie du personnage.
     * @param defense           Défense du personnage.
     * @param forceAttaque      Force d'attaque du personnage.
     * @param position          Position du personnage.
     * @param degatsForceAttaque Dégâts de la force d'attaque du personnage.
     */
    public Personnage(int pv, float defense, String forceAttaque, int position, int degatsForceAttaque) {
        this.pv = pv;
        this.defense = defense;
        this.forceAttaque = forceAttaque;
        this.position = position;
        this.degatsForceAttaque = degatsForceAttaque;
    }

    // Liste des getters et setters

    /**
     * Retourne les points de vie du personnage.
     *
     * @return Points de vie du personnage.
     */
    public int getPv() {
        return pv;
    }

    /**
     * Définit les points de vie du personnage.
     *
     * @param pv Points de vie du personnage.
     */
    public void setPv(int pv) {
        this.pv = pv;
    }

    /**
     * Retourne la défense du personnage.
     *
     * @return Défense du personnage.
     */
    public float getDefense() {
        return defense;
    }

    /**
     * Définit la défense du personnage.
     *
     * @param defense Défense du personnage.
     */
    public void setDefense(float defense) {
        this.defense = defense;
    }

    /**
     * Retourne la force d'attaque du personnage.
     *
     * @return Force d'attaque du personnage.
     */
    public String getForceAttaque() {
        return forceAttaque;
    }

    /**
     * Définit la force d'attaque du personnage.
     *
     * @param forceAttaque Force d'attaque du personnage.
     */
    public void setForceAttaque(String forceAttaque) {
        this.forceAttaque = forceAttaque;
    }

    /**
     * Retourne les dégâts de la force d'attaque du personnage.
     *
     * @return Dégâts de la force d'attaque du personnage.
     */
    public int getDegatsForceAttaque() {
        return degatsForceAttaque;
    }

    /**
     * Définit les dégâts de la force d'attaque du personnage.
     *
     * @param degatsForceAttaque Dégâts de la force d'attaque du personnage.
     */
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