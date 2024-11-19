package org.example;

public class Hero extends Personnage{
    TypeHero typeHero;
    public Hero(int position, TypeHero typeHero) {
        super(typeHero.getPv(), typeHero.getDefense(), typeHero.getForceAttaque(), position);
        this.typeHero = typeHero;
    }

}
