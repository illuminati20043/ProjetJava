package org.example;

import java.util.Random;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * La classe Jeu gère la logique principale du jeu, y compris l'initialisation, la boucle de jeu,
 * la sélection du héros, les combats et l'utilisation des pouvoirs spéciaux.
 */
public class Jeu {

    private static final Logger logger = Logger.getLogger(Jeu.class.getName());
    private CarteGraphique carteGraphique;
    private Hero hero;

    /**
     * Constructeur de la classe Jeu.
     * Configure le logger, initialise le héros et la carte graphique avec un nombre aléatoire d'ennemis.
     */
    public Jeu() {
        // Désactivation des logs dans la console
        for (Handler handler : logger.getHandlers()) {
            if (handler instanceof ConsoleHandler) {
                logger.removeHandler(handler);
            }
        }
        logger.setUseParentHandlers(false); // Désactive les gestionnaires par défaut

        try {
            // Configuration du logger pour écrire dans un fichier

        } catch (Exception e) {
            e.printStackTrace();
        }

        hero = selectionHero();

        // Générer un nombre aléatoire d'ennemis entre 3 et 10
        int nombreEnnemis = genererNombreAleatoire(3, 10);
        carteGraphique = new CarteGraphique(nombreEnnemis, hero); // Initialiser la carte avec ce nombre
        logger.info("Jeu initialisé avec une carte graphique et " + nombreEnnemis + " ennemis.");
    }

    /**
     * Méthode pour générer un nombre aléatoire dans une plage donnée.
     *
     * @param min Valeur minimale.
     * @param max Valeur maximale.
     * @return Un nombre aléatoire entre min et max.
     */
    private int genererNombreAleatoire(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    /**
     * Démarre la boucle principale du jeu.
     * Gère les déplacements du héros, les rencontres avec les ennemis et les actions du joueur.
     */
    public void demarrer() {
        Scanner scanner = new Scanner(System.in);

        boolean enJeu = true;
        while (enJeu && hero.getPv() > 0) {
            carteGraphique.afficherCarte();
            System.out.print("\nDéplacez-vous (w/a/s/d) ou 'q' pour quitter : ");
            String direction = scanner.next();

            // Vérifier si le joueur veut quitter
            if (direction.equalsIgnoreCase("q")) {
                System.out.println("Vous avez choisi de quitter le jeu. À bientôt !");
                logger.info("Le joueur a quitté le jeu.");
                break;  // Quitter la boucle de jeu
            }

            // Vérifier que la direction est valide (w, a, s, d)
            while (!direction.matches("[wasd]")) {
                System.out.print("Entrée invalide. Veuillez entrer 'w', 'a', 's', 'd' ou 'q' pour quitter : ");
                direction = scanner.next();
                // Vérifier si le joueur veut quitter
                if (direction.equalsIgnoreCase("q")) {
                    System.out.println("Vous avez choisi de quitter le jeu. À bientôt !");
                    logger.info("Le joueur a quitté le jeu.");
                    break;  // Quitter la boucle de jeu
                }
            }

            // Si la boucle interne a arrêté le jeu (via 'q'), on sort de la boucle principale
            if (direction.equalsIgnoreCase("q")) {
                break;
            }

            carteGraphique.deplacerJoueur(direction.charAt(0));

            // Vérifier les interactions avec les ennemis
            Ennemi ennemiProche = ennemiAdjacent();
            if (ennemiProche != null) {
                System.out.println("\nVous avez rencontré un ennemi !");
                logger.info("Ennemi proche détecté.");

                carteGraphique.afficherCarte();
                System.out.println("\nChoisissez une action :");
                System.out.println("1. Attaquer l'ennemi");
                System.out.println("2. Utiliser un pouvoir spécial");

                int choix = -1;
                while (choix < 1 || choix > 2) {
                    System.out.print("Entrez votre choix (1-2) : ");
                    if (scanner.hasNextInt()) {
                        choix = scanner.nextInt();
                    } else {
                        scanner.next(); // Consomme la mauvaise entrée
                    }
                }

                switch (choix) {
                    case 1 -> {
                        lancerCombat(hero, ennemiProche);
                        logger.info("Combat lancé contre l'ennemi.");
                    }
                    case 2 -> {
                        choixPouvoir(hero, carteGraphique);
                        logger.info("Pouvoir spécial utilisé.");
                    }
                }

                // Vérification de l'état du héros après le combat
                if (hero.getPv() <= 0) {
                    enJeu = false;
                    System.out.println("\nGame Over - Vous avez perdu !");
                    logger.info("Défaite du joueur.");
                } else if (carteGraphique.getEnnemis().isEmpty()) {
                    // Si tous les ennemis ont été éliminés
                    System.out.println("\nFélicitations ! Vous avez terminé la carte !");
                    logger.info("Victoire, tous les ennemis sont vaincus.");
                    enJeu = false;
                }

                logger.info("Ennemis restants : " + carteGraphique.getEnnemis().size());
            }
        }
        scanner.close();
    }

    /**
     * Vérifie si un ennemi est adjacent au héros.
     *
     * @return L'ennemi adjacent s'il y en a un, sinon null.
     */
    private Ennemi ennemiAdjacent() {
        int x = hero.getPositionX();
        int y = hero.getPositionY();
        for (Ennemi ennemi : carteGraphique.getEnnemis()) {
            if ((ennemi.getPositionX() == x && Math.abs(ennemi.getPositionY() - y) == 1) ||
                    (ennemi.getPositionY() == y && Math.abs(ennemi.getPositionX() - x) == 1)) {
                return ennemi;
            }
        }
        return null;
    }

    /**
     * Permet au joueur de sélectionner une classe de héros.
     *
     * @return Le héros sélectionné.
     */
    public Hero selectionHero() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nChoisissez votre classe de héros : ");
        System.out.println("1. Tank (200 HP, 20 défense, Bouclier)");
        System.out.println("2. Damage (100 HP, 10 défense, Épée)");
        System.out.println("3. Archer (80 HP, 5 défense, Arc)");

        TypeHero typeHero = null;
        int choix = -1;

        while (choix < 1 || choix > 3) {
            System.out.print("Entrez votre choix (1-3) : ");
            choix = scanner.nextInt();
        }

        switch (choix) {
            case 1 -> {
                typeHero = TypeHero.Tank;
                logger.info("Classe choisie : Tank.");
            }
            case 2 -> {
                typeHero = TypeHero.Damage;
                logger.info("Classe choisie : Damage.");
            }
            case 3 -> {
                typeHero = TypeHero.Archer;
                logger.info("Classe choisie : Archer.");
            }
        }
        return new Hero(0, typeHero, 50);
    }

    /**
     * Gère le combat entre le héros et un ennemi.
     *
     * @param attaquant Le personnage attaquant.
     * @param defenseur Le personnage défenseur.
     */
    public void lancerCombat(Personnage attaquant, Personnage defenseur) {
        while (attaquant.getPv() > 0 && defenseur.getPv() > 0) {
            Attaque.lancerAttaque(attaquant, defenseur);
            logger.info("Attaquant : " + attaquant.getClass().getSimpleName() + ", Défenseur : " + defenseur.getClass().getSimpleName());

            if (defenseur.getPv() > 0) {
                Attaque.lancerAttaque(defenseur, attaquant);
                logger.info("Attaquant : " + defenseur.getClass().getSimpleName() + ", Défenseur : " + attaquant.getClass().getSimpleName());
            }
        }

        if (defenseur.getPv() <= 0) {
            System.out.println(defenseur.getClass().getSimpleName() + " a été vaincu !");
            if (defenseur instanceof Ennemi ennemi) {
                ennemi.marquerVaincu();
                carteGraphique.retirerEnnemi(ennemi); // Retirer l'ennemi de la carte
            }
        } else {
            System.out.println(attaquant.getClass().getSimpleName() + " a été vaincu !");
        }
    }

    /**
     * Gère l'utilisation du pouvoir spécial du héros.
     *
     * @param hero            Le héros utilisant le pouvoir spécial.
     * @param carteGraphique  La carte graphique du jeu.
     */
    public void choixPouvoir(Hero hero, CarteGraphique carteGraphique) {
        // Implémentation de l'utilisation du pouvoir spécial
        // Exemple : régénération, augmentation des dégâts, etc.
        System.out.println("\nPouvoir spécial utilisé avec succès !");
        logger.info("Pouvoir spécial utilisé.");
    }

    /**
     * Point d'entrée du programme.
     *
     * @param args Les arguments de la ligne de commande (non utilisés).
     */
    public static void main(String[] args) {
        Jeu jeu = new Jeu();
        jeu.demarrer();
    }
}
