package cards;
import game.CoreGame;
import game.Player;

public class Prince extends Card {

    @Override
    public void appliquerEffet(Player joueurActif, CoreGame game) {
        // L'effet du Prince est de faire défausser une carte à un joueur ciblé.
        System.out.println("Le Prince a été joué. Un joueur ciblé défausse sa main.");

        Player cible = game.demanderCible(joueurActif);
        if (!cible.hand.isEmpty()) {
            cible.hand.get(0).defausser(cible);
            cible.hand.remove(0);
            //Piocher?
        }
    }

    public Prince() {
        super("Prince", 5);
    }

}
