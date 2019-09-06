package phone面经;

/**
 * Created by lizzie on 9/6/19.
 */
import java.util.*;
public class SubwayStation {

        public int shortestDistance(Station start, Station end, StationMap map){
            if (start == end) return 0;
            Queue<Station> queue = new LinkedList<>();
            Set<Station> set = new HashSet<>();

            queue.offer(start);
            set.add(start);
            int distance = 0;
            while (!queue.isEmpty()){
                distance++;
                int size = queue.size();
                for (int i = 0; i < size; i++){
                    Station cur = queue.poll();
                    for (Station adj : cur.neighbors){
                        if (adj == end){
                            return distance;
                        }
                        if (!set.contains(adj)){
                            queue.offer(adj);
                            set.add(adj);
                        }
                    }
                }
            }
            return -1;
        }

}
