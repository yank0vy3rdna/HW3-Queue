package queue;

import java.util.Arrays;

public class ArrayQueue extends ArrayQueueInterface{
    private int head;
    private int tail;
    private final Object[] elements = new Object[5];

    // Pre: elem != null && elem is immutable
    public void enqueue(Object elem) {
        assert elem != null;
        ensureCapacity(size() + 1);
        elements[tail] = elem;
        tail = (tail + 1) % elements.length;
    }
    // Post: size = size' + 1 && queue[0..size'- 1] is immutable && queue[size - 1] = elem



    // Pre: size > 0
    public Object dequeue() {
        if (isEmpty()) {
            return null;
        }
        Object res = elements[head];
        elements[head] = null;
        head = (head + 1) % elements.length;
        return res;

    }
    // Post: res = queue[head] && size = size' - 1


    public Object[] toArray() {
        Object[] res = new Object[size()];
        for (int i = 0; i < size(); i++) {
            res[i] = elements[(head + i) % elements.length];
        }
        return res;
    }
    // Post: res = queue[0..size - 1] && type(res) = array && queue is immutable


    // Pre: size > 0
    public Object element() {
        if (isEmpty()) {
            return null;
        }
        return elements[head];
    }
    // Post: res = queue[head] && queue is immutable


    public void clear() {
        Arrays.fill(elements, null);
        head = 0;
        tail = 0;
    }
    // Post: size = 0, head = 0, tail = 0


    public boolean isEmpty() {
        return head == tail;
    }
    // Post: Res = size > 0? && queue is immutable

}
