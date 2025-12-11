package cards;
import game.CoreGame;
import game.Player;

public class Chancelier extends Card {
    @Override
    public void appliquerEffet(Player joueurActif, CoreGame game) {
        // L'effet du Chancelier est de piocher 3 cartes et d'en remettre 2 sous la pioche.
        System.out.println("Le Chancelier a été joué. Pioche 3 cartes et en remet 2 sous la pioche.");
        // TODO Quand liste pioche créée
    }

    public Chancelier() {
        super("Chancelier", 9); // Le Chancelier a une valeur de 9
    }

}
