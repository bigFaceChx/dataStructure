package HuffmanCode;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * 哈夫曼压缩算法
 */
public class huffmanCode {
    public static void main(String[] args) {
        String content="an apple a day,and docotry away";
        List nodes = getNodes(content);
        //System.out.println(nodes);
        Node node = BuildHuffmanTree(nodes);
        //System.out.println("----------------------------");
        //node.preOrder();
        //System.out.println("------------------");
        Map<Byte, String> byteStringMap = CreateHuffmanCode(node);
        System.out.println(byteStringMap);
        byte[] yasuo = yasuo(content, byteStringMap);
        System.out.println(Arrays.toString(yasuo));
        //String s="1110101";
        //System.out.println(Integer.parseInt(s,2));
        //System.out.println(Integer.toBinaryString(2|256));
        //String jiema = jiema(yasuo, byteStringMap);
        //System.out.println(jiema);
    }
    //解码
    public static String jiema(byte[] huffmanCode,Map<Byte,String> codeTable){
        StringBuilder stringBuilder = new StringBuilder();
        //步骤一：将压缩后的byte数组转化为二进制字符串
        for (int i = 0; i < huffmanCode.length; i++) {
            byte b=huffmanCode[i];
            boolean flag=(i==huffmanCode.length-1);
            if (flag){
                stringBuilder.append(0);
            }
            stringBuilder.append(byteToString(!flag,b));
        }
        //步骤二：将对应二进制字符串联系编码表还原数据,先将编码表反转
        StringBuilder stringBuilder1 = new StringBuilder();
        Map<String,Byte> reverseCodeTable=codeTableReverse(codeTable);
        //System.out.println(reverseCodeTable);
        int count=1;
        for (int i = 0; i < stringBuilder.length(); i+=count) {
            count=0;
            String s=stringBuilder.substring(i,i+count);
            while (reverseCodeTable.get(s)==null){
                count++;
                s=stringBuilder.substring(i,i+count);
            }
            Byte aByte = reverseCodeTable.get(s);
            stringBuilder1.append(aByte);
        }
        return stringBuilder.toString();
    }
    //map集合反转
    private static Map<String, Byte> codeTableReverse(Map<Byte, String> codeTable) {
        Map<String, Byte> stringByteMap = new HashMap<>();
        for (Map.Entry<Byte, String> byteStringEntry : codeTable.entrySet()) {
            stringByteMap.put(byteStringEntry.getValue(),byteStringEntry.getKey());
        }
        return stringByteMap;
    }

    /**
     * 功能：将一个byte转成二进制字符串
     * @param flag：false代表无需补位和截位
     * @param b
     * @return
     */
    public static String byteToString(boolean flag,byte b){
        int temp=b;
        String s=null;
        if (flag){
            temp|=256;
        }
        s= Integer.toBinaryString(temp);
        if (flag){
            return s.substring(s.length()-8);
        }else {
            return s;
        }
    }
    //数据压缩,返回压缩后的编码
    public static byte[] yasuo(String content,Map<Byte, String> byteStringMap){
        StringBuilder stringBuilder = new StringBuilder();
        byte[] bytes = content.getBytes();
        for (byte aByte : bytes) {
            //System.out.println(aByte);
            String s = byteStringMap.get(aByte);
            stringBuilder.append(s);
        }
        System.out.println(stringBuilder);
        int length=0;
        if (stringBuilder.length()%8==0){
            length=stringBuilder.length()/8;
        }else{
            length=stringBuilder.length()/8+1;
        }
        byte[] huffmancode = new byte[length];
        int j=0;
        for (int i = 0; i < stringBuilder.length(); i+=8) {
            String substring=null;
            if (i+8>stringBuilder.length()){
                substring = stringBuilder.substring(i);//**此处有错误
            }else{
                substring = stringBuilder.substring(i, i + 8);
            }
            int i1 = Integer.parseInt(substring, 2);
            huffmancode[j]= (byte) i1;
            j++;
        }

        return huffmancode;
    }
    //创建map集合存放哈夫曼编码表
    static Map<Byte, String> huffmanCode = new HashMap<Byte, String>();
    //创建哈夫曼编码表(传入哈夫曼树的根节点)
    public static Map<Byte,String> CreateHuffmanCode(Node rootNode){
        //用于拼接编码
        StringBuilder stringBuilder = new StringBuilder();
        if (rootNode!=null){
            CreateHuffmanCode(rootNode,"",stringBuilder);
        }
        return huffmanCode;
    }
    public static void CreateHuffmanCode(Node curNode,String code,StringBuilder stringBuilder){
        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
        stringBuilder1.append(code);
        if (curNode.getaByte()!=null){//不为空，说明该节点是叶子节点
            huffmanCode.put(curNode.getaByte(),stringBuilder.toString());
        }
        if (curNode.getLeftNode()!=null){
            CreateHuffmanCode(curNode.getLeftNode(),"0",stringBuilder1);
        }
        if (curNode.getRightNode()!=null){
            CreateHuffmanCode(curNode.getRightNode(),"1",stringBuilder1);
        }
    }
    public static List getNodes(String content) {
        byte[] bytes = content.getBytes();
        ArrayList<Node> nodes = new ArrayList<Node>();
        HashMap<Byte, Integer> h = new HashMap<>();
        for (byte aByte : bytes) {
            Integer count = h.get(aByte);
            if (count == null) {
                h.put(aByte, 1);
            } else {
                h.put(aByte, count + 1);
            }
        }
        for (Map.Entry<Byte, Integer> entry : h.entrySet()) {
            nodes.add(new Node(entry.getKey(),entry.getValue()));
        }
        return nodes;
    }
    /**
     * 构建哈夫曼树
     */
    public static Node BuildHuffmanTree(List list){
        while (list.size()>1){
            Collections.sort(list);
            Node leftNode= (Node) list.get(0);
            Node rightNode= (Node) list.get(1);
            Node newNode = new Node(leftNode.getCount() + rightNode.getCount());
            newNode.setLeftNode(leftNode);
            newNode.setRightNode(rightNode);
            list.remove(0);
            list.remove(0);
            list.add(newNode);
        }
        return (Node) list.get(0);
    }

}

class Node  implements Comparable<Node>{
    private Byte aByte;
    private Integer count;
    private Node leftNode;
    private Node rightNode;
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
    public Node() {
    }

    public Node(Integer count) {
        this.count = count;
    }

    public Node(Byte aByte, Integer count) {
        this.aByte = aByte;
        this.count = count;
    }

    public Byte getaByte() {
        return aByte;
    }

    public void setaByte(Byte aByte) {
        this.aByte = aByte;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return "Node{" +
                "aByte=" + aByte +
                ", count=" + count +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.count-o.count;
    }
}
