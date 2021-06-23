package LinkList;

import com.sun.org.apache.regexp.internal.RE;

/**
 * 单向链表(包含头节点)
 */
public class SingleLinkList<T> {
    public static void main(String[] args) {
        user user01 = new user("chx", 15);
        user user02 = new user("wjc", 18);
        user user03 = new user("csa", 17);
        SingleLinkList<user> userSingleLinkList = new SingleLinkList<>();
        userSingleLinkList.addEle(user01);
        userSingleLinkList.addEle(user02);
        userSingleLinkList.addEle(user03);
        userSingleLinkList.overEles();
        System.out.println(userSingleLinkList.getSize());
        //System.out.println(userSingleLinkList.getCountDown(4));
        /*userSingleLinkList.reverseLinkList();
        userSingleLinkList.overEles();*/
        userSingleLinkList.reverseTraversal();
    }
    private Node<T> header;//定义头节点
    private int size;//链表长度

    public SingleLinkList() {
        this.header=new Node<T>();
        this.size=0;
    }
    //添加链表数据
    public void addEle(T ele){
        Node<T> node = new Node<T>(ele);//创建该元素节点
        Node currentNode=header;
        boolean flag=false;//设置标志
        //while循环寻找尾节点，找到链表尾节点时flag设为true;
        while (true){
            if (currentNode.getNext()!=null){
                //不为空说明当前节点不是尾节点
                currentNode=currentNode.getNext();
            }else {
                flag=true;
                break;
            }
        }
        if (flag){
            currentNode.setNext(node);
            size++;
        }else {
            System.out.println("没有找到尾节点");
        }
    }

    //删除元素(并且返回该节点)
    public Node deleteEle(T ele){
        Node<T> tNode = new Node<>(ele);
        Node<T> node=null;//保存该删除的节点
        //先判断链表是否为空,若为空
        if (isEmpty()){
            System.out.println("链表为空，无法删除");
        }else {
            Node currentNode=header;
            boolean flag=false;
            while (true){
                if (currentNode==null){
                    break;
                }else if(currentNode.getNext().getData().equals(ele)){
                    flag=true;
                    break;
                }else {
                    currentNode=currentNode.getNext();
                }
            }
            if (flag){
                node=currentNode.getNext();
                currentNode.setNext(currentNode.getNext().getNext());
                size--;
            }
        }
        return node;
    }
    //查看链表所有元素
    public void overEles(){
        if (isEmpty()){
            System.out.println("链表为空，无法查看");
        }else {
            Node<T> currentNode=header;
            //遍历链表
            while (true){
                if (currentNode!=null){
                    System.out.println("该元素为:"+currentNode);
                    currentNode=currentNode.getNext();
                }else {
                    break;
                }
            }
        }
    }

    //判断链表是否为空
    public boolean isEmpty(){
        return header.getNext()==null;
    }
    //获取链表长度
    public int getSize(){
        return size;
    }
    //找到链表的倒数第k个元素
    public T getCountDown(int k){
        //判断链表是否为空
        if (isEmpty()){
            throw  new RuntimeException("链表为空");
        }else if (k>size){
            throw  new RuntimeException("链表长度不够");
        }else{
            //
            Node<T> current=header;
            //倒数第k个元素就是第(size-k+1)个元素
            int count=(size-k+1);
            for (int i = count; i > 0; i--) {
                current=current.getNext();
            }
            return current.getData();
        }
    }
    //链表反转
    public void reverseLinkList(){
        if (isEmpty()){
            return;
        }else{
            Node<T> currentNode=header.getNext();
            Node<T> reverseNode=new Node<>();
            //遍历反转
            while (true){
                if (currentNode==null){
                    break;
                }else {
                    Node<T> currentNode01=new Node<>(currentNode.getData());
                    if (reverseNode.getNext()==null){
                        reverseNode.setNext(currentNode01);
                    }else {
                        currentNode01.setNext(reverseNode.getNext());
                        reverseNode.setNext(currentNode01);
                    }
                    currentNode=currentNode.getNext();
                }
            }
            header.setNext(reverseNode.getNext());
        }
    }
    //反向遍历:递归算法
    public void reverseTraversal(){
        Node<T> currentNode=header;
        demo(currentNode);
    }

    private void demo(Node<T> currentNode) {
        if (currentNode.getNext()!=null){
            demo(currentNode.getNext());
        }
        System.out.println(currentNode);
    }

}

/**
 * 定义节点类
 * @param <T>
 */
class Node<T>{
    private T data;
    private Node next;

    public Node() {
    }

    public Node(T data) {
        this.data = data;
    }

    public Node(Node next) {
        this.next = next;
    }

    public Node(T data, Node next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}