package org.example;

import java.util.List;
import java.util.Random;

public class CardClass  extends DeckClass{
    private int total;

    public List<String> CardNumber(List<String> CardList, boolean start, List<String> PreviousList){
        String card;
        Random r=new Random();
        if(start){
            for(int i=0;i<2;i++)
            {
                int index=r.nextInt(CardList.size());
                card=(String) CardList.get(index);
                gettotal(card);
                PreviousList.add(card);
            }
        } else {
            int index=r.nextInt(CardList.size());
            card=(String) CardList.get(index);
            PreviousList.add(card);
            gettotal(card);
        }
        for(int i=0;i<PreviousList.size();i++)
        {
            System.out.println(PreviousList.get(i));
        }
        return PreviousList;
    }
    public int GetCardsTotal(int PreviousTotal)
    {
        return this.total = PreviousTotal;
    }
    private int gettotal(String card) {
        int value=0;
        String[] Totalarr=card.split(" of");
        switch(Totalarr[0])
        {
            case "Jack":
                value=11;
                break;
            case "Queen":
                value=12;
                break;
            case "King":
                value=13;
                break;
            case "Ace":
                value=1;
                break;
            default:value= Integer.parseInt(Totalarr[0]);
        }
        total=total+value;
        return total;
    }
}
