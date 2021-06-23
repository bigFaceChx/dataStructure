package HashTable;

import LinkList.user;

/**
 * 散列表（哈希表）
 */
public class hashTable<T> {
    public static void main(String[] args) {
        hashTable<Object> objecthashTable = new hashTable<>(5);
        objecthashTable.addEle(new user("chx",21));
        objecthashTable.addEle(new user("wjc",3));
        objecthashTable.addEle(new user("wyl",11));
        objecthashTable.showList();
    }
    //创建链表数组
    private singleLindList[] singleLindLists;
    private  int size=0;//链表个数
    public hashTable(int size) {
        this.size=size;
        singleLindLists=new singleLindList[size];
        //初始化各链表
        for (int i = 0; i < size; i++) {
            singleLindLists[i]=new singleLindList<T>();
        }
    }

    //定义散列函数
    public  int hashFun(T data){
        return data.hashCode()%size;
    }
    //添加数据
    public void addEle(T data){
        int i = this.hashFun(data);
        singleLindLists[i].addNode(new Node03(data));
    }
    //显示链表数据
    public void showList(){
        for (int i = 0; i < size; i++) {
            singleLindLists[i].showList(i);
        }
    }
}
