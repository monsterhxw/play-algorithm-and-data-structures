package heap;

/**
 * @author huangxuewei
 * @since 2023/6/20
 */
public interface Queue<E> {

    void enqueue(E e);

    E dequeue();

    E getFront();

    int getSize();

    boolean isEmpty();
}
