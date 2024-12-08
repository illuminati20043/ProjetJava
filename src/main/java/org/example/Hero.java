package org.example;

public class Hero extends Personnage implements ICombatant {
    public Hero(int position, TypeHero typeHero, int degatsForceAttaque) {
        super(typeHero.getPv(), typeHero.getDefense(), typeHero.getForceAttaque(), position, degatsForceAttaque);
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

