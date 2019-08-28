/**
 * Created by lizzie on 10/21/18.
 */
import java.util.*;
public class OptimalRoute {
    List<List<Integer>> optimalRoute(int maxTravelDist, List<List<Integer>> forwardRouteList, List<List<Integer>> returnRouteList) {
        if (forwardRouteList == null || returnRouteList == null) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        int maxSoFar = Integer.MIN_VALUE;
        for (List<Integer> forwordRoute : forwardRouteList) {
            for (List<Integer> returnRoute: returnRouteList) {
                if (forwordRoute.get(1) + returnRoute.get(1) > maxSoFar && forwordRoute.get(1) + returnRoute.get(1) <= maxTravelDist) {
                    result.clear();
                    List<Integer> cur = new ArrayList<>();
                    cur.add(forwordRoute.get(0));
                    cur.add(returnRoute.get(0));
                    result.add(cur);
                    maxSoFar = forwordRoute.get(1) + returnRoute.get(1);
                } else if (forwordRoute.get(1) + returnRoute.get(1) == maxSoFar) {
                    List<Integer> cur = new ArrayList<>();
                    cur.add(forwordRoute.get(0));
                    cur.add(returnRoute.get(0));
                    result.add(cur);
                }
            }
        }
        return result;
    }}
