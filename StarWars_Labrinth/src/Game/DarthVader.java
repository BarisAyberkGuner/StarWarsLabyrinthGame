package Game;

public class DarthVader extends Character {

    DarthVader() {
        setName("DarthVader");
        setIsGoodGuy(false);
        setLocation(0, 0);
        setStartingPoint(0, 0);
    }

    DarthVader(int x, int y) {
        setName("DarthVader");
        setIsGoodGuy(false);
        setLocation(x, y);
        setStartingPoint(x, y);
    }
}