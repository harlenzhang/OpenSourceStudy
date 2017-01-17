package asm.study.cases.aop;

import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;

/**
 * Created by harlenzhang on 2017/1/16.
 */
public class AddSecurityCheckClassAdapter extends ClassAdapter{

    public AddSecurityCheckClassAdapter(ClassVisitor classVisitor) {
        super(classVisitor);
    }

    @Override
    public MethodVisitor visitMethod(final int access, final String name,
                                     final String desc, final String signature, final String[] exceptions) {
        MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
        MethodVisitor wrappedMv = mv;
        if (mv != null){
            if (name.equals("operation")){
                wrappedMv = new AddSecurityCheckMethodAdapter(mv);
            }else if (name.equals("<init>")){
                wrappedMv = new ChangeToChildConstructorMethodAdapter(mv);
            }
        }
        return wrappedMv;
    }
}
