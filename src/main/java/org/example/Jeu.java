package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jeu {

    private List<Ennemi> listeEnnemis;



    public Hero selectionHero(){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choisissez votre classe : ");
            System.out.println("1 : Tank (200 HP, 20 defense,Bouclier");
            System.out.println("2 : Combattant (100 HP, 10 defense, Epee");
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
            return new Hero(0,typeHero);



    }


}
