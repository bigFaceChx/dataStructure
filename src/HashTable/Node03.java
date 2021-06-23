package HashTable;

import linked.Node;

import java.util.Objects;

/**
 * 节点类
 */
public class Node03<T> {


    public static void main(String[] args) {
        Node03<Object> objectNode03 = new Node03<>();
        Node03<Object> objectNode04 = new Node03<>();
        System.out.println(objectNode03.hashCode());
        System.out.println(objectNode04.hashCode());
    }
    private T data;//数据
    private Node03<T> next;//指向下一个节点

    public Node03() {
    }

    public Node03(T data) {
        this.data = data;
    }

    public Node03(T data, Node03<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node03<T> getNext() {
        return next;
    }

    public void setNext(Node03<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node03{" +
                "data=" + data +
                '}';
    }
}