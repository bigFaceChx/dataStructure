package Queue;

/**
 * 数组实现循环队列
 */
public class circleQueue {
    private Object[] queque;//数组
    private  int front;//头节点
    private  int rear;//尾节点
    private int maxsize;//数组长度
    private int num;//数组数据个数

    public static void main(String[] args) {
        circleQueue circleQueue = new circleQueue(5);
        circleQueue.add(1);
        circleQueue.add(2);
        circleQueue.add(3);
        circleQueue.add(4);
        circleQueue.lookQueue();
        System.out.println();
        System.out.println(circleQueue.pop());
        System.out.println(circleQueue.pop());
        System.out.println(circleQueue.pop());
        System.out.println(circleQueue.getSize());
        circleQueue.add(5);
        circleQueue.add(6);
        circleQueue.add(7);
        circleQueue.lookQueue();
    }
    public circleQueue() {
        //默认数组长度为10
        this.maxsize=10;
        this.queque=new Object[maxsize];
        front=0;//指向头元素
        rear=0;//指向最后一个元素的后一个位置,预留一个位置，作为约定
        num=0;
    }
    public circleQueue(int maxsize) {
        //默认数组长度为10
        this.maxsize=maxsize;
        this.queque=new Object[maxsize];
        front=0;
        rear=0;
        num=0;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return front==rear;
    }
    //判断队列是否已满
    public boolean isFull(){
        return (rear+1+maxsize)%maxsize==front;
    }
    //进队列
    public void add(Object obj){
        //判断是否已满
        if (isFull()){
            System.out.println("队列已满");
        }else{
            queque[rear]=obj;
            rear=(rear+1)%maxsize;
            num++;
        }
    }
    //出队列
    public Object pop(){
        Object obj=null;
        //判断是否为空
        if (isEmpty()){
            System.out.println("队列为空");
            return obj;
        }else{
            obj=queque[front];
            front=(front+1)%maxsize;
            num--;
        }
        return obj;
    }
    //遍历队列
    public void lookQueue(){
        //判断是否为空
        if (isEmpty()){
            System.out.println("队列为空");
        }else{
            for (int i = front; i < front+num; i++) {
                int j=i%maxsize;
                System.out.print(queque[j]+" ");
            }
        }
    }
    //返回队列数据个数
    public int getSize(){
        return  num;
    }
}
