package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestDefaiteHero {

    @Test
    public void testHeroEstVaincuAvantLigneArrivee() {
        // Création d'un héros avec peu de PV
        Hero hero = new Hero(0, TypeHero.Damage, 10); // PV = 10
        Ennemi ennemi = new Ennemi(TypeEnnemi.GANGSTER, 0, 50); // Dégâts = 50

        // Initialisation du jeu
        Jeu jeu = new Jeu();

        // Lancer le combat
        jeu.lancerCombat(hero, ennemi);

        // Vérification : le héros est vaincu
        assertEquals(0, hero.getPv(), "Le héros aurait dû avoir 0 PV.");
        assertFalse(hero.getPv() > 0, "La partie aurait dû se terminer par une défaite.");
    }
}
