package niuke;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by likz on 2023/7/6
 *
 * @author likz
 */
public class StudentsMajor2Classes {
    public static class Student {
        private String id;
        private String classNo;
        private Integer grade;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Integer getGrade() {
            return grade;
        }

        public void setGrade(Integer grade) {
            this.grade = grade;
        }

        public void setClassNo(String classNo) {
            this.classNo = classNo;
        }

        public String getClassNo() {
            return classNo;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String class1 = bf.readLine();
        String class2 = bf.readLine();
        Map<String, Student> class1Map = new HashMap<>();
        Map<String, Student> class2Map = new HashMap<>();
        String[] studentNoAndGrade1 = class1.split(";");
        String[] studentNoAndGrade2 = class2.split(";");

        fillMap(class1Map, studentNoAndGrade1);
        fillMap(class2Map, studentNoAndGrade2);

        List<Student> resSort = new ArrayList<>();
        // 找出在两个map都出现的学号
        for (String id : class1Map.keySet()) {
            if (class2Map.get(id) != null) {
                Student e = class2Map.get(id);
                e.setGrade(e.getGrade() + class1Map.get(id).getGrade());
                resSort.add(e);
            }
        }
        if (resSort.isEmpty()) {
            System.out.println("NULL");
            return;
        }
        resSort.sort((o1, o2) -> o1.getClassNo().equals(o2.getClassNo()) ?
                (o2.getGrade().equals(o1.getGrade()) ? o1.getId().compareTo(o2.getId()) : o2.getGrade() - o1.getGrade())
                : o1.getClassNo().compareTo(o2.getClassNo()));

        String classNo = resSort.get(0).getClassNo();
        System.out.println(classNo);
        boolean beginFlag = true;
        for (Student s : resSort) {
            if (!classNo.equals(s.getClassNo())) {
                System.out.println();
                System.out.println(s.getClassNo());
                classNo = s.getClassNo();
                beginFlag = true;
            }
            if (beginFlag) {
                System.out.print(s.getId());
                beginFlag = false;
            } else {
                System.out.print(";" + s.getId());
            }
        }
    }

    private static void fillMap(Map<String, Student> class2Map, String[] studentNoAndGrade2) {
        for (String stu : studentNoAndGrade2) {
            String[] info = stu.split(",");
            Student student = new Student();
            student.setId(info[0]);
            student.setClassNo(info[0].substring(0, 5));
            student.setGrade(Integer.parseInt(info[1]));
            class2Map.put(info[0], student);
        }
    }


/*
    * 示例1
    输入:
         01202021,75;01201033,95;01202008,80;01203006,90;01203088,100
         01202008,70;01203088,85;01202111,80;01202021,75;01201100,88
    输出:
    *     01202
          01202008;01202021
          01203
          01203088

    示例2
    输入:
          01201022,75;01202033,95;01202018,80;01203006,90;01202066,100
          01202008,70;01203102,85;01202111,80;01201021,75;01201100,88
    输出: NULL
* */
}
