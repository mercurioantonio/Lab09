
package it.polito.tdp.borders;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.borders.model.Country;
import it.polito.tdp.borders.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Model model;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    
    @FXML
    private ComboBox<Country> cmbStati;

    @FXML // fx:id="txtAnno"
    private TextField txtAnno; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML
    void doCalcolaConfini(ActionEvent event) {
    	txtResult.clear();
    	try {
    		int anno = Integer.parseInt(txtAnno.getText());
    		if(anno<1816 || anno>2016) {
    			txtResult.appendText("Devi inserire un anno compreso tra 1816 e 2016");
    		}
    		else {
    			txtResult.appendText(model.creaGrafo(anno));
    		}
    	}
    	catch (NumberFormatException ne) {
    		txtResult.setText("Devi inserire un numero");
    		return;
    	}

    	cmbStati.getItems().addAll(model.getNodi());
    }
    
    @FXML
    void doStati(ActionEvent event) {
    	txtResult.clear();
          Country c = cmbStati.getValue();
          
          for(Country cc : model.trovaRaggiungibili(c)) {
        	txtResult.appendText(cc + "\n");  
          }
        	  
          
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtAnno != null : "fx:id=\"txtAnno\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbStati != null : "fx:id=\"cmbStati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model = model;
    }
}
