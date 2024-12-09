package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestsDegatsEnnemi {

    @Test
    public void testEnnemiTakingDamage() {
        // Création d'un ennemi avec des PV initiaux
        Ennemi ennemi = new Ennemi(TypeEnnemi.CATCHER, 0); // TypeEnnemi.CATCHER et position = 0
        ennemi.setPv(80); // Définir les PV de l'ennemi à 80

        // Simuler les dégâts
        int damage = 30;
        ennemi.setPv(Math.max(ennemi.getPv() - damage, 0)); // Réduire les PV de l'ennemi

        // Vérification : les PV de l'ennemi ont diminué
        assertEquals(50, ennemi.getPv(), "L'ennemi aurait dû avoir 50 PV après avoir subi des dégâts.");
    }
}