

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

public class NumberField extends TextField{
	
	public NumberField(String text){
		NumberField test= this;
		this.setPromptText(text);
		this.textProperty().addListener(new ChangeListener<String>() {
			   @Override
			   public void changed(ObservableValue<? extends String> observable, String oldValue, 
			       String newValue) {
			       if (!newValue.matches("\\d*")) {
			    	   test.setText(newValue.replaceAll("[^\\d]", ""));
			       }
			   }
		});
	
	}
}
