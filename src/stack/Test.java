package stack;

/**该算法有问题
 * 栈实现计算器功能
 * 要求：给一个简单表达式，计算结果
 *类似：2*5+6-8
 */
public class Test {
        public static void main(String[] args) {
                Test test = new Test();
                String  expression="5+6-9*2";
                int method = test.method(expression);
                System.out.println(method);
        }

        public int method(String expression){
                //创建两个栈，一个存放数，一个存放操作符
                arrayStack numStack = new arrayStack(10);
                arrayStack operStack = new arrayStack(10);
                //遍历表达式
                for (int i = 0; i < expression.length(); i++) {
                        char ch=expression.charAt(i);
                        //判断该字符是操作符还是数
                        if (isOperator(ch)){//如果是操作符
                                //判断操作符栈是否为空
                                if (operStack.isEmpty()){//如果栈为空，则将操作符直接压栈
                                        operStack.push(ch);
                                }else{//如果不为空，则比较栈顶操作符的优先级
                                        if (priority(ch)>priority((Character) operStack.lookTop())){
                                                operStack.push(ch);
                                        }else{
                                                int num1=(Integer) numStack.pop();
                                                int num2=(Integer) numStack.pop();
                                                int oper=(Character)operStack.pop();
                                                int res = calculate(num1, num2, oper);
                                                numStack.push(res);
                                                operStack.push(ch);
                                        }

                                }
                        }else{//如果是数
                                numStack.push(ch-48);
                        }

                }
                //遍历两个栈，计算结果
                while (!operStack.isEmpty()){
                        int num=(Integer) numStack.pop();
                        int num1=(Integer) numStack.pop();
                        int oper=(Character)operStack.pop();
                        int res = calculate(num, num1, oper);
                        numStack.push(res);
                }
                return (Integer) numStack.pop();
        }
        //判断该字符是否数字
        public boolean isNumber(char ch){
                return (ch>'1'&&ch<'9')?true:false;
        }
        //判断该字符是否是运算符
        public boolean isOperator(char ch){
                return (ch=='+'||ch=='-'||ch=='*'||ch=='/');
        }
        //判断运算符优先级，数字代替，越大优先级越高
        public int priority(int ch){
                int priority=-1;
                switch (ch){
                        case '*':priority=1;break;
                        case '/':priority=1;break;
                        case '+':priority=0;break;
                        case '-':priority=0;break;
                        default:
                                System.out.println("没有该操作符");
                }
                return priority;
        }
        //运算操作
        public int calculate(int num1,int num2,int oper){
                int res=0;//存放结果
                switch (oper){
                        case '+':res= (num1+num2);
                        break;
                        case '-':res= (num2-num1);
                        break;
                        case '*':res= (num2*num1);
                        break;
                        case '/':res= (num1/num2);
                        default:
                                System.out.println("没有这个运算符");
                }
                return res;
        }

}
