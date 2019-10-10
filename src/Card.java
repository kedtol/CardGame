import java.io.StringReader;

public class Card
{
    protected Status status;
    protected boolean passive = false;
    protected boolean stealable = true;
    public String target;
    public boolean drawCard;
    public String drawTarget;
    protected String name;
    public int amount;

    public Card(boolean character)
    {
        if (character == true)
        {
            status = new Status();
            passive = true;
            stealable = false;
        }
        else
        {
            status = new Status();
            passive = false;
            stealable = false;
        }
    }
}
