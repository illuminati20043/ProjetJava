package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestEnnemiType {

    @Test
    public void testEnnemiChangingType() {
        // Création d'un ennemi
        Ennemi ennemi = new Ennemi(TypeEnnemi.BRIGAND, 0); // TypeEnnemi.BRIGAND et position = 0

        // Changer le type de l'ennemi
        ennemi.setType(TypeEnnemi.GANGSTER);

        // Vérification : le type de l'ennemi a changé
        assertEquals(TypeEnnemi.GANGSTER, ennemi.getType(), "Le type de l'ennemi aurait dû être GANGSTER.");
    }
}