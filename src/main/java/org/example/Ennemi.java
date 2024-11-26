package org.example;

public class Ennemi extends Personnage{


    private TypeEnnemi type;

    public Ennemi(TypeEnnemi type, int position,int degatsForceAttaque){
        super(type.getPv(), type.getDefense(), type.getForceAttaque(), position, degatsForceAttaque);
        this.type = type;

    }

    public TypeEnnemi getType() {
        return type;
    }

    public void setType(TypeEnnemi type) {
        this.type = type;
    }
}
