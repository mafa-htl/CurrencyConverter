package CurrencyConverter;

public class CurrencyConverter {

    private int rate = 124;

    public int euroToYen(double euro){

        int value = (int)(euro * rate);

        return value;
    }

}
