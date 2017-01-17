package asm.study.cases.aop;

import org.objectweb.asm.MethodAdapter;
import org.objectweb.asm.MethodVisitor;

/**
 * Created by harlenzhang on 2017/1/16.
 */
public class AddSecurityCheckMethodAdapter extends MethodAdapter{
    public AddSecurityCheckMethodAdapter(MethodVisitor methodVisitor) {
        super(methodVisitor);
    }
}
