package m3mpm.smartcalc.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class CalculatorTest {
    @Autowired
    private Calculator calc;

    private static final double DELTA = 1e-7;

    @Test
    public void test01(){
        String str = "1+2";
        double x = 0.0;
        double res = 1+2;
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void test02(){
        String str = "1.4356789-2.245";
        double x = 0.0;
        double res = 1.4356789-2.245;
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void test03(){
        String str = "100.456";
        double x = 0.0;
        double res = 100.456;
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void test04(){
        String str = "2.1/(1.5+1.678)";
        double x = 0.0;
        double res = 2.1/(1.5+1.678);
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void test05(){
        String str = "2.7856*(5.345-2.345)";
        double x = 0.0;
        double res = 2.7856*(5.345-2.345);
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void test06(){
        String str = "2.25*(5.67-x)";
        double x = 2.543;
        double res = 2.25*(5.67-x);
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void test07(){
        String str = "(2^2)+(2^2)";
        double x = 0.0;
        double res = Math.pow(2,2)+Math.pow(2,2);
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void test08(){
        String str = "((((10.987))))";
        double x = 0.0;
        double res = 10.987;
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void test09(){
        String str = "sqrt(9)";
        double x = 0.0;
        double res = Math.sqrt(9);
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void test10(){
        String str = "log(10)";
        double x = 0.0;
        double res = Math.log10(10);
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void test11(){
        String str = "ln(2.718281828459045)";
        double x = 0.0;
        double res = Math.log(2.718281828459045);
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void test12(){
        String str = "5.25-10.01";
        double x = 0.0;
        double res = 5.25-10.01;
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void test13(){
        String str = "3.01*3.02";
        double x = 0.0;
        double res = 3.01*3.02;
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void test14(){
        String str = "9.45/3.26";
        double x = 0.0;
        double res = 9.45/3.26;
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void test15(){
        String str = "0*3";
        double x = 0.0;
        double res = 0*3;
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void test16(){
        String str = "9.45/3.26";
        double x = 0.0;
        double res = 9.45/3.26;
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void test17(){
        String str = "-0";
        double x = 0.0;
        double res = 0;
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void test18(){
        String str = "sin(2.14/2.1)";
        double x = 0.0;
        double res = Math.sin(2.14/2.1);
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void test19(){
        String str = "sin(0)";
        double x = 0.0;
        double res = Math.sin(0);
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void test20(){
        String str = "-sin(2.14/2.1)";
        double x = 0.0;
        double res = -(Math.sin(2.14/2.1));
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void test21(){
        String str = "cos(2.14/2.1)";
        double x = 0.0;
        double res = (Math.cos(2.14/2.1));
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void test22(){
        String str = "cos(0)";
        double x = 0.0;
        double res = Math.cos(0);
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void test23(){
        String str = "cos(2.14/2.1)+(10.01)*(-1.1)";
        double x = 0.0;
        double res = Math.cos(2.14/2.1)+(10.01)*(-1.1);
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void test24(){
        String str = "tan(0)";
        double x = 0.0;
        double res = Math.tan(0);
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void test25(){
        String str = "tan(2.14/4.01)";
        double x = 0.0;
        double res = Math.tan(2.14/4.01);
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void test26(){
        String str = "-tan(2.14/4.01)";
        double x = 0.0;
        double res = -Math.tan(2.14/4.01);
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void test27(){
        String str = "asin(-0.91)";
        double x = 0.0;
        double res = Math.asin(-0.91);
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void test28(){
        String str = "acos(0)";
        double x = 0.0;
        double res = Math.acos(0);
        assertEquals(calc.getResult(str,x),res,DELTA);
    }


    @Test
    public void test29(){
        String str = "atan(-1.01)";
        double x = 0.0;
        double res = Math.atan(-1.01);
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void test30(){
        String str = "2^2^2^2";
        double x = 0.0;
        double res = Math.pow(2,Math.pow(2,Math.pow(2,2)));
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void test31(){
        String str = "4+4*5-23^3/6";
        double x = 0.0;
        double res = 4+4*5-Math.pow(23,3)/6;
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void test32(){
        String str = "3.56*4-0.7865/45.67+6";
        double x = 0.0;
        double res = 3.56*4-0.7865/45.67+6;
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void test33(){
        String str = "3.56*((4-0.7865)/45.67+6)";
        double x = 0.0;
        double res = 3.56*((4-0.7865)/45.67+6);
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void test34(){
        String str = "(3+4)*(sin(0.245))";
        double x = 0.0;
        double res = (3+4)*(Math.sin(0.245));
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void test35(){
        String str = "6/cos(35)+(6-76)";
        double x = 0.0;
        double res = 6/Math.cos(35)+(6-76);
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void test36(){
        String str = "-6+9.8^4";
        double x = 0.0;
        double res = -6+Math.pow(9.8,4);
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void test37(){
        String str = "4.76-(-11+5)";
        double x = 0.0;
        double res = 4.76-(-11+5);
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void test38(){
        String str = "10mod5";
        double x = 0.0;
        double res = 10 % 5;
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void test39(){
        String str = "-9.43mod-6.3";
        double x = 0.0;
        double res = -9.43 % -6.3;
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void test40(){
        String str = "sin(+5+1.4)+sin(-3)";
        double x = 0.0;
        double res = Math.sin(+5+1.4)+Math.sin(-3);
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void test41(){
        String str = "sin(cos(4)+5)";
        double x = 0.0;
        double res = Math.sin(Math.cos(4)+5);
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void test42(){
        String str = "sin(2.5)^4*cos(1.7)^-2";
        double x = 0.0;
        double res = (Math.pow(Math.sin(2.5), 4) * Math.pow(Math.cos(1.7), -2));
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void test43(){
        String str = "acos(1)+asin(1)+atan(1)+cos(1)+sin(1)+tan(1)";
        double x = 0.0;
        double res = Math.acos(1)+Math.asin(1)+Math.atan(1)+Math.cos(1)+Math.sin(1)+Math.tan(1);
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void test44(){
        String str = "atan(4^7-acos(0.326))+8.98";
        double x = 0.0;
        double res = Math.atan(Math.pow(4,7)-Math.acos(0.326))+8.98;
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void test45(){
        String str = "log(47)/ln(54)";
        double x = 0.0;
        double res = Math.log10(47)/Math.log(54);
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void test46(){
        String str = "-67*-ln(0.321)";
        double x = 0.0;
        double res = -67*-Math.log(0.321);
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void test47(){
        String str = "10/log(100)*(102+5.86)";
        double x = 0.0;
        double res = 10/Math.log10(100)*(102+5.86);
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void test48(){
        String str = "cos(sqrt(ln(300)))";
        double x = 0.0;
        double res = Math.cos(Math.sqrt(Math.log(300)));
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void test49(){
        String str = "sqrt(x*x+x)*cos(cos(x))*sin(x*4)*tan(x)";
        double x = 76.89;
        double res = Math.sqrt(x*x+x)*Math.cos(Math.cos(x))*Math.sin(x*4)*Math.tan(x);
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void test50(){
        String str = "1+1.23e2";
        double x = 0.0;
        double res = 1+1.23e2;
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void test51(){
        String str = "-1+1.23e+2";
        double x = 0.0;
        double res = -1+1.23e+2;
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void test52(){
        String str = "-1-1.23e-2";
        double x = 0.0;
        double res = -1-1.23e-2;
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void test53(){
        String str = "+1785478537-1.235784758475389e+2";
        double x = 0.0;
        double res = +1785478537 - 1.235784758475389e+2;
        assertEquals(calc.getResult(str,x),res,DELTA);
    }

    @Test
    public void infnan01(){
        String str = "1/0";
        double x = 0.0;
        System.out.println(calc.getResult(str,x));
        assertTrue(Double.isInfinite(calc.getResult(str,x)));
    }

    @Test
    public void infnan02(){
        String str = "2mod0";
        double x = 0.0;
        System.out.println(calc.getResult(str,x));
        assertTrue(Double.isNaN(calc.getResult(str,x)));
    }

    @Test
    public void infnan03(){
        String str = "log(-10)";
        double x = 0.0;
        System.out.println(calc.getResult(str,x));
        assertTrue(Double.isNaN(calc.getResult(str,x)));
    }

    @Test
    public void infnan04(){
        String str = "ln(-10)";
        double x = 0.0;
        System.out.println(calc.getResult(str,x));
        assertTrue(Double.isNaN(calc.getResult(str,x)));
    }

    @Test
    public void infnan05(){
        String str = "sqrt(-10)";
        double x = 0.0;
        System.out.println(calc.getResult(str,x));
        assertTrue(Double.isNaN(calc.getResult(str,x)));
    }

    @Test
    public void infnan06(){
        String str = "0^(-1)";
        double x = 0.0;
        System.out.println(calc.getResult(str,x));
        assertTrue(Double.isInfinite(calc.getResult(str,x)));
    }


    @Test
    public void infnan07(){
        String str = "ln(0)";
        double x = 0.0;
        System.out.println(calc.getResult(str,x));
        assertTrue(Double.isInfinite(calc.getResult(str,x)));
    }


    @ParameterizedTest
    @ValueSource(strings = {"1+cos(1+", ")+(1-2"})
    public void invalidBrackets(String str) {
        assertThrows(Exception.class, () -> {
            calc.getResult(str,0.0);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"(2+tan()+sin()-3+y)", "2+p", "1+tyn(0.2)"})
    public void invalidCharacters(String str){
        assertThrows(Exception.class, () -> {
            calc.getResult(str,0.0);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"+1-2*(", "+1-2*(x+sin(","1+1-2*x.+sin(1)","(1+1-2*x).(+sin(1))","(1+1-2*x)+(+sin(1...3))",
                            "(1+1-2*x)+(+sin(1.3.3))","1+1.3e2.1","1+1.3e(2+1)","1+1.3e/2","1+1.3emod3","5*acos(",
                            "asin(*1"})
    public void invalidInputString(String str){
        assertThrows(Exception.class, () -> {
            calc.getResult(str,0.0);
        });
    }

}
