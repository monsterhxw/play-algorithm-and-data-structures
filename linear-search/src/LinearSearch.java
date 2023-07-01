/**
 * @author huangxuewei
 * @since 2023/6/16
 */
public class LinearSearch {

    public static <E> int search(E[] data, E target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 1_000_000;
        Integer[] data = ArrayGenerator.generateOrderedArray(n);

        long startTime = System.nanoTime();
        LinearSearch.search(data, n);
        long endTime = System.nanoTime();

        double time = (endTime - startTime) / 1_000_000_000.0;
        System.out.println(time + " s");

//        int res = LinearSearch.search(data, 16);
//        System.out.println(res);
//
//        int res2 = LinearSearch.search(data, 666);
//        System.out.println(res2);
//
//        Student[] students = {new Student("Alice"), new Student("Bobo"), new Student("Charles")};
//        Student bobo = new Student("Bobo");
//        int res3 = LinearSearch.search(students, bobo);
//        System.out.println(res3);
    }
}
