import java.io.*;
import java.util.ArrayList;

public class DefaultDeck
{
    public ArrayList<Card> defaultCards = new ArrayList<Card>();
    public ArrayList<CharacterCard> defaultCharacterCards;
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
            while(readLine != null);
            System.out.println("Default deck loaded!");
            System.out.println("There are "+defaultCards.size()+" normal cards!");
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
        if (_readLine == null)
        {
            return;
        }

        if (_readLine.equals("start-") && cardReading == false)
        {
            cardReading = true;
            readingCard = new Card(false);
            readingState = 0;
            return;
        }

        if (cardReading == true)
        {


            if (readingState == 0)
            {
                if (_readLine.startsWith("name "))
                {
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
                    readingCard.amount = Integer.parseInt(_readLine.substring(7));
                }
                else
                {
                    System.out.println("malformed normalCards.txt");
                    System.out.println("error type: (no amount)");
                    cardReading = false;
                }
            }
            if (readingState > 1)
            {


                if (_readLine.startsWith("health "))
                {
                    readingCard.status.health = Integer.parseInt(_readLine.substring(7));
                }

                if (_readLine.startsWith("power "))
                {
                    readingCard.status.power = Integer.parseInt(_readLine.substring(6));
                }

                if (_readLine.startsWith("protection "))
                {
                    readingCard.status.protection = Integer.parseInt(_readLine.substring(11));
                }

                if (_readLine.startsWith("statustarget "))
                {
                    readingCard.target = _readLine.substring(13);
                }

                if (_readLine.startsWith("drawtarget "))
                {
                    readingCard.drawTarget = _readLine.substring(11);
                }
            }

            readingState ++;
        }

        if (_readLine.equals("end-") && cardReading == true)
        {
            defaultCards.add(readingCard);
            readingState = 0;
            cardReading = false;
        }

    }


}
