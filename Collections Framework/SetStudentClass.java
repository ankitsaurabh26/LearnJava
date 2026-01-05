import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Student {
    String name;
    int rollNo;

    public Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    @Override
    public String toString() {
        return "Student {" + "name = '" + name + '\'' + ", rollNo = " + rollNo + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Student student = (Student) o;
        return rollNo == student.rollNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollNo);
    }

}

public class SetStudentClass {
    public static void main(String[] args) {
        Set<Student> st = new HashSet<>();
        st.add(new Student("Raju", 11));
        st.add(new Student("Gukesh", 1));
        st.add(new Student("Ankit", 2));
        st.add(new Student("Ankit", 2));

        System.out.println(st);

    }
}
