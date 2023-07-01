/**
 * @author huangxuewei
 * @since 2023/6/16
 */
public class Student {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != Student.class) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        Student another = (Student) obj;
        return this.name.equals(another.name);
    }
}
