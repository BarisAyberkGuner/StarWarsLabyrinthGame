package Game;

public class KyloRen extends Character{
    KyloRen()
    {
        setName("KyloRen");
        setIsGoodGuy(false);
        setLocation(0,0);
        setStartingPoint(0, 0);
    }
    KyloRen(int x,int y)
    {
        setName("KyloRen");
        setIsGoodGuy(false);
        setLocation(x,y);
        setStartingPoint(x, y);
    }
}