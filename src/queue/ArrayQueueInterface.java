package queue;

public abstract class ArrayQueueInterface {
    static int head;
    static int tail;
    static Object[] elements = new Object[5];
    public static String toStr() {
        StringBuilder res = new StringBuilder("[");
        for (int i = 0; i < size(); i++) {
            res.append(elements[(i + head) % elements.length]);
            if (i != size() - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }
    // Post: res = '['queue[0]', queue[1], .., [queue[size - 1]]' && type(res) = String && queue is immutable

    //Pre:
    static void ensureCapacity(int capacity) {
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
