package jvm;

import java.math.BigDecimal;

/**
 * Created by harlenzhang on 2017/1/18.
 */
public class String {

    public static void main(java.lang.String[] args) {
        System.out.println("test");
        try {
            Thread.currentThread().getContextClassLoader().loadClass("jvm.String");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
