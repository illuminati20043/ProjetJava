package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {

        System.out.println("Bienvenue sur le projet de Adam GUIZAOUI et Elyes AÏSSAT");

        //Initialisation du jeu
        Jeu jeu = new Jeu();

        //Selection du personnage
        Hero hero = jeu.selectionHero();

        //Selection de la carte
        Carte carte = jeu.selectionCarte();
        jeu.genererEnnemis(carte);

        //lecture des données entrées pas l'utilisateur
        Scanner scanner = new Scanner(System.in);


        // BOUCLE DU JEU
        boolean enJeu = true;
        while(enJeu && hero.getPv() > 0 && !carte.getEnnemis().isEmpty()) {

            System.out.println("\nChoisir une action");
            System.out.println("1. Combattre un ennemi");
            System.out.println("2. Quitter le jeu");

            int choix = scanner.nextInt();
            switch(choix){
                case 1 :
                    Ennemi ennemi = carte.getEnnemis().removeFirst();
                    System.out.println("Vous affrontez un " + ennemi.getType());
                    jeu.lancerCombat(hero, ennemi);
                    if (hero.getPv() <= 0) {
                        enJeu = false;
                        System.out.println("Game Over");
                    } else if (carte.getEnnemis().isEmpty()) {
                        System.out.println("Vous avez terminé la carte !");
                        enJeu = false;
                    }
                    System.out.println(carte.getEnnemis());
                    break;
                case 2:
                    enJeu = false;
                    System.out.println("Vous avez quitté le jeu! Merci pour y avoir joué");
                    break;
                default:
                    System.out.print("Choix invalide");
            }
        }

        // fermer le scanner
        scanner.close();
    }
}