import java.util.Stack;

public class Queue {
    int front, rear, size;
    int capacity;
    int[] queue;

    public Queue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }

    public void enqueue(int element) {
        if (isFull()) {
            System.out.println("Queue id Full...!!!");
            return;
        }
        if (front == -1 && rear == -1) {
            front++;
            queue[++rear] = element;
            size = size + 1;
        } else {
            queue[++rear] = element;
            size = size + 1;
        }
    }

    public void enqueueAtFront(int element) {
        if (isFull()) {
            System.out.println("Queue id Full...!!!");
            return;
        }
        if (front == -1 && rear == -1) {
            front++;
            queue[++rear] = element;
            size = size + 1;
        } else {
            for (int i = size - 1; i >= 0; i --) {
                queue[i + 1] = queue[i];
            }
            queue[front] = element;
            rear++;
            size++;
        }
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty...!!!");
            return;
        }
        queue[front] = 0;
        front++;
        size--;

    }

    public void dequeueAtEnd() {
        if (isEmpty()) {
            System.out.println("Queue is Empty...!!!");
            return;
        }
        if (rear == 0) {
            rear = -1;
            front = -1;
            size--;
            return;
        }

        queue[rear] = 0;
        rear--;
        size--;
    }

    public int front() {
        if (isEmpty()) {
            return -1;
        }
        return queue[front];
    }

    public int rear() {
        if (isEmpty()) {
            return -1;
        }

        return queue[rear];
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public void circularEnqueue(int element) {


        if ((rear+1)%capacity == front) {
            System.out.println("Queue Overflow...!!!");
        } else {
            if (front == -1 && rear == -1) {
                front = 0;
            }
            rear = (rear+1) % capacity;
            queue[rear] = element;
            size++;
        }
    }

    public void circularDequeue() {
        if (size == 0) {
            System.out.println("Queue Underflow...!!!");
            return;
        }

        if(rear == front) {
            queue[front] = 0;
            rear = -1;
            front = -1;
        } else {
            queue[front] = 0;
            front = (front+1) % capacity;
        }
        size--;
    }


    public void priorityEnqueue(int element) {
        if (size == capacity) {
            System.out.println("Array is Full...!!!");
            return;
        }

        if (size == 0) {
            front++;
            rear++;
            queue[rear] = element;
            size++;
            return;
        } else if (rear == 1 && queue[rear] >= element) {
            rear++;
            queue[rear] = element;
            size++;
            return;
        } else if (rear == 1 && queue[rear] < element) {
            queue[rear+1] = queue[rear];
            queue[rear] = element;
            rear++;
            size++;
            return;
        }

        if (queue[rear] >= element) {
            rear++;
            queue[rear] = element;
            size++;
        } else {
            for (int i = 0; i < size; i++) {

                if (queue[i] >= element && queue[i+1] < element) {
                    for (int j = size-1; j > i; j--) {
                        queue[j+1] = queue[j];
                    }
                    queue[i+1] = element;
                    size++;
                    rear++;
                    return;
                }
            }
        }
    }

    public void priorityDequeue() {
        if (size == 0) {
            System.out.println("Queue is Empty...!!!");
            return;
        }

        if (size == 1) {
            rear = -1;
            front = -1;
            size--;
            return;
        }

        int minElement = queue[0];

        for (int i = 1; i < size; i++) {
            if (minElement > queue[i]) {
                minElement = queue[i];
            }
        }


        for (int i = 0; i < size; i++) {
            if (minElement == queue[i]) {
                for (int j = i; j < size-1; j++) {
                    queue[j] = queue[j+1];
                }
                rear--;
                size--;
                return;
            }
        }
    }

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public void enqueueUsingTwoStacks(int element) {
        stack1.push(element);
    }

    public void dequeueUsinTwoStacks() {
        if (!stack2.isEmpty()) {
            stack2.pop();
            return;
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                int a = stack1.pop();
                stack2.push(a);
            }
            stack2.pop();
        }
    }

    public void printQueueOfStacks() {
        if (!stack2.isEmpty()) {
            for (int i = stack2.size() - 1; i >= 0; i--) {
                System.out.print(stack2.get(i) + ", ");
            }
        }
//        if (!stack1.isEmpty()) {
//            for (int i = 0; i < stack1.size(); i++) {
//                System.out.print(stack1.get(i) + ", ");
//            }
//        }
        System.out.println();
    }





    public void display() {
        if (size == 0) {
            System.out.println("Queue is Empty....!!!!");
            return;
        }

        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + ", ");
        }
        System.out.println();
    }


    public void circularDisplay() {
        if (size == 0) {
            System.out.println("Queue is Empty...!!!");
            return;
        }

        int i = front;
        while (true) {
            System.out.print(queue[i] + ", ");

            if (i == rear) break;
            i = (i + 1) % capacity;
        }
        System.out.println();
    }
}
