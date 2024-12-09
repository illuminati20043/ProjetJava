package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestDefaiteHero {

    @Test
    public void testHeroEstVaincuAvantLigneArrivee() {
        // Création d'un héros avec peu de PV
        Hero hero = new Hero(0, TypeHero.Damage, 50); // Position = 0, TypeHero.Damage, PV = 50
        Ennemi ennemi = new Ennemi(TypeEnnemi.GANGSTER, 0); // TypeEnnemi.GANGSTER et position = 0
        ennemi.setDegatsForceAttaque(50); // Dégâts = 50

        // Simuler le combat
        int degats = ennemi.getDegatsForceAttaque() - (int) hero.getDefense();
        degats = Math.max(degats, 0); // Les dégâts ne peuvent pas être négatifs
        hero.setPv(Math.max(hero.getPv() - degats, 0)); // Appliquer les dégâts et s'assurer que les PV ne sont pas négatifs

        // Vérification : le héros est vaincu
        assertEquals(0, hero.getPv(), "Le héros aurait dû avoir 0 PV.");
        assertFalse(hero.getPv() > 0, "La partie aurait dû se terminer par une défaite.");
    }
}