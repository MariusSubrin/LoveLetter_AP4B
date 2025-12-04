package cards;

import java.util.Scanner;

import game.Player;

public class Prince extends Card {
    @Override
    public void appliquerEffet() {
        // L'effet du Prince est de faire défausser une carte à un joueur ciblé.
        System.out.println("Le Prince a été joué. Un joueur ciblé défausse sa main.");
        
        Card.demanderCible().defausser(); // TODO Est ce que tout fonctionne ?

    public Prince() {
        super("Prince", 5);
    }
   
}
