package Week5;

public class ExpressionEvaluation {

    public static boolean infixToPostfix(String expression, List result, StackChar stack) {
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (Character.isDigit(ch)) {
                StringBuilder numBuilder = new StringBuilder();
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    numBuilder.append(expression.charAt(i));
                    i++;
                }
                result.append(numBuilder.toString());
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.top() != '(') {
                    result.append(Character.toString(stack.top()));
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    System.out.println("Error: Mismatched parentheses");
                    return false;
                }
                stack.pop();
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                int currPrecedence = checkPrecedence(ch);

                while (!stack.isEmpty() && stack.top() != '(' && checkPrecedence(stack.top()) >= currPrecedence) { //while stack has something, and it isn't '(', and the stack precedence is higher than the current precedence
                    result.append(Character.toString(stack.top()));
                    stack.pop();
                }

                stack.push(ch);
            } else if (ch == ' ') {
                //left empty; nothing happens if character is a space
            }
        }

        while (!stack.isEmpty()) {
            if (stack.top() == '('){
                System.out.println("Error: Mismatched parentheses");
                return false;
            }
            result.append(Character.toString(stack.top()));
            stack.pop();
        }
        return true;
    }

    public static int checkPrecedence(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        } else if (ch == '*' || ch == '/') {
            return 2;
        } else {
            System.out.println("Precedence error; character isn't an operator");
            return -1;
        }
    }

    public static Integer testExpressionEvaluation(String infixExpression, List postfix) {
        StackChar cStack = new StackChar(postfix.listCapacity());
        if(infixToPostfix(infixExpression, postfix, cStack)) {
            StackInt iStack = new StackInt(postfix.listCapacity());
            return evaluatePostfix(postfix, iStack);
        }
        return null;
    }

    public static int evaluatePostfix(List postfixExpression, StackInt stack) {
        for (int i = 0; i < postfixExpression.size(); i++) {
            if (Character.isDigit(postfixExpression.itemAt(i).charAt(0))) { //if first character of String is a number, assume the whole String is a number
                stack.push(Integer.parseInt(postfixExpression.itemAt(i)));
            } else { //otherwise it's an operand, since the postfixExpression variable only contains numbers and operators
                int rightOperand = stack.top();
                stack.pop();
                int leftOperand =  stack.top();
                stack.pop();
                if (postfixExpression.itemAt(i).charAt(0) == '+') {
                    stack.push(leftOperand + rightOperand);
                } else if (postfixExpression.itemAt(i).charAt(0) == '-') {
                    stack.push(leftOperand - rightOperand);
                } else if (postfixExpression.itemAt(i).charAt(0) == '*') {
                    stack.push(leftOperand * rightOperand);
                } else if (postfixExpression.itemAt(i).charAt(0) == '/') {
                    stack.push(leftOperand / rightOperand);
                }
            }
        }
        return stack.top();
    }

    public static void main(String[] args) {
        String infixExpression = "12 + 3 * ( 456 - 78 ) ";
        List postfix = new List(200);
        Integer result = testExpressionEvaluation(infixExpression, postfix);
        if(result != null) {
            System.out.println("Infix Expression: " + infixExpression);
            System.out.print("Postfix Expression:");
            System.out.println(postfix);
            System.out.println("Final Result: " + result);
        }
    }
}
