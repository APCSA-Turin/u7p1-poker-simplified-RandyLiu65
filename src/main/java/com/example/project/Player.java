package com.example.project;
import java.util.ArrayList;
import java.util.Arrays;


public class Player{
    private ArrayList<Card> hand; // the player's cards in hand
    private ArrayList<Card> allCards; // the current community cards + hand
    String[] suits  = Utility.getSuits();
    String[] ranks = Utility.getRanks();
    
    public Player(){ // initialize hand and allCards variables
        hand = new ArrayList<>(); 
        allCards = new ArrayList<>();
    }

    public ArrayList<Card> getHand(){return hand;} // get player hand
    public ArrayList<Card> getAllCards(){return allCards;} // get all card (player hand + community cards)

    public void addCard(Card c){
        hand.add(c);
        allCards.add(c);
    }

    public String playHand(ArrayList<Card> communityCards){
        // initiate allCards variable
        allCards.clear();
        allCards.addAll(hand);
        allCards.addAll(communityCards);
        // ------- Check Royal Flush
        if (grf(8) == 1 && grf(9) == 1 && grf(10) == 1 && grf(11) == 1 && grf(12) == 1) {
            for (int x = 0; x < 4;  x++) {
                if (gsf(x) == 5) {
                    return "Royal Flush";
                }
            }
        }
        // ------- Check Straight Flush
        int SFcount = 0;
        for (int s = 0; s < 4; s++) {
            if (gsf(s) == 5) {
                for (int r = 0; r < 13; r++) {
                    if (grf(r) >= 1) {
                        SFcount++;
                        if (SFcount == 5) {
                            break;
                        }
                    } else {
                        SFcount = 0;
                    }
                }
            }
        }
        if (SFcount == 5) {
            return "Straight Flush";
        }
        
            
        // ------- Check Four of a Kind
        for (int x = 0; x < 13;  x++) {
            if (grf(x) == 4) {
                return "Four of a Kind";
            }
        }
        // ------- Check Full House
        for (int x = 0; x < 13;  x++) {
            if (grf(x) == 3) {
                for (int y = 0; y < 13;  y++) {
                    if (grf(y) == 2) {
                        return "Full House";
                    }
                }
            }
        }
        // ------- Check Flush
        for (int x = 0; x < 4;  x++) {
            if (gsf(x) == 5) {
                return "Flush";
            }
        }
        // ------- Check Straight
        int Scount = 0;
        for (int x = 0; x < 13;  x++) {
            if (grf(x) >= 1) {
                Scount++;
                if (Scount == 5) {
                    break;
                }
            } else {
                Scount = 0;
            }
        }
        if (Scount == 5) {
            return "Straight";
        }
        // ------- Check Three of a Kind
        for (int x = 0; x < 13;  x++) {
            if (grf(x) == 3) {
                return "Three of a Kind";
            }
        }
        // ------- Check Two Pair
        int TPcount = 0;
        for (int x = 0; x < 13;  x++) {
            if (grf(x) == 2){
                TPcount++;
            }
        }
        if (TPcount == 2) {
            return "Two Pair";
        }
        // ------- Check A Pair
        for (int x = 0; x < 13;  x++) {
            if (grf(x) == 2) {
                return "A Pair";
            }
        }
        // ------- Check High Card
        int HCval = 0;
        for (int HC = 12; HC > 0; HC--) {
            if (grf(HC) >= 1) {
                HCval = HC;
                break;
            }
        }   
        if (Utility.getRankValue(hand.get(0).getRank()) == Utility.getRankValue(Utility.getRanks()[HCval]) || Utility.getRankValue(hand.get(1).getRank()) == Utility.getRankValue(Utility.getRanks()[HCval])) {
            return "High Card";
        }
        // Finally returns nothing if all hand types above are invalid
        return "Nothing";
    }

    public void sortAllCards(){
        if (allCards.isEmpty()) {return;} // checks if allCards is empty and ends the method if so
        for (int i = 0; i < allCards.size() - 1; i++) { // selection sort
            for (int j = i + 1; j < allCards.size(); j++) {
                if (Utility.getRankValue(allCards.get(i).getRank()) > Utility.getRankValue(allCards.get(j).getRank())) {
                    Card tempCard = allCards.get(i);
                    allCards.set(i, allCards.get(j));
                    allCards.set(j, tempCard);
                }
            }
        }
    } 

    public ArrayList<Integer> findRankingFrequency(){ // checking every card of allCards for each card ranking freq and adds it to an ArrayList
        int two = 0; int three = 0; int four = 0;int five= 0; int six = 0; int seven = 0; int eight = 0; int nine = 0; int ten = 0; int J = 0; int Q = 0; int K = 0; int ace = 0;
        for (Card card : allCards) {
            if (card.getRank().equals("2")) {
                two++;
            } else if (card.getRank().equals("3")) {
                three++;
            } else if (card.getRank().equals("4")) {
                four++;
            } else if (card.getRank().equals("5")) {
                five++;
            } else if (card.getRank().equals("6")) {
                six++;
            } else if (card.getRank().equals("7")) {
                seven++;
            } else if (card.getRank().equals("8")) {
                eight++;
            } else if (card.getRank().equals("9")) {
                nine++;
            } else if (card.getRank().equals("10")) {
                ten++;
            } else if (card.getRank().equals("J")) {
                J++;
            } else if (card.getRank().equals("Q")) {
                Q++;
            } else if (card.getRank().equals("K")) {
                K++;
            } else if (card.getRank().equals("A")) {
                ace++;
            }
        }
        return new ArrayList<Integer>(Arrays.asList(two, three, four, five, six, seven, eight, nine, ten, J, Q, K, ace)); 
    }

    public ArrayList<Integer> findSuitFrequency() {  // similar to findRankFreq this one does it for suit freq
        //"♠","♥","♣", "♦”];
        int spades = 0; int hearts = 0; int clubs = 0; int diamonds = 0;
        for (Card card : allCards) {
            if (card.getSuit().equals(Utility.getSuits()[0])) {
                spades++;
            } else if (card.getSuit().equals(Utility.getSuits()[1])) {
                hearts++;
            } else if (card.getSuit().equals(Utility.getSuits()[2])) {
                clubs++;
            } else if (card.getSuit().equals(Utility.getSuits()[3])) {
                diamonds++;
            }
        }

        return new ArrayList<Integer>(Arrays.asList(spades, hearts, clubs, diamonds)); 
    }

   
    @Override
    public String toString(){
        return hand.toString();
    }

    // helper methods 
    // to get an index of my findRankingFrequency and findSuitfrequency ArrayLists easily and reduce code chunkiness
    public int grf(int idx){
        return findRankingFrequency().get(idx);
    }

    public int gsf(int idx){
        return findSuitFrequency().get(idx);
    }
}
