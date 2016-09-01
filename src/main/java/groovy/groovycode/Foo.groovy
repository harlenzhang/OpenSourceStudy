import groovy.javacode.Student;
import groovy.sql.Sql;
def db= Sql.newInstance(
        url:"jdbc:mysql://121.40.143.236:3306/tqbase?characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull",
        user:"shop_rw",
        password:"Tufw7w4Ukpt",
        driverClassName:"com.mysql.jdbc.Driver"
);
db.rows("SELECT * FROM db_gift_item limit 10").each {row-> println((row['gift_name']))};
def val = 12;
println(name);
def student = new Student();
student.age = 12;
student.name = "tefda";
return student;
/*import groovy.javacode.IFoo;
class Foo implements IFoo{
    def x
    public Object run(Object foo, Object bar){
        println 'hello, test'
        x = 123
        println foo * 10
        println bar
        return 'success'
    }
}*/
