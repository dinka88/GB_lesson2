package ru.dinka88.profflvl.lesson7;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestRunner {
    public static void start(Class clazz) throws Exception {
        Object instance = clazz.newInstance();
        Method[] methods = clazz.getDeclaredMethods();
        int b = 0;
        int a = 0;
        for (Method method : methods) {
            BeforeSuite beforeSuite = method.getDeclaredAnnotation(BeforeSuite.class);
            if (beforeSuite != null) {
                b++;
                if (b > 1) {
                    throw new RuntimeException();
                }
                method.invoke(instance);
            }

        }

        List<Method> forInvoke = Arrays.asList(methods)
                .stream()
                .filter(t -> t.getDeclaredAnnotation(Test.class) != null)
                .sorted((a1, b1) -> {
                    return a1.getDeclaredAnnotation(Test.class).priority() - b1.getDeclaredAnnotation(Test.class).priority();
                })
                .collect(Collectors.toList());
        for (Method method : forInvoke) {
            method.invoke(instance);
        }

        for (Method method : methods) {
            AfterSuite afterSuite = method.getDeclaredAnnotation(AfterSuite.class);
            if (afterSuite != null) {
                a++;
                if (a > 1) {
                    throw new RuntimeException();
                }
                method.invoke(instance);
            }
        }
    }
}
