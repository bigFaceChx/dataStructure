package linked;
/**
 * 单向链表
 */
public class linkd {
    private  Node header;//头节点
    private int size=0;


    //添加数据
    public void add(Object date){
        Node node = new Node(date, null);
        //如果头节点为空，则设置该节点为头节点
        if (header==null){
            header=node;
            size++;
            return;
        }
        //如果头节点不为空，则寻找尾节点
        Node wei=sreachWeiNode(header);
        wei.setNext(node);
        size++;
    }
    /*//删除数据
    public void deleteNode(Object data){
        Node currentNode=header;
        while (true){
            if ((currentNode.getData().equals(data))&&(currentNode==header)){
                header=currentNode.getNext();
            }else if(currentNode.getNext().getData().equals(data)){

            }
            currentNode=currentNode.getNext();
        }
    }*/
    //查找尾节点
    private Node sreachWeiNode(Node header) {
        if (header.getNext()==null){
            return header;
        }
        return sreachWeiNode(header.getNext());//递归
    }
    public Node getHeader() {
        return header;
    }

    public void setHeader(Node header) {
        this.header = header;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
