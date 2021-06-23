package LinkList;

/**
 * 单向循环链表实现（无头结点）
 */
public class circleSingleLinkList<T> {
    public static void main(String[] args) {
        circleSingleLinkList<user> circleSingleLinkList = new circleSingleLinkList<>();
        user user01 = new user("chx", 15);
        user user02 = new user("wjc", 18);
        user user03 = new user("csa", 17);
        circleSingleLinkList.addNode(user01);
        circleSingleLinkList.addNode(user02);
        circleSingleLinkList.addNode(user03);
        circleSingleLinkList.showNodes();
        circleSingleLinkList.deleteNode(user01);
        circleSingleLinkList.showNodes();
    }
    private Node3<T> first;//指向第一个节点
    private int size;//链表长度

    public Node3<T> getFirst() {
        return first;
    }

    //判断链表是否为空
    public boolean isEmpty(){
        return first==null;
    }
    //向链表尾部添加数据（节点）
    public void addNode(T data){
        Node3<T> tNode3 = new Node3<>(data);
        if (isEmpty()){
            first=tNode3;
            first.setNext(tNode3);
            size++;
        }else {
            Node3<T> currentNode=first;
            //寻找尾节点
            while (true){
                if (currentNode.getNext()==first){
                    break;
                }else {
                    currentNode=currentNode.getNext();
                }
            }
            currentNode.setNext(tNode3);
            tNode3.setNext(first);
            size++;
        }
    }
    //显示链表数据
    public void showNodes(){
        if (isEmpty()){
            System.out.println("链表为空");
        }else {
            Node3<T> currentNode=first;
            while (true){
                if (currentNode.getNext()==first){
                    break;
                }else {
                    System.out.println(currentNode.getData());
                    currentNode=currentNode.getNext();
                }
            }
            System.out.println(currentNode.getData());
        }
    }
    //删除链表数据
    public void deleteNode(T data){
        if (isEmpty()){
            System.out.println("链表为空");
        }else{
            Node3<T> currentNode=first;
            boolean flag=false;//设置标志，找到数据则改为true
            //遍历获取删除节点前一个节点
            while (true){
                if (currentNode.getNext()==first){
                    if (currentNode.getNext().getData().equals(data)){
                        flag=true;
                    }
                    break;
                }else {
                    if (currentNode.getNext().getData().equals(data)){
                        flag=true;
                        break;
                    }
                    currentNode=currentNode.getNext();
                }
            }
            //删除节点
            if (flag){
                if (currentNode.getNext()==first){
                    first=first.getNext();
                }
                currentNode.setNext(currentNode.getNext().getNext());
                size--;
            }else {
                System.out.println("没有找到该节点");
            }
        }
    }
    //获取链表尾部节点
    public Node3<T> getLastNode(){
        if(isEmpty()){
            System.out.println("链表为空");
            return null;
        }else{
            Node3<T> currentNode=first;
            while(true){
                if (currentNode.getNext()==first){
                    break;
                }else {
                    currentNode=currentNode.getNext();
                }

            }
            return currentNode;
        }
    }

}
class Node3<T>{
    private T data;
    private Node3<T> next;

    public Node3() {
    }

    public Node3(T data) {
        this.data = data;
    }

    public Node3(T data, Node3<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node3<T> getNext() {
        return next;
    }

    public void setNext(Node3<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node3{" +
                "data=" + data +
                '}';
    }
}
