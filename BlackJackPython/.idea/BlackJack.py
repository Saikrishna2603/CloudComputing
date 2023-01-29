import array
import random


class Cards:
    def getTotal(self,card,previoustotal):
        value=0
        total=previoustotal
        Totalarr =card.split(" of")
        match Totalarr[0]:
            case "Jack":
                value=11;
            case "Queen":
                value=12;
            case "King":
                value=13;
            case "Ace":
                value=1;
            case default:
                value=int(Totalarr[0])
        total=previoustotal+value
        return total
    def getCard(self,cardlist,start,PreviousList,PreviousTotal):
        total=PreviousTotal
        NewCardList=PreviousList
        if start:
            for i in range(0,2):
                index=random.randrange(0,len(cardlist))
                card=cardlist[index]
                total=self.getTotal(card,total)
                NewCardList.append(card);
        elif not start:
            index=random.randrange(0,len(cardlist))
            card=cardlist[index]
            total=self.getTotal(card,total)
            NewCardList.append(card);
        print("--------------------")
        for i in range(len(NewCardList)):
            print(NewCardList[i])
        print("")
        print("The Total Points are:",total)
        self.total=total
        return NewCardList
    def getTotalValue(self):
        return self.total

class Decks:
    def shuffle(self):
        ranks = ["2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"];
        suits = ["Clubs", "Hearts", "Diamonds", "Spades"];
        DeckOfCards = []
        for i in range(len(suits)):
            for j in range(len(ranks)):
                cardValues = ranks[j] + " of " + suits[i]
                DeckOfCards.append(cardValues)
        return DeckOfCards;

class BlackJack:
    def main():
        option1='y'
        option2='y'
        cardList=[]
        DealerTrigger=True
        ReturnCardList=[]
        UpdatedTotal=0
        playerTotal=0
        DealerTotal=0
        start=True
        DecksObj=Decks()
        cardlist=DecksObj.shuffle()
        CardsObj=Cards()
        while True:
            while True:
                print("Player Side")
                ReturnCardList=CardsObj.getCard(cardlist,start,ReturnCardList,UpdatedTotal)
                UpdatedTotal=CardsObj.getTotalValue()
                start=False
                if (UpdatedTotal <= 21):
                    option2=input("Do You Want To hit card again y/n")
                    if(option2 == 'n'):
                        break
                else:
                    print("Dealer Won The Game")
                    option2='n'
                    DealerTrigger=False
                    break
            if(option2 == 'n' and DealerTrigger == True):
                playerTotal=UpdatedTotal
                start=True
                ReturnCardList.clear();
                print("Dealer Side")
                UpdatedTotal=0
                while(UpdatedTotal <=21 and DealerTotal<=16):
                    if(playerTotal !=DealerTotal):
                        ReturnCardList=CardsObj.getCard(cardlist,start,ReturnCardList,UpdatedTotal)
                        UpdatedTotal=CardsObj.getTotalValue()
                        start=False
                        DealerTotal=UpdatedTotal
                    elif(playerTotal == DealerTotal):
                        DealerTotal=0
                        playerTotal=0
                        print("Your Total:"+playerTotal+" !Dealer Total:"+DealerTotal+" DRAW")

                if(playerTotal > DealerTotal and playerTotal <= 21):
                    print("Your is BlackJack! Congrats")
                elif(DealerTotal > playerTotal and DealerTotal <= 21):
                    print("Dealer is BlackJack!You Lose")
                elif(playerTotal < DealerTotal and DealerTotal > 21):
                    print("Your is BlackJack! Congrats")
                elif(DealerTotal < playerTotal and playerTotal > 21):
                    println("Dealer is BlackJack!You Lose")
                elif (DealerTotal == playerTotal):
                        print("Dealer "+DealerTotal+" You "+playerTotal+"!Draw.");
            option1=input("Do You want to Play Again y/n")
            if(option1 == 'y'):
                ReturnCardList.clear()
                start=True
                DealerTrigger=True
                UpdatedTotal=0
                playerTotal=0
                DealerTotal=0
            elif(option1 == 'n'):
                break


if __name__ == "__main__":
    bj=BlackJack
    bj.main()