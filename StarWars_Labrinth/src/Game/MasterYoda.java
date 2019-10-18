package Game;

public class MasterYoda extends Character
{
    private final int maxHP =6;
    private int HP;

    MasterYoda()
    {
        HP=6;
        setName("MasterYoda");
        setIsGoodGuy(true);
        setLocation(6,5);
        setStartingPoint(6, 5);
    }
    MasterYoda(int x, int y)
    {
        HP=6;
        setName("MasterYoda");
        setIsGoodGuy(true);
        setLocation(x,y);
        setStartingPoint(x, y);
    }

    public int getHP()
    {
        return HP;
    }

    public void setHP(int HP)
    {
        this.HP=HP;
    }

    public int getMaxHP()
    {
        return maxHP;
    }
}
