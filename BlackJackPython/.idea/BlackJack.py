import array



class Cards:
    def getCard(self):
        print()
class Decks:
    def shuffle(self):
        ranks = ["2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"];
        suits = ["Clubs", "Hearts", "Diamonds", "Spades"];
        DeckOfCards = []
        for i in suits:
            for j in ranks:
                cardValues = ranks[j] + " of " + suits[i]
                DeckOfCards.append(cardValues)
        return DeckOfCards;


class BlackJack:
    def main():
        start= True
        UpdatedTotal
        DecksObj=Decks()
        cardlist=DecksObj.shuffle()
        CardsObj=Cards()
        while True:
            print("Player Side")
            ReturnCardList=CardsObj.getCard(cardlist,start,ReturnCardList,UpdatedTotal)
            if

if __name__ == "__main__":
    bj=BlackJack
    bj.main()