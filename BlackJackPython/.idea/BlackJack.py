import array


class BlackJack:
    DecksObj=Decks(object)
    cardlist=DecksObj.shuffle()
class Cards:
    print()
class Decks(object):

    @classmethod
    def shuffle():
        ranks = ["2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"];
        suits = ["Clubs", "Hearts", "Diamonds", "Spades"];
        DeckOfCards = []
        for i in suits:
            for j in ranks:
                cardValues = ranks[j] + " of " + suits[i]
                DeckOfCards.append(cardValues)
        return DeckOfCards;