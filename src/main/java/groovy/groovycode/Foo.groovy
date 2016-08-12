package groovy.groovycode

import groovy.javacode.IFoo;
class Foo implements IFoo{
    def x
    public Object run(Object foo, Object bar){
        println 'hello, harlen'
        x = 123
        println foo * 10
        println bar
        return 'success'
    }
}
