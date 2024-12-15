package m3mpm.smartcalc.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class Credit {
    public Credit() {}
    public List<List<Double>> getCreditData(Double inputSum, Integer inutPeriod, Double inputPercent, Integer inputType) {
            List<List<Double>> data = new ArrayList<>();
            double fixMonthPay = 0.0;
            double monthPercent = (inputPercent/12)/100;

            if(inputType == 1){
                fixMonthPay = inputSum * (monthPercent + (monthPercent / (Math.pow(1+monthPercent,inutPeriod)-1)));
                double leftDolg = inputSum;

                for (int i = 0; i < inutPeriod; i++) {
                    double overPayi = leftDolg * monthPercent;
                    double mainDolgPayi = fixMonthPay - overPayi;
                    leftDolg -= mainDolgPayi;
                    List<Double> row = Arrays.asList((double)(i+1),fixMonthPay,mainDolgPayi,overPayi,leftDolg);
                    data.add(row);
                }
            } else if(inputType == 2){
                fixMonthPay = inputSum/inutPeriod;
                double overPayi = 0.0;
                double leftDolg = inputSum;

                for (int i = 0; i < inutPeriod; i++){
                    overPayi = leftDolg * monthPercent;
                    leftDolg -= fixMonthPay;
                    double monthPayi = fixMonthPay + overPayi;
                    List<Double> row = Arrays.asList((double)(i+1),monthPayi,fixMonthPay,overPayi,leftDolg);
                    data.add(row);
                }
            }
            return data;
    }
}
