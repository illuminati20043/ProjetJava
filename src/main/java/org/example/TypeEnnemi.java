package org.example;

public enum TypeEnnemi {
    BRIGAND(50, 5, "Couteau"),
    CATCHER(80, 10, "Poings"),
    GANGSTER(100, 8, "Pistolet");
    private final int pv;
    private final float defense;
    private final String forceAttaque;
    TypeEnnemi(int pv, float defense, String forceAttaque) {
        this.pv = pv;
        this.defense = defense;
        this.forceAttaque = forceAttaque;
    }

    public int getPv() {
        return pv;
    }

    public float getDefense() {
        return defense;
    }

    public String getForceAttaque() {
        return forceAttaque;
    }
}
