package Game;

public class Location
{
    private int x;
    private int y;

    Location()
    {
        x=0;
        y=0;
    }

    Location(int x,int y)
    {
        this.x=x;
        this.y=y;
    }

    public void setLocation(int x,int y)
    {
        this.x=x;
        this.y=y;
    }

    public int getX(){
        return x;
    }

    public void setX(int x)
    {
        this.x=x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y){
        this.y=y;
    }

}

