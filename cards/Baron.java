package cards;

import game.CoreGame;
import game.Player;

public class Baron extends Card
{
    @Override
    public void appliquerEffet(Player joueurActif)
    {
        // L'effet du Baron est de comparer les mains avec un autre joueur.
        System.out.println("Le Baron a été joué. Comparaison des mains.");
        Player choix = CoreGame.demanderCible(joueurActif);
        if (choix.hand.get(0).valueCard > joueurActif.hand.get(0).valueCard)
        {
            System.out.println(choix.getNom() + " a une main plus forte. " + joueurActif.getNom() + " est éliminé.");
            joueurActif.elimination();
        }
        else if (choix.hand.get(0).valueCard < joueurActif.hand.get(0).valueCard)
        {
            System.out.println(joueurActif.getNom() + " a une main plus forte. " + choix.getNom() + " est éliminé.");
            choix.elimination();
        }
        else
        {
            System.out.println("Les mains sont égales. Aucun joueur n'est éliminé.");
        }

    }

    public Baron() 
    {
        super("Baron", 2);
    }
}