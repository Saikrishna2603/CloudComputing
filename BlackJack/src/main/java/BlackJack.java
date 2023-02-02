import java.util.*;
public class BlackJack
{
    public static List<String> ReturnCardList= new ArrayList<>();
    public static char option1 ='y',option2='y';
    public static boolean start=true,DealerTrigger=true;
    public static int UpdatedTotal=0,PlayerTotal=0,DealerTotal=0;
    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        decks d=new decks();
        d.shuffle();
        List<String> list = d.getList();
        Cards c=new Cards();
        do{
            do
            {
                System.out.println("Player Side:");
                ReturnCardList=c.CardValues(list,start,ReturnCardList,UpdatedTotal);
                UpdatedTotal=c.GetCardsTotal();
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

            if(option2 == 'n' && DealerTrigger)
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
                        ReturnCardList=c.CardValues(list,start,ReturnCardList,UpdatedTotal);
                        UpdatedTotal=c.GetCardsTotal();
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
class Cards extends decks
{
    public List<String> NewCardList=new ArrayList<String>();
    public int total=0;
    public List<String> CardValues(List<String> CardList,boolean start,List<String> PreviousList,int PreviousTotal)
    {
        NewCardList=PreviousList;
        total=PreviousTotal;
        Random r=new Random();
        String card="";
        if(start)
        {
            for(int i=0;i<2;i++)
            {
                int index=r.nextInt(CardList.size());
                card= CardList.get(index);
                gettotal(card);
                NewCardList.add(card);
            }
        }
        else if(!start)
        {
            int index=r.nextInt(CardList.size());
            card= CardList.get(index);
            NewCardList.add(card);
            gettotal(card);
        }
        System.out.println("-----------------------");
        for(int i=0;i<NewCardList.size();i++)
        {
            System.out.println(NewCardList.get(i));
        }
        System.out.println();
        System.out.println("The Total Points are:"+total);
        return NewCardList;
    }
    public int GetCardsTotal()
    {
        return this.total;
    }
    public int gettotal(String card)
    {
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
class decks
{
    public String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King","Ace"};
    public String[] suits ={"Clubs","Hearts","Spades","Diamonds"};
    public ArrayList<String> DecksofCards=new ArrayList<String>();
    public void shuffle()
    {
        String CardValue;
        for(int i=0;i<suits.length;i++)
        {
            for(int j=0;j<ranks.length;j++)
            {
                CardValue=ranks[j]+" of "+suits[i];
                DecksofCards.add(CardValue);
            }
        }
        setList(DecksofCards);
    }
    public void setList(ArrayList list) {
        this.DecksofCards = list;
    }
    public ArrayList getList() {
        return DecksofCards;
    }
}