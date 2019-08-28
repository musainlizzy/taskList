/**
 * Created by lizzie on 10/21/18.
 */
import java.util.*;
class Point {
    int x;
    int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class NeareastRes {

        public List<List<Integer>> nearestRestaurant(List<List<Integer>> restaurant, int n) {
            // Write your code here
            Point origin = new Point(0, 0);
            PriorityQueue<Point> pq = new PriorityQueue<>(n, new Comparator<Point>() {
                @Override
                public int compare(Point a, Point b) {
                    int diff = getDistance(b, origin) - getDistance(a, origin);
                    return diff;
                }
            });
            for (List<Integer> point : restaurant) {
                if(point.size() == 2) {
                    Point rest = new Point(point.get(0), point.get(1));
                    pq.offer(rest);
                    if (pq.size() > n) {
                        pq.poll();
                    }
                }
            }
            List<List<Integer>> result = new ArrayList<>();
            while (!pq.isEmpty()) {
                Point curt = pq.poll();
                List<Integer> curtPoint = new ArrayList<>();
                curtPoint.add(curt.x);
                curtPoint.add(curt.y);
                result.add(curtPoint);
            }
            return result;
        }
    private int getDistance(Point a, Point b) {
        return (a.x - b.x)*(a.x - b.x) + (a.y - b.y)*(a.y - b.y);
    }

}
