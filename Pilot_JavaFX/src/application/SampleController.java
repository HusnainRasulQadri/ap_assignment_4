package application;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;

import javafx.fxml.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.input.DragEvent;
import javafx.stage.StageStyle;
import javafx.collections.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class SampleController {
    @FXML private Pane paneTitle;
    @FXML private ImageView minimizeButton, closeButton;
    @FXML private Label lblResult;
    @FXML private DatePicker dob;
    @FXML private DatePicker today;
    @FXML private Label years, months, days, weeks, hours, minutes, nextYears, nextMonths, nextDays;
    @FXML private Label yearMonths, yearDays, birthdayDay;
    @FXML private Label orignalPrice, discountPercentage, finalPrice, saving;
    @FXML private Label weight,height,bmiCalculated,level;
    @FXML private ChoiceBox currency1,currency2,currency3;
    @FXML private Label value1,value2,value3;
    @FXML private Label investmentAmount, interestPercentage, durationYears, durationMonths;
    @FXML private Label totalValue, principleBalance, interestValue, durationResult;
    
    
    private Stage stage;
    private double x, y;
    private double num1 = 0;
    private boolean[] ageTurn;
    private boolean[] discountTurn;
    private boolean[] bmiTurn;
    private boolean[] currencyTurn;
    private boolean[] investmentTurn;
    private String operator = "+";
    private String[] previousCurrency;
    ObservableList<String> currencies = FXCollections.observableArrayList("USD","PKR","GBP");
    private static final DecimalFormat df = new DecimalFormat("0.00");


    public void init(Stage stage) {
    	this.stage = stage;
    	ageTurn = new boolean[2];
    	discountTurn = new boolean[2];
    	bmiTurn = new boolean[2];
    	currencyTurn = new boolean[3];
    	investmentTurn = new boolean[4];
    	previousCurrency = new String[3];
    	previousCurrency[0] = "USD";
    	previousCurrency[1] = "PKR";
    	previousCurrency[2] = "GBP";
    	ageTurn[0] = false;
    	ageTurn[1] = false;
    	discountTurn[0] = true;
    	discountTurn[1] = false;
    	bmiTurn[0] = true;
    	bmiTurn[1] = false;
    	currencyTurn[0] = true;
    	currencyTurn[1] = false;
    	currencyTurn[2] = false;
    	investmentTurn[0] = true;
    	investmentTurn[1] = false;
    	investmentTurn[2] = false;
    	investmentTurn[3] = false;
    	
        paneTitle.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        });
        paneTitle.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX()-x);
            stage.setY(mouseEvent.getScreenY()-y);
        });

        closeButton.setOnMouseClicked(mouseEvent -> stage.close());
        minimizeButton.setOnMouseClicked(mouseEvent -> stage.setIconified(true));
    }

    public void currencyIntialiser() {
        currency1.setValue("USD");
        currency1.setItems(currencies);
        currency2.setValue("PKR");
        currency2.setItems(currencies);
        currency3.setValue("GBP");
        currency3.setItems(currencies);
    }
    
    @FXML
    void onNumberClicked(MouseEvent event) {
        int value = Integer.parseInt(((Pane)event.getSource()).getId().replace("button",""));
        lblResult.setText(Double.parseDouble(lblResult.getText())==0?String.valueOf((double)value):String.valueOf(Double.parseDouble(lblResult.getText())*10+value));
    }
    
    @FXML
    void onViewClicked(MouseEvent event) throws Exception {
        String symbol = ((Pane)event.getSource()).getId().replace("view","");
        FXMLLoader loader;
        Scene scene;
        switch (symbol) {
        case "1":
        	loader = new FXMLLoader(getClass().getResource("view1.fxml"));
        	scene = new Scene(loader.load());
			scene.setFill(Color.TRANSPARENT);
            stage.setScene(scene);
	        stage.setResizable(false);
	        stage.setTitle("Calculator");
	        stage.getIcons().add(new Image(getClass().getResourceAsStream("calculator.png")));
	        ((SampleController)loader.getController()).init(stage);
			break;
        case "2":
        	loader = new FXMLLoader(getClass().getResource("view2.fxml"));
        	scene = new Scene(loader.load());
        	scene.setFill(Color.TRANSPARENT);
            stage.setScene(scene);
	        stage.setResizable(false);
	        stage.setTitle("Calculator");
	        stage.getIcons().add(new Image(getClass().getResourceAsStream("calculator.png")));
	        ((SampleController)loader.getController()).init(stage);        	
	        break;
	        
        case "3":
        	loader = new FXMLLoader(getClass().getResource("view3.fxml"));
        	scene = new Scene(loader.load());
        	scene.setFill(Color.TRANSPARENT);
            stage.setScene(scene);
	        stage.setResizable(false);
	        stage.setTitle("Calculator");
	        stage.getIcons().add(new Image(getClass().getResourceAsStream("calculator.png")));
	        ((SampleController)loader.getController()).init(stage);    
	        break;
        }
    }
    
    @FXML
    void onMoneyChoice(MouseEvent event) throws IOException {
    	 String symbol = ((Pane)event.getSource()).getId();//.replace("view","");
         FXMLLoader loader;
         Scene scene;
    	 switch (symbol) {
         case "currencyConvertor":
         	loader = new FXMLLoader(getClass().getResource("currencyConvertor.fxml"));
            scene = new Scene(loader.load());
            scene.setFill(Color.TRANSPARENT);
            stage.setScene(scene);
	        stage.setResizable(false);
	        stage.setTitle("Calculator");
	        stage.getIcons().add(new Image(getClass().getResourceAsStream("calculator.png")));
	        ((SampleController)loader.getController()).init(stage);
	        ((SampleController)loader.getController()).currencyIntialiser(); 			
	        break;
         case "investment":
         	loader = new FXMLLoader(getClass().getResource("investment.fxml"));
            scene = new Scene(loader.load());
            scene.setFill(Color.TRANSPARENT);
            stage.setScene(scene);
	        stage.setResizable(false);
	        stage.setTitle("Calculator");
	        stage.getIcons().add(new Image(getClass().getResourceAsStream("calculator.png")));
	        ((SampleController)loader.getController()).init(stage);
	        break;
         }
    }
    
    @FXML
    void onWidgetChoice(MouseEvent event) throws IOException {
    	 String symbol = ((Pane)event.getSource()).getId();
         FXMLLoader loader;
         Scene scene;
    	 switch (symbol) {
         case "bmi":
         	loader = new FXMLLoader(getClass().getResource("bmi.fxml"));
            scene = new Scene(loader.load());
            scene.setFill(Color.TRANSPARENT);
            stage.setScene(scene);
	        stage.setResizable(false);
	        stage.setTitle("Calculator");
	        stage.getIcons().add(new Image(getClass().getResourceAsStream("calculator.png")));
	        ((SampleController)loader.getController()).init(stage); 			
	        break;
         case "discount":
         	loader = new FXMLLoader(getClass().getResource("discount.fxml"));
            scene = new Scene(loader.load());
            scene.setFill(Color.TRANSPARENT);
            stage.setScene(scene);
	        stage.setResizable(false);
	        stage.setTitle("Calculator");
	        stage.getIcons().add(new Image(getClass().getResourceAsStream("calculator.png")));
	        ((SampleController)loader.getController()).init(stage);
	        break;
         case "age":
          	loader = new FXMLLoader(getClass().getResource("age.fxml"));
             scene = new Scene(loader.load());
             scene.setFill(Color.TRANSPARENT);
             stage.setScene(scene);
 	        stage.setResizable(false);
 	        stage.setTitle("Calculator");
 	        stage.getIcons().add(new Image(getClass().getResourceAsStream("calculator.png")));
 	        ((SampleController)loader.getController()).init(stage);
 	        break;
	        
         }
    }

    @FXML  
    void onSymbolClicked(MouseEvent event) {
        String symbol = ((Pane)event.getSource()).getId().replace("button","");
        if(symbol.equals("Equals")) {
            double num2 = Double.parseDouble(lblResult.getText());
            switch (operator) {
                case "+" -> lblResult.setText((num1+num2) + "");
                case "-" -> lblResult.setText((num1-num2) + "");
                case "*" -> lblResult.setText((num1*num2) + "");
                case "/" -> lblResult.setText((num1/num2) + "");
                case "%" -> lblResult.setText((num1%num2) + "");
            }
            operator = ".";
            num1=-1;
        }
        else if(symbol.equals("Clear")) {
            lblResult.setText(String.valueOf(0.0));
            operator = ".";
            num1=-1;
        }
        else {
            switch (symbol) {
                case "Plus" -> operator = "+";
                case "Minus" -> operator = "-";
                case "Multiply" -> operator = "*";
                case "Divide" -> operator = "/";
                case "Mod" -> operator = "%";
            }
            if (num1!=-1) {
            	switch (operator) {
                case "+" -> num1+=Double.parseDouble(lblResult.getText());
                case "-" -> num1-=Double.parseDouble(lblResult.getText());
                case "*" -> num1*=Double.parseDouble(lblResult.getText());
                case "/" ->	num1/=Double.parseDouble(lblResult.getText());
                case "%" -> num1%=Double.parseDouble(lblResult.getText());
            	}
            	lblResult.setText(String.valueOf(0.0));
            }
            else {
            	num1 = Double.parseDouble(lblResult.getText());
            	lblResult.setText(String.valueOf(0.0));
            }
        }
    }

    @FXML
    void onDateClicked(ActionEvent event) throws ParseException {
    	String symbol = ((DatePicker)event.getSource()).getId();
    	switch (symbol) {
    	case "dob":
    		LocalDate dobDate = dob.getValue();
            System.out.println(dobDate.toString());
            ageTurn[0] = true;
    		break;
    	case "today":
    		LocalDate todayDate = today.getValue();
            System.out.println(todayDate.toString());
    		ageTurn[1] = true;
            break;
    	}
    	
    	
    	if (ageTurn[0] && ageTurn[1]) {
    		Age age = new Age(dob.getValue().toString(),today.getValue().toString());
    		
    		age.calculate();
    		
    		years.setText(age.getYears());    		
    		months.setText(age.getMonths());
    		days.setText(age.getDays());
    		weeks.setText(age.getWeeks());
    		hours.setText(age.getHours());
    		minutes.setText(age.getMinutes());
    		nextYears.setText(age.getYears());
    		nextMonths.setText(age.getNextMonth());
    		nextDays.setText(age.getNextDays());
    		yearMonths.setText(age.getYearMonths());
    		yearDays.setText(age.getYearDays());
    		birthdayDay.setText(age.getBirthday());
    		
    		ageTurn[0] = false;
        	ageTurn[1] = false;
    	}
    	
    }

    @FXML
    void onNumberClickedDiscount(MouseEvent event) {
        int value = Integer.parseInt(((Pane)event.getSource()).getId().replace("button",""));
        if (value == 10) {
        	double orignal_price =  Double.parseDouble(orignalPrice.getText());
        	double discount_percentage = Double.parseDouble(discountPercentage.getText());
        	double answer = orignal_price * ((100-discount_percentage)/100);
        	double saved = orignal_price-answer;
            System.out.println(answer);
        	finalPrice.setText(String.valueOf(answer));
        	saving.setText(String.valueOf(saved));
        }
        else if (value == 11) {
        	orignalPrice.setText("0.0");
        	discountPercentage.setText("0");
        	finalPrice.setText("0.0");
        	saving.setText("0");
        	discountTurn[0] = true;
        	discountTurn[1] = false;
        	return;
        }
        if (discountTurn[0]) {
            orignalPrice.setText(Double.parseDouble(orignalPrice.getText())==0?String.valueOf((double)value):String.valueOf(Double.parseDouble(orignalPrice.getText())*10+value));
        }
        else if (discountTurn[1]) {
        	discountPercentage.setText(Double.parseDouble(discountPercentage.getText())==0?String.valueOf((double)value):String.valueOf(Double.parseDouble(discountPercentage.getText())*10+value));
        }
    }
    
    @FXML
    void onDiscountChoice(MouseEvent event) {
        String symbol = ((Pane)event.getSource()).getId();
        switch (symbol) {
        case "orignalPane":
        	discountTurn[0] = true;
        	discountTurn[1] = false;
        	
        	break;
        case "discountPane":
        	discountTurn[1] = true;
        	discountTurn[0] = false;
        	break;
        }
    }
	
    @FXML
    void onNumberClickedBmi(MouseEvent event) {
        int value = Integer.parseInt(((Pane)event.getSource()).getId().replace("button",""));
        if (value == 10) {
        	double weightKg =  Double.parseDouble(weight.getText());
        	double heightCm = Double.parseDouble(height.getText());
        	double answer = (weightKg/heightCm/heightCm)*10000;
            bmiCalculated.setText(String.valueOf(df.format(answer)));
            if (answer < 18.5 && answer > 16.0) {
            	level.setText("Underweight");
            }
            else if (answer < 25.0 && answer > 18.5) {
            	level.setText("Normal");
            }
            else if (answer < 40 && answer > 25.0) {
            	level.setText("Overweight");
            }
            else {
            	level.setText("Out of Range");
            }
            return;
        }
        else if (value == 11) {
        	weight.setText("0");
        	height.setText("0");
        	level.setText("level");
        	bmiCalculated.setText("0");
        	bmiTurn[0] = true;
        	bmiTurn[1] = false;
        	return;
        }
        if (bmiTurn[0]) {
            weight.setText(Double.parseDouble(weight.getText())==0?String.valueOf((double)value):String.valueOf(Double.parseDouble(weight.getText())*10+value));
        }
        else if (bmiTurn[1]) {
        	height.setText(Double.parseDouble(height.getText())==0?String.valueOf((double)value):String.valueOf(Double.parseDouble(height.getText())*10+value));
        }
    }
    
    @FXML
    void onBmiChoice(MouseEvent event) {
        String symbol = ((Pane)event.getSource()).getId();
        switch (symbol) {
        case "weightPane":
        	bmiTurn[0] = true;
        	bmiTurn[1] = false;
        	
        	break;
        case "heightPane":
        	bmiTurn[1] = true;
        	bmiTurn[0] = false;
        	break;
        }
    }
	
    double getConvertedCurrency(String curr1,String curr2,double value) {
    	if (curr1 == "USD") {
    		if (curr2 == "USD") {
    			return value;
        	}
        	else if (curr2 == "PKR") {
        		return value*176;
        	}
        	else if(curr2 == "GBP") {
        		return value*0.76;
        	}
    	}
    	else if (curr1 == "PKR") {
    		if (curr2 == "USD") {
    			return value*0.0057;
        	}
        	else if (curr2 == "PKR") {
        		return value;
        	}
        	else if(curr2 == "GBP") {
        		return value*0.0043;
        	}
    	}
    	else if(curr1 == "GBP") {
    		if (curr2 == "USD") {
    			return value*1.32;
        	}
        	else if (curr2 == "PKR") {
        		return value*233.89;
        	}
        	else if(curr2 == "GBP") {
        		return value;
        	}
    	}
    	return 0;
    }
    
    @FXML
    void onNumberClickedCurrency(MouseEvent event) {
        int value = Integer.parseInt(((Pane)event.getSource()).getId().replace("button",""));
        if (value == 10) {
        	
        	if (previousCurrency[0] == currency1.getValue()) {
        		value2.setText(String.valueOf(getConvertedCurrency(previousCurrency[0],currency2.getValue().toString(),Double.parseDouble(value1.getText()))));
            	value3.setText(String.valueOf(getConvertedCurrency(previousCurrency[0],currency3.getValue().toString(),Double.parseDouble(value1.getText()))));
        	}
        	else if (previousCurrency[1] == currency2.getValue()) {
        		value1.setText(String.valueOf(getConvertedCurrency(previousCurrency[1],currency1.getValue().toString(),Double.parseDouble(value2.getText()))));
            	value3.setText(String.valueOf(getConvertedCurrency(previousCurrency[1],currency3.getValue().toString(),Double.parseDouble(value2.getText()))));
           
        	}
        	else if (previousCurrency[2] == currency3.getValue()) {
        		value1.setText(String.valueOf(getConvertedCurrency(previousCurrency[2],currency1.getValue().toString(),Double.parseDouble(value3.getText()))));
            	value2.setText(String.valueOf(getConvertedCurrency(previousCurrency[2],currency2.getValue().toString(),Double.parseDouble(value3.getText()))));
           
        	}
        	else {
        		value2.setText(String.valueOf(getConvertedCurrency(previousCurrency[1],currency2.getValue().toString(),Double.parseDouble(value2.getText()))));
            	value3.setText(String.valueOf(getConvertedCurrency(previousCurrency[2],currency3.getValue().toString(),Double.parseDouble(value3.getText()))));
            	value1.setText(String.valueOf(getConvertedCurrency(previousCurrency[0],currency1.getValue().toString(),Double.parseDouble(value1.getText()))));
        	}
        	previousCurrency[0] = currency1.getValue().toString();
        	previousCurrency[1] = currency2.getValue().toString();
        	previousCurrency[2] = currency3.getValue().toString();
        	return;
        }
        else if (value == 11) {
        	value1.setText("0");
        	value2.setText("0");
        	value3.setText("0");
        	currencyTurn[0] = true;
        	currencyTurn[1] = false;
        	currencyTurn[2] = false;
        	return;
        }
        if (currencyTurn[0]) {
        	value1.setText(Double.parseDouble(value1.getText())==0?String.valueOf((double)value):String.valueOf(Double.parseDouble(value1.getText())*10+value));
        	value2.setText(String.valueOf(getConvertedCurrency(currency1.getValue().toString(),currency2.getValue().toString(),Double.parseDouble(value1.getText()))));
        	value3.setText(String.valueOf(getConvertedCurrency(currency1.getValue().toString(),currency3.getValue().toString(),Double.parseDouble(value1.getText()))));
        	previousCurrency[0] = currency1.getValue().toString();
        	previousCurrency[1] = currency2.getValue().toString();
        	previousCurrency[2] = currency3.getValue().toString();
        }
        else if (currencyTurn[1]) {
        	value2.setText(Double.parseDouble(value2.getText())==0?String.valueOf((double)value):String.valueOf(Double.parseDouble(value2.getText())*10+value));
        	value1.setText(String.valueOf(getConvertedCurrency(currency2.getValue().toString(),currency1.getValue().toString(),Double.parseDouble(value2.getText()))));
        	value3.setText(String.valueOf(getConvertedCurrency(currency2.getValue().toString(),currency3.getValue().toString(),Double.parseDouble(value2.getText()))));
        	previousCurrency[0] = currency1.getValue().toString();
        	previousCurrency[1] = currency2.getValue().toString();
        	previousCurrency[2] = currency3.getValue().toString();
        }
        else if (currencyTurn[2]) {
        	value3.setText(Double.parseDouble(value3.getText())==0?String.valueOf((double)value):String.valueOf(Double.parseDouble(value3.getText())*10+value));
        	value1.setText(String.valueOf(getConvertedCurrency(currency3.getValue().toString(),currency1.getValue().toString(),Double.parseDouble(value3.getText()))));
        	value2.setText(String.valueOf(getConvertedCurrency(currency3.getValue().toString(),currency2.getValue().toString(),Double.parseDouble(value3.getText()))));
        	previousCurrency[0] = currency1.getValue().toString();
        	previousCurrency[1] = currency2.getValue().toString();
        	previousCurrency[2] = currency3.getValue().toString();
        }
    }
    
    @FXML
    void currencyChanged(MouseEvent event) {
        int value = Integer.parseInt(((ChoiceBox)event.getSource()).getId().replace("currency",""));
        System.out.println(value);
        if (value == 1) {
        	//value2.setText(String.valueOf(getConvertedCurrency(previousCurrency[1],currency2.getValue().toString(),Double.parseDouble(value2.getText()))));
        	//value3.setText(String.valueOf(getConvertedCurrency(previousCurrency[2],currency3.getValue().toString(),Double.parseDouble(value3.getText()))));
        	//value1.setText(String.valueOf(getConvertedCurrency(previousCurrency[0],currency1.getValue().toString(),Double.parseDouble(value1.getText()))));
        }
        else if (value == 2) {
        	//value2.setText(String.valueOf(getConvertedCurrency(previousCurrency[1],currency2.getValue().toString(),Double.parseDouble(value2.getText()))));
        	//value3.setText(String.valueOf(getConvertedCurrency(previousCurrency[2],currency3.getValue().toString(),Double.parseDouble(value3.getText()))));
        	//value1.setText(String.valueOf(getConvertedCurrency(previousCurrency[0],currency1.getValue().toString(),Double.parseDouble(value1.getText()))));
        }
        else if (value == 3) {
        	//value2.setText(String.valueOf(getConvertedCurrency(previousCurrency[1],currency2.getValue().toString(),Double.parseDouble(value2.getText()))));
        	//value3.setText(String.valueOf(getConvertedCurrency(previousCurrency[2],currency3.getValue().toString(),Double.parseDouble(value3.getText()))));
        	//value1.setText(String.valueOf(getConvertedCurrency(previousCurrency[0],currency1.getValue().toString(),Double.parseDouble(value1.getText()))));
        }
    }
    @FXML
    void onCurrencyChoice(MouseEvent event) {
        String symbol = ((Pane)event.getSource()).getId();
        switch (symbol) {
        case "currency1Pane":
        	currencyTurn[0] = true;
        	currencyTurn[1] = false;
        	currencyTurn[2] = false;
        	break;
        case "currency2Pane":
        	currencyTurn[1] = true;
        	currencyTurn[0] = false;
        	currencyTurn[2] = false;
        	break;
        case "currency3Pane":
        	currencyTurn[2] = true;
        	currencyTurn[0] = false;
        	currencyTurn[1] = false;
        	break;
        }
    }

    @FXML
    void onNumberClickedInvestment(MouseEvent event) throws IOException {
        int value = Integer.parseInt(((Pane)event.getSource()).getId().replace("button",""));
        if (value == 10) {
        	double initialAmount = Double.parseDouble(investmentAmount.getText());
        	double interestAmount = Double.parseDouble(interestPercentage.getText());
        	double yearsAmount = Double.parseDouble(durationYears.getText());
        	double monthsAmount = Double.parseDouble(durationMonths.getText());
        	yearsAmount+=(monthsAmount/12);
        	double finalResult = initialAmount*Math.pow((1+((interestAmount/100)/4)),((4*yearsAmount)));
        	String durationResult = "Years: "+String.valueOf(yearsAmount)+" Months: "+String.valueOf(monthsAmount); 
        	System.out.println(finalResult);
        	
        	FXMLLoader loader;
            Scene scene;
        	loader = new FXMLLoader(getClass().getResource("investmentResult.fxml"));
            scene = new Scene(loader.load());
            scene.setFill(Color.TRANSPARENT);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Calculator");
            stage.getIcons().add(new Image(getClass().getResourceAsStream("calculator.png")));
            ((SampleController)loader.getController()).init(stage);
            ((SampleController)loader.getController()).setResult(finalResult,initialAmount,finalResult-initialAmount, durationResult);         	
        	return;
        }
        else if (value == 11) {
        	investmentAmount.setText("0");
        	interestPercentage.setText("0");
        	durationYears.setText("0");
        	durationMonths.setText("0");
        	investmentTurn[0] = true;
        	investmentTurn[1] = false;
        	investmentTurn[2] = false;
        	investmentTurn[3] = false;
        	return;
        }
        
        if (investmentTurn[0]) {
        	investmentAmount.setText(Double.parseDouble(investmentAmount.getText())==0?String.valueOf((double)value):String.valueOf(Double.parseDouble(investmentAmount.getText())*10+value));
        }
        else if (investmentTurn[1]) {
        	interestPercentage.setText(Double.parseDouble(interestPercentage.getText())==0?String.valueOf((double)value):String.valueOf(Double.parseDouble(interestPercentage.getText())*10+value));
        }
        else if (investmentTurn[2]) {
        	durationYears.setText(Double.parseDouble(durationYears.getText())==0?String.valueOf((double)value):String.valueOf(Double.parseDouble(durationYears.getText())*10+value));
        }
        else if (investmentTurn[3]) {
        	durationMonths.setText(Double.parseDouble(durationMonths.getText())==0?String.valueOf((double)value):String.valueOf(Double.parseDouble(durationMonths.getText())*10+value));
        }
    }
    
    @FXML
    void onInvestmentChoice(MouseEvent event) {
        String symbol = ((Pane)event.getSource()).getId();
        switch (symbol) {
        case "investmentPane":
        	investmentTurn[0] = true;
        	investmentTurn[1] = false;
        	investmentTurn[2] = false;
        	investmentTurn[3] = false;
        	break;
        case "interestPane":
        	investmentTurn[1] = true;
        	investmentTurn[0] = false;
        	investmentTurn[2] = false;
        	investmentTurn[3] = false;

        	break;
        case "yearPane":
        	investmentTurn[2] = true;
        	investmentTurn[0] = false;
        	investmentTurn[1] = false;
        	investmentTurn[3] = false;
        	break;
        case "monthPane":
        	investmentTurn[3] = true;
        	investmentTurn[0] = false;
        	investmentTurn[1] = false;
        	investmentTurn[2] = false;
        	break;
        }
    }

    @FXML
    void onBack(MouseEvent event) throws IOException {
    	FXMLLoader loader;
        Scene scene;
    	loader = new FXMLLoader(getClass().getResource("investment.fxml"));
        scene = new Scene(loader.load());
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Calculator");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("calculator.png")));
        ((SampleController)loader.getController()).init(stage); 			
    }

    void setResult(double totalValue_t,double principleAmount_t,double totalInterest_t,String Duration) {
    	totalValue.setText(String.valueOf(df.format(totalValue_t)));
    	principleBalance.setText(String.valueOf(df.format(principleAmount_t)));
    	interestValue.setText(String.valueOf(df.format(totalInterest_t)));
    	durationResult.setText(Duration);
    }
}
