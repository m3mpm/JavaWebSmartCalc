package m3mpm.smartcalc.model;

import m3mpm.smartcalc.exceptions.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Component
public class Chart {
    @Autowired
    private Calculator calculator;
    @Autowired
    private PolishNotation polishNotation;


    final private double MAX_Y = 1000000;
    final private double MIN_Y = -1000000;

    public List<List<Double>> getChartData(String str, Double min, Double max, Double step) {
        List<List<Double>> chartDataMatrix = new ArrayList<>();
        try {
            Stack<String> polishStack = polishNotation.createPolishNotation(str);

            List<Double> arr_x = new ArrayList<>();
            List<Double> arr_y = new ArrayList<>();

            double y = 0.0;
            for (double x = min; x <= max; x += step) {
                arr_x.add(x);
                Stack<String> copyPolishStack = (Stack<String>) polishStack.clone();
                y = calculator.getResult(copyPolishStack,x);
                if((y >= MIN_Y && y <= MAX_Y) && !Double.isInfinite(y)){
                    arr_y.add(y);
                } else {
                    arr_y.add(null);
                }
            }
            chartDataMatrix.add(arr_x);
            chartDataMatrix.add(arr_y);
        } catch (Exception e){
            throw new MyException("Chart error!");
        }
        return chartDataMatrix;
    }
}
