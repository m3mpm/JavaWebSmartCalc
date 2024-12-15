package m3mpm.smartcalc.controller;

import com.alibaba.fastjson.JSONObject;
import m3mpm.smartcalc.model.Chart;
import m3mpm.smartcalc.model.Credit;
import org.springframework.beans.factory.annotation.Autowired;
import m3mpm.smartcalc.model.Calculator;
import m3mpm.smartcalc.service.History;

import jakarta.validation.Valid;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.prefs.BackingStoreException;


@Controller
@RequestMapping()
public class CalcController {
    @Autowired
    private Calculator calculator;
    @Autowired
    private History history;
    @Autowired
    private Chart chart;
    @Autowired
    private Credit credit;


    @GetMapping("")
    public String start(){
        return "calc";
    }

    @ResponseBody
    @GetMapping("/calc")
    public Double makeCalc(@RequestParam(name="str") String inputStr,
                           @RequestParam(name="x", required=false, defaultValue = "0.0") Double inputX) {

        return calculator.getResult(inputStr,inputX);
    }

    @ResponseBody
    @PostMapping("/history/save")
    public void saveRecordToHistory(@NotNull @Valid @RequestBody JSONObject jsonObj){
        String str = (String) jsonObj.get("str");
        history.saveRecordToHistory(str);
    }

    @ResponseBody
    @GetMapping("/history/get")
    public String[] getHistory() throws BackingStoreException {
        return history.getHistory();
    }

    @ResponseBody
    @DeleteMapping("/history/clean")
    public void cleanHistory() throws BackingStoreException {
        history.cleanHistory();
    }

    @ResponseBody
    @GetMapping("/chart")
    public List<List<Double>> getChartData(@RequestParam(name="str") String inputStr,
                                           @RequestParam(name="min", required = false, defaultValue = "-30") Double minX,
                                           @RequestParam(name="max", required = false, defaultValue = "30") Double maxX,
                                           @RequestParam(name="step", required = false,defaultValue = "0.01") Double stepX) {

        return chart.getChartData(inputStr,minX,maxX,stepX);
    }

    @ResponseBody
    @GetMapping("/credit")
    public List<List<Double>> getCreditData(@RequestParam(name="sum") Double inputSum,
                                            @RequestParam(name="period") Integer inputPeriod,
                                            @RequestParam(name="percent") Double inputPercent,
                                            @RequestParam(name="type") Integer inputType){

        return credit.getCreditData(inputSum,inputPeriod,inputPercent,inputType);
    }

}
