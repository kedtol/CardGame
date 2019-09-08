public class Player extends GameObject
{
    private Deck passiveDeck;
    private Card characterCard;
    private Status status;
    public int roundOrder;
    private int selectedCard;

    public Player(int _roundOrder)
    {
        status = new Status("Player");
        passiveDeck = new Deck();
        characterCard = new Card(true);
        roundOrder = _roundOrder;
        selectedCard = 0;
    }

    public void useCard(GameObject target, int _index) //place a card into a deck
    {
        if (target.deck.checkSpace() == true)
        {
            target.deck.add(deck.remove(_index));
        }
    }

    public void drawCard(GameObject target, int _index) //draws a specific (_index) card from a deck
    {
        if (target.deck.checkEmpty(_index) == false)
        {
            deck.add(target.deck.remove(_index),_index);
        }
    }

    public void drawCard(GameObject target) //draws a card from a deck
    {
        if (target.deck.checkEmpty() == false)
        {
            deck.add(target.deck.remove());
        }
    }

    private void applyStatus(Player _player, Status _status) //apply a status to another player
    {
        _player.statusApplied(_status);
    }

    public void statusApplied(Status _status) //apply a status
    {
        status = _status;
    }
}
