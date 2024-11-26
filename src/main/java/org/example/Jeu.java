package org.example;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jeu {

    private List<Ennemi> listeEnnemis;
    private List<Carte> cartesDisponibles;


    public Jeu(){

            // Initialisation des cartes disponibles
            cartesDisponibles = new ArrayList<>();
            cartesDisponibles.add(new Carte("New York - Times Square", "New York", 10, new ArrayList<>(), 0, 3));
            cartesDisponibles.add(new Carte("Tokyo - Shibuya Crossing", "Tokyo", 20, new ArrayList<>(), 0, 4));
            cartesDisponibles.add(new Carte("Paris - Champs-Élysées", "Paris", 15, new ArrayList<>(), 0, 2));
            cartesDisponibles.add(new Carte("Londres - Piccadilly Circus", "Londres", 18, new ArrayList<>(), 0, 3));
            cartesDisponibles.add(new Carte("Shanghai - The Bund", "Shanghai", 25, new ArrayList<>(), 0, 5));


    }
    public Hero selectionHero(){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choisissez votre classe : ");
            System.out.println("1 : Tank (200 HP, 20 defense,Bouclier)");
            System.out.println("2 : Combattant (100 HP, 10 defense, Epee)");
            System.out.println("3 : Combattant (50 HP, 5 defense, Arc");
            TypeHero typeHero = null;
            int choix = scanner.nextInt();
            switch(choix){
                case 1, 3:
                    typeHero = TypeHero.Tank;
                    break;
                case 2 :
                    typeHero = TypeHero.Damage;
                    break;
                default :
                    System.out.println("Choix Indisponible");

            }
            return new Hero(0,typeHero,50);



    }
    public Carte selectionCarte() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choisissez votre carte : ");
        for (int i = 0; i < cartesDisponibles.size(); i++) {
            Carte carte = cartesDisponibles.get(i);
            System.out.println((i + 1) + " : " + carte.getNom() + " (" + carte.getLieu() + ")");
        }
        int choix = scanner.nextInt();
        if (choix > 0 && choix <= cartesDisponibles.size()) {
            return cartesDisponibles.get(choix - 1);
        } else {
            System.out.println("Choix Indisponible");
            return null;
        }
    }
    public void genererEnnemis(Carte carte) {
        int nombreEnnemis = carte.getDifficulte() * 3;
        List<Ennemi> ennemis = new ArrayList<>();
        Random random = new Random();
        TypeEnnemi[] typesEnnemis = TypeEnnemi.values();

        for (int i = 0; i < nombreEnnemis; i++) {
            TypeEnnemi typeAleatoire = typesEnnemis[random.nextInt(typesEnnemis.length)];
            ennemis.add(new Ennemi(typeAleatoire, i,30)); // Utilisez l'index comme position pour l'exemple
        }
        carte.setEnnemis(ennemis);
    }

    public void lancerCombat(Personnage attaquant, Personnage defenseur) {
        while (attaquant.getPv() > 0 && defenseur.getPv() > 0) {
            Attaque.lancerAttaque(attaquant, defenseur);
            if (defenseur.getPv() > 0) {
                Attaque.lancerAttaque(defenseur, attaquant);
            }
        }
        if (attaquant.getPv() <= 0) {
            System.out.println(attaquant.getClass() + " a été vaincu !");
        } else {
            System.out.println(defenseur.getClass() + " a été vaincu !");
        }
    }
}


