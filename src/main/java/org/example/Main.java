package org.example;

import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try {
            // Désactiver les gestionnaires par défaut
            for (Handler handler : logger.getHandlers()) {
                if (handler instanceof ConsoleHandler) {
                    logger.removeHandler(handler);
                }
            }
            logger.setUseParentHandlers(false); // Désactiver les gestionnaires parents

            // Configuration du logger pour écrire dans un fichier
            FileHandler fh = new FileHandler("./game.log", true); // true pour le mode append
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            // Message d'accueil
            System.out.println("\nBienvenue sur le projet de Adam GUIZAOUI et Elyes AÏSSAT\n");

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