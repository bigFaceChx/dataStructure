package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 哈夫曼树（最优树）
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr={5,15,26,31,9,46,18,29};
        ArrayList<node> nodes = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            nodes.add(new node(arr[i]));
        }
        System.out.println(nodes);
        node node = buildHuffmanTree(nodes);
        preOrder(node);

    }
    //构建哈夫曼树
    public static node buildHuffmanTree(List<node> list){
        while (list.size()>1){
            //排序
            Collections.sort(list);
            //取两个最小的数据
            node leftNode= list.get(0);
            node rightNode=list.get(1);
            node newRoot = new node(leftNode.getValue() + rightNode.getValue());
            newRoot.setLeftNode(leftNode);
            newRoot.setRightNode(rightNode);
            //移除两个小节点，添加新节点
            list.remove(0);
            list.remove(0);
            list.add(newRoot);
        }
        return list.get(0);
    }
    //前序遍历
    public static void preOrder(node root){
        if (root!=null){
            root.preOrder();
        }
    }

}
class  node implements Comparable<node> {
    private int value;
    private char c;
    private node leftNode;
    private node rightNode;

    public node() {
    }

    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if (this.leftNode!=null){
            this.leftNode.preOrder();
        }
        if (this.rightNode!=null){
            this.rightNode.preOrder();
        }
    }
    public node(int value) {
        this.value = value;
    }

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(node leftNode) {
        this.leftNode = leftNode;
    }

    public node getRightNode() {
        return rightNode;
    }

    public void setRightNode(node rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return "node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(node o) {
        return this.value-o.value;
    }
}
