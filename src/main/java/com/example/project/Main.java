package com.example.project;

import java.util.Arrays;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        player.addCard(new Card("A", "♠"));
        player.addCard(new Card("6", "♦"));
        
        // Community Cards
        ArrayList<Card> communityCards = new ArrayList<>();
        communityCards.add(new Card("5", "♣"));
        communityCards.add(new Card("2", "♠"));
        communityCards.add(new Card("3", "♠"));
        
        player.playHand(communityCards);
        String handResult = player.playHand(communityCards);
        System.out.println(handResult);
        System.out.println(player.getHand());
        System.out.println(player.getAllCards());
        for (int i = 0; i < 13; i++) {
            System.out.print(player.grf(i) + " ");
        }
        System.out.println("");
        int HCval = 0;
        for (int HC = 12; HC > 0; HC--) {
            if (player.grf(HC) >= 1) {
                HCval = HC;
                break;
            }
        }   
        System.out.println(Utility.getRankValue(Utility.getRanks()[HCval]));

    }
}
