package basic.studyexception;

/**
 * Created by harlenzhang on 16/9/1.
 */
public class TestException {

    boolean testEx() throws Exception {
        boolean ret = true;
        try {
            ret = testEx1();
        } catch (Exception e) {
            System.out.println("testEx, catch exception");
            ret = false;
            throw e;
        } finally {
            System.out.println("testEx, finally; return value=" + ret);
            return ret;
        }
    }

    boolean testEx1() throws Exception {
        boolean ret = true;
        try {
            ret = testEx2();
            System.out.println("testEx1, at the end of try");
            return ret;
        } catch (Exception e) {
            System.out.println("testEx1, catch exception");
            ret = false;
            throw e;
        } finally {
            System.out.println("testEx1, finally; return value=" + ret);
            return ret;
        }
    }

    boolean testEx2() throws Exception {
        boolean ret = true;
        try {
            int b = 12;
            int c;
            for (int i = 2; i >= -2; i--) {
                c = b / i;
                System.out.println("i=" + i);
            }
            return true;
        } catch (Exception e) {
            System.out.println("testEx2, catch exception");
            ret = false;
            throw e;
        } finally {
            System.out.println("testEx2, finally; return value=" + ret);
        }
    }


    public static int test(boolean flag) throws Exception {
        try {
            if (flag)
                return 1;
            return 0;
        } finally {
            System.out.println("in test method");
        }

    }

    public static void main(String[] args) {
        /*int result = test(false);*/
        /*System.out.println(result);*/
        TestException testException1 = new TestException();


        try {
            testException1.testEx();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
