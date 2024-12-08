package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JeuTest {

    @Test
    public void testHeroAttaqueEnnemiAvecDegatsEgauxPv() {
        // Initialisation du jeu
        Jeu jeu = new Jeu();

        // Création d'un ennemi avec 50 PV (égaux aux dégâts du héros)
        Ennemi ennemi = new Ennemi(TypeEnnemi.BRIGAND, 0, 50);

        // Création du héros avec des dégâts égaux aux PV de l'ennemi
        Hero hero = new Hero(0, TypeHero.Damage, 50);

        // Combat : le héros attaque l'ennemi
        jeu.lancerCombat(hero, ennemi);

        // Vérification : l'ennemi est marqué comme vaincu
        assertTrue(ennemi.isEstVaincu(), "L'ennemi aurait dû être marqué comme vaincu.");
    }
}
