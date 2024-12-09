package org.example;

public class Hero extends Personnage implements ICombatant {
    private int positionX;
    private int positionY;

    public Hero(int position, TypeHero typeHero, int degatsForceAttaque) {
        super(typeHero.getPv(), typeHero.getDefense(), typeHero.getForceAttaque(), position, degatsForceAttaque);
        this.positionX = 0; // Position initiale par défaut
        this.positionY = 0; // Position initiale par défaut
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    @Override
    public void attaquer(ICombatant cible) {
        // Code de l'attaque du héros
    }

    @Override
    public void subirAttaque(int degats) {
        this.setPv(this.getPv() - degats);
    }
}