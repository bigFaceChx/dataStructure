package LinkList;

/**
 * 单向循环队列解决约瑟夫环顺序问题
 * 约瑟夫问题是个有名的问题：N个人围成一圈，从第k个开始报数，数m个数，第(k+m-1)个人将被杀掉，最后剩下一个，其余人都将被杀掉。
 * 例如N=6，k=1,M=5，被杀掉的顺序是：5，4，6，2，3。
 */
public class JosephusExcise {

    public static void main(String[] args) {
        int n=20;//n个人
        int k=19;//从第k个人开始报数
        int m=4;//数m个数
        method(n,k,m);
    }

    /**
     *
     * @param n:n个人
     * @param k:从第k个人开始报数
     * @param m:数m个数
     */
    private static void method(int n, int k, int m) {
        circleSingleLinkList<Object> circleSingleLinkList = new circleSingleLinkList<>();
        //添加n个人
        for (int i = 1; i <= n; i++) {
            circleSingleLinkList.addNode(i);
        }
        Node3<Object> helperNode =null;//创建辅助节点
        Node3<Object> first=circleSingleLinkList.getFirst();
        helperNode=circleSingleLinkList.getLastNode();//使辅助节点指向链表尾部,使其始终在first节点之前
        //circleSingleLinkList.showNodes();
        //使first和helper初始化,使其指向第k个节点
        for (int i = 1; i <= (k - 1); i++) {
            first=first.getNext();
            helperNode=helperNode.getNext();
        }
        System.out.println(first);
        System.out.print("自杀的顺序为：");
        while (true){
            //说明只剩最后一个人
            if (first==helperNode){
                break;
            }else{
                //再数m个数
                for (int i = 0; i < m-1; i++) {
                    first=first.getNext();
                    helperNode=helperNode.getNext();
                }
                //删除first节点
                System.out.print(first.getData()+" ");
                first=first.getNext();
                helperNode.setNext(first);
            }
        }
        System.out.println(first.getData());
    }
}
