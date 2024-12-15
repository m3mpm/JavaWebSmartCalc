package m3mpm.smartcalc.model;

import org.springframework.stereotype.Component;

import java.util.Stack;

@Component
public class PolishNotation {
    private String str;
    private final Stack<String> reverseStack = new Stack<>();
    private final Stack<Character> operatorsStack = new Stack<>();


    public PolishNotation(){}

    public Stack<String> createPolishNotation(String str){
        Stack<String> polishStack = new Stack<>();
        this.str = str;
        rebuildString();
        covertStringIntoPolishNotation(polishStack);
        return polishStack;
    }

    private void rebuildString(){
        renameFunctionsInString();
        renameUnaryPlusMinus();
    }

    private void renameFunctionsInString() {
        str = str.replaceAll("acos", "o")
                .replaceAll("asin", "i")
                .replaceAll("atan", "a")
                .replaceAll("cos", "c")
                .replaceAll("sin", "s")
                .replaceAll("tan", "t")
                .replaceAll("sqrt", "q")
                .replaceAll("ln", "n")
                .replaceAll("log", "g")
                .replaceAll("mod", "m")
                .replaceAll("(?<=[)x])(f{0})(?=[(oiacstqngx\\d])|(?<=\\d)(f{0})(?=[(oiacstqngx])", "*");
    }

    private void renameUnaryPlusMinus(){
        char [] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (i == 0){
                if (charArray[i] == '-') {
                    charArray[i] = 'u';
                } else if (charArray[i] == '+') {
                    charArray[i] = 'p';
                }
            } else {
                if (charArray[i - 1] == '(' || charArray[i - 1] == 'o' || charArray[i - 1] == 'i' || charArray[i - 1] == 'a' ||
                        charArray[i - 1] == 'c' || charArray[i - 1] == 's' || charArray[i - 1] == 't' || charArray[i - 1] == 'q' ||
                        charArray[i - 1] == 'n' || charArray[i - 1] == 'g' || charArray[i - 1] == 'm' || charArray[i - 1] == '*' ||
                        charArray[i - 1] == '/' || charArray[i - 1] == '^') {
                    if (charArray[i] == '-') {
                        charArray[i] = 'u';
                    } else if (charArray[i] == '+') {
                        charArray[i] = 'p';
                    }
                }
            }
        }
        str = String.copyValueOf(charArray);
    }

    private int getPriority(char ch) {
        return switch (ch) {
            case '+', '-' -> 1;
            case '*', '/', 'm' -> 2;
            case 'c', 's', 't', 'o', 'i', 'a', 'q', 'n', 'g' -> 5;
            case '^' -> 6;
            case 'p', 'u' -> 7;
            default -> 0; // for '(', ')'
        };
    }

    private void covertStringIntoPolishNotation(Stack<String> polishStack){
        char[] charArray = str.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            switch (Lexem.getLexemeType(charArray[i])){
                case NUMBER,DOT:
                    i = handleDigits(i,charArray);
                    break;
                case X:
                    reverseStack.push(String.valueOf(charArray[i]));
                    break;
                case FUNCTION,UNARY_PLUS,UNARY_MINUS,BRACKET_L:
                    operatorsStack.push(charArray[i]);
                    break;
                case BRACKET_R:
                    handleBrackets();
                    break;
                case OPERATOR:
                    handleOperators(i,charArray);
                    break;
                case POW:
                    handlePow(i,charArray);
                    break;
            }
        }

       while(!operatorsStack.empty()){
           reverseStack.push(String.valueOf(operatorsStack.pop()));
       }

       while(!reverseStack.empty()) polishStack.push(reverseStack.pop());

    }

    private int handleDigits(int i, char[] charArray){
        StringBuilder sb = new StringBuilder();
        while(i < charArray.length && (Lexem.getLexemeType(charArray[i]) == Lexem.lexemeType.NUMBER
                                    || Lexem.getLexemeType(charArray[i]) == Lexem.lexemeType.DOT
                                    || Lexem.getLexemeType(charArray[i]) == Lexem.lexemeType.E)){
            if(charArray[i] == 'e'){
                sb.append(charArray[i]);
                ++i;
                if(charArray[i] == '-' || charArray[i] == '+'){
                    sb.append(charArray[i]);
                    ++i;
                }
            } else {
                sb.append(charArray[i]);
                ++i;
            }
        }
        reverseStack.push(sb.toString());
        return  i - 1;
    }

    private void handleBrackets(){
        while (Lexem.getLexemeType(operatorsStack.peek()) != Lexem.lexemeType.BRACKET_L){
            reverseStack.push(String.valueOf(operatorsStack.pop()));
        }
        if (Lexem.getLexemeType(operatorsStack.peek()) == Lexem.lexemeType.BRACKET_L) operatorsStack.pop();
    }

    private void handleOperators(int i, char [] charArray){
        if(!operatorsStack.empty()){
            int arrayOpPr = getPriority(charArray[i]);
            int stackOpPr = getPriority(operatorsStack.peek());
            if (stackOpPr >= arrayOpPr){
                while (stackOpPr >= arrayOpPr && !operatorsStack.empty()){
                    reverseStack.push(String.valueOf(operatorsStack.pop()));
                    if (!operatorsStack.empty()){
                        stackOpPr = getPriority(operatorsStack.peek());
                    }
                }
            }
        }
        operatorsStack.push(charArray[i]);
    }

    private void handlePow(int i, char [] charArray){
        if(!operatorsStack.empty()){
            int str_pr = getPriority(charArray[i]);
            int stack_op_pr = getPriority(operatorsStack.peek());
            if (stack_op_pr > str_pr || stack_op_pr == 5){
                while ((stack_op_pr > str_pr || stack_op_pr == 5) && !operatorsStack.empty()){
                    reverseStack.push(String.valueOf(operatorsStack.pop()));
                    if (!operatorsStack.empty()){
                        stack_op_pr = getPriority(operatorsStack.peek());
                    }
                }
            }
            if(stack_op_pr == str_pr){
                operatorsStack.push(charArray[i]);
            }else {
                operatorsStack.push(charArray[i]);
            }
        } else {
            operatorsStack.push(charArray[i]);
        }
    }
}
