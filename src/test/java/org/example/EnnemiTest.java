package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class EnnemiTest {

    @Test
    public void testGenererEnnemis() {
        // Initialiser le jeu et la carte
        Jeu jeu = new Jeu();
        Carte carte = new Carte("Test Carte", "Test Lieu", 10, new ArrayList<>(), 0, 3);

        // Générer les ennemis sur la carte
        jeu.genererEnnemis(carte);

        // Vérifier que des ennemis ont été générés
        assertFalse(carte.getEnnemis().isEmpty(), "La liste des ennemis ne doit pas être vide");

        // Vérifier le nombre d'ennemis générés
        int expectedNombreEnnemis = carte.getDifficulte() * 3;
        assertEquals(expectedNombreEnnemis, carte.getEnnemis().size(), "Le nombre d'ennemis générés doit correspondre à la difficulté de la carte");

        // Vérifier les attributs des ennemis générés
        for (Ennemi ennemi : carte.getEnnemis()) {
            assertNotNull(ennemi.getType(), "Le type de l'ennemi ne doit pas être nul");
            assertTrue(ennemi.getPv() > 0, "Les points de vie de l'ennemi doivent être positifs");
        }
    }
}