package Game;

public class Stormtrooper extends Character{
    Stormtrooper()
    {
        setName("Stormtrooper");
        setIsGoodGuy(false);
        setLocation(0,0);
        setStartingPoint(0, 0);
    }
    Stormtrooper(int x,int y)
    {
        setName("Stormtrooper");
        setIsGoodGuy(false);
        setLocation(x,y);
        setStartingPoint(x, y);
    }

    public int[][] ShortestPath(int maze[][],int[] x, int[] y,int dx,int dy)
    {
        if(x[x.length-1]==dx && y[y.length-1]==dy)
        {
            return maze;
        }
        else
        {

            return maze;
        }
    }
}
