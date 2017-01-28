package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by harlenzhang on 2017/1/24.
 */
public class Demo {
    public static void main(String[] args) {

        try {

            
            Class clazz = Class.forName("reflection.RefectObject");
            Class[] cons = new Class[] {String.class, String.class, Integer.class};
            Constructor constructor = clazz.getConstructor(cons);
            RefectObject object = (RefectObject)constructor.newInstance("lydia","harlen",null);
            for (Method method : clazz.getMethods()){
                if (method.getName().startsWith("get")){
                    System.out.println("I'm invoking the getter method");
                    method.setAccessible(true);
                    Object result = method.invoke(object);
                    if (result == null){
                        System.out.println("the result is null");
                    }else
                        System.out.println(method.invoke(object));
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
