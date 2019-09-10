public class Status
{
    private int health;
    private int protection;
    private int power;
    private boolean action;
    private int actionTimer;
    private boolean visible;
    private int visibleTimer;

    public Status(String _statusInput)
    {
        if (_statusInput.equals("Player"))
        {
            health = 5;
            protection = 0;
            power = 0;
        }

        if (_statusInput.equals("Attack"))
        {
            health = 0;
            protection = 0;
            power = 1;
        }

        if (_statusInput.equals("Dodge"))
        {
            health = 0;
            protection = 1;
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
