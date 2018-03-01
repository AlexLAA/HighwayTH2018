package genericsExample;

/**
 * Created by lolik on 3/1/18.
 */
class Pair<T1, T2> {

    T1 t1;
    T2 t2;

    Pair(T1 one, T2 two) {
        t1 = one;
        t2 = two;
    }

    public T1 getFirst() {
        return t1;
    }

    public T2 getSecond() {
        return t2;
    }

}

