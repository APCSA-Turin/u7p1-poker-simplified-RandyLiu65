package com.example.project;
import java.util.ArrayList;


public class Game{
    public static String determineWinner(Player p1, Player p2,String p1Hand, String p2Hand,ArrayList<Card> communityCards){
        String play1 = p1.playHand(communityCards);
        String play2 = p2.playHand(communityCards);
        if (Utility.getHandRanking(play1) > Utility.getHandRanking(play2) ) {
            return "Player 1 wins!";
        } else if (Utility.getHandRanking(play1) < Utility.getHandRanking(play2)) {
            return "Player 2 wins!";
        } else if (Utility.getHandRanking(play1) == Utility.getHandRanking(play2)) {
            if (Utility.getRankValue(p1.getHand().get(0).getRank()) > Utility.getRankValue(p2.getHand().get(0).getRank())) {
                return "Player 1 wins!";
            } else if (Utility.getRankValue(p1.getHand().get(0).getRank()) < Utility.getRankValue(p2.getHand().get(0).getRank())) {
                return "Player 2 wins!";
            } else {
                return "Tie!";
            }
        }
        return "Error";
    }

    // public static void play(){ //simulate card playing
    //     Deck deck = new Deck();
    //     Player p1 = new Player();
    //     Player p2 = new Player();

    //     p1.addCard(deck.drawCard());
    //     p2.addCard(deck.drawCard());
    //     p1.addCard(deck.drawCard());
    //     p2.addCard(deck.drawCard());
    //     p1.sortAllCards();
    //     p2.sortAllCards();
    //     determineWinner(p1, p2, p1.getHand().toString(), p2.getHand().toString(), p1.get)
    // }
        
        

}