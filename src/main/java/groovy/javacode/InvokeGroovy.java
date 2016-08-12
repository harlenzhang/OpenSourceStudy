package groovy.javacode;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by harlenzhang on 16/8/12.
 */
public class InvokeGroovy {
    public static void main(String[] args) {
        ClassLoader loader = new InvokeGroovy().getClass().getClassLoader();
        GroovyClassLoader groovyClassLoader = new GroovyClassLoader(loader);
        Class groovyClass = null;
        try {
            File file = new File("/Users/harlenzhang/Documents/projects/OpenSourceStudy/src/main/java/groovy/groovycode/Foo.groovy");
            groovyClass = groovyClassLoader.parseClass(file);
            IFoo foo = (IFoo)groovyClass.newInstance();
            System.out.println(foo.run(new Integer(2), "more parameter"));
            System.out.println("--------------------------------------");


            GroovyObject groovyObject = (GroovyObject)groovyClass.newInstance();
            System.out.println(groovyObject.invokeMethod("run", new Object[]{new Integer(2),"More parameter..."}));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
