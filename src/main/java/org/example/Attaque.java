package org.example;

public class Attaque {

    public static void lancerAttaque(Personnage attaquant, Personnage defenseur) {
        // Calculer les dégâts infligés
        int degats = calculerDegats(attaquant, defenseur);

        // Assure que les PV du défenseur ne deviennent pas négatifs
        int nouveauxPv = Math.max(defenseur.getPv() - degats, 0);
        defenseur.setPv(nouveauxPv); // Appliquer les dégâts

        // Afficher le résultat de l'attaque
        afficherResultatAttaque(degats);

        // Vérifier l'état du défenseur après l'attaque
        if (defenseur.getPv() <= 0) {
            System.out.println(defenseur.getClass().getSimpleName() + " est KO");
            // En option, tu pourrais marquer l'ennemi comme vaincu ici.
        } else {
            System.out.println(defenseur.getClass().getSimpleName() + " a encore " + defenseur.getPv() + " PV");
        }
    }

    private static int calculerDegats(Personnage attaquant, Personnage defenseur) {
        // Calcul de la force de l'attaque moins la défense de l'ennemi
        int forceAttaque = attaquant.getDegatsForceAttaque();
        int defense = (int) defenseur.getDefense();
        int degats = forceAttaque - defense;

        // Les dégâts ne peuvent pas être négatifs
        return Math.max(degats, 0);
    }

    private static void afficherResultatAttaque(int degats) {
        // Affichage des dégâts infligés
        System.out.println("Attaque (basique) : -" + degats + " PV");
    }
}
