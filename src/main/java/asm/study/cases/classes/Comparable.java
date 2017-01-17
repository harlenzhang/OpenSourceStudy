package asm.study.cases.classes;

/**
 * Created by harlenzhang on 2017/1/17.
 */
public interface Comparable  {
    int LESS = -1;
    int EQUAL = 0;
    int GREATER = 1;
    int compareTo(Object o);
}
