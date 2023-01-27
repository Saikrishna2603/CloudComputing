import array


class BlackJack:

class Cards:

class Decks:

    @classmethod
    def shuffle(cls):
        ranks=["2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King","Ace"];
        suits=["Clubs","Hearts","Diamonds","Spades"];
        DeckOfCards=[]
        for i in suits:
            for j in ranks:
                cardValues=ranks[j]+" of "+suits[i]
                DeckOfCards.append(cardValues)

