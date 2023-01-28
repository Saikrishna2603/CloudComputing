package org.example;

import java.util.ArrayList;

public class DeckClass {
    String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King","Ace"};
    String[] suits = {"Clubs","Hearts","Spades","Diamonds"};
    ArrayList<String> cards = new ArrayList<String>();

    public ArrayList<String> GetCards(){
        for(int i=0;i<suits.length;i++){
            for(int j=0;j< rank.length;j++){
                String randomcard = rank[j]+" of "+suits[i];
                cards.add(randomcard);
            }
        }
        return cards;
    }
}
