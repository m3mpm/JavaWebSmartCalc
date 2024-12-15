package m3mpm.smartcalc.model;

import m3mpm.smartcalc.exceptions.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Stack;

@Component
public class Calculator {
    @Autowired
    private PolishNotation polishNotation;

    private Double x;
    private Stack<String> polishStack;
    private Stack<Double> numbersStack = new Stack<>();

    public Calculator() {}

    public double getResult(String str, Double x){
        polishStack = polishNotation.createPolishNotation(str);
        this.x = x;
        return makeCalculation();
    }

    public double getResult(Stack<String> polishStack, Double x){
        this.polishStack = polishStack;
        this.x = x;
        return  makeCalculation();
    }

    private double makeCalculation () {
        while (!polishStack.empty()) {
            switch (polishStack.peek()){
                case "u" -> calcUnaryMinus();
                case "p" -> calcUnaryPlus();
                case "+" -> calcAdd();
                case "-" -> calcSub();
                case "*" -> calcMulti();
                case "/" -> calcDiv();
                case "m" -> calcMod();
                case "^" -> calcPow();
                case "c" -> calcCos();
                case "s" -> calcSin();
                case "t" -> calcTan();
                case "o" -> calcAcos();
                case "i" -> calcAsin();
                case "a" -> calcAtan();
                case "q" -> calcSqrt();
                case "g" -> calcLog();
                case "n" -> calcLn();
                case "x" -> {
                            numbersStack.push(x);
                            polishStack.pop();
                    }
                default -> numbersStack.push(Double.parseDouble(polishStack.pop()));
            }
        }
        double result;
        if(numbersStack.empty()) {
            String msg = "Calculator: makeCalculation error!";
            throw new MyException(msg);
        } else {
            result = numbersStack.pop();
        }
        return result;
    }

    private void calcUnaryMinus(){
        double num = numbersStack.pop();
        numbersStack.push( num * (-1));
        polishStack.pop();
    }

    private void calcUnaryPlus(){
        double num = numbersStack.pop();
        numbersStack.push(num * 1);
        polishStack.pop();
    }

    private void calcAdd(){
        double num2 = numbersStack.pop();
        double num1 = numbersStack.pop();
        numbersStack.push(num1 + num2);
        polishStack.pop();
    }

    private void calcSub(){
        double num2 = numbersStack.pop();
        double num1 = numbersStack.pop();
        numbersStack.push(num1 - num2);
        polishStack.pop();
    }

    private void calcMulti(){
        double num2 = numbersStack.pop();
        double num1 = numbersStack.pop();
        numbersStack.push(num1 * num2);
        polishStack.pop();
    }

    private void calcDiv(){
        double num2 = numbersStack.pop();
        double num1 = numbersStack.pop();
        numbersStack.push(num1 / num2);
        polishStack.pop();
    }

    private void calcMod(){
        double num2 = numbersStack.pop();
        double num1 = numbersStack.pop();
        numbersStack.push(num1 % num2);
        polishStack.pop();
    }

    private void calcPow(){
        double num2 = numbersStack.pop();
        double num1 = numbersStack.pop();
        numbersStack.push(Math.pow(num1,num2));
        polishStack.pop();
    }

    private void calcCos(){
        double num = numbersStack.pop();
        numbersStack.push(Math.cos(num));
        polishStack.pop();
    }

    private void calcSin(){
        double num = numbersStack.pop();
        numbersStack.push(Math.sin(num));
        polishStack.pop();
    }

    private void calcTan(){
        double num = numbersStack.pop();
        numbersStack.push(Math.tan(num));
        polishStack.pop();
    }

    private void calcAcos(){
        double num = numbersStack.pop();
        numbersStack.push(Math.acos(num));
        polishStack.pop();
    }

    private void calcAsin(){
        double num = numbersStack.pop();
        numbersStack.push(Math.asin(num));
        polishStack.pop();
    }

    private void calcAtan(){
        double num = numbersStack.pop();
        numbersStack.push(Math.atan(num));
        polishStack.pop();
    }

    private void calcSqrt(){
        double num = numbersStack.pop();
        numbersStack.push(Math.sqrt(num));
        polishStack.pop();
    }

    private void calcLog(){
        double num = numbersStack.pop();
        numbersStack.push(Math.log10(num));
        polishStack.pop();
    }

    private void calcLn(){
        double num = numbersStack.pop();
        numbersStack.push(Math.log(num));
        polishStack.pop();
    }
}
