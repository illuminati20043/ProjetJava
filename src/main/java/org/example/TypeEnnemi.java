package org.example;

/**
 * L'énumération TypeEnnemi représente différents types d'ennemis avec leurs points de vie (pv), leur défense et leur force d'attaque.
 */
public enum TypeEnnemi {
    BRIGAND(50, 5, "Couteau"),
    CATCHER(80, 10, "Poings"),
    GANGSTER(100, 8, "Pistolet");

    private final int pv; // Points de vie de l'ennemi
    private final float defense; // Défense de l'ennemi
    private final String forceAttaque; // Force d'attaque de l'ennemi

    /**
     * Constructeur de l'énumération TypeEnnemi.
     *
     * @param pv          Points de vie de l'ennemi.
     * @param defense     Défense de l'ennemi.
     * @param forceAttaque Force d'attaque de l'ennemi.
     */
    TypeEnnemi(int pv, float defense, String forceAttaque) {
        this.pv = pv;
        this.defense = defense;
        this.forceAttaque = forceAttaque;
    }

    /**
     * Retourne les points de vie de l'ennemi.
     *
     * @return Points de vie de l'ennemi.
     */
    public int getPv() {
        return pv;
    }

    /**
     * Retourne la défense de l'ennemi.
     *
     * @return Défense de l'ennemi.
     */
    public float getDefense() {
        return defense;
    }

    /**
     * Retourne la force d'attaque de l'ennemi.
     *
     * @return Force d'attaque de l'ennemi.
     */
    public String getForceAttaque() {
        return forceAttaque;
    }
}