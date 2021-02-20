package ds.heap;

import java.lang.reflect.Array;
import java.util.Arrays;

public abstract class Heap<T extends Comparable> {
    private static int MAX_SIZE = 40;
    private T[] array;
    private int count = 0;

    public Heap(Class<T> clazz){
        this(clazz, MAX_SIZE);
    }

    public Heap(Class<T> clazz, int size){
        array = (T[]) Array.newInstance(clazz, size);
    }
}
