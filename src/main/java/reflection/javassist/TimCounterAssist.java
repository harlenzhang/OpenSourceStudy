package reflection.javassist;

import javassist.*;

import java.io.IOException;

/**
 * Created by harlenzhang on 2017/1/24.
 */
public class TimCounterAssist {

    private static void addTimeMonitor(CtClass ctClass, String mname) throws NotFoundException, CannotCompileException {
        CtMethod mold = ctClass.getDeclaredMethod(mname);
        String nname = mname + "$impl";
        mold.setName(nname);

        CtMethod mnew = CtNewMethod.copy(mold, mname, ctClass, null);
        String type = mold.getReturnType().getName();
        StringBuffer body = new StringBuffer();
        body.append("{\nlong start = System.currentTimeMillis();\n");
        if (!type.equals("void")){
            body.append(type + " result = ");
        }
        body.append("System.out.println(\"Call to method " + mname +
                " took \" +\n (System.currentTimeMillis()-start) + " +
                "\" ms.\");\n");
        if (!"void".equals(type)) {
            body.append("return result;\n");
        }
        body.append("}");
        mnew.setBody(body.toString());
        ctClass.addMethod(mnew);

        System.out.println("Interceptor method body:");
        System.out.println(body.toString());
    }

    public static void main(String[] args) throws NotFoundException, CannotCompileException, IOException {
        if (args.length == 2){
            CtClass clas = ClassPool.getDefault().get(args[0]);
            if (clas == null)
                System.out.println("class " + args[0] + " not found");
            else {
                addTimeMonitor(clas, args[1]);
                clas.writeFile();
                System.out.println("added time monitor to method " + args[0] + "." + args[1]);

            }

        }else {
            System.out.println("Usage: JassistTiming class method-name");
        }
    }
}
