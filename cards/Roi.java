package cards; //Fait parti du package cards

import game.CoreGame;
import game.Player;
import cards.Card;
import java.util.ArrayList;
import java.util.List;

public class Roi extends Card{
    @Override
    public void appliquerEffet(Player joueurActif) {
        // L'effet du Roi est d'échanger sa main avec un autre joueur.
        System.out.println("Le Roi a été joué. Échange de deux mains.");

        game.Player choix = demanderCible();
        List<Card> copie = new ArrayList<>(this.userCard.hand);
        this.userCard.hand = choix.hand;
        choix.hand = copie;
        //inversion des deux listes de mains

        
        
        // TODO A compléter lorsque liste de mains créée
    }

    public Roi() {
        super("Roi", 6);
    }
}
