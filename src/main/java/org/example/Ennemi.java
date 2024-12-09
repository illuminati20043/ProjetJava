package org.example;

/**
 * La classe Ennemi représente un ennemi dans le jeu, héritant de la classe Personnage.
 * Elle contient des informations spécifiques sur le type d'ennemi, son état (vaincu ou non) et sa position sur la carte.
 */
public class Ennemi extends Personnage {

    private TypeEnnemi type; // Type de l'ennemi
    private boolean estVaincu; // Attribut pour indiquer l'état de l'ennemi
    private int positionX; // Position X de l'ennemi sur la carte
    private int positionY; // Position Y de l'ennemi sur la carte

    /**
     * Constructeur de la classe Ennemi.
     *
     * @param type     Type de l'ennemi.
     * @param position Position initiale de l'ennemi.
     */
    public Ennemi(TypeEnnemi type, int position) {
        super(type.getPv(), type.getDefense(), type.getForceAttaque(), position, 30); // Exemple de dégâts de force d'attaque
        this.type = type;
        this.estVaincu = false; // Initialisation par défaut
        this.positionX = 0; // Position initiale par défaut
        this.positionY = 0; // Position initiale par défaut
    }

    /**
     * Retourne le type de l'ennemi.
     *
     * @return Type de l'ennemi.
     */
    public TypeEnnemi getType() {
        return type;
    }

    /**
     * Définit le type de l'ennemi.
     *
     * @param type Type de l'ennemi.
     */
    public void setType(TypeEnnemi type) {
        this.type = type;
    }

    /**
     * Vérifie si l'ennemi est vaincu.
     *
     * @return true si l'ennemi est vaincu, false sinon.
     */
    public boolean isEstVaincu() {
        return estVaincu;
    }

    /**
     * Marque l'ennemi comme vaincu.
     */
    public void marquerVaincu() {
        this.estVaincu = true;
        System.out.println(this.getClass().getSimpleName() + " a été marqué comme vaincu !");
    }

    /**
     * Retourne la position X de l'ennemi sur la carte.
     *
     * @return Position X de l'ennemi.
     */
    public int getPositionX() {
        return positionX;
    }

    /**
     * Définit la position X de l'ennemi sur la carte.
     *
     * @param positionX Position X de l'ennemi.
     */
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    /**
     * Retourne la position Y de l'ennemi sur la carte.
     *
     * @return Position Y de l'ennemi.
     */
    public int getPositionY() {
        return positionY;
    }

    /**
     * Définit la position Y de l'ennemi sur la carte.
     *
     * @param positionY Position Y de l'ennemi.
     */
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
}