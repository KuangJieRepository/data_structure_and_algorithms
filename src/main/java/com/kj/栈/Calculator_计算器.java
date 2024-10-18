package com.kj.栈;

/**
 * 利用栈的特性实现简单的计算器功能
 * 链表实现、数组实现的栈都可以。
 *
 * @author kj
 * @date 2024/10/18
 */
public class Calculator_计算器 extends ArrayStack {
    public Calculator_计算器(int maxStack) {
        super(maxStack);
    }

    /**
     * 是否是操作符
     *
     * @param operator 字符
     * @return 是否
     */
    private boolean isOperator(String operator) {
        return "+".equals(operator)
                || "-".equals(operator)
                || "*".equals(operator)
                || "/".equals(operator);
    }

    private int priority(String operator) {
        if ("*".equals(operator) || "/".equals(operator)) {
            return 2;
        }
        if ("+".equals(operator) || "-".equals(operator)) {
            return 1;
        }
        throw new IllegalArgumentException("无效操作符");
    }

    /**
     * 计算
     *
     * @param n1 数字1
     * @param n2 数字2
     * @param operator 操作符
     * @return 结果
     */
    private int calcNum(int n1, int n2, String operator) {
        return switch (operator) {
            case "+" -> n1 + n2;
            case "-" -> n1 - n2;
            case "*" -> n1 * n2;
            case "/" -> n1 / n2;
            default -> throw new IllegalArgumentException("无效操作符");
        };
    }

    /**
     * 解析表达式进行计算
     *
     * @param expression 表达式
     * @return 结果
     */
    public int calc(String expression) {
        ArrayStack<Integer> numStack = new ArrayStack<>(expression.length());
        ArrayStack<String> operatorStack = new ArrayStack<>(expression.length());

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < expression.length(); i++) {
            String c = String.valueOf(expression.charAt(i));
            if (isOperator(c)) {
                // 是操作符
                if (operatorStack.isEmpty()) {
                    operatorStack.push(c);
                } else {
                    String peek = operatorStack.peek();
                    // 必须是小于等于 <=
                    // 小于获取等于都要对前边的进行计算
                    // 相同优先级，谁在前先计算谁
                    if (priority(c) <= priority(peek)) {
                        // 当前操作符小于或者等于栈顶操作符的优先级，要对前边的两个数据进行计算
                        Integer num1 = numStack.pop();
                        Integer num2 = numStack.pop();
                        String operator = operatorStack.pop();
                        int rs = calcNum(num2, num1, operator);
                        // 结果压栈
                        numStack.push(rs);
                        // 当前操作符压栈
                        operatorStack.push(c);
                    } else {
                        operatorStack.push(c);
                    }
                }

            } else {
                sb.append(c);
                if (i == expression.length() - 1
                        || isOperator(String.valueOf(expression.charAt(i + 1)))) {
                    numStack.push(Integer.parseInt(sb.toString()));
                    sb = new StringBuffer();
                }
            }
        }

        // 表达式解析完毕，数据都已入栈，开始计算
        while (!operatorStack.isEmpty()) {
            String operator = operatorStack.pop();
            Integer num1 = numStack.pop();
            Integer num2 = numStack.pop();
            int rs = calcNum(num2, num1, operator);
            // 结果压栈
            numStack.push(rs);
        }
        return numStack.pop();
    }

}
