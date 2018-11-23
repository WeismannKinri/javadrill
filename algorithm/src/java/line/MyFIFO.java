package line;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MyFIFO<T> {

    private int front;
    private int rear;
    int size;
    T[] queue;

    public MyFIFO(int inSize) {
        size = inSize;
        queue = (T[]) new Object[size];
        front = -1;
        rear = -1;
    }

    public boolean isEmpty() {
        return (front == -1 && rear == -1);
    }

    public boolean offer(T value) {
        if ((rear + 1) % size == front) {
            return false;
        } else if (isEmpty()) {
            front++;
            rear++;
            queue[rear] = value;

        } else {
            rear = (rear + 1) % size;
            queue[rear] = value;
        }

        return true;
    }

    public T take() {
        T value;
        if (isEmpty()) {
            throw null;
        } else if (front == rear) {
            value = queue[front];
            front = -1;
            rear = -1;

        } else {
            value = queue[front];
            front = (front + 1) % size;

        }
        return value;

    }

    public int size() {
        return isEmpty() ? 0 : rear >= front ? rear - front + 1 : (rear + size - front);
    }


    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] queueSizeAndCommandSize = input.split("\\s+");
        int queueSize = Integer.parseInt(queueSizeAndCommandSize[1]);
        int commandSize = Integer.parseInt(queueSizeAndCommandSize[0]);
        MyFIFO<String> queue = new MyFIFO<>(queueSize);
        for (int i = 0; i < commandSize; i++) {
            String[] commandAndParam = br.readLine().split("\\s+");
            if (commandAndParam[0].equalsIgnoreCase("OFFER")) {
                System.out.println(queue.offer(commandAndParam[1]));
            } else if (commandAndParam[0].equalsIgnoreCase("TAKE")) {
                String element = queue.take();
                if (element != null) {
                    System.out.println(element);
                }
            } else if (commandAndParam[0].equalsIgnoreCase("SIZE")) {
                System.out.println(queue.size());
            } else {
                throw new IllegalAccessException();
            }
        }
    }
}