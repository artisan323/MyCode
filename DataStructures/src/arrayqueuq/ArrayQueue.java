package arrayqueuq;

//普通队列
public class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        front = -1;
        rear = -1;
        arr = new int[maxSize];
    }

    //判断队列是否已满
    public boolean isFull(){
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    //添加数据
    public void addQueue(int n){
        if (isFull()){
            System.out.println("队列已满");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    //出队
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空,不能出队");
        }
        front++;
        return arr[front];
    }

    //得到队首数据
    public int getQueueHead(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，不能获取队首元素");
        }
        return arr[front + 1];
    }

    //遍历队列
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空");
        }
        for (int i = front + 1; i <= rear; i++){
            System.out.println(arr[i] + "\t");
        }
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(5);
        arrayQueue.addQueue(5);
        arrayQueue.addQueue(7);
        arrayQueue.addQueue(3);
        arrayQueue.addQueue(7);

        arrayQueue.showQueue();

        arrayQueue.getQueue();
        arrayQueue.getQueue();
        arrayQueue.getQueue();
        arrayQueue.getQueue();
        arrayQueue.getQueue();

        System.out.println("====");
        arrayQueue.showQueue();
    }
}
