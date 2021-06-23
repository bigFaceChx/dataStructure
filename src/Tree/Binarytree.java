package Tree;

/**
 * 二叉树结构实现
 */
public class Binarytree<T> {
    public static void main(String[] args) {
        student chx = new student("chx", 23);
        student wjc = new student("wjc", 16);
        student csa = new student("csa", 19);
        student wyl = new student("wyl", 21);
        student fzq = new student("fzq", 27);
        student a = new student("a", 6);
        student q = new student("q", 3);
        Binarytree<student> students = new Binarytree<student>(new treeNode<>(chx));
        students.rootNode.setLeftTree(new treeNode<>(wjc));
        students.rootNode.setRightTree(new treeNode<>(wyl));
        students.rootNode.getLeftTree().setLeftTree(new treeNode<>(csa));
        students.rootNode.getLeftTree().setRightTree(new treeNode<>(fzq));
        students.rootNode.getRightTree().setLeftTree(new treeNode<>(a));
        students.rootNode.getRightTree().setRightTree(new treeNode<>(q));
        students.deleteNode(q);
        students.midTraversal();
        //students.fixTraversal();
        /*student student = students.fixFindDate(q);
        System.out.println(student);*/
    }
    private treeNode<T> rootNode;

    public Binarytree(treeNode<T> rootNode) {
        this.rootNode = rootNode;
    }
    /**
     * 删除节点
     */
    public void deleteNode(T data){
        if (rootNode!=null){
            if (rootNode.getData().equals(data)){
                rootNode=null;
            }else{
                rootNode.deleteNode(data);
            }
        }
    }
    /**
     * 前序查找
     */
    public T preFindDate(T data){
        treeNode<T> ttreeNode = rootNode.preFindData(data);
        if (ttreeNode==null){
            System.out.println("没有该节点");
            return null;
        }else {
            return ttreeNode.getData();
        }
    }
    /**
     * 中序查找
     */
    public T midFindDate(T data){
        treeNode<T> ttreeNode = rootNode.midFindData(data);
        if (ttreeNode==null){
            System.out.println("没有该节点");
            return null;
        }else {
            return ttreeNode.getData();
        }
    }
    /**
     * 后序查找
     */
    public T fixFindDate(T data){
        treeNode<T> ttreeNode = rootNode.fixFindData(data);
        if (ttreeNode==null){
            System.out.println("没有该节点");
            return null;
        }else {
            return ttreeNode.getData();
        }
    }

    /**
     * 前序遍历：先根后左子树，再右子树
     */
    public void preTraversal() {
        if (this.rootNode != null) {
            this.rootNode.preTraversal();
        } else {
            System.out.println("二叉樹爲空");
        }
    }

    /**
     * 中序遍历：先左子树，后根节点，再右子树
     */
    public void midTraversal() {
        if (this.rootNode != null) {
            this.rootNode.midTraversal();
        } else {
            System.out.println("二叉樹爲空");
        }
    }

    /**
     * 后序遍历：先左子树，后右节点，再根节点
     */
    public void fixTraversal() {
        if (this.rootNode != null) {
            this.rootNode.fixTraversal();
        } else {
            System.out.println("二叉樹爲空");
        }
    }
}

