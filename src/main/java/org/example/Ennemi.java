package org.example;

public class Ennemi extends Personnage{


    private TypeEnnemi type;

    public Ennemi(TypeEnnemi type, int position){
        super(type.getPv(), type.getDefense(), type.getForceAttaque(), position);
        this.type = type;

    }

    public TypeEnnemi getType() {
        return type;
    }

    public void setType(TypeEnnemi type) {
        this.type = type;
    }
}
