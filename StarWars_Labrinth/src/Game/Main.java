package Game;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args) throws IOException
    {

        int[][] Maze = new int[11][14];

        Stormtrooper [] StormtrooperArr;
        DarthVader [] DarthVaderArr;
        KyloRen [] KyloRenArr;

        Character MainCharacter = new MasterYoda();

        System.out.println("Hello World!");

        List<KyloRen> KyloRen = new ArrayList<KyloRen>();
        List<DarthVader> DarthVader = new ArrayList<DarthVader>();
        List<Stormtrooper> Stormtrooper = new ArrayList<Stormtrooper>();

        try
        {
            BufferedReader br = new BufferedReader(new FileReader("src\\Game\\Maze.txt"));
            int i=0;

            int x=0,y=0;

            for(String line ; (line = br.readLine()) != null; )
            {
                if(line.startsWith("K"))
                {
                    String[] integerStrings = line.split(":");
                    if (integerStrings.length>=3) {
                        if (integerStrings[2].startsWith("A")) {
                            x = 0;
                            y = 5;
                        } else if (integerStrings[2].startsWith("B")) {
                            x = 4;
                            y = 0;
                        } else if (integerStrings[2].startsWith("C")) {
                            x = 12;
                            y = 0;
                        } else if (integerStrings[2].startsWith("D")) {
                            x = 13;
                            y = 5;
                        } else if (integerStrings[2].startsWith("E")) {
                            x = 4;
                            y = 10;
                        }
                    }

                    if (integerStrings[1].startsWith("Stormtrooper"))
                    {
                        Stormtrooper.add(new Stormtrooper(x,y));
                    }
                    else if (integerStrings[1].startsWith("DarthVader"))
                    {
                        DarthVader.add(new DarthVader(x,y));
                    }
                    else if (integerStrings[1].startsWith("KyloRen"))
                    {
                        KyloRen.add(new KyloRen(x,y));
                    }
                    else if (integerStrings[1].startsWith("Stormtrooper"))
                    {
                        Stormtrooper.add(new Stormtrooper(x,y));
                    }
                    else if (integerStrings[1].startsWith("MasterYoda"))
                    {
                        MainCharacter = new MasterYoda();
                    }
                    else if (integerStrings[1].startsWith("LukeSkywalker"))
                    {
                        MainCharacter = new LukeSkywalker();
                    }

                }
                else
                {
                    String[] integerStrings = line.split("\\s+");
                    for (int j = 0; j < integerStrings.length; j++)
                    {
                        Maze[i][j] = Integer.parseInt(integerStrings[j]);
                    }
                    i++;
                }
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        for (int i = 0; i < Maze.length; i++)
        {
            for (int j = 0; j < Maze[0].length; j++)
            {
                System.out.print(Maze[i][j]+ "\t");
            }
            System.out.println();
        }

         StormtrooperArr = Stormtrooper.toArray( new Stormtrooper[ Stormtrooper.size() ]);
         DarthVaderArr = DarthVader.toArray( new DarthVader[ DarthVader.size() ]);
         KyloRenArr = KyloRen.toArray( new KyloRen[ KyloRen.size() ]);

        System.out.println("\nStormtrooper");
        for (Game.Stormtrooper stormtrooper : StormtrooperArr) { //foreach Stormtrooper
            System.out.println(stormtrooper.getX() + " " + stormtrooper.getIsGoodGuy() + " " + stormtrooper.getY());

        }
        System.out.println("DarthVaderArr");
        for (Game.DarthVader darthVader : DarthVaderArr) {
            System.out.println(darthVader.getX() + " " + darthVader.getIsGoodGuy() + " " + darthVader.getY());

        }
        System.out.println("KyloRenArr");
        for (Game.KyloRen kyloRen : KyloRenArr) {
            System.out.println(kyloRen.getX() + " " + kyloRen.getIsGoodGuy() + " " + kyloRen.getY());

        }


        GameScreen gameScreen = new GameScreen(StormtrooperArr,DarthVaderArr,KyloRenArr,MainCharacter,Maze);

        SwingUtilities.invokeLater(new Runnable()
        {
            @Override

            public void run()
            {
                gameScreen.setVisible(true);
            }
        });


    }
}