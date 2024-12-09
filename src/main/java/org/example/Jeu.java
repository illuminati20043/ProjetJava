package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;

public class Jeu {

    private static final Logger logger = Logger.getLogger(Jeu.class.getName());
    private List<Carte> cartesDisponibles;
    public boolean pouvoirDisponible;

    public Jeu() {
        cartesDisponibles = new ArrayList<>();
        cartesDisponibles.add(new Carte("New York - Times Square", "New York", 10, new ArrayList<>(), 0, 3));
        cartesDisponibles.add(new Carte("Tokyo - Shibuya Crossing", "Tokyo", 20, new ArrayList<>(), 0, 4));
        cartesDisponibles.add(new Carte("Paris - Champs-Élysées", "Paris", 15, new ArrayList<>(), 0, 2));
        cartesDisponibles.add(new Carte("Londres - Piccadilly Circus", "Londres", 18, new ArrayList<>(), 0, 3));
        cartesDisponibles.add(new Carte("Shanghai - The Bund", "Shanghai", 25, new ArrayList<>(), 0, 5));
        pouvoirDisponible = true;
        logger.info("Cartes disponibles initialisées");
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

    public Carte selectionCarte() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choisissez votre carte : ");
        for (int i = 0; i < cartesDisponibles.size(); i++) {
            Carte carte = cartesDisponibles.get(i);
            System.out.println((i + 1) + " : " + carte.getNom() + " (" + carte.getLieu() + ")");
        }

        int choix = -1;
        while (choix < 1 || choix > cartesDisponibles.size()) {
            System.out.print("Entrez votre choix de carte : ");
            choix = scanner.nextInt();
        }

        Carte carteChoisie = cartesDisponibles.get(choix - 1);
        logger.info("Carte choisie : " + carteChoisie.getNom());
        return carteChoisie;
    }

    public void genererEnnemis(Carte carte) {
        int nombreEnnemis = carte.getDifficulte() * 3;
        List<Ennemi> ennemis = new ArrayList<>();
        Random random = new Random();
        TypeEnnemi[] typesEnnemis = TypeEnnemi.values();

        for (int i = 0; i < nombreEnnemis; i++) {
            TypeEnnemi typeAleatoire = typesEnnemis[random.nextInt(typesEnnemis.length)];
            ennemis.add(new Ennemi(typeAleatoire, i, 30)); // Exemple : position i, dégâts 30
        }
        carte.setEnnemis(ennemis);
    }

    public void choixPouvoir(Personnage personnage, Carte carte) {
        if (!pouvoirDisponible) {
            System.out.println("Pouvoir spécial déjà utilisé !");
            return;
        }

        String _pouvoirSpecial = personnage.getForceAttaque();
        switch (_pouvoirSpecial) {
            case "Regénération":
                int ajout = personnage.getPv() + 40;
                personnage.setPv(ajout);
                break;
            case "Demacian Justice":
                int nouveauxDegats = personnage.getDegatsForceAttaque() + 20; // Augmente les dégâts de 20
                personnage.setDegatsForceAttaque(nouveauxDegats);
                break;
            case "Karthus Ult":
                List<Ennemi> ennemis = carte.getEnnemis(); // Utilisation de la carte sélectionnée
                for (Ennemi ennemi : ennemis) {
                    int pvRestants = ennemi.getPv() - 20; // Inflige 20 dégâts à chaque ennemi
                    ennemi.setPv(pvRestants);
                }
                break;
            default:
                logger.warning("Pouvoir spécial inconnu : " + _pouvoirSpecial);
                break;
        }

        pouvoirDisponible = false; // Met à jour la disponibilité du pouvoir
        logger.info("Pouvoir spécial utilisé : " + _pouvoirSpecial);
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
            }
        } else {
            System.out.println(attaquant.getClass().getSimpleName() + " a été vaincu !");
        }
    }
}
