package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestHeroRegen {

    @Test
    public void testHeroHealing() {
        // Création d'un héros avec des PV réduits
        Hero hero = new Hero(0, TypeHero.Tank, 20); // Position = 0, TypeHero.Tank, PV = 20
        hero.setPv(50); // Réduire les PV du héros à 50

        // Simuler la guérison
        int healingAmount = 30;
        hero.setPv(hero.getPv() + healingAmount); // Augmenter les PV du héros

        // Vérification : les PV du héros ont augmenté
        assertEquals(80, hero.getPv(), "Le héros aurait dû avoir 80 PV après la guérison.");
    }
}