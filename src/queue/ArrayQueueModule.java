package queue;

import java.util.Arrays;

public class ArrayQueueModule {
    static int head;
    static int tail;
    static Object[] elements = new Object[5];

    // Pre: elem != null && elem is immutable
    public static void enqueue(Object elem) {
        assert elem != null;
        ensureCapacity(size() + 1);
        elements[tail] = elem;
        tail = (tail + 1) % elements.length;
    }
    // Post: size = size' + 1 && queue[0..size'- 1] is immutable && queue[size - 1] = elem

    // Pre: size > 0
    public static Object dequeue() {
        if (isEmpty()) {
            return null;
        }
        Object res = elements[head];
        elements[head] = null;
        head = (head + 1) % elements.length;
        return res;
    }
    // Post: res = queue[head] && size = size' - 1

    public static boolean isEmpty() {
        return head == tail;
    }
    // Post: Res = size > 0? && queue is immutable

    public static void clear() {
        Arrays.fill(elements, null);
        head = 0;
        tail = 0;
    }
    // Post: size = 0, head = 0, tail = 0

    // Pre: size > 0
    public static Object element() {
        if (isEmpty()) {
            return null;
        }
        return elements[head];
    }
    // Post: res = queue[head] && queue is immutable

    public static Object[] toArray() {
        Object[] res = new Object[size()];
        for (int i = 0; i < size(); i++) {
            res[i] = elements[(head + i) % elements.length];
        }
        return res;
    }
    // Post: res = queue[0..size - 1] && type(res) = array && queue is immutable

    public static String toStr() {
        StringBuilder res = new StringBuilder("[");
        for (int i = 0; i < size(); i++) {
            res.append(String.valueOf(elements[(i + head) % elements.length]));
            if (i != size() - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }
    // Post: res = '['queue[0]', queue[1], .., [queue[size - 1]]' && type(res) = String && queue is immutable

    //Pre:
    private static void ensureCapacity(int capacity) {
        if (capacity < elements.length) {
            return;
        }
        Object[] newElements = new Object[2 * capacity];
        for (int i = 0; i < size(); i++) {
            newElements[i] = elements[(head + i) % elements.length];
        }
        tail = size();
        head = 0;
        elements = newElements;
    }
    // Post: if capacity > size': size = 2 * capacity && queue is immutable

    public static int size() {
        if (head > tail) {
            return elements.length - head + tail;
        }
        return tail - head;
    }
    // Post: res = size (size of queue)
}
