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
        loadDefaultDeck();
        resetSimpleDeck();
        System.out.println("Game started");
        while (!quit)
        {
            if (roundPlayer == 0)
            {
                System.out.println("Round started");
            }

            playerRound();

            if (roundPlayer == maxPlayers-1)
            {
                System.out.println("Round finished");
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
        simpleDeck.generate();
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

        if (roundPlayer < maxPlayers-1)
        {
            roundPlayer += 1;
        }
        else
        {
            roundPlayer = 0;
        }
    }

   private void playerInteraction(String _command)
   {
       // if (_command.equals())
   }

}

