package queue;

import java.util.Arrays;

public class ArrayQueueADT {
    private int head;
    private int tail;
    private Object[] elements = new Object[5];

    public static void enqueue(ArrayQueueADT queue, Object elem) {
        assert elem != null;
        ensureCapacity(queue,size(queue) + 1);
        queue.elements[queue.tail] = elem;
        queue.tail = (queue.tail + 1) % queue.elements.length;
    }

    private static void ensureCapacity(ArrayQueueADT queue, int capacity) {
        if (capacity < queue.elements.length) {
            return;
        }
        Object[] newElements = new Object[2 * capacity];
        for (int i = 0; i < size(queue); i++){
            newElements[i] = queue.elements[(queue.head + i) % queue.elements.length];
        }
        queue.tail = size(queue);
        queue.head = 0;
        queue.elements = newElements;

    }
    public static Object dequeue(ArrayQueueADT queue){
        if (isEmpty(queue)) {
            return null;
        }
        Object res = queue.elements[queue.head];
        queue.elements[queue.head] = null;
        queue.head = (queue.head + 1) % queue.elements.length;
        return res;
    }
    public static boolean isEmpty(ArrayQueueADT queue){
        return queue.head == queue.tail;
    }
    public static void clear(ArrayQueueADT queue){
        Arrays.fill(queue.elements, null);
        queue.head = 0;
        queue.tail = 0;
    }
    public static Object element(ArrayQueueADT queue){
        if (isEmpty(queue)){
            return null;
        }
        return queue.elements[queue.head];
    }
    public static int size(ArrayQueueADT queue){
        if (queue.head > queue.tail) {
            return queue.elements.length - queue.head + queue.tail;
        }
        return queue.tail - queue.head;
    }
}
