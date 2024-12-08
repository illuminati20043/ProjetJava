package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestHeroVsEnnemi {

    @Test
    public void testHeroAttaqueEnnemiAvecDegatsEgauxPv() {
        // Initialisation du jeu
        Jeu jeu = new Jeu();

        // Création d'un ennemi avec 50 PV
        Ennemi ennemi = new Ennemi(TypeEnnemi.BRIGAND, 0, 50);

        // Création d'un héros avec des dégâts égaux aux PV de l'ennemi
        Hero hero = new Hero(0, TypeHero.Damage, 50);

        // Combat : le héros attaque l'ennemi
        jeu.lancerCombat(hero, ennemi);

        // Vérification : l'ennemi est marqué comme vaincu
        assertTrue(ennemi.isEstVaincu(), "L'ennemi aurait dû être marqué comme vaincu.");
        assertEquals(0, ennemi.getPv(), "L'ennemi aurait dû avoir 0 PV.");
    }
}
