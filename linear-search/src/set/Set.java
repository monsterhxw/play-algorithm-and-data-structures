package set;

/**
 * @author huangxuewei
 * @since 2023/6/27
 */
public interface Set<E> {

    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();
}
