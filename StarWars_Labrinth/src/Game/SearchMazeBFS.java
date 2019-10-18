package Game;

import java.util.ArrayDeque;
import java.util.Queue;

class SearchMazeBFS {
    // BFS to find the shortest path between
    // a given source cell to a destination cell.

    public static final int ROW = 14;
    public static final int COL = 11;
    int[] rowNum = new int[]{-1, 0, 0, 1};
    int[] colNum = new int[]{0, -1, 1, 0};

    // class to store matrix cell coordinates
    static class Point {
        public Point(int row, int col) {
            this.x = col;
            this.y = row;
        }

        int x;
        int y;
    }

    // An object to store data for queue used in BFS
    public static class QueueNode {
        public QueueNode(Point src, int d, QueueNode prev) {
            this.pt = src;
            this.dist = d;
            this.prev = prev;
        }

        Point pt; // The coordinates of a cell
        int dist; // cell's distance of from the source
        QueueNode prev;
    }

    boolean isValid(int col, int row) {
        // return true if row number and column number
        // is in range
        return (((row >= 0) && (row < ROW)) && ((col >= 0) && (col < COL)));
    }

    // These arrays are used to get row and column
    // numbers of 4 neighbors of a given cell

    QueueNode BFS(int mat[][], Point src, Point dest) {

        // check source and destination cell
        // of the matrix have value 1
        //if ((mat[src.x][src.y] == 0) || (mat[dest.x][dest.y] == 0))
          //  return null;

        boolean[][] visited = new boolean[mat.length][mat[1].length];

        // Mark the source cell as visited
        visited[src.y][src.x] = true;

        // Create a queue for BFS  --> see http://stackoverflow.com/questions/11149707/best-implementation-of-java-queue
        Queue<QueueNode> q = new ArrayDeque<QueueNode>();

        // distance of source cell is 0
        QueueNode s = new QueueNode(src, 0, null);
        q.add(s); // Enqueue source cell

        // Do a BFS starting from source cell
        while (!q.isEmpty()) {

            QueueNode curr = q.peek();
            Point pt = curr.pt;

            // If we have reached the destination cell,
            // we are done
            if (pt.x == dest.x && pt.y == dest.y)
                return q.peek();

            // Otherwise dequeue the front cell in the queue
            // and enqueue its adjacent cells
            q.poll();


            for (int i = 0; i < 4; i++) {
                int row = pt.x + colNum[i];
                int col = pt.y + rowNum[i];

                // if adjacent cell is valid, has path and
                // not visited yet, enqueue it.
                if(row >= 0 && col >= 0)
                if ((isValid(row, col) && mat[row][col] == 1)
                        && !visited[row][col]) {
                    // mark cell as visited and enqueue it
                    visited[row][col] = true;
                    QueueNode adjCell = new QueueNode(new Point(row, col),

                            curr.dist + 1, curr);
                    q.add(adjCell);
                }
            }
        }

        // return -1 if destination cannot be reached
        return q.peek();
    }
}