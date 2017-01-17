/*
package groovy.javacode;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;

*/
/**
 * Created by harlenzhang on 16/8/12.
 *//*

public class InvokeGroovy {
    public static void main(String[] args) {
        ClassLoader loader = new InvokeGroovy().getClass().getClassLoader();
        GroovyClassLoader groovyClassLoader = new GroovyClassLoader(loader);
        Class groovyClass = null;
        try {
            File file = new File("/Users/harlenzhang/Documents/projects/OpenSourceStudy/src/main/java/groovy/groovycode/Foo.groovy");
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                StringBuilder sb = new StringBuilder();
                while((line = reader.readLine()) != null)
                    sb.append(line);
                String script = sb.toString();
                ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
                ScriptEngine engine = scriptEngineManager.getEngineByName("groovy");
            engine.put("name", "harlen");
            engine.getBindings(ScriptContext.ENGINE_SCOPE).put("name", "lydia");
            Student result = (Student)engine.eval(script);
            System.out.println(result.getAge());
            int val = (Integer)engine.get("val");
            System.out.println(val);
            */
/*groovyClass = groovyClassLoader.parseClass(file);
            IFoo foo = (IFoo)groovyClass.newInstance();
            System.out.println(foo.run(new Integer(2), "more parameter"));
            System.out.println("--------------------------------------");
            GroovyObject groovyObject = (GroovyObject)groovyClass.newInstance();
            System.out.println(groovyObject.invokeMethod("run", new Object[]{new Integer(2),"More parameter..."}));*//*

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
*/
