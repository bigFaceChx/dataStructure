package stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * 中缀表达式转后缀表达式
 * 规则：
 */
public class Test01 {
    public static void main(String[] args) {
        //准备一个中缀表达式
        String InfisExpression="6+((7*5+9-3)/4)-1";
        Test01 test01 = new Test01();
        ArrayList<String> sufixExpression = test01.method(InfisExpression);
        for (String s : sufixExpression) {
            System.out.print(s+" ");
        }
    }

   public ArrayList<String> method(String InfisExpression){
       ArrayList<String> list = new ArrayList<>();
       //准备两个栈,一个存放中间结果s1，一个存放操作符s2
       Stack s1=new Stack();
       Stack s2=new Stack();
       //从左到右遍历中缀表达式
       for (int i = 0; i < InfisExpression.length(); i++) {
           String s=String.valueOf(InfisExpression.charAt(i));
           //判断该字符串是操作符还是数，还是括号
           if (isNum(s)){//如果是数，则直接压栈
               s1.push(s);
           }else {//如果是操作符，则判断此时操作符栈是否为空
               if (s2.isEmpty()||s2.peek().equals("(")||s.equals("(")){//如果为空或栈顶元素为”（“，则直接压栈
                   s2.push(s);
               }else{//否则分两种情况，1，判断s是否是右括号，2，s是操作符
                    if (s.equals(")")){//如果是右括号，则依次弹出s2元素到s1，知道s2栈顶为”（“,消去一堆括号
                        while (s2.size()!=0&&!s2.peek().equals("(")){
                            s1.push(s2.pop());
                        }
                        s2.pop();//弹出左括号
                    }else{//如果是操作符，则判断s的优先级是否高于栈顶元素
                        if (priority(s)>priority((String)s2.peek())){//如果高于，则直接入栈
                            s2.push(s);
                        }else {
                            while(s2.size()>0&&!s2.peek().equals("(")&&priority(s)<=priority((String)s2.peek())){
                                s1.push(s2.pop());
                            }
                            s2.push(s);
                        }
                    }
               }
           }
       }
       //将s2遍历push进s1
       while (!s2.isEmpty()) {
           s1.push(s2.pop());
       }
      //StringBuffer stringBuffer = new StringBuffer();
       //遍历s1到集合
       while (!s1.isEmpty()) {
           Object pop = s1.pop();
           list.add((String)pop);
       }
       Collections.reverse(list);
       return list;
   }
   //判断操作符优先级
    public int priority(String s){
       int res=0;
       switch (s){
           case "*":res=1;break;
           case "/":res=1;break;
           case "+":res=0;break;
           case "-":res=0;break;
           default:
               System.out.println("没有改操作符");
       }
       return res;
    }
   //判断该字符串是否是操作符
    public boolean isOper(String s){
       boolean res=false;
       switch (s){
           case "+":res=true;break;
           case "-":res=true;break;
           case "*":res=true;break;
           case "/":res=true;break;
           default:
               System.out.println("没有该操作符");
       }
       return res;
    }
   //判断该字符串是否是数
    public boolean isNum(String s){
        return Character.isDigit(s.charAt(0));
    }


}
