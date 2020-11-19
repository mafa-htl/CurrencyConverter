package sample;

import CurrencyConverter.CurrencyConverter;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField euroField;
    @FXML
    private TextField foreignField;
    @FXML
    private ChoiceBox currencyChoice;

    private CurrencyConverter converter = new CurrencyConverter();

    @FXML
    public void doConversion(){

        String chosenCurrency = currencyChoice.getValue().toString();

        String euroFieldText = euroField.getText();

        //ändert mögliche Beistriche in Punkte für Rechnung
        if(euroFieldText.contains(",")){
            StringBuilder sb = new StringBuilder(euroFieldText);
            sb.setCharAt(euroFieldText.indexOf(','), '.');

            euroFieldText = sb.toString();
        }

        double valueEuro = Double.parseDouble(euroFieldText);
        double valueForeign = converter.euroToCurrency(valueEuro, chosenCurrency);

        String foreignFieldText = "";

        //Formatierung für Währung
        if(chosenCurrency.equals("Yen")) {  //Yen hat keine Kommastellen
            int valueYen = (int)valueForeign;
            foreignFieldText = "¥ " + String.format("%,d", valueYen);
        }
        else if(chosenCurrency.equals("USD"))
            foreignFieldText = "$ " + String.format("%,.2f",valueForeign);
        else if(chosenCurrency.equals("GBP"))
            foreignFieldText = "£ " + String.format("%,.2f",valueForeign);
        else if(chosenCurrency.equals("Yuan"))  //Yuan hat nur eine Kommastelle
            foreignFieldText = "¥ " + String.format("%,.1f",valueForeign);

        //Formatierugn bei Euro
        euroFieldText = "€ " + String.format("%,.2f",valueEuro);

        foreignField.setText(foreignFieldText);
        euroField.setText(euroFieldText);
    }

    @FXML
    public void clrEuroField(){
        euroField.setText("");
    }

    @FXML
    public void setRatePrompt(){
        foreignField.setText("");

        double rate = converter.getRate(currencyChoice.getValue().toString());
        foreignField.setPromptText("" + rate);
    }

}
