package Reflection_06.Beans;

public class NumberClassTo {
    Number value;
    String value2;

    public NumberClassTo(Number value, String value2) {
        this.value = value;
        this.value2 = value2;
    }

    public Number getValue() {
        return value;

    }

    public void setValue(Number value) {
        this.value = value;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }
}
