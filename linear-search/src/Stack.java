/**
 * @author huangxuewei
 * @since 2023/6/20
 */
public interface Stack<E> {

    void push(E e);

    E pop();

    E peek();

    int getSize();

    boolean isEmpty();
}
