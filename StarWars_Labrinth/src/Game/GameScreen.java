package Game;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;


import static javax.imageio.ImageIO.read;

public class GameScreen extends JFrame
{

    public BufferedImage Image;
    public String ImagePath = "C:\\Users\\XPS\\Downloads\\Road.png";

    public Stormtrooper [] StormtrooperArr;
    public DarthVader [] DarthVaderArr;
    public KyloRen [] KyloRenArr;
    public Character MainCharacter;
    public int[][] Maze;

    public GameScreen(Stormtrooper[] StormtrooperArr,DarthVader [] DarthVaderArr,KyloRen [] KyloRenArr,Character MainCharacter,int[][] Maze){
        setTitle("STAR WARS");
        setSize(960,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        try{
            Image = read(new File(ImagePath));//
        }catch (Exception e){

        }

        this.StormtrooperArr = StormtrooperArr;
        this.DarthVaderArr = DarthVaderArr;
        this.KyloRenArr = KyloRenArr;
        this.MainCharacter = MainCharacter;
        this.Maze = Maze;
    }


    public void paint(Graphics g)
    {
        super.paint(g);
        g.translate(5,10);


        for (int i = 0; i < Maze.length; i++)
        {
            for (int j = 0; j < Maze[0].length; j++)
            {
                if(Maze[i][j]==0)
                {
                    g.setColor(Color.BLACK);
                    g.fillRect(50+(50*j),50+(50*i),50,50);
                }
                else
                {
                   //g.drawImage(Image,50+(50*j),50+(50*i),50,50,null);
                }

            }
        }
        g.setColor(Color.YELLOW);
        g.fillRect(50 + (50 * MainCharacter.getX()), 50 + (50 * MainCharacter.getY()), 50, 50);
        for (Stormtrooper stormtrooper : StormtrooperArr) {
                g.setColor(Color.BLUE);
                g.fillRect(50 + (50 * stormtrooper.getX()), 50 + (50 * stormtrooper.getY()), 50, 50);
        }
        for (DarthVader darthVader : DarthVaderArr) {
            g.setColor(Color.RED);
            g.fillRect(50 + (50 * darthVader.getX()), 50 + (50 * darthVader.getY()), 50, 50);
        }
        for (KyloRen kyloRen : KyloRenArr) {
            g.setColor(Color.ORANGE);
            g.fillRect(50 + (50 * kyloRen.getX()), 50 + (50 * kyloRen.getY()), 50, 50);
        }
    }
    public void processKeyEvent(KeyEvent event) {
        if((event.getKeyCode() == KeyEvent.VK_UP || event.getKeyCode() == KeyEvent.VK_W)&& event.getID() == KeyEvent.KEY_PRESSED && MainCharacter.getY()-1>=0 ) { // W or Arrow Up Key to Walk Upward
            if(Maze[MainCharacter.getY()-1][MainCharacter.getX()]==1){
                MainCharacter.setLocation(MainCharacter.getX(),MainCharacter.getY()-1);
                isCaught();
                moveAllCharacters();
                repaint();
            }

        }
        else if ((event.getKeyCode() == KeyEvent.VK_LEFT || event.getKeyCode() == KeyEvent.VK_A)&& event.getID() == KeyEvent.KEY_PRESSED && MainCharacter.getX()-1>=0) { // A or Arrow Left Key to Walk Left
            if(Maze[MainCharacter.getY()][MainCharacter.getX()-1]==1){
                MainCharacter.setLocation(MainCharacter.getX()-1,MainCharacter.getY());
                isCaught();
                //moveAllCharacters();
                repaint();
            }
        }
        else if ((event.getKeyCode() == KeyEvent.VK_RIGHT || event.getKeyCode() == KeyEvent.VK_D)&& event.getID() == KeyEvent.KEY_PRESSED && MainCharacter.getX()+1<Maze[0].length ) { // D or Arrow Right Key to Walk Right
            if(Maze[MainCharacter.getY()][MainCharacter.getX()+1]==1){
                MainCharacter.setLocation(MainCharacter.getX()+1,MainCharacter.getY());
                isCaught();
                //moveAllCharacters();
                repaint();
            }
        }
        else if ((event.getKeyCode() == KeyEvent.VK_DOWN || event.getKeyCode() == KeyEvent.VK_S)&& event.getID() == KeyEvent.KEY_PRESSED && MainCharacter.getY()+1<Maze.length ) { // S or Arrow Down Key to Walk Downward
            if(Maze[MainCharacter.getY()+1][MainCharacter.getX()]==1){
                MainCharacter.setLocation(MainCharacter.getX(),MainCharacter.getY()+1);
                isCaught();
                //moveAllCharacters();
                repaint();
            }
        }

    }

    private void moveAllCharacters() {
        SearchMazeBFS searchMazeBFS = new SearchMazeBFS();
        for(Stormtrooper s : StormtrooperArr){
            SearchMazeBFS.Point source = new SearchMazeBFS.Point(s.getX(), s.getY());
            SearchMazeBFS.Point dest =   new SearchMazeBFS.Point(MainCharacter.getX(), MainCharacter.getY());

            SearchMazeBFS.QueueNode node = searchMazeBFS.BFS(Maze, source, dest);
            if(node != null) {
                while (node.prev != null) {
                    node = node.prev;
                }
                s.setLocation(node.pt.x, node.pt.y);
                repaint();
            }
        }
       /* for(DarthVader d : DarthVaderArr){
            SearchMazeBFS.Point source = new SearchMazeBFS.Point(d.getX(), d.getY());
            SearchMazeBFS.Point dest =   new SearchMazeBFS.Point(MainCharacter.getX(), MainCharacter.getY());

            SearchMazeBFS.QueueNode node = searchMazeBFS.BFS(Maze, source, dest);
            if(node != null) {
                while (node.prev != null) {
                    node = node.prev;
                }
                d.setLocation(node.pt.x, node.pt.y);
                repaint();
            }
        }*/

        /*for(KyloRen k : KyloRenArr){
            for (int i = 0; i < 2; i++) {
                SearchMazeBFS.Point source = new SearchMazeBFS.Point(k.getX(), k.getY());
                SearchMazeBFS.Point dest =   new SearchMazeBFS.Point(MainCharacter.getX(), MainCharacter.getY());

                SearchMazeBFS.QueueNode node = searchMazeBFS.BFS(Maze, source, dest);
                if(node != null) {
                    while (node.prev != null) {
                        node = node.prev;
                    }
                    k.setLocation(node.pt.x, node.pt.y);
                    repaint();
                    isCaught();

                }
            }
        }*/


    }

    public  void isCaught()
    {
        for (Stormtrooper stormtrooper : StormtrooperArr) {
            if (stormtrooper.getX()==MainCharacter.getX() && stormtrooper.getY()==MainCharacter.getY())
            {
            // TODO Takes Damage


                resetLocations();
            }
        }
        for (DarthVader darthVader : DarthVaderArr) {
            if (darthVader.getX()==MainCharacter.getX() && darthVader.getY()==MainCharacter.getY())
            {
                // TODO Takes Damage


                resetLocations();
            }
        }
        for (KyloRen kyloRen : KyloRenArr) {
            if (kyloRen.getX()==MainCharacter.getX() && kyloRen.getY()==MainCharacter.getY())
            {
                // TODO Takes Damage


                resetLocations();
            }
        }
    }
    public void resetLocations()
    {
        for (Stormtrooper st : StormtrooperArr) {
            st.setLocation(st.getSX(),st.getSY());
        }
        for (DarthVader dv : DarthVaderArr) {
            dv.setLocation(dv.getSX(),dv.getSY());
        }
        for (KyloRen kr : KyloRenArr) {
            kr.setLocation(kr.getSX(),kr.getSY());
        }
    }



}