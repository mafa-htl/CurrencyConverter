package CurrencyConverter;

import Currency.Currency;

public class CurrencyConverter {

    private Currency yen = new Currency("Yen", 124);
    private Currency usd = new Currency("USD", 1.18);
    private Currency gbp = new Currency("GBP", 0.9);
    private Currency yuan = new Currency("Yuan", 7.8);

    public double euroToCurrency(double euro, String currency){

        double value = 0;

        if(currency.equals(yen.getSign()))
            value = euro * yen.getValue();
        else if(currency.equals(usd.getSign()))
            value = euro * usd.getValue();
        else if(currency.equals(gbp.getSign()))
            value = euro * gbp.getValue();
        else if(currency.equals(yuan.getSign()))
            value = euro * yuan.getValue();

        return value;
    }

    public double getRate(String currency){
        if(currency.equals(yen.getSign()))
            return yen.getValue();
        else if(currency.equals(usd.getSign()))
            return usd.getValue();
        else if(currency.equals(gbp.getSign()))
            return gbp.getValue();
        else if(currency.equals(yuan.getSign()))
            return yuan.getValue();

        return 0;
    }

}
