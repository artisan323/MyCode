package stack;

import java.util.Stack;

public class StackCalculator {

    public static void main(String[] args) {
        String expression = "5*4+2*6/2/2-2*1-3";
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> operStack = new Stack<>();

        int index = 0;
        int num1 = 0;
        int num2 = 0;
        char temp = ' ';
        char oper = ' ';
        int res = 0;

        for (int i = 0; i < expression.length(); i++){
            oper = expression.charAt(i);
            if (isOper(oper)){
                //是一个运算符
                if (operStack.isEmpty()){
                    //如果是空栈
                    operStack.push(oper);
                }else {
                    //不是空栈,取出符号栈顶元素
                    temp = operStack.peek();
                    //比较优先级
                    if (priority(oper)  <= priority(temp)){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        res = cal(num1, num2, temp);
                        numStack.push(res);
                        operStack.pop();
                        operStack.push(oper);
                    }else {
                        //优先级大则直接入栈
                        operStack.push(oper);
                    }
                }
            }else {
                //当先字符是一个数字
                numStack.push(oper - 48);
            }
        }

        while (!operStack.isEmpty()){
            num1 = numStack.pop();
            num2 = numStack.pop();
            temp = operStack.pop();
            res = cal(num1, num2, temp);
            numStack.push(res);
        }

        System.out.println(numStack.peek());
    }



    //判断符号优先级
    public static int priority(char oper){
        if (oper == '*' || oper == '/'){
            return 1;
        }else if (oper == '+' || oper == '-'){
            return 0;
        }else {
            return -1;
        }
    }

    //判断是不是一个运算符
    public static boolean isOper(char val){
        return val == '*' || val =='/' || val == '+' || val =='-';
    }

    //计算
    public static int cal(int num1, int num2, char oper){
        int sum = 0;
        switch (oper){
            case '+':
                sum = num1 + num2;
                break;
            case '-':
                sum = num2 - num1;
                break;
            case '*':
                sum = num1 * num2;
                break;
            case '/':
                sum = num2 / num1;
                break;
            default:
                break;
        }
        return sum;
    }
}
