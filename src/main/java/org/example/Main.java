package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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

            // Sélection du personnage
            Hero hero = jeu.selectionHero();
            logger.info("Joueur choisi");

            // Sélection de la carte
            Carte carte = jeu.selectionCarte();
            logger.info("Carte choisie");
            jeu.genererEnnemis(carte);
            logger.info("Ennemis générés");

            // Lecture des données entrées par l'utilisateur
            Scanner scanner = new Scanner(System.in);

            // BOUCLE DU JEU
            boolean enJeu = true;
            while (enJeu && hero.getPv() > 0 && !carte.getEnnemis().isEmpty()) {

                System.out.println("\nChoisir une action");
                System.out.println("1. Combattre un ennemi");
                System.out.println("2. Utiliser pouvoir spécial");
                System.out.println("3. Quitter le jeu");

                // Vérification de l'entrée de l'utilisateur pour éviter les erreurs
                int choix = -1;
                while (choix < 1 || choix > 2) {
                    System.out.print("Entrez votre choix : ");
                    if (scanner.hasNextInt()) {
                        choix = scanner.nextInt();
                    } else {
                        scanner.next(); // Consomme la mauvaise entrée
                    }
                }

                switch (choix) {
                    case 1:
                        // Combat contre un ennemi
                        Ennemi ennemi = carte.getEnnemis().removeFirst(); // Le premier ennemi est retiré
                        System.out.println("Vous affrontez un " + ennemi.getType());
                        logger.info("Combat commencé contre un ennemi de type " + ennemi.getType());
                        jeu.lancerCombat(hero, ennemi);

                        // Vérification de l'état du héros après le combat
                        if (hero.getPv() <= 0) {
                            enJeu = false;
                            System.out.println("Game Over");
                            logger.info("Défaite du joueur");
                        } else if (carte.getEnnemis().isEmpty()) {
                            // Si tous les ennemis ont été éliminés
                            System.out.println("Vous avez terminé la carte !");
                            logger.info("Victoire, tous les ennemis sont vaincus");
                            enJeu = false;
                        }

                        logger.info("Ennemis restants : " + carte.getEnnemis().size());
                        break;
                    case 2 :
                        jeu.choixPouvoir(hero, carte);
                        break;
                    case 3:
                        // Quitter le jeu
                        enJeu = false;
                        System.out.println("Vous avez quitté le jeu! Merci pour y avoir joué");
                        logger.info("Jeu quitté");
                        break;

                    default:
                        // Si le choix est invalide
                        System.out.print("Choix invalide");
                        logger.warning("Choix invalide");
                }
            }

            // Fermeture du scanner
            scanner.close();
        } catch (Exception e) {
            logger.severe("Erreur: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
