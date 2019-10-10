public class Status
{
    public int health;
    public int protection;
    public int power;
    public boolean action;
    public int actionTimer;
    public boolean visible;
    public int visibleTimer;

    public Status(String _statusInput)
    {
        if (_statusInput.equals("Player"))
        {
            health = 5;
            protection = 0;
            power = 0;
        }
    }

    public Status()
    {
        health = 0;
        protection = 0;
        power = 0;
    }

}
