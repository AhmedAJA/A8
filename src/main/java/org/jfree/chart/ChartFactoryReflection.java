package org.jfree.chart;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class ChartFactoryReflection extends ChartFactory {
    ChartFactoryReflection() {

    }

    public JFreeChart getChartReflection(String chartType, List<Object> params)
            throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class<?> classObj = Class.forName(chartType);
        Constructor<?> chartConstructor = classObj.getConstructor();

        String chart = classObj.getSimpleName();

        if (chart == null || chart == "") {
            return null;
        }

        Object chartObj = chartConstructor.newInstance();

        return getChartObject(chart, classObj, chartObj, params);

    }

    public JFreeChart getChartObject(String simpleClassName, Class<?> classObj, Object chartObj, List<Object> params)
            throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException {
        Method createMethod;
        Class<?>[] parameterTypes = new Class<?>[params.size()];

        for (int i = 0; i < parameterTypes.length; i++) {
            var objectType = params.get(i).getClass();
            parameterTypes[i] = objectType;
        }

        System.out.println("Parameters in parameterTypes are: \n");

        for (var param : parameterTypes) {
            System.out.println(param);
        }

        Object[] inputParams = new Object[params.size()];

        for (int i = 0; i < params.size(); i++) {
            inputParams[i] = params.get(i);
        }

        var methods = classObj.getMethods();

        for (var method : methods) {
            if (method.getName().equalsIgnoreCase("createChart") && method.getParameterCount() == 5) {
                System.out.println("Method name: " + method.getName() + "\nParameter Count: "
                        + method.getParameterCount() + "\nParameterTypes: \n");
                for (var paramType : method.getParameterTypes()) {
                    System.out.println(paramType);
                }
            }

        }
        createMethod = classObj.getMethod("createChart", parameterTypes);
        return (JFreeChart) createMethod.invoke(chartObj, inputParams);

    }
}
