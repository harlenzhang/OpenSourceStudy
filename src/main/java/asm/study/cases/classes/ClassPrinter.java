package asm.study.cases.classes;


import aj.org.objectweb.asm.*;
import javassist.util.proxy.MethodFilter;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Created by harlenzhang on 2017/1/16.
 */
public class ClassPrinter extends ClassVisitor{

    public ClassPrinter(int i) {
        super(i);
    }

    public void test(){
        System.out.println("testmethod");
    }

    @Override
    public void visitSource(String s, String s1) {
        System.out.println(s + s1);
        super.visitSource(s, s1);
    }

    @Override
    public MethodVisitor visitMethod(int i, String s, String s1, String s2, String[] strings) {
        return null;
    }

    @Override
    public void visit(int i, int i1, String s, String s1, String s2, String[] strings) {
        super.visit(i, i1, s, s1, s2, strings);
        System.out.println(s + s1 + s2);
    }

    public static void main(String[] args) {
        ClassPrinter printer = new ClassPrinter(1);
        try {
            ClassReader cr = new ClassReader("asm.study.cases.classes.ClassPrinter");
            cr.accept(printer, 0);
            for (Method method : printer.getClass().getMethods())
                System.out.println(method.getName());
            System.out.println(cr.getClassName());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
