package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestEnnemiDefaite {

    @Test
    public void testEnnemiDefaite() {
        // Création d'un ennemi
        Ennemi ennemi = new Ennemi(TypeEnnemi.BRIGAND, 0);
        ennemi.setPv(0); // Définir les PV de l'ennemi à 0

        // Marquer l'ennemi comme vaincu
        ennemi.marquerVaincu();

        // Vérification : l'ennemi est marqué comme vaincu
        assertTrue(ennemi.isEstVaincu(), "L'ennemi aurait dû être marqué comme vaincu.");
    }
}