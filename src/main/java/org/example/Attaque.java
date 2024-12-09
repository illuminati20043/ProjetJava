package org.example;

/**
 * La classe Attaque gère les attaques entre personnages dans le jeu.
 * Elle permet de lancer une attaque, de calculer les dégâts et d'afficher le résultat de l'attaque.
 */
public class Attaque {

    /**
     * Lance une attaque d'un personnage attaquant vers un personnage défenseur.
     *
     * @param attaquant Le personnage qui attaque.
     * @param defenseur Le personnage qui défend.
     */
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

    /**
     * Calcule les dégâts infligés par l'attaquant au défenseur.
     *
     * @param attaquant Le personnage qui attaque.
     * @param defenseur Le personnage qui défend.
     * @return Les dégâts infligés.
     */
    private static int calculerDegats(Personnage attaquant, Personnage defenseur) {
        // Calcul de la force de l'attaque moins la défense de l'ennemi
        int forceAttaque = attaquant.getDegatsForceAttaque();
        int defense = (int) defenseur.getDefense();
        int degats = forceAttaque - defense;

        // Les dégâts ne peuvent pas être négatifs
        return Math.max(degats, 0);
    }

    /**
     * Affiche le résultat de l'attaque.
     *
     * @param degats Les dégâts infligés.
     */
    private static void afficherResultatAttaque(int degats) {
        // Affichage des dégâts infligés
        System.out.println("Attaque (basique) : -" + degats + " PV");
    }
}