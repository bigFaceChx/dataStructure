package Tree;

/**
 * 线索化二叉树
 */
public class threadedBinaryTree<T> {
    public static void main(String[] args) {
        threadedBinaryTree<Object> objectthreadedBinaryTree = new threadedBinaryTree<>(new treeNode<>());
        objectthreadedBinaryTree.arrTranTree(new Object[]{15, 16, 17, 18, 19, 20, 21});
        objectthreadedBinaryTree.threadedTree(objectthreadedBinaryTree.rootNode);
        System.out.println(objectthreadedBinaryTree.rootNode.getLeftTree().getRightTree().getLeftTree());//19
        System.out.println(objectthreadedBinaryTree.rootNode.getLeftTree().getRightTree().getLeftType());
        System.out.println(objectthreadedBinaryTree.rootNode.getRightTree().getLeftTree().getLeftTree());//20
        System.out.println(objectthreadedBinaryTree.rootNode.getRightTree().getLeftTree().getLeftType());
        System.out.println(objectthreadedBinaryTree.rootNode.getRightTree().getRightTree().getLeftTree());//21
        System.out.println(objectthreadedBinaryTree.rootNode.getRightTree().getRightTree().getLeftType());
        objectthreadedBinaryTree.midOrder();
    }

    private treeNode<T> rootNode;
    private treeNode<T> pre = null;//指向当前节点的前驱

    public threadedBinaryTree(treeNode<T> rootNode) {
        this.rootNode = rootNode;
    }

    public void arrTranTree(T[] arr) {
        if (arr != null || arr.length != 0) {
            rootNode = new treeNode<>();
            rootNode.arrTranTree(arr, 0);
        }
    }

    /**
     * 中序线索化二叉树
     */
    public void threadedTree(treeNode<T> node) {
        if (node == null) {
            return;
        }
        //向左递归遍历
        threadedTree(node.getLeftTree());
        //设置前驱
        if (node.getLeftTree() == null) {
            node.setLeftTree(pre);
            node.setLeftType(1);
        }
        //设置后继
        if (pre != null && pre.getRightTree() == null) {
            pre.setRightTree(node);
            pre.setRightType(1);
        }
        pre = node;
        //向右递归遍历
        threadedTree(node.getRightTree());
    }
    /**
     * 遍历线索化二叉树(中序)
     */
    public void midOrder(){
        treeNode<T> curNode=rootNode;
        while (curNode!=null){
            while (curNode.getLeftType()==0){
                curNode=curNode.getLeftTree();
            }
            System.out.println(curNode);
            while (curNode.getRightType()==1){
                curNode=curNode.getRightTree();
                System.out.println(curNode);
            }
            curNode=curNode.getRightTree();
        }
    }
}
