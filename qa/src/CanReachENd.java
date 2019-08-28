/**
 * Created by lizzie on 10/22/18.
 */
import java.util.*;
public class CanReachENd {
    class Coordinate {
        int x, y;
        Coordinate (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public boolean reachEndpoint(int[][] map) {
        if (map == null || map.length == 0) {
            return false;
        }

        int[] directionX = {1, 0, -1, 0};
        int[] directionY = {0, 1, 0, -1};

        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(0,0));

        while (!queue.isEmpty()) {
            Coordinate coor = queue.poll();
            if (map[coor.x][coor.y] == 9) {
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int x = coor.x + directionX[i];
                int y = coor.y + directionY[i];
                Coordinate c = new Coordinate(x, y);
                if (isValid(map, x, y)) {
                    queue.offer(c);
                    if (map[x][y] == 1)
                        map[x][y] = 0;
                }
            }
        }

        return false;
    }

    private boolean isValid(int[][] map, int x, int y) {
        int m = map.length;
        int n = map[0].length;
        return x >= 0 && x < m && y >= 0 && y < n && map[x][y] != 0;
    }
}
