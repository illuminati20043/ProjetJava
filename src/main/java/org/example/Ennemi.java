package org.example;

public class Ennemi extends Personnage {

    private TypeEnnemi type;
    private boolean estVaincu; // Attribut pour indiquer l'état de l'ennemi
    private int positionX;
    private int positionY;

    public Ennemi(TypeEnnemi type, int position) {
        super(type.getPv(), type.getDefense(), type.getForceAttaque(), position, 30); // Exemple de dégâts de force d'attaque
        this.type = type;
        this.estVaincu = false; // Initialisation par défaut
        this.positionX = 0; // Position initiale par défaut
        this.positionY = 0; // Position initiale par défaut
    }

    public TypeEnnemi getType() {
        return type;
    }

    public void setType(TypeEnnemi type) {
        this.type = type;
    }

    public boolean isEstVaincu() {
        return estVaincu;
    }

    public void marquerVaincu() {
        this.estVaincu = true;
        System.out.println(this.getClass().getSimpleName() + " a été marqué comme vaincu !");
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
}