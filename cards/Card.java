package cards;

import game.CoreGame;
import game.Player;
import java.util.List;
import java.util.Scanner;

public abstract class Card {

    // Enum pour représenter l'état de la carte
    public enum State {
        CACHEE,    // carte mise de côté au début
        DANS_PIOCHE,
        DANS_MAIN,
        DEFAUSSEE
    }

    private static int compteurId = 0; 
    //C'est bon en private car le constructeur mère est appelé avant

    // Attributs de la classe
    protected int idCard;
    protected String nameCard;
    protected State stateCard;
    protected int valueCard;
    protected Player userCard;

    public Card(String nameCard,int valueCard) {
        this.idCard = compteurId++;
        this.nameCard = nameCard;
        this.valueCard = valueCard;
        this.stateCard = State.DANS_PIOCHE; // par défaut : dans la pioche
        this.userCard = null; //La carte n'appartient à aucun joueur
    }

    // Getters
    public int getIdCard() {
        return this.idCard;
    }

    public String getNameCard() {
        return this.nameCard;
    }

    public State getStateCard() {
        return this.stateCard;
    }

    public int getValueCard() {
        return this.valueCard;
    }

    public Player getUserCard() {
        return this.userCard;
    }

    // Méthodes pour changer l'état
    public void mettreDansPioche() {
        this.stateCard = State.DANS_PIOCHE;
        CoreGame.pioche.add(0, this); //Place la carte au-dessous de la pioche
    }

    public void mettreDansMain(Player player) {
        this.stateCard = State.DANS_MAIN;
        player.hand.add(this);
        this.userCard = player;
        }

    public void defausser() {
        this.stateCard = State.DEFAUSSEE;
    }

    public void cacher() {
        this.stateCard = State.CACHEE;
    }

    @Override //Pour afficher la carte au joueur
    public String toString() {
        return "Card{id=" + idCard +
               ", name='" + nameCard + '\'' +
               ", state=" + stateCard +
               '}';
    }

    public static Player demanderCible(Player userCard) {
        Scanner sc = new Scanner(System.in);

        while(true) { //C'est pas une boucle infinie ?
            System.out.println("\n" + userCard.getNom() + ", qui vises tu ? :");
            System.out.print("Nom : ");
            String nomChoisi = sc.nextLine().trim();

            // Cherche un joueur avec ce nom
            for (Player p : CoreGame.joueurs) {
                if (p.getNom().equalsIgnoreCase(nomChoisi) && !(p.isElimine()) && !(p.hasProtection())) { //Si on mettais un while pour vérifier que la selection est valide ? Il faudrait aussi vérifier si le joueur n'est pas éliminé ou protégé sinon il choisit quelqu'un d'autre
                    return p; //Donc retourner un joueur
                }
            }

            // Si pas trouvé
            System.out.println("Aucun joueur ne s'appelle \"" + nomChoisi + "\".");
        }
    }

    // Méthode "virtuelle pure" (méthode abstraite)
    // Elle devra être définie dans chaque sous-classe 
    public abstract void appliquerEffet(); 
    //Paramètres à changer en fonction des cartes
}

