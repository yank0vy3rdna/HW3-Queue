import queue.*;
public class Main {
    public static void fill() {
        for (int i = 0; i < 100; i++) {
            ArrayQueueModule.enqueue(i);
        }
    }

    public static void dump() {
        while (!ArrayQueueModule.isEmpty()) {
            System.out.println(
                    ArrayQueueModule.element() + " " +
                            ArrayQueueModule.dequeue()
            );
        }
    }

    public static void main(String[] args) {
        ArrayQueueModule.enqueue("a");
        ArrayQueueModule.enqueue("b");
        ArrayQueueModule.enqueue("c");
        System.out.println(ArrayQueueModule.dequeue());
        ArrayQueueModule.dequeue();
        ArrayQueueModule.dequeue();
        fill();
        dump();
    }
}
