package stack;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 后缀表达式计算
 * 需求：给一个后缀表达式，计算出结果
 */
public class test02 {
    public int caculate(ArrayList<String> list){
        //创建一个栈
        Stack<Integer> stack = new Stack<>();
        //遍历集合
        for (String s : list) {
            if (Character.isDigit(s.charAt(0))){
                stack.push(Integer.parseInt(s));
            }else{
                int num1=stack.pop();
                int num2=stack.pop();
                int res=cacu(num1,num2,s);
                stack.push(res);
            }
        }
        return stack.pop();
    }

    private int cacu(int num1, int num2, String s) {
        int res=0;
        switch (s){
            case "+":res=num1+num2;break;
            case "-":res=num2-num1;break;
            case "*":res=num1*num2;break;
            case "/":res=num2/num1;break;
            default:
                System.out.println("没有改运算符");
        }
        return res;
    }

    public static void main(String[] args) {
        Test01 test01 = new Test01();
        test02 test02 = new test02();
        ArrayList<String> list = test01.method("9*((2-3)*4)-5");
        int caculate = test02.caculate(list);
        System.out.println("计算结果为："+caculate);
    }
}
