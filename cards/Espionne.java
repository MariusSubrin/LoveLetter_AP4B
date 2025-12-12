package cards;

import game.Player;

public class Espionne extends Card
{
    @Override
    public void appliquerEffet(Player joueurActif) {
        // L'effet de l'Espionne est un passif.
        System.out.println("L'Espionne a été joué.");
        joueurActif.espionneJouee();
    }

    public Espionne() {
        super("Espionne", 7);
    }
}
