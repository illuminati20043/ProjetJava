package org.example;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestCarteEtEnnemis {

    @Test
    public void testGenererEnnemisSurCarte() {
        // Initialisation du jeu et d'une carte
        Jeu jeu = new Jeu();
        Carte carte = new Carte("Test Carte", "Test Lieu", 10, new ArrayList<>(), 0, 3);

        // Génération des ennemis
        jeu.genererEnnemis(carte);

        // Vérification : le nombre d'ennemis correspond à la difficulté * 3
        int expectedEnnemis = 3 * carte.getDifficulte();
        assertEquals(expectedEnnemis, carte.getEnnemis().size(), "Le nombre d'ennemis générés est incorrect.");
    }
}
