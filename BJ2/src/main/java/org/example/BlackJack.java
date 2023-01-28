package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlackJack {
    public static List<String> ReturnCardList= new ArrayList<>();    public static char option1 ='y',option2='y';
    public static boolean start=true,DealerTrigger=true;
    public static int UpdatedTotal=0,PlayerTotal=0,DealerTotal=0;
    ArrayList[] list;
    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        DeckClass deck=new DeckClass();

        List<String> list = deck.GetCards();
        CardClass c=new CardClass();
        do{
            do
            {
                System.out.println("Player Side:");
                ReturnCardList=c.CardNumber(list,start,ReturnCardList);
                UpdatedTotal=c.GetCardsTotal(UpdatedTotal);
                start=false;
                if(UpdatedTotal <=21)
                {
                    System.out.println("Do you want to hit card again y/n");
                    option2=s.next().charAt(0);
                    option2=Character.toLowerCase(option2);
                }
                else
                {
                    System.out.println("Dealer Won the game");
                    option2='n';
                    DealerTrigger=false;
                }
            }while(option2 == 'y');

            if(option2 == 'n' && DealerTrigger == true)
            {
                PlayerTotal=UpdatedTotal;
                start=true;
                ReturnCardList.clear();
                System.out.println("Dealer Side:");
                UpdatedTotal=0;
                while(UpdatedTotal <=21 && DealerTotal<=16)
                {
                    if(PlayerTotal != DealerTotal)
                    {
                        ReturnCardList=c.CardNumber(list,start,ReturnCardList);
                        UpdatedTotal=c.GetCardsTotal(UpdatedTotal);
                        start=false;
                        DealerTotal=UpdatedTotal;
                    }
                    else if(PlayerTotal == DealerTotal)
                    {
                        DealerTotal=0;
                        PlayerTotal=0;
                        System.out.println("Your Total: "+PlayerTotal+" !Delare Total: "+DealerTotal+" DRAW");
                    }

                }
                if(PlayerTotal > DealerTotal && PlayerTotal <= 21)
                {
                    System.out.println("Your is BlackJack! Congrats");
                }
                else if(DealerTotal > PlayerTotal && DealerTotal <= 21)
                {
                    System.out.println("Dealer is BlackJack!You Lose");
                }
                else if(PlayerTotal < DealerTotal && DealerTotal > 21)
                {
                    System.out.println("Your is BlackJack! Congrats");
                }
                else if(DealerTotal < PlayerTotal && PlayerTotal > 21)
                {
                    System.out.println("Dealer is BlackJack!You Lose");
                } else if (DealerTotal == PlayerTotal)
                {
                    System.out.println("Dealer "+DealerTotal+" You "+PlayerTotal+"!Draw.");
                }
            }
            System.out.println("Do you want to Play Again y/n");
            option1=s.next().charAt(0);
            option1=Character.toLowerCase(option1);
            if(option1 == 'y')
            {
                ResetGame();
            }
        }while(option1 =='y');
    }
    public static void ResetGame()
    {
        ReturnCardList.clear();
        start=true;
        UpdatedTotal=0;
        PlayerTotal=0;
        DealerTotal=0;
        DealerTrigger=true;
    }
}