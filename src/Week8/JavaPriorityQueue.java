package Week8;

import java.util.*;

class Student implements Comparable<Student>{
    String name;
    double cgpa;
    int id;
    public Student(String name, double cgpa, int id){
        this.name = name;
        this.cgpa = cgpa;
        this.id = id;
    }
    public String getName(){
        return this.name;
    }
    public double getCgpa(){
        return this.cgpa;
    }
    public int getId(){
        return this.id;
    }
    public int compareTo(Student s){
        if(this.cgpa < s.cgpa){
            return 1;
        }
        else if(this.cgpa > s.cgpa){
            return -1;
        }
        else{
            if(this.name.equals(s.name)){
                return this.id - s.id;
            }
            else{
                return this.name.compareTo(s.name);
            }
        }
    }
}
class Priorities{
    List<Student> p = new ArrayList<>();
    List<Student> st = new ArrayList<>();
    List<Student> getStudents(List<String> events){
        for(String event : events){
            String[] arr = event.split(" ");
            if(arr[0].equals("ENTER")){
                p.add(new Student(arr[1], Double.parseDouble(arr[2]), Integer.parseInt(arr[3])));
            }
            else{
                if(!p.isEmpty()){
                    p.remove(0);
                }

            }
            Collections.sort(p);
        }
        while(!p.isEmpty()){
            st.add(p.get(0));
            p.remove(0);
        }
        return st;
    }
}



//class Student implements Comparable<Student>{
//    String name = "";
//    double cgpa;
//    int id;
//    public Student(String name,double cgpa,int id)
//    {
//        this.name = name;
//        this.cgpa = cgpa;
//        this.id = id;
//    }
//    public String getName(){
//        return this.name;
//    }
//    public int compareTo(Student s)
//    {
//        if(cgpa == s.cgpa)
//        {
//            if(name.compareTo(s.name) == 0)
//            {
//                if(id == s.id)
//                    return 0;
//                else if (id > s.id)
//                    return 1;
//                else
//                    return -1;
//            }
//            else
//                return name.compareTo(s.name);
//        }
//        else if(cgpa > s.cgpa)
//            return -1;
//        else
//            return 1;
//    }
//}
//
//class Priorities{
//    public ArrayList<Student> getStudents(List<String> events)
//    {
//        int n = events.size();
//        PriorityQueue<Student> pq = new PriorityQueue<Student>();
//        for(String i:events)
//        {
//            String[] s = new String[4];
//            s = i.split("\\s");
//            if(s.length>1)
//            {
//                pq.add(new Student(s[1],Double.valueOf(s[2]),Integer.valueOf(s[3])));
//            }
//            else
//            {
//                pq.poll();
//            }
//        }
//        while(pq.size()>1)
//        {
//            System.out.println(pq.poll().name);
//        }
//        return new ArrayList<Student>(pq);
//    }
//}

//}
//class Student {
//
//    private int id;
//    private String name;
//    private double cgpa;
//
//    public Student(int id, String name, double cgpa) {
//        this.id = id;
//        this.name = name;
//        this.cgpa = cgpa;
//    }
//
//    public int getID() {
//
//        return this.id;
//
//    }
//
//    //returns the name of student
//    public String getName() {
//
//        return this.name;
//
//    }
//
//    //returns the cumulative grade point average (cgpa) of student
//    public double getCgpa() {
//
//        return this.cgpa;
//
//    }
//}
//class Priorities {
//
//    private List<Student> students = new ArrayList<>();
//
//    public Priorities() {
//        this.students = new ArrayList<>();
//    }
//
//    public List<Student> getStudents(List<String> events) {
//        for (String student : events) {
//            String[] splited = student.split("\\s+");
//            if (splited[0].equals("ENTER")) {
//                double cgpa = Double.parseDouble(splited[2]);
//                int id = Integer.parseInt(splited[3]);
//                Student s = new Student(id, splited[1], cgpa);
//                this.students.add(s);
//            } else if (splited[0].equals("SERVED")) {
//                Collections.sort(this.students, new Comparator<Student>() {
//                    @Override
//                    public int compare(Student o1, Student o2) {
//                        if (o1.getCgpa() == o2.getCgpa()) {
//                            return o2.getName().compareTo(o1.getName());
//
//                        } else if (o1.getCgpa() == o2.getCgpa() && o1.getName().equals(o2.getName())) {
//                            return Integer.compare(o2.getID(), o1.getID());
//                        } else {
//                            return Double.compare(o1.getCgpa(), o2.getCgpa());
//
//                        }
//                    }
//                });
//                Collections.reverse(this.students);
//                if (!this.students.isEmpty()) {
//                    this.students.remove(0);
//                }
//
//            }
//        }
//        return this.students;
//
//    }
//}
