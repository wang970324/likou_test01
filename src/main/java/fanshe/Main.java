package fanshe;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class<?> targetClass = Class.forName("fanshe.TargetObject");
        TargetObject targetObject = (TargetObject)targetClass.newInstance();

        Method[] methods = targetClass.getDeclaredMethods();
        for (Method method:methods){
            System.out.println(method.getName());
        }

        Method publicMethod = targetClass.getDeclaredMethod("publicMethod", String.class);
        publicMethod.invoke(targetObject,"java");

        Field field = targetClass.getDeclaredField("value");

        field.setAccessible(true);
        field.set(targetObject,"javaguide");

        Method privateMethod = targetClass.getDeclaredMethod("privateMethod");

        privateMethod.setAccessible(true);
        privateMethod.invoke(targetObject);


    }
}
