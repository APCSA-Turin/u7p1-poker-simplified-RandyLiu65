package com.example.project;
import java.util.ArrayList;
import java.util.Collections;

public class Deck{
    private ArrayList<Card> cards;

    public Deck(){
        cards = new ArrayList<Card>();
        initializeDeck();
        shuffleDeck();
    }

    public ArrayList<Card> getCards(){
        return cards;
    }

    public  void initializeDeck(){ //hint.. use the utility class
        for(int i = 0; i < Utility.getSuits().length; i++){
            for(int j = 0; j < Utility.getRanks().length; j++){
                Card card = new Card(Utility.getSuits()[i], Utility.getRanks()[j]);
                cards.add(card);
            }
        }
    }

    public  void shuffleDeck(){ //You can use the Collections library or another method. You do not have to create your own shuffle algorithm
        Collections.shuffle(cards);
    }

    public  Card drawCard(){
        Card card = new Card("", "");
        if(!isEmpty()){
            card = cards.remove(0);
        } else {
            return null;
        }
       return card;
    }

    public  boolean isEmpty(){
        return cards.isEmpty();
    }
    
}