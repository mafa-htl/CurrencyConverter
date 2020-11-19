package Currency;

public class Currency {

    private String sign;
    private double value;

    public Currency(String sign, double value) {
        this.sign = sign;
        this.value = value;
    }

    public String getSign() {
        return sign;
    }

    public double getValue() {
        return value;
    }

}