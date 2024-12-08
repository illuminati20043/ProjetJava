package org.example;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestProgressionCombat {

    @Test
    public void testTousLesEnnemisVaincus() {
        // Initialisation du jeu et d'une carte avec des ennemis
        Jeu jeu = new Jeu();
        Carte carte = new Carte("Test Carte", "Test Lieu", 10, new ArrayList<>(), 0, 3);
        jeu.genererEnnemis(carte);

        // Création d'un héros puissant pour vaincre tous les ennemis
        Hero hero = new Hero(0, TypeHero.Tank, 100);

        // Combattre tous les ennemis
        for (Ennemi ennemi : carte.getEnnemis()) {
            jeu.lancerCombat(hero, ennemi);
        }

        // Vérification : tous les ennemis sont vaincus
        assertTrue(carte.getEnnemis().stream().allMatch(Ennemi::isEstVaincu), "Tous les ennemis auraient dû être vaincus.");
    }
}
