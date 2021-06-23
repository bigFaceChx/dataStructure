package LinkList;

import com.sun.org.apache.regexp.internal.RE;

/**
 *双向链表（无头结点）
 * @param <T>
 */
public class DoubleLinkList<T> {
    public static void main(String[] args) {
        DoubleLinkList<user> userDoubleLinkList = new DoubleLinkList<>();
        user user01 = new user("chx", 15);
        user user02 = new user("wjc", 18);
        user user03 = new user("csa", 17);
        userDoubleLinkList.addNode(user01);
        userDoubleLinkList.addNode(user02);
        userDoubleLinkList.addNode(user03);
        userDoubleLinkList.showNodes();
        userDoubleLinkList.deleteNode(user01);
        userDoubleLinkList.showNodes();
        System.out.println("----------------");
        System.out.println(userDoubleLinkList.getLastNode());
        System.out.println(userDoubleLinkList.getSize());
    }
    private Node2<T> first;//指向第一个节点
    private int size;//节点个数

    public DoubleLinkList() {
        this.first=null;
        size=0;
    }
    //判断链表是否为空
    public boolean isEmpty(){
        return first==null;
    }
    //向链表尾部添加节点
    public void addNode(T data){
        Node2<T> tNode = new Node2<>(data);//创建节点
        if (isEmpty()){
            first=tNode;
            size++;
        }else {
            //寻找尾部节点
            Node2<T> currentNode=first;
            while (true){
                if (currentNode.getNext()==null){
                    break;
                }else {
                    currentNode=currentNode.getNext();
                }
            }
            currentNode.setNext(tNode);
            tNode.setPre(currentNode);
            size++;
        }
    }
    //显示链表数据
    public void showNodes(){
        if (isEmpty()){
            System.out.println("链表为空");
        }else {
            Node2<T> currentNode=first;
            while (true){
                if (currentNode==null){
                    break;
                }else {
                    System.out.println(currentNode);
                    currentNode=currentNode.getNext();
                }
            }
        }
    }
    //取節點數據(尾節點)
    public T getLastNode(){
        if (isEmpty()){
            System.out.println("链表为空");
            return null;
        }else {
            Node2<T> currentNode=first;
            while (true){
                if (currentNode.getNext()==null){
                    break;
                }else {
                    currentNode=currentNode.getNext();
                }
            }
            return currentNode.getData();
        }
    }
    //刪除節點數據
    public void deleteNode(T data){
        if (isEmpty()){
            System.out.println("鏈表爲空");
        }else{
            //遍歷鏈表
            Node2<T> currentNode=first;
            boolean flag=false;//設置標志，找到該節點改爲true
            while (true){
                if (currentNode==null){
                    break;
                }else {
                    if (currentNode.getData().equals(data)){
                        flag=true;
                    }
                    break;
                }
            }
            //刪除該節點
            if (flag){

                if (currentNode==first){ //判斷該節點是否是頭節點
                    first=currentNode.getNext();
                }else if (currentNode.getNext()==null){ //判斷該節點是否是尾節點
                    currentNode.getPre().setNext(null);
                }else {
                    currentNode.getPre().setNext(currentNode.getNext());
                    currentNode.getNext().setPre(currentNode.getPre());
                }
                size--;
            }
        }
    }
    //獲取鏈表長度
    public int getSize(){
        return size;
    }
}
class Node2<T>{
    private T data;
    private Node2<T> pre;//该节点指向的前一个节点
    private Node2<T> next;//该节点指向的后一个节点
    public Node2() {
    }

    public Node2(T data) {
        this.data = data;
    }

    public Node2(T data, Node2<T> pre, Node2<T> next) {
        this.data = data;
        this.pre = pre;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node2<T> getPre() {
        return pre;
    }

    public void setPre(Node2<T> pre) {
        this.pre = pre;
    }

    public Node2<T> getNext() {
        return next;
    }

    public void setNext(Node2<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node2{" +
                "data=" + data +
                '}';
    }
}
