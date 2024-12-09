package org.example;

import java.util.List;

/**
 * La classe Carte représente une carte dans le jeu.
 * Elle contient des informations sur le nom, le lieu, les positions de début et de fin, la difficulté et les ennemis présents sur la carte.
 */
public class Carte {

    // Définition des attributs de la Carte
    private String nom; // Nom de la carte
    private String lieu; // Lieu de la carte
    private int debut; // Position de début sur la carte
    private int fin; // Position de fin sur la carte
    private int difficulte; // Niveau de difficulté de la carte
    private List<Ennemi> ennemis; // Liste des ennemis présents sur la carte

    /**
     * Constructeur de la classe Carte.
     * Initialise une carte avec ses attributs.
     *
     * @param nom        Nom de la carte.
     * @param lieu       Lieu de la carte.
     * @param fin        Position de fin sur la carte.
     * @param ennemis    Liste des ennemis présents sur la carte.
     * @param debut      Position de début sur la carte.
     * @param difficulte Niveau de difficulté de la carte.
     */
    public Carte(String nom, String lieu, int fin, List<Ennemi> ennemis, int debut, int difficulte) {
        this.nom = nom;
        this.lieu = lieu;
        this.fin = fin;
        this.ennemis = ennemis;
        this.debut = debut;
        this.difficulte = difficulte;
    }

    // Getters et Setters

    /**
     * Retourne le nom de la carte.
     *
     * @return Le nom de la carte.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom de la carte.
     *
     * @param nom Le nouveau nom de la carte.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne le lieu de la carte.
     *
     * @return Le lieu de la carte.
     */
    public String getLieu() {
        return lieu;
    }

    /**
     * Définit le lieu de la carte.
     *
     * @param lieu Le nouveau lieu de la carte.
     */
    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    /**
     * Retourne la position de fin sur la carte.
     *
     * @return La position de fin sur la carte.
     */
    public int getFin() {
        return fin;
    }

    /**
     * Définit la position de fin sur la carte.
     *
     * @param fin La nouvelle position de fin sur la carte.
     */
    public void setFin(int fin) {
        this.fin = fin;
    }

    /**
     * Retourne la position de début sur la carte.
     *
     * @return La position de début sur la carte.
     */
    public int getDebut() {
        return debut;
    }

    /**
     * Définit la position de début sur la carte.
     *
     * @param debut La nouvelle position de début sur la carte.
     */
    public void setDebut(int debut) {
        this.debut = debut;
    }

    /**
     * Retourne le niveau de difficulté de la carte.
     *
     * @return Le niveau de difficulté de la carte.
     */
    public int getDifficulte() {
        return difficulte;
    }

    /**
     * Définit le niveau de difficulté de la carte.
     *
     * @param difficulte Le nouveau niveau de difficulté de la carte.
     */
    public void setDifficulte(int difficulte) {
        this.difficulte = difficulte;
    }

    /**
     * Retourne la liste des ennemis présents sur la carte.
     *
     * @return La liste des ennemis présents sur la carte.
     */
    public List<Ennemi> getEnnemis() {
        return ennemis;
    }

    /**
     * Définit la liste des ennemis présents sur la carte.
     *
     * @param ennemis La nouvelle liste des ennemis présents sur la carte.
     */
    public void setEnnemis(List<Ennemi> ennemis) {
        this.ennemis = ennemis;
    }
}