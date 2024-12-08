package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarteTest {

    @Test
    public void testSelectionCarte() {
        Jeu jeu = new Jeu();
        Carte carte = jeu.selectionCarte();

        assertNotNull(carte);
        assertTrue(carte instanceof Carte);
    }
}