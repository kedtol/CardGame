import java.util.Collections;

public class SimpleDeck extends GameObject
{
    public Deck dumpDeck = new Deck();


    public void generate(DefaultDeck defaultDeck)
    {


        for (int i = 0; i < defaultDeck.defaultCards.size(); i++)
        {
            deck.addDeckCapacity(defaultDeck.defaultCards.get(i).amount);
            for (int i1 = 0; i1 < defaultDeck.defaultCards.get(i).amount; i1++)
            {
                deck.add(defaultDeck.defaultCards.get(i));
            }
        }

        deck.shuffle();
    }
}
