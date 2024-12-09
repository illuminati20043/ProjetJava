package org.example;

import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try {
            // Configuration du logger
            FileHandler fh = new FileHandler("game.log", true); // true for append mode
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            System.out.println("\nBienvenue sur le projet de Adam GUIZAOUI et Elyes AÏSSAT");

            // Initialisation du jeu
            Jeu jeu = new Jeu();
            logger.info("Jeu initialisé");

            // Démarrer le jeu
            jeu.demarrer();

        } catch (Exception e) {
            logger.severe("Erreur: " + e.getMessage());
            e.printStackTrace();
        }
    }
}