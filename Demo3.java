class Student {
    String name;
    int age;
    int marks;
    }

public class Demo3 {
    public static void main(String[] args) {

        Student student[] = new Student[3];
        // similar to int arr[] = new int[3];

        student[0] = new Student();
        student[0].name = "Alice";  
        student[0].age = 20;
        student[0].marks = 85;

        student[1] = new Student();
        student[1].name = "Bob";
        student[1].age = 22;
        student[1].marks = 90;

        student[2] = new Student();
        student[2].name = "Charlie";
        student[2].age = 21;
        student[2].marks = 88;

        // for (int i = 0; i < student.length; i++) {
        //     System.out.println("Name: " + student[i].name);
        //     System.out.println("Age: " + student[i].age);
        //     System.out.println("Marks: " + student[i].marks);
        //     System.out.println("Address of student"+i+": "+student[i]);
        //     System.out.println();
        // }  

        System.out.println("--- Using for-each loop ---");

        for (Student s : student) {
            System.out.println("Name: " + s.name);
            System.out.println("Age: " + s.age);
            System.out.println("Marks: " + s.marks);
            System.out.println();
        }   
        
    }
}
