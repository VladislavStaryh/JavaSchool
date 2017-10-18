package Reflection_06.Beans;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class BeansUtils {
    /**
     * Scans object "from" for all getters. If object "to"
     * contains correspondent setter, it will invoke it
     * to set property value for "to" which equals to the property
     * of "from".
     * <p/>
     * The type in setter should be compatible to the value returned
     * by getter (if not, no invocation performed).
     * Compatible  means that parameter type in setter should
     * be the same or be superclass of the return type of the getter.
     * <p/>
     * The method takes care only about public methods.
     *
     *
     * @param to     Object which properties will be set.
     * @param from Object which properties will be used to get values.
     */
    public static void assign(Object from, Object to) {

        Class clazzTo = to.getClass();
        Class clazzFrom = from.getClass();

        Method[] methodsFrom = clazzFrom.getMethods();
        Method[] methodsTo = clazzTo.getMethods();

        HashMap<String, Method> mapMethodsTo = new HashMap<>();

        for (Method method : methodsTo) {
            mapMethodsTo.put(method.getName(), method);
        }

        for (Method getMethod : methodsFrom) {
            if (getMethod.getName().startsWith("get")) {

                String setMethodName = getMethod.getName().replace("get", "set");
                Method setMethod = mapMethodsTo.get(setMethodName);
                if (setMethod == null) {
                    System.out.println("set-метод " + setMethodName + " не найден");
                    return;
                }
                Class<?> setMethodType = setMethod.getParameterTypes()[0];
                Class<?> getMethodType = getMethod.getReturnType();

                if (setMethodType.isAssignableFrom(getMethodType)) {
                    try {
                        setMethod.invoke(to, getMethod.invoke(from));
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        System.out.println("Метод недоступен" + e.getMessage());
                    }
                } else {
                    System.out.println("Типы параметров get- и set-методов несовместимы");
                }

            }
        }
    }

}
