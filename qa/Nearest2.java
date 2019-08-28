import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
/*
有n个目的地(用坐标表示)， 卡车从坐标(0,0)出发，求出送货距离最近的K个点 思路:
1. 将所有的truck (0,0) -> location 的距离一一算出来，存入PriorityQueue里去
2. 根据numDeliveries的个数决定从PriorityQueue里弹出值 复杂度分析:
Time: O(n*logn) 因为每add一个元素到PriorityQueue里，需要logn时间，而我需要将n个元素add进PriorityQueue里。 Space: O(n)
因为我将allLocations 的每个元素都放入了minHeap里
 */
public class ClosestXDestinations {
    List<List<Integer>> ClosestXdestinations(int numDestinations,
                                             List<List<Integer>> allLocations,int numDeliveries) {
        // CORNER CASE
        if (allLocations == null || allLocations.size() == 0 ||
                allLocations.size() < numDeliveries) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<Position> minHeap = new PriorityQueue<>((o1, o2) ->
                o1.distance - o2.distance);
        /*
           PART1: add each position into minHeap
*/
        for (int i = 0; i < allLocations.size(); i++) {
            List<Integer> list = allLocations.get(i);
            // Pythagorean Theorem
            int distance = list.get(0) * list.get(0) + list.get(1) * list.get(1);
            Position p = new Position(list, distance);
            minHeap.add(p);
        }
        /*
           PART2: grab the number of numDeliveries from minHeap
*/
        for (int i = 0; i < numDestinations && i < numDeliveries; i++) {
            result.add(minHeap.poll().list);
        }
        return result;
    }
    class Position {
        List<Integer> list;
        int distance;
        public Position(List<Integer> list, int distance) {
            this.list = list;
            this.distance = distance;
        } }
    /*
    TEST CASE
    */
    public static void main(String[] args) {
        ClosestXDestinations test = new ClosestXDestinations();
        int numDestinations = 3;
        int numDeliveries = 2;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        List<List<Integer>> allLocations = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list2.add(3);
        list2.add(4);
        list3.add(1);
        list3.add(-1);
        allLocations.add(list1);
        allLocations.add(list2);
        allLocations.add(list3);
        List<List<Integer>> result = test.ClosestXdestinations(numDestinations,
                allLocations, numDeliveries);
        for (int i = 0; i < result.size() ; i++) {
            System.out.println("[" + result.get(i).get(0) + "," +
                    result.get(i).get(1) + "]");
        } }
}