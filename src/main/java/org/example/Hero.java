package org.example;

/**
 * La classe Hero représente un héros dans le jeu.
 * Elle hérite de la classe Personnage et implémente l'interface ICombatant.
 */
public class Hero extends Personnage implements ICombatant {
    private int positionX; // Position X du héros sur la carte
    private int positionY; // Position Y du héros sur la carte

    /**
     * Constructeur de la classe Hero.
     * Initialise un héros avec ses caractéristiques et sa position initiale.
     *
     * @param position           Position initiale du héros (non utilisée directement).
     * @param typeHero           Type du héros (Tank, Damage, Archer).
     * @param degatsForceAttaque Dégâts de la force d'attaque du héros.
     */
    public Hero(int position, TypeHero typeHero, int degatsForceAttaque) {
        super(typeHero.getPv(), typeHero.getDefense(), typeHero.getForceAttaque(), position, degatsForceAttaque);
        this.positionX = 0; // Position initiale par défaut
        this.positionY = 0; // Position initiale par défaut
    }

    /**
     * Retourne la position X du héros sur la carte.
     *
     * @return La position X du héros.
     */
    public int getPositionX() {
        return positionX;
    }

    /**
     * Définit la position X du héros sur la carte.
     *
     * @param positionX La nouvelle position X du héros.
     */
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    /**
     * Retourne la position Y du héros sur la carte.
     *
     * @return La position Y du héros.
     */
    public int getPositionY() {
        return positionY;
    }

    /**
     * Définit la position Y du héros sur la carte.
     *
     * @param positionY La nouvelle position Y du héros.
     */
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    /**
     * Méthode pour attaquer une cible.
     * Implémentation de l'interface ICombatant.
     *
     * @param cible La cible à attaquer.
     */
    @Override
    public void attaquer(ICombatant cible) {
        // Code de l'attaque du héros
    }

    /**
     * Méthode pour subir une attaque.
     * Réduit les points de vie du héros en fonction des dégâts reçus.
     *
     * @param degats Les dégâts subis par le héros.
     */
    @Override
    public void subirAttaque(int degats) {
        this.setPv(this.getPv() - degats);
    }
}