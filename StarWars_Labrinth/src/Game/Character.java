package Game;

public class Character
{
    private String name;
    private boolean isGoodGuy;
    //private int round;
    private Location location = new Location();
    private Location startingPoint = new Location();

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name= name;
    }

    public boolean getIsGoodGuy()
    {
        return isGoodGuy;
    }

    public void setIsGoodGuy(boolean isGoodGuy)
    {
        this.isGoodGuy=isGoodGuy;
    }

    public int getX(){
        return location.getX();
    }

    public void setX(int x){
        location.setX(x);
    }

    public int getY(){
        return location.getY();
    }

    public void setY(int y){
        location.setY(y);
    }

    public void setLocation(int x,int y){
        location.setX(x);
        location.setY(y);
    }
    public Location getLocation(int x,int y){
        return location;
    }

    public void setStartingPoint(int x,int y){
        startingPoint.setX(x);
        startingPoint.setY(y);
    }

    public Location getStartingPoint(){
        return startingPoint;
    }
    public int getSX(){
        return startingPoint.getX();
    }

    public void setSX(int x){
        startingPoint.setX(x);
    }

    public int getSY(){
        return startingPoint.getY();
    }

    public void setSY(int y){
        startingPoint.setY(y);
    }


}
