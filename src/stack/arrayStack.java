package stack;

/**
 * 数组实现栈
 */
public class arrayStack {
    public static void main(String[] args) {
        arrayStack arrayStack = new arrayStack(5);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        arrayStack.push(5);
        arrayStack.push(6);
        arrayStack.lookStacks();
        System.out.println(arrayStack.pop());
        System.out.println("----------");
        arrayStack.lookStacks();
    }
    private Object[] stack;//创建栈
    private int top;//栈顶指针
    private int maxsize;//栈长度
    private int num;//栈元素个数

    public arrayStack() {
        this.maxsize=10;
        this.stack=new Object[maxsize];
        top=-1;
        num=0;

    }
    //自定义栈长度
    public arrayStack(int maxsize) {
        this.maxsize = maxsize;
        this.stack = new Object[maxsize];
        top = -1;
        num=0;
    }
    //判断栈是否为空
    public boolean isEmpty(){
        return top==-1;
    }
    //判断栈是否已满
    public boolean isFull(){
        return top==maxsize-1;
    }
    //压栈
    public void push(Object obj){
        if (isFull()){
            System.out.println("栈已满");
        }else{
            top=top+1;
            stack[top]=obj;
            num++;
        }
    }
    //弹栈
    public Object pop(){
        Object obj=null;
        if (isEmpty()){
            System.out.println("栈空");
        }else{
            obj=stack[top];
            top--;
            num--;
        }
        return obj;
    }
    //查看栈所有元素(从栈头到栈底)
    public void lookStacks(){
        if(isEmpty()){
            System.out.println("栈空");
        }else{
            for (int i = top; i >= 0; i--) {
                System.out.println(stack[i]);
            }
        }
    }
    //查看栈顶元素
    public Object lookTop(){
        return stack[top];
    }


}
