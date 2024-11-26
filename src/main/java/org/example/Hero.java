package org.example;

public class Hero extends Personnage{
    TypeHero typeHero;
    public Hero(int position, TypeHero typeHero, int degatsForceAttaque) {
        super(typeHero.getPv(), typeHero.getDefense(), typeHero.getForceAttaque(), position, degatsForceAttaque);
        this.typeHero = typeHero;
    }

}
