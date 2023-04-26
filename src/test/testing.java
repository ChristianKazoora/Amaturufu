package test;
import main.backend.Card;
import main.backend.Deck;
import main.backend.Loader;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class testing {

@Test
void checkIfShuffled()
{
    Card[] cards ={ new Card("2", "Spade"),new Card("3", "Spade"),new Card("4", "Spade"),new Card("5", "Spade")};
    Deck deal = new Deck();
    assertEquals(36,deal.Deck.size(),"No cards in the Deck");
    Card [] deckCards={deal.Deck.get(0),deal.Deck.get(1),deal.Deck.get(2),deal.Deck.get(3)};
    assertNotEquals(cards[3].toString(),deckCards[3].toString());
}


@Test
    void checkIfPlayerCardIsInDeck()
{
    Deck deal = new Deck();
    deal.startingPick();
    Card card = deal.playerCards.get(0);
    assertTrue(Loader.Deck.contains(card));
}



}
