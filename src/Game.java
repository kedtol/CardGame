import java.io.*;

public class Game
{
    private int round = 0;
    private int roundPlayer = 0;
    private int maxPlayers;
    private Player[] playerList;
    private boolean quit = false;

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public SimpleDeck simpleDeck = new SimpleDeck();
    private DefaultDeck defaultDeck = new DefaultDeck();

    public Game(int _maxPlayers)
    {
        maxPlayers = _maxPlayers;
        round = 0;
        roundPlayer = 0;
        start();
    }

    private String consoleRead()
    {
        try
        {
            return br.readLine();
        }
        catch (IOException e)
        {
            System.out.println("BufferedReader exception");
            return "IOexception";
        }
    }

    private void start()
    {
        resetPlayerList();
        loadDefaultDeck();
        resetSimpleDeck();
        System.out.println("---Game started---");
        while (!quit)
        {
            if (roundPlayer == 0)
            {
                System.out.println("--Round started--");
            }

            playerRound();

            if (roundPlayer == maxPlayers-1)
            {
                System.out.println("--Round finished--");
            }

            if (roundPlayer < maxPlayers-1)
            {
                roundPlayer += 1;
            }
            else
            {
                roundPlayer = 0;
            }
        }
    }

    private void resetPlayerList()
    {
        playerList = new Player[maxPlayers];

        int i = 0;
        for (Player player : playerList)
        {
            player = new Player(i);
            playerList[i] = player;
            i++;
        }

    }

    private void resetSimpleDeck()
    {
        simpleDeck.generate(defaultDeck);
    }

    private void loadDefaultDeck()
    {
        if (defaultDeck.loadDeckFromFile() == false)
        {
            quit = true;
        }
    }

    private void playerRound()
    {
        System.out.println("Player"+roundPlayer+" starts!");

        if (playerList[roundPlayer].deck.checkSpace())
        {
            playerList[roundPlayer].drawCard(simpleDeck);
        }

        String command;
        System.out.println("Type 'end' to end your round.");
        //playerList[roundPlayer].draw
        command = consoleRead();

        while (!command.equals("end"))
        {
            playerInteraction(command);
            command = consoleRead();
        }

        System.out.println("Player"+roundPlayer+" finished!");


    }

   private void playerInteraction(String _command)
   {
       Player player = playerList[roundPlayer];

       if (_command.equals("list"))
       {
            String[] names = player.deck.listCardNames();

            for (String name : names)
            {
                System.out.print(name+" ");
            }
            System.out.println();

       }

       if (_command.startsWith("place "))
       {
            String[] command = _command.split(" ");

            if (command.length == 2)
            {
                int cardIndex;

                try
                {
                    cardIndex = Integer.parseInt(command[1]);

                }
                catch(java.lang.NumberFormatException e)
                {
                    System.out.println("Please only use numbers as arguments!");
                    return;
                }

                if (player.deck.check(cardIndex) != null)
                {
                    if (player.deck.check(cardIndex).target.equals("self") && player.deck.check(cardIndex).drawTarget.equals("null"))
                    {
                        player.useCard(simpleDeck, cardIndex);
                        System.out.println("Card placed.");
                        return;
                    }
                    else
                    {
                        System.out.println("You must specify a target!");
                        return;
                    }
                }
                else
                {
                    System.out.println("That card slot is empty!");
                    return;
                }
            }

            if (command.length == 3)
            {
                int cardIndex;

                try
                {
                    cardIndex = Integer.parseInt(command[1]);

                }
                catch(java.lang.NumberFormatException e)
                {
                    System.out.println("Please only use numbers as arguments!");
                    return;
                }

                int targetIndex;

                try
                {
                    targetIndex = Integer.parseInt(command[2]);

                    if (targetIndex < 0 || targetIndex >= playerList.length)
                    {
                        System.out.println("There's not a single player with the number: "+targetIndex);
                        return;
                    }
                    if (targetIndex == roundPlayer)
                    {
                        System.out.println("You cannot target yourself!");
                        return;
                    }
                }
                catch(java.lang.NumberFormatException e)
                {
                    System.out.println("Please only use numbers as arguments!");
                    return;
                }

                if (player.deck.check(cardIndex) != null)
                {
                    if (player.deck.check(cardIndex).target.equals("player"))
                    {

                        return;
                    }

                    if (player.deck.check(cardIndex).drawTarget.equals("player"))
                    {
                        if (Integer.parseInt(command[2]) < playerList.length && Integer.parseInt(command[2]) >= 0)
                        {

                        }

                        return;
                    }
                }
                else
                {
                    System.out.println("That card slot is empty!");
                    return;
                }

                System.out.println("Incorrect target!");
            }

            System.out.println("Incorrect 'place' format!");
            System.out.println("Use 'place cardIndex (target)'!");
       }

       if (_command.startsWith("check "))
       {

       }


   }

}

