package org.example;

public class Ennemi extends Personnage{


    private TypeEnnemi type;
    private boolean estVaincu; // Nouvel attribut

    public Ennemi(TypeEnnemi type, int position, int degatsForceAttaque) {
        super(type.getPv(), type.getDefense(), type.getForceAttaque(), position, degatsForceAttaque);
        this.type = type;
        this.estVaincu = false; // Initialisation par défaut à false
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

    public void setEstVaincu(boolean estVaincu) {
        this.estVaincu = estVaincu;
    }

//    private TypeEnnemi type;

//    public Ennemi(TypeEnnemi type, int position,int degatsForceAttaque){
//        super(type.getPv(), type.getDefense(), type.getForceAttaque(), position, degatsForceAttaque);
//        this.type = type;
//
//    }

    //  public TypeEnnemi getType() {
    //  return type;
    //}

    //public void setType(TypeEnnemi type) {
    //  this.type = type;
    //}
}
