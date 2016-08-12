package groovy.javacode;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by harlenzhang on 16/8/12.
 */
public class TestEvalGroovy {
    public static void main(String[] args) {
        ScriptEngineManager factory = new ScriptEngineManager(TestEvalGroovy.class.getClassLoader());
        ScriptEngine scriptEngine = factory.getEngineByName("groovy");
            try {
                scriptEngine.eval("println 'hello, harlen'\n" +
                        "        x = 123\n" +
                        "        println x\n" );
            } catch (ScriptException e) {
                e.printStackTrace();
            }
    }


}
