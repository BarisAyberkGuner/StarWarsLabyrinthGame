package Game;

public class LukeSkywalker extends Character{
    private final int maxHP =3;
    private int HP;

    public LukeSkywalker()
    {
        HP=3;
        setName("LukeSkywalker");
        setIsGoodGuy(true);
        setLocation(6,5);
        setStartingPoint(6, 5);
    }

    public LukeSkywalker(int x, int y)
    {
        HP=3;
        setName("LukeSkywalker");
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