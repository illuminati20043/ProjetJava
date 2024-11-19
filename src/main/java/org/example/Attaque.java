package org.example;

public class Attaque {

    public static void lancerAttaque(Personnage attaquant, Personnage defenseur) {
        int degats = calculerDegats(attaquant, defenseur); // calculer les degats infligés
        defenseur.setPv(defenseur.getPv() - degats); // Infliger des degats

        afficherResultatAttaque(degats); // Afficher le résultat de l'attaque

        if (defenseur.getPv() <= 0) {
            System.out.println("L'adversaire est KO");
        } else {
            System.out.println("L'adversaire a encore " + defenseur.getPv() + " pv");
        }
    }

    public static int calculerDegats(Personnage attaquant, Personnage defenseur) {
        int forceAttaque = Integer.parseInt(attaquant.getForceAttaque());
        int defense = (int) defenseur.getDefense();
        int degats = forceAttaque - defense;
        return Math.max(degats, 0);
    }

    public static void afficherResultatAttaque(int degats) {
        System.out.println("Attaque (basique) : " + "-" + degats + " pv");
    }
}