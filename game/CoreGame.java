package game;

import cards.Card;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoreGame {
    public static List<Card> 
    pioche = new ArrayList<Card>(), // Pioche principale
    carteDefausse = new ArrayList<Card>(); // Liste des cartes défaussées (Cartes visibles pour tous les joueurs)
    public static List<Player> joueurs = new ArrayList<Player>();

    public Player demanderCible(Player joueurActif, List<Player> joueurs) {
        //Liste des joueurs donnée en paramètre != liste globale des joueurs, uniquement ceux encore en jeu
        Scanner sc = new Scanner(System.in);
        boolean selectionValide = false; //Flag pour le while

            System.out.println("\n" + joueurActif.getNom() + ", qui vises tu ? :");
            System.out.print("Nom : ");

        while(!selectionValide)
            {
                String nomChoisi = sc.nextLine().trim();
                // Cherche un joueur avec ce nom
                for (Player p : joueurs) 
                    {
                        if (p.getNom().equalsIgnoreCase(nomChoisi) && ((p.isElimine()) || (p.hasProtection()))) 
                            {
                                System.out.println("Vous ne pouvez pas choisir ce joueur. Choisissez-en un autre.");
                            }
                        else if (p.getNom().equalsIgnoreCase(nomChoisi) && CoreGame.joueurs.contains(p)) 
                            {
                                selectionValide = true;
                                return p; //Retourne le joueur ciblé
                            }
                        else
                            {
                                System.out.println("Aucun joueur ne s'appelle \"" + nomChoisi + "\".");
                            }
                        }
            }
        return null; //Au cas où
    }
}

