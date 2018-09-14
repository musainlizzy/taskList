import java.util.*;

public class LatestStudent {
    public static String latestStudent(List<List<String>> input) {
        Collections.sort(input, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                return o1.get(0).compareTo(o2.get(0));
            }
        });
        Map<String, Integer> avgLate = new HashMap<>();
        int index = 0;
        while(index < input.size()) {
            String curr = input.get(index).get(0);
            int sum = 0;
            int count = 0;
            while(index < input.size() && input.get(index).get(0).equals(curr)) {
                int num = Integer.parseInt(input.get(index).get(3)) - Integer.parseInt(input.get(index).get(2));
                sum += Math.max(0, num);
                count++;
                index++;
            }
            avgLate.put(curr, sum/count);
        }
        Map<String, Integer> personLate = new HashMap<>();
        int max = 0;
        PriorityQueue<String> pq = new PriorityQueue<>();
        for(List<String> l : input) {
            String person = l.get(1);
            int num = Integer.parseInt(l.get(3)) - Integer.parseInt(l.get(2));
            int average = avgLate.get(l.get(0));
            if(num >= average) {
                int late = personLate.getOrDefault(person, 0) + num - average;
                personLate.put(person, late);
            } else {
                personLate.put(person, personLate.getOrDefault(person, 0));
            }
            if(personLate.get(person) > max) {
                max = personLate.get(person);
                pq.clear();
                pq.offer(person);
            } else if(personLate.get(person) == max) {
                pq.offer(person);
            }
        }
        return pq.size() == 0? "" : pq.peek();
    }

    public static void main(String[] argv) {
        List<List<String>> input1 = new ArrayList<>();
        input1.add(Arrays.asList("06-22","Chuck","540","540"));
        input1.add(Arrays.asList("06-23","Debby","540","555"));
        input1.add(Arrays.asList("06-23","Chuck","540","540"));
        input1.add(Arrays.asList("06-23","Doug","600","630"));
        input1.add(Arrays.asList("06-24","Chuck","600","600"));
        input1.add(Arrays.asList("06-24","Doug","600","600"));
        System.out.println(latestStudent(input1));
    }
}
