package org.example;

public class Ennemi extends Personnage {

    private TypeEnnemi type;
    private boolean estVaincu; // Attribut pour indiquer l'état de l'ennemi

    public Ennemi(TypeEnnemi type, int position, int degatsForceAttaque) {
        super(type.getPv(), type.getDefense(), type.getForceAttaque(), position, degatsForceAttaque);
        this.type = type;
        this.estVaincu = false; // Initialisation par défaut
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

    // Méthode pour marquer l'ennemi comme vaincu
    public void marquerVaincu() {
        this.estVaincu = true;
        System.out.println(this.getClass().getSimpleName() + " a été marqué comme vaincu !");
    }
}
