package Queue;
/*
数组实现队列（非循环）
 */
public class singleQueue {
    public static void main(String[] args) {
        singleQueue singleQueue = new singleQueue(5);
        singleQueue.addEle(1);
        singleQueue.addEle(2);
        singleQueue.addEle(3);
        singleQueue.addEle(4);
        singleQueue.addEle(5);
        singleQueue.lookQueue();
        singleQueue.pop();
        singleQueue.pop();
        singleQueue.pop();
        singleQueue.pop();
        singleQueue.pop();
        singleQueue.lookQueue();
        singleQueue.addEle(1);
    }
    private Object[] queue;
    private int front;//头指针
    private int rear;//尾指针
    private int maxsize;//队列长度
    private int num=0;//队列数据个数

    public singleQueue() {
        //默认初始化数组大小为10
        maxsize=10;
        this.queue=new Object[maxsize];
        front=-1;//指向队列头部元素前一个位置
        rear=-1;//指向队尾元素
    }
    public singleQueue(int size) {
        this.maxsize = size;
        this.queue=new Object[size];
        front=-1;//指向队列头部元素前一个位置
        rear=-1;//指向队尾元素
    }
    //进队列
    public void addEle(Object obj){
        //判断队列是否已满
        if (rear==maxsize-1){
            System.out.println("队列已满");
        }else {
            rear++;
            queue[rear]=obj;
            num++;
        }
    }
    //出队列
    public Object pop(){
        Object obj=null;
        //判断队列是否为空
        if (rear==front){
            System.out.println("队列已空");
        }else {
            front++;
            obj=queue[front];
            num--;
        }
        return obj;
    }
    //查看队列头部元素
    public Object getHeader(){
        Object obj=null;
        //判断队列是否为空
        if (rear==front){
            System.out.println("队列已空");
        }else {
            obj=queue[front+1];
        }
        return obj;
    }
    //遍历队列
    public void lookQueue(){
        //判断队列是否为空
        if (rear==front){
            System.out.println("队列为空");
        }else {
            for (int i = front+1; i <=rear; i++) {
                System.out.print(queue[i]+" ");
            }
        }
    }
}
