import java.io.*;

public class DefaultDeck
{
    public Card[] defaultCards;
    public CharacterCard[] defaultCharacterCards;
    private boolean cardReading = false;
    private int readingState = 0;
    private Card readingCard;
    public boolean loadDeckFromFile()
    {
        try
        {
            FileReader fr = new FileReader("Gamerules/normalCards");
            BufferedReader br = new BufferedReader(fr);

            int cardAmount = 0;
            String readLine = "";

            do
            {
                readLine = br.readLine();
                normalDeckLoader(readLine);
            }
            while(!readLine.equals(null));

            return true;
        }
        catch (IOException e)
        {
            System.out.println("There are no cards!");
            return false;
        }
    }

    private void normalDeckLoader(String _readLine)
    {
        if (_readLine.equals("start-") && cardReading == false)
        {
            cardReading = true;
            readingState = 0;
        }

        if (cardReading == true)
        {
            if (readingState == 0)
            {
                if (_readLine.startsWith("name "))
                {
                    readingCard = new Card(false);
                    readingCard.name = _readLine.substring(4);
                }
                else
                {
                    System.out.println("malformed normalCards.txt");
                    System.out.println("error type: (no name)");
                    cardReading = false;
                }
            }
            if (readingState == 1)
            {
                if (_readLine.startsWith("amount "))
                {
                    readingCard = new Card(false);
                    readingCard.amount = Integer.parseInt(_readLine.substring(6));
                }
                else
                {
                    System.out.println("malformed normalCards.txt");
                    System.out.println("error type: (no amount)");
                    cardReading = false;
                }
            }
            readingState ++;
        }

    }


}
