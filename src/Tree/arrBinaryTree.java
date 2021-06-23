package Tree;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 顺序存储二叉树
 */
public class arrBinaryTree<T> {
    public static void main(String[] args) {
        /*Object[] arrs = new Object[]{5, 36, 41, 9, 454, 2, 545, 564, 231};
        arrBinaryTree arrBinaryTree = new arrBinaryTree(arrs);
        arrBinaryTree.preOrder(0);*/
        /*student chx = new student("chx", 23);
        student wjc = new student("wjc", 16);
        student csa = new student("csa", 19);
        student wyl = new student("wyl", 21);
        student fzq = new student("fzq", 27);
        student a = new student("a", 6);
        student q = new student("q", 3);
        arrBinaryTree<student> students = new arrBinaryTree<student>(new treeNode<>(chx));
        students.rootNode.setLeftTree(new treeNode<>(wjc));
        students.rootNode.setRightTree(new treeNode<>(wyl));
        students.rootNode.getLeftTree().setLeftTree(new treeNode<>(csa));
        students.rootNode.getLeftTree().setRightTree(new treeNode<>(fzq));
        students.rootNode.getRightTree().setLeftTree(new treeNode<>(a));
        students.rootNode.getRightTree().setRightTree(new treeNode<>(q));
        students.treeTranArr();*/
        arrBinaryTree<Object> objectarrBinaryTree = new arrBinaryTree<>();
        objectarrBinaryTree.arrTranTree(new Object[]{15,4,7,45,8,42,6});
        objectarrBinaryTree.preTraver();
        //System.out.println(objectarrBinaryTree.rootNode);
    }
    private treeNode<T> rootNode;//根节点
    private Object[] arrs;

    public arrBinaryTree() {
        arrs=new Object[20];
    }
    public arrBinaryTree(treeNode<T> rootNode) {
        arrs=new Object[20];
        this.rootNode = rootNode;
    }

    public arrBinaryTree(Object[] arrs) {
        this.arrs = arrs;
    }

    /**
     * 前序遍历顺序二叉树
     * index:数组的索引
     */
    public void preOrder(int index) {
        if (arrs == null || arrs.length == 0) {
            System.out.println("数组为空，无法遍历");
        }
        System.out.println(arrs[index]);
        //向左递归遍历
        if (index * 2 + 1 < arrs.length) {
            preOrder(index * 2 + 1);
        }
        //向右递归遍历
        if (index * 2 + 2 < arrs.length) {
            preOrder(index * 2 + 2);
        }
    }
    /**
     * 二叉树转数组
     */
    public void treeTranArr(){
        if (rootNode!=null){
            rootNode.treeTranArr(0,arrs);
            for (Object arr : arrs) {
                System.out.println(arr);
            }
        }
    }
    public void arrTranTree(T[] arr){
        if (arr!=null||arr.length!=0){
            rootNode=new treeNode<>();
            rootNode.arrTranTree(arr,0);
        }
    }
    //前序遍历
    public void preTraver(){
        if (rootNode!=null){
            rootNode.preTraversal();
        }
    }

}
