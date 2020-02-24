package queue;

import java.util.Arrays;

public class ArrayQueueModule {
    static int head;
    static int tail;
    static Object[] elements = new Object[5];


    public static void enqueue(Object elem) {
        assert elem != null;
        ensureCapacity(size() + 1);
        elements[tail] = elem;
        tail = (tail + 1) % elements.length;

    }

    public static Object dequeue() {
        if (isEmpty()) {
            return null;
        }
        Object res = elements[head];
        elements[head] = null;
        head = (head + 1) % elements.length;
        return res;
    }

    public static boolean isEmpty() {
        return head == tail;
    }

    public static void clear() {
        Arrays.fill(elements, null);
        head = 0;
        tail = 0;
    }

    public static Object element() {
        if (isEmpty()) {
            return null;
        }
        return elements[head];
    }

    private static void ensureCapacity(int capacity) {
        if (capacity < elements.length) {
            return;
        }
        Object[] newElements = new Object[2 * capacity];
        for (int i = 0; i < size(); i++){
            newElements[i] = elements[(head + i) % elements.length];
        }
        tail = size();
        head = 0;
        elements = newElements;
    }

    public static int size() {
        if (head > tail) {
            return elements.length - head + tail;
        }
        return tail - head;
    }
}
