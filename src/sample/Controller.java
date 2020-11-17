package sample;

import CurrencyConverter.CurrencyConverter;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField euroField;
    @FXML
    private TextField yenField;

    @FXML
    public void doConversion(){

        CurrencyConverter converter = new CurrencyConverter();

        String euroFieldText = euroField.getText();

        //ändert mögliche Beistriche in Punkte für Rechnung
        if(euroFieldText.contains(",")){
            StringBuilder sb = new StringBuilder(euroFieldText);
            sb.setCharAt(euroFieldText.indexOf(','), '.');

            euroFieldText = sb.toString();
        }

        double valueEuro = Double.parseDouble(euroFieldText);
        int valueYen = converter.euroToYen(valueEuro);

        //Formatierung bei Yen
        String yenFieldText = "¥ " + String.format("%,d", valueYen);

        //Formatierugn bei Euro
        euroFieldText = "€ " + String.format("%,.2f",valueEuro);

        yenField.setText(yenFieldText);
        euroField.setText(euroFieldText);
    }

}
