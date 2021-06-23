package Tree;

/**
 * 二叉树节点
 */
public class treeNode<T> {
    private T data;
    private treeNode<T> leftTree;//左子树
    private treeNode<T> rightTree;//右子树
    private int leftType=0;//如果为1，代表左子树是其前驱
    private int rightType=0;//如果为1，代表左子树是其后继

    public treeNode() {
    }

    public treeNode(T data) {
        this.data = data;
    }

    public treeNode(T data, treeNode<T> leftTree, treeNode<T> rightTree) {
        this.data = data;
        this.leftTree = leftTree;
        this.rightTree = rightTree;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public treeNode<T> getLeftTree() {
        return leftTree;
    }

    public void setLeftTree(treeNode<T> leftTree) {
        this.leftTree = leftTree;
    }

    public treeNode<T> getRightTree() {
        return rightTree;
    }

    public void setRightTree(treeNode<T> rightTree) {
        this.rightTree = rightTree;
    }

    @Override
    public String toString() {
        return "treeNode{" +
                "data=" + data +
                '}';
    }
    /**
     * 前序遍历：先根后左子树，再右子树
     */
    public void preTraversal(){
        System.out.println(this);//输出根节点数据
        if (this.leftTree!=null){//遍历左子树
            this.leftTree.preTraversal();
        }
        if (this.rightTree!=null){
            this.rightTree.preTraversal();
        }
    }
    /**
     * 中序遍历：先左子树，后根节点，再右子树
     */
    public void midTraversal(){
        if (this.leftTree!=null){//遍历
            this.leftTree.midTraversal();
        }
        System.out.println(this.data);//
        if (this.rightTree!=null){
            this.rightTree.midTraversal();
        }
    }
    /**
     * 后序遍历：先左子树，后右节点，再根节点
     */
    public void fixTraversal(){
        if (this.leftTree!=null){//遍历x
            this.leftTree.fixTraversal();
        }
        if (this.rightTree!=null){
            this.rightTree.fixTraversal();
        }
        System.out.println(this.data);
    }
    /**
     * 前序查找
     */
    public treeNode<T> preFindData(T data){
        treeNode<T> curTreeNode=null;
        if (this.getData().equals(data)){
            return this;
        }
        if (this.leftTree!=null){
            curTreeNode= this.leftTree.preFindData(data);
        }
        if (curTreeNode!=null){
            return curTreeNode;
        }
        if (this.rightTree!=null){
            curTreeNode= this.rightTree.preFindData(data);
        }
        return curTreeNode;
    }
    /**
     * 中序查找
     */
    public treeNode<T> midFindData(T data){
        treeNode<T> curTreeNode=null;
        if (this.leftTree!=null){
            curTreeNode=this.leftTree.midFindData(data);
        }
        if (this.data.equals(data)){
            return this;
        }
        if (curTreeNode!=null){
            return curTreeNode;
        }
        if (this.rightTree!=null){
            curTreeNode=this.rightTree.midFindData(data);
        }
        return curTreeNode;
    }
    /**
     * 后序查找
     */
    public treeNode<T> fixFindData(T data){
        treeNode<T> curTreeNode=null;
        if (this.leftTree!=null){
            curTreeNode=this.leftTree.fixFindData(data);
        }
        if (curTreeNode!=null){
            return curTreeNode;
        }
        if (this.rightTree!=null){
            curTreeNode=this.rightTree.fixFindData(data);
        }
        if (this.data.equals(data)){
            return this;
        }
        return curTreeNode;
    }
    /**
     * 删除节点:规定如果删除的是叶子节点，则直接删除，如果删除的不是叶子节点，则删除整个子树
     */
    public void deleteNode(T data){
        if(this.leftTree!=null&&this.leftTree.getData().equals(data)){
           this.setLeftTree(null);
           return;
        }
        if (this.rightTree!=null&&this.rightTree.getData().equals(data)){
            this.setRightTree(null);
            return;
        }
        if (this.leftTree!=null){
            this.leftTree.deleteNode(data);
        }
        if (this.rightTree!=null){
            this.rightTree.deleteNode(data);
        }
    }
    /**
     * 二叉树转数组
     */
    public void treeTranArr(int index,Object[] arr){
        arr[index]=this.getData();
        //向左递归
        if (this.leftTree!=null){
            index=index*2+1;
            this.leftTree.treeTranArr(index,arr);
        }
        //向右递归
        if (this.rightTree!=null){
            index=index+2;
            this.rightTree.treeTranArr(index,arr);
        }

    }
    //数组转二叉树
    public void arrTranTree(T[] arr,int index){
        if (index>arr.length){
            return;
        }
        this.setData(arr[index]);
        if (index*2+1<arr.length){
            this.setLeftTree(new treeNode<>(arr[index*2+1]));
        }else{return;}
        if (index*2+2<arr.length){
            this.setRightTree(new treeNode<>(arr[index*2+2]));
        }else {return;}
        //向左子树递归
        this.leftTree.arrTranTree(arr,index*2+1);
        //向右子树递归
        this.rightTree.arrTranTree(arr,index*2+2);
    }
}
