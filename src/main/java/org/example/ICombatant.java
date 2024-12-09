package org.example;

/**
 * L'interface ICombatant définit les méthodes que doivent implémenter les classes représentant des combattants dans le jeu.
 */
public interface ICombatant {

    /**
     * Attaque un autre combattant.
     *
     * @param cible Le combattant cible de l'attaque.
     */
    void attaquer(ICombatant cible);

    /**
     * Subit une attaque et réduit les points de vie en fonction des dégâts reçus.
     *
     * @param degats Les dégâts subis par le combattant.
     */
    void subirAttaque(int degats);
}
