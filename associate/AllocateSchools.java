import sun.jvm.hotspot.runtime.StubRoutines;

import java.util.*;
public class AllocateSchools {
    public static List<Integer> allocateSchools(List<Integer> schoolSeatsArray, List<Integer> studentScoreArray,
                                                List<List<Integer>> studentSchoolPreferencesArray) {
        int seatNotFill = 0;
        int studentNoSchool = 0;
        //convert score to students
        Student[] students = new Student[studentScoreArray.size()];
        PriorityQueue<Student> pq = new PriorityQueue<>(11, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.score > o2.score) {
                    return -1;
                } else if(o1.score < o2.score) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        for(int i = 0; i < studentScoreArray.size(); i++) {
            pq.add(new Student(studentScoreArray.get(i), studentSchoolPreferencesArray.get(i)));
        }
        for(int i = 0; i < studentScoreArray.size(); i++) {
            Student curr = pq.poll();
            for(int j = 0; j < curr.preference.size(); j++) {
                int preferredSchool = curr.preference.get(j);
                if(schoolSeatsArray.get(preferredSchool) > 0) {
                    schoolSeatsArray.set(preferredSchool, schoolSeatsArray.get(preferredSchool) - 1);
                    break;
                }
                if(j == curr.preference.size() - 1) {
                    studentNoSchool++;
                }
            }
        }
        for(int seat : schoolSeatsArray) {
            seatNotFill += seat;
        }
        return Arrays.asList(seatNotFill, studentNoSchool);
    }

    static class Student {
        public int score;
        public List<Integer> preference;
        public  Student(int score, List<Integer> preference) {
            this.score = score;
            this.preference = preference;
        }
    }

    public static void main(String[] argv) {
        List<Integer> schoolSeatsArray = Arrays.asList(1,3,1,2);
        List<Integer> studentScoreArray = Arrays.asList(990,780,830,860,920);
        List<List<Integer>> studentSchoolPrefArray = new ArrayList<>();
        studentSchoolPrefArray.add(Arrays.asList(3,2,1));
        studentSchoolPrefArray.add(Arrays.asList(3,0,0));
        studentSchoolPrefArray.add(Arrays.asList(2,0,1));
        studentSchoolPrefArray.add(Arrays.asList(0,1,3));
        studentSchoolPrefArray.add(Arrays.asList(0,2,3));
        System.out.println(allocateSchools(schoolSeatsArray,studentScoreArray,studentSchoolPrefArray));
    }
}
