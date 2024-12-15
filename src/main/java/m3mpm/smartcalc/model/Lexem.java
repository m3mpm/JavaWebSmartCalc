package m3mpm.smartcalc.model;

public class Lexem {
    public Lexem() {}

    public enum lexemeType { NUMBER, E, DOT, X, FUNCTION, UNARY_PLUS , UNARY_MINUS, BRACKET_L, BRACKET_R, OPERATOR, POW };

    static public lexemeType getLexemeType(char ch) {
        return switch (ch) {
            case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> lexemeType.NUMBER;
            case '.' -> lexemeType.DOT;
            case 'e' -> lexemeType.E;
            case '+', '-', '*', '/', 'm' -> lexemeType.OPERATOR;
            case '(' -> lexemeType.BRACKET_L;
            case ')' -> lexemeType.BRACKET_R;
            case 'p' -> lexemeType.UNARY_PLUS;
            case 'u' -> lexemeType.UNARY_MINUS;
            case 'x' -> lexemeType.X;
            case '^' -> lexemeType.POW;
            default -> lexemeType.FUNCTION;
        };
    }
}
