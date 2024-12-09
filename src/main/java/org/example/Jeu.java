package org.example;

import java.util.Scanner;
import java.util.logging.Logger;

public class Jeu {

    private static final Logger logger = Logger.getLogger(Jeu.class.getName());
    private CarteGraphique carteGraphique;
    private Hero hero;

    public Jeu() {
        hero = selectionHero();
        carteGraphique = new CarteGraphique(5, hero); // Initialiser avec 5 ennemis et le héros
        logger.info("Jeu initialisé avec une carte graphique");
    }

    public void demarrer() {
        Scanner scanner = new Scanner(System.in);

        boolean enJeu = true;
        while (enJeu && hero.getPv() > 0) {
            carteGraphique.afficherCarte();
            System.out.print("Déplacez-vous (w/a/s/d) : ");
            char direction = scanner.next().charAt(0);

            carteGraphique.deplacerJoueur(direction);
            // Vérifier les interactions avec les ennemis
            Ennemi ennemiProche = ennemiAdjacent();
            if (ennemiProche != null) {
                System.out.println("Vous avez rencontré un ennemi !");
                logger.info("Ennemi proche détecté");

                System.out.println("Choisissez une action :");
                System.out.println("1. Attaquer l'ennemi");
                System.out.println("2. Utiliser pouvoir spécial");

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
                        logger.info("Combat lancé contre l'ennemi");
                    }
                    case 2 -> {
                        choixPouvoir(hero, carteGraphique);
                        logger.info("Pouvoir spécial utilisé");
                    }
                }

                // Vérification de l'état du héros après le combat
                if (hero.getPv() <= 0) {
                    enJeu = false;
                    System.out.println("Game Over");
                    logger.info("Défaite du joueur");
                } else if (carteGraphique.getEnnemis().isEmpty()) {
                    // Si tous les ennemis ont été éliminés
                    System.out.println("Vous avez terminé la carte !");
                    logger.info("Victoire, tous les ennemis sont vaincus");
                    enJeu = false;
                }

                logger.info("Ennemis restants : " + carteGraphique.getEnnemis().size());
            }
        }
        scanner.close();
    }

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

    public Hero selectionHero() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choisissez votre classe : ");
        System.out.println("1 : Tank (200 HP, 20 défense, Bouclier)");
        System.out.println("2 : Damage (100 HP, 10 défense, Épée)");
        System.out.println("3 : Archer (80 HP, 5 défense, Arc)");

        TypeHero typeHero = null;
        int choix = -1;

        while (choix < 1 || choix > 3) {
            System.out.print("Entrez votre choix (1-3) : ");
            choix = scanner.nextInt();
        }

        switch (choix) {
            case 1 -> {
                typeHero = TypeHero.Tank;
                logger.info("Classe choisie : Tank");
            }
            case 2 -> {
                typeHero = TypeHero.Damage;
                logger.info("Classe choisie : Damage");
            }
            case 3 -> {
                typeHero = TypeHero.Archer;
                logger.info("Classe choisie : Archer");
            }
        }
        return new Hero(0, typeHero, 50);
    }

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

    public void choixPouvoir(Hero hero, CarteGraphique carteGraphique) {
        // Implémentation de l'utilisation du pouvoir spécial
        // Exemple : régénération, augmentation des dégâts, etc.
        System.out.println("Pouvoir spécial utilisé !");
        logger.info("Pouvoir spécial utilisé");
    }

    public static void main(String[] args) {
        Jeu jeu = new Jeu();
        jeu.demarrer();
    }
}