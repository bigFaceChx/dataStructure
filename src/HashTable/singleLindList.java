package HashTable;

import linked.Node;

/**
 * 单向链表（无头结点）
 */
public class singleLindList<T> {
    private Node03<T> header;//头节点
    private int size=0;//链表长度

    //添加节点
    public void addNode(Node03<T> node){
        if (header==null){
            header=node;
            size++;
        }else {
            Node03<T> curNode=header;
            while (curNode.getNext()!=null){
                curNode=curNode.getNext();
            }
            curNode.setNext(node);
            size++;
        }
    }
    //删除节点,返回-1，代表没有改节点，返回1，代表删除成功
    public int deleteNode(T data){
        if (header==null){
            return -1;
        }else {
            Node03<T> curNode=header;
            if (curNode.getData().equals(data)){
                header=curNode.getNext();
                size--;
                return 1;
            }
            while (curNode.getNext()!=null){
                if (curNode.getNext().getData().equals(data)){
                    curNode.setNext(curNode.getNext().getNext());
                    size--;
                    return 1;
                }else{
                    curNode=curNode.getNext();
                }
            }
            return -1;
        }
    }
    //遍历链表
    public void showList(int i){
        if (header==null){
            System.out.println("链表为空");
        }else {
            Node03<T> curNode=header;//辅助遍历节点
            while (curNode!=null){
                System.out.println("第"+i+"条链表的数据："+curNode.getData());
                curNode=curNode.getNext();
            }
        }
    }
}
