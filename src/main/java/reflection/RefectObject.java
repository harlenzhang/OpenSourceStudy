package reflection;

/**
 * Created by harlenzhang on 2017/1/24.
 */
public class RefectObject {
    private String prop1;
    private String prop2;

    private Integer prop;

    public String getProp1() {
        return prop1;
    }

    public void setProp1(String prop1) {
        this.prop1 = prop1;
    }

    public String getProp2() {
        return prop2;
    }

    public void setProp2(String prop2) {
        this.prop2 = prop2;
    }

    public Integer getProp() {
        return prop;
    }

    public void setProp(Integer prop) {
        this.prop = prop;
    }

    public void increase(){
        this.prop = this.prop + 1;
    }

    public RefectObject(String prop1, String prop2, Integer prop) {
        this.prop1 = prop1;
        this.prop2 = prop2;
        this.prop = prop;
    }
}
