package hashtable;

import java.util.HashSet;
import java.util.Objects;

/**
 * @author huangxuewei
 * @since 2023/6/30
 */
public class Student {

    private int grade;
    private int cls;
    private String firstName;
    private String lastName;

    public Student(int grade, int cls, String firstName, String lastName) {
        this.grade = grade;
        this.cls = cls;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int hashCode() {
        int B = 31;
        int hash = 0;

        hash = hash * B + grade;
        hash = hash * B + cls;
        hash = hash * B + firstName.toLowerCase().hashCode();
        hash = hash * B + lastName.toLowerCase().hashCode();

        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student another = (Student) o;
        if (grade != another.grade || cls != another.cls) {
            return false;
        }
        if (!this.firstName.equalsIgnoreCase(another.firstName)) {
            return false;
        }
        if (!this.lastName.equalsIgnoreCase(another.lastName)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        HashSet<Student> set = new HashSet<>();

        Student student = new Student(3, 2, "bobo", "liu");
        System.out.println(student.hashCode());
        set.add(student);
        System.out.println(set.size());

        student = new Student(3, 2, "Bobo", "liu");
        System.out.println(student.hashCode());
        set.add(student);
        System.out.println(set.size());
    }
}
