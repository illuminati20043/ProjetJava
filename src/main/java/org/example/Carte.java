package org.example;

import jdk.jshell.execution.JdiInitiator;

import java.util.List;

public class Carte {

    //Définition des attributs de la Carte
    String nom;
    String lieu;
    int debut;
    int fin;
    int difficulte;
    private List<Ennemi> ennemis;

    //Constructeur de la classe Carte


    public Carte(String nom, String lieu, int fin, List<Ennemi> ennemis, int debut, int difficulte) {
        this.nom = nom;
        this.lieu = lieu;
        this.fin = fin;
        this.ennemis = ennemis;
        this.debut = debut;
        this.difficulte = difficulte;
    }

    //Getters et Setters


    public String getNom() {
        return nom;
    }

    public String getLieu() {
        return lieu;
    }

    public int getFin() {
        return fin;
    }

    public int getDebut() {
        return debut;
    }
    public int getDifficulte(){
        return difficulte;
    }

    public List<Ennemi> getEnnemis() {
        return ennemis;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public void setDebut(int debut) {
        this.debut = debut;
    }

    public void setDifficulte(int difficulte){
        this.difficulte = difficulte;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }

    public void setEnnemis(List<Ennemi> ennemis) {
        this.ennemis = ennemis;
    }
}
