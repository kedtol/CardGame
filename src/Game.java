import java.io.*;

public class Game
{
    private boolean quit;
    private int round;
    private int maxPlayers;
    private Player[] playerList;

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public SimpleDeck simpleDeck = new SimpleDeck();

    public Game(int _maxPlayers)
    {
        maxPlayers = _maxPlayers;
        start();
    }


    public void playRound()
    {


    }

    private void start()
    {


        quit = false;
        while (!quit)
        {
            System.out.println("Round started");
            System.out.println();
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

}

