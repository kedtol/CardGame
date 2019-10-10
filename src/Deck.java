import java.util.ArrayList;
import java.util.Collections;

public class Deck
{
    private ArrayList<Card> cards;
    private int deckCapacity = 7;

    public Deck()
    {
        cards = new ArrayList<Card>(deckCapacity);

        for (int i = 0; i < deckCapacity; i++)
        {
            cards.add(null);
        }
    }

    public void addDeckCapacity(int amount)
    {
        deckCapacity += amount;
    }

    public void add(Card _card) //gives a card to the deck
    {
        for (int i = 0; i < cards.size();i++)
        {
            if (cards.get(i) == null)
            {
                cards.set(i, _card);
                return;
            }
        }

        if (cards.size() != deckCapacity)
        {
            cards.add(_card);
            return;
        }
    }

    public boolean add(Card _card, int _index) //sets a card to the deck at _index (its false if the index is out of bounds)
    {
        if (_index < cards.size() && _index > 0)
        {
            cards.set(_index,_card);
            return true;
        }
        else
        {
            return false;
        }
    }

    public Card remove(int _index) //steals a card from the deck at _index
    {
        if (_index < cards.size() && _index > 0)
        {
            Card card_ = cards.get(_index);
            cards.set(_index,null);
            return card_;
        }
        else
        {
            return null;
        }
    }

    public Card remove() //steals a random card from the deck
    {
        for (int i = 0; i < cards.size();i++)
        {
            if (cards.get(i) != null)
            {
                Card card_ = cards.get(i);
                cards.set(i,null);
                return card_;
            }
        }

        return null;
    }

    public Card check(int _index) //what card is at _index?
    {
        if (_index < cards.size() && _index >= 0)
        {
            return cards.get(_index);
        }

        return null;
    }

    public boolean checkSpace() //is there an empty space in the deck?
    {
        for (Card card : cards)
        {
            if (card == null)
            {
                return true;
            }
        }

        if (cards.size() < deckCapacity)
        {
            return true;
        }

        return false;
    }

    public boolean checkEmpty() //is the deck empty?
    {
        for (Card card : cards)
        {
            if (card != null)
            {
                return false;
            }
        }

        if (cards.size() < deckCapacity)
        {
            return false;
        }

        return true;
    }

    public boolean checkEmpty(int _index) //is there an empty place at _index?
    {
        if (cards.get(_index) != null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public void reset()
    {
        for(Card card : cards)
        {
            cards.add(null);
        }
    }

    public void reset(int _size)
    {
        ArrayList<Card> cardsBck = cards;
        cards = new ArrayList<Card>(_size);
        reset();
        for(int i = 0;i < cardsBck.size();i++)
        {
            cards.set(i,cardsBck.get(i));
        }
    }

    public void shuffle() //shuffles the deck
    {
        Collections.shuffle(cards);
    }

    public String[] listCardNames()
    {
        String[] names_;

        if (cards.size() > 0)
        {
            names_ = new String[deckCapacity];


            for (int i = 0; i < cards.size(); i++)
            {
                if (cards.get(i) == null)
                {
                    names_[i] = i+" -empty-";
                }
                else
                {
                    names_[i] = i+" "+cards.get(i).name;
                }
            }
        }
        else
        {
            names_ = new String[1];
            names_[0] = "Your deck is empty.";
        }

        return names_;
    }

}
