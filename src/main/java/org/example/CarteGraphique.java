package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarteGraphique {
    private static final int TAILLE_CARTE = 10;
    private char[][] carte;
    private Hero hero;
    private List<Ennemi> ennemis;

    public CarteGraphique(int nombreEnnemis, Hero hero) {
        this.hero = hero;
        carte = new char[TAILLE_CARTE][TAILLE_CARTE];
        ennemis = new ArrayList<>();
        initialiserCarte(nombreEnnemis);
    }

    private void initialiserCarte(int nombreEnnemis) {
        for (int i = 0; i < TAILLE_CARTE; i++) {
            for (int j = 0; j < TAILLE_CARTE; j++) {
                carte[i][j] = '.';
            }
        }
        hero.setPositionX(TAILLE_CARTE / 2);
        hero.setPositionY(TAILLE_CARTE / 2);
        carte[hero.getPositionX()][hero.getPositionY()] = 'J';

        Random random = new Random();
        TypeEnnemi[] typesEnnemis = TypeEnnemi.values();
        for (int i = 0; i < nombreEnnemis; i++) {
            int x, y;
            do {
                x = random.nextInt(TAILLE_CARTE);
                y = random.nextInt(TAILLE_CARTE);
            } while (carte[x][y] != '.');
            TypeEnnemi typeAleatoire = typesEnnemis[random.nextInt(typesEnnemis.length)];
            Ennemi ennemi = new Ennemi(typeAleatoire, i);
            ennemi.setPositionX(x);
            ennemi.setPositionY(y);
            ennemis.add(ennemi);
            carte[x][y] = 'E';
        }
    }

    public void afficherCarte() {
        for (int i = 0; i < TAILLE_CARTE; i++) {
            for (int j = 0; j < TAILLE_CARTE; j++) {
                System.out.print(carte[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void deplacerJoueur(char direction) {
        carte[hero.getPositionX()][hero.getPositionY()] = '.';
        switch (direction) {
            case 'w' -> hero.setPositionX(Math.max(hero.getPositionX() - 1, 0));
            case 's' -> hero.setPositionX(Math.min(hero.getPositionX() + 1, TAILLE_CARTE - 1));
            case 'a' -> hero.setPositionY(Math.max(hero.getPositionY() - 1, 0));
            case 'd' -> hero.setPositionY(Math.min(hero.getPositionY() + 1, TAILLE_CARTE - 1));
        }
        carte[hero.getPositionX()][hero.getPositionY()] = 'J';
    }

    public boolean joueurSurEnnemi() {
        for (Ennemi ennemi : ennemis) {
            if (ennemi.getPositionX() == hero.getPositionX() && ennemi.getPositionY() == hero.getPositionY()) {
                return true;
            }
        }
        return false;
    }

    public Ennemi getEnnemiALaPosition(int x, int y) {
        for (Ennemi ennemi : ennemis) {
            if (ennemi.getPositionX() == x && ennemi.getPositionY() == y) {
                return ennemi;
            }
        }
        return null;
    }

    public List<Ennemi> getEnnemis() {
        return ennemis;
    }

    public void retirerEnnemi(Ennemi ennemi) {
        ennemis.remove(ennemi);
        carte[ennemi.getPositionX()][ennemi.getPositionY()] = '.';
    }
}