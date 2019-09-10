import java.io.*;

public class Game
{
    private boolean quit;
    private int round = 0;
    private int roundPlayer = 0;
    private int maxPlayers;
    private Player[] playerList;


    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public SimpleDeck simpleDeck = new SimpleDeck();

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
        resetSimpleDeck();
        quit = false;
        while (!quit)
        {
            System.out.println("Round started");
            System.out.println("Player"+roundPlayer+" starts!");
            playerInteraction();
            System.out.println("Player"+roundPlayer+" finished!");
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

    }

    private void loadDefaultDeck()
    {


    }

    private void playerInteraction()
    {
        String command;
        System.out.println("Type 'end' to end your round.");
        //playerList[roundPlayer].draw
        command = consoleRead();

        while (command.equals("end"))
        {


            command = consoleRead();
        }

    }
}

