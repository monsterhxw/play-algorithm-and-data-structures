import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

/**
 * @author huangxuewei
 * @since 2023/6/20
 */
public class ArrayStack<E> implements Stack<E> {

    private Array<E> array;

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayStack() {
        array = new Array<>();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("ArrayStack: ");
        ret.append('[');
        for (int i = 0; i < array.getSize(); i++) {
            ret.append(array.get(i));
            if (i != array.getSize() - 1) {
                ret.append(", ");
            }
        }
        ret.append("] top");
        return ret.toString();
    }

    public static void main(String[] args) {
//        Stack<Integer> stack = new ArrayStack<>();
//        for (int i = 0; i < 5; i++) {
//            stack.push(i + 1);
//        }
//        System.out.println(stack);
//
//        System.out.println();
//        for (int i = 5; i > 0; i--) {
//            Integer pop = stack.pop();
//            System.out.println("pop: " + pop + ", " + stack);
//        }

        String[] s = new String[]{"()", "()[]{}", "(]"};
        for (String string : s) {
            System.out.println("s = " + string + ", isValid = " + isValid(string));
        }
    }

    private static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (ch == ')' && top != '(') {
                    return false;
                }
                if (ch == '}' && top != '{') {
                    return false;
                }
                if (ch == ']' && top != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
