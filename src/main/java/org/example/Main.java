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
            FileHandler fh = new FileHandler("game.log", true); // true for append mode
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            System.out.println("Bienvenue sur le projet de Adam GUIZAOUI et Elyes AÏSSAT");

            //Initialisation du jeu
            Jeu jeu = new Jeu();
            logger.info("Jeu initialisé");

            //Selection du personnage
            Hero hero = jeu.selectionHero();
            logger.info("Joueur choisi");

            //Selection de la carte
            Carte carte = jeu.selectionCarte();
            logger.info("Carte choisie");
            jeu.genererEnnemis(carte);
            logger.info("Ennemis générés");

            //lecture des données entrées pas l'utilisateur
            Scanner scanner = new Scanner(System.in);


            // BOUCLE DU JEU
            boolean enJeu = true;
            while (enJeu && hero.getPv() > 0 && !carte.getEnnemis().isEmpty()) {

                System.out.println("\nChoisir une action");
                System.out.println("1. Combattre un ennemi");
                System.out.println("2. Quitter le jeu");

                int choix = scanner.nextInt();
                switch (choix) {
                    case 1:
                        Ennemi ennemi = carte.getEnnemis().removeFirst();
                        System.out.println("Vous affrontez un " + ennemi.getType());
                        logger.info("Combat commencé contre un ennemi de type "+ennemi.getType());
                        jeu.lancerCombat(hero, ennemi);
                        if (hero.getPv() <= 0) {
                            enJeu = false;
                            System.out.println("Game Over");
                            logger.info("Defeat");
                        } else if (carte.getEnnemis().isEmpty()) {
                            System.out.println("Vous avez terminé la carte !");
                            logger.info("Victory");
                            enJeu = false;
                        }
                        logger.info("Ennemis restants : "+ carte.getEnnemis().size());
                        break;
                    case 2:
                        enJeu = false;
                        System.out.println("Vous avez quitté le jeu! Merci pour y avoir joué");
                        logger.info("Jeu quitté");
                        break;
                    default:
                        System.out.print("Choix invalide");
                        logger.warning("Choix invalide");
                }
            }

            // fermer le scanner
            scanner.close();
        }
        catch(Exception e) {
            logger.severe("Erreur: "+e.getMessage());

        }
    }
}