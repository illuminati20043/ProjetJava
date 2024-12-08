package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestSelectionHero {

    @Test
    public void testSelectionHero() {
        // Initialisation du jeu
        Jeu jeu = new Jeu();

        // Sélection du héros
        Hero hero = jeu.selectionHero();

        // Vérification : un héros valide est créé
        assertNotNull(hero, "Le héros sélectionné ne devrait pas être null.");
        assertTrue(hero.getPv() > 0, "Le héros sélectionné devrait avoir des PV positifs.");
    }
}
