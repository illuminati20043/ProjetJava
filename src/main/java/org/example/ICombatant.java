package org.example;

public interface ICombatant {
    void attaquer(ICombatant cible);  // Attaque un autre combatant
    void subirAttaque(int degats);  // Subit une attaque
}

