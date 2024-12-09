package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * La classe CarteGraphique représente une carte de jeu en 2D avec un héros, des ennemis et des buissons.
 * Elle permet de gérer l'affichage de la carte, le déplacement du héros et les interactions avec les ennemis.
 */
public class CarteGraphique {
    private static final int TAILLE_CARTE = 10; // Taille de la carte (10x10)
    private char[][] carte; // Grille de la carte
    private Hero hero; // Héros du jeu
    private List<Ennemi> ennemis; // Liste des ennemis sur la carte

    /**
     * Constructeur de la classe CarteGraphique.
     * Initialise la carte avec un nombre donné d'ennemis et place le héros au centre.
     *
     * @param nombreEnnemis Nombre d'ennemis à générer sur la carte.
     * @param hero          Le héros du jeu.
     */
    public CarteGraphique(int nombreEnnemis, Hero hero) {
        this.hero = hero;
        carte = new char[TAILLE_CARTE][TAILLE_CARTE];
        ennemis = new ArrayList<>();
        initialiserCarte(nombreEnnemis);
    }

    /**
     * Initialise la carte en plaçant le héros au centre, en générant des ennemis et des buissons aléatoirement.
     *
     * @param nombreEnnemis Nombre d'ennemis à générer sur la carte.
     */
    private void initialiserCarte(int nombreEnnemis) {
        Random random = new Random();

        // Placer des buissons aléatoirement
        int nombreBuissons = TAILLE_CARTE; // Par exemple, un buisson par ligne
        for (int i = 0; i < nombreBuissons; i++) {
            int x, y;
            do {
                x = random.nextInt(TAILLE_CARTE);
                y = random.nextInt(TAILLE_CARTE);
            } while (carte[x][y] != '\0'); // Assurer que la case est vide
            carte[x][y] = '#'; // Utiliser '#' pour buisson
        }

        // Placer le héros au centre
        hero.setPositionX(TAILLE_CARTE / 2);
        hero.setPositionY(TAILLE_CARTE / 2);
        carte[hero.getPositionX()][hero.getPositionY()] = 'H';

        // Générer des ennemis aléatoirement
        TypeEnnemi[] typesEnnemis = TypeEnnemi.values();
        for (int i = 0; i < nombreEnnemis; i++) {
            int x, y;
            do {
                x = random.nextInt(TAILLE_CARTE);
                y = random.nextInt(TAILLE_CARTE);
            } while (carte[x][y] != '\0'); // Assurer que la case est vide
            TypeEnnemi typeAleatoire = typesEnnemis[random.nextInt(typesEnnemis.length)];
            Ennemi ennemi = new Ennemi(typeAleatoire, i);
            ennemi.setPositionX(x);
            ennemi.setPositionY(y);
            ennemis.add(ennemi);
            carte[x][y] = 'E';
        }

        // Remplir les cases vides avec des points
        for (int i = 0; i < TAILLE_CARTE; i++) {
            for (int j = 0; j < TAILLE_CARTE; j++) {
                if (carte[i][j] == '\0') {
                    carte[i][j] = '.';
                }
            }
        }
    }

    /**
     * Affiche la carte sur le terminal.
     */
    public void afficherCarte() {
        System.out.println(); // Laisser un espace avant l'affichage

        // Calcul pour centrer les bordures en fonction de la largeur totale de la carte
        int largeurTotale = TAILLE_CARTE * 2 + 3; // 2 caractères par colonne + bordures (| et espace)
        int padding = (largeurTotale - (TAILLE_CARTE * 2 + 1)) / 2;

        // Ligne supérieure de bordure
        System.out.print(" ".repeat(padding));
        System.out.print("-");
        for (int j = 0; j < TAILLE_CARTE; j++) {
            System.out.print("--");
        }
        System.out.println("-");

        // Contenu de la carte avec bordures
        for (int i = 0; i < TAILLE_CARTE; i++) {
            System.out.print(" ".repeat(padding)); // Ajouter l'espacement
            System.out.print("|"); // Bordure gauche
            for (int j = 0; j < TAILLE_CARTE; j++) {
                System.out.print(carte[i][j] + " ");
            }
            System.out.println("|"); // Bordure droite
        }

        // Ligne inférieure de bordure
        System.out.print(" ".repeat(padding));
        System.out.print("-");
        for (int j = 0; j < TAILLE_CARTE; j++) {
            System.out.print("--");
        }
        System.out.println("-");
        System.out.println(); // Laisser un espace après l'affichage
    }

    /**
     * Déplace le héros sur la carte en fonction de la direction donnée.
     *
     * @param direction La direction du déplacement ('w' pour haut, 's' pour bas, 'a' pour gauche, 'd' pour droite).
     */
    public void deplacerJoueur(char direction) {
        int newX = hero.getPositionX();
        int newY = hero.getPositionY();

        // Effacer la position actuelle du héros
        carte[hero.getPositionX()][hero.getPositionY()] = '.'; // Remplacer l'ancienne position par un point (vide)

        // Mettre à jour la position selon la direction
        switch (direction) {
            case 'w' -> newX = Math.max(hero.getPositionX() - 1, 0);
            case 's' -> newX = Math.min(hero.getPositionX() + 1, TAILLE_CARTE - 1);
            case 'a' -> newY = Math.max(hero.getPositionY() - 1, 0);
            case 'd' -> newY = Math.min(hero.getPositionY() + 1, TAILLE_CARTE - 1);
        }

        // Vérifier si la nouvelle position est un buisson
        if (carte[newX][newY] != '#') { // Vérifier qu'il n'y a pas de buisson
            // Mettre à jour la position du héros
            hero.setPositionX(newX);
            hero.setPositionY(newY);
            carte[hero.getPositionX()][hero.getPositionY()] = 'H'; // Placer le héros avec "H" à sa nouvelle position
        }
    }


    /**
     * Vérifie si le héros se trouve sur la même case qu'un ennemi.
     *
     * @return true si le héros est sur un ennemi, false sinon.
     */
    public boolean joueurSurEnnemi() {
        for (Ennemi ennemi : ennemis) {
            if (ennemi.getPositionX() == hero.getPositionX() && ennemi.getPositionY() == hero.getPositionY()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retourne l'ennemi à une position donnée sur la carte.
     *
     * @param x Coordonnée x de la position.
     * @param y Coordonnée y de la position.
     * @return L'ennemi à la position donnée, ou null s'il n'y a pas d'ennemi à cette position.
     */
    public Ennemi getEnnemiALaPosition(int x, int y) {
        for (Ennemi ennemi : ennemis) {
            if (ennemi.getPositionX() == x && ennemi.getPositionY() == y) {
                return ennemi;
            }
        }
        return null;
    }

    /**
     * Retourne la liste des ennemis sur la carte.
     *
     * @return La liste des ennemis.
     */
    public List<Ennemi> getEnnemis() {
        return ennemis;
    }

    /**
     * Retire un ennemi de la carte et de la liste des ennemis.
     *
     * @param ennemi L'ennemi à retirer.
     */
    public void retirerEnnemi(Ennemi ennemi) {
        ennemis.remove(ennemi);
        carte[ennemi.getPositionX()][ennemi.getPositionY()] = '.';
    }
}
