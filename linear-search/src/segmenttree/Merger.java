package segmenttree;

/**
 * @author huangxuewei
 * @since 2023/6/28
 */
public interface Merger<E> {

    E merge(E a, E b);
}
