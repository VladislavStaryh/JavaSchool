package Reflection_06.Proxy;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        ICalculator calculator = (ICalculator) Proxy.newProxyInstance(  Calculator.class.getClassLoader(),
                                                                        new Class[]{ICalculator.class},
                                                                        new CachedProxy(new Calculator())
                                                                        );


        System.out.println("1+1 = " + calculator.plus(1., 1.));
        System.out.println("1+1 = " + calculator.plus(1., 1.));
        System.out.println("1+1 = " + calculator.plus(2., 1.));
    }
}
