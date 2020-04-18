/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citizenapp.Module;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author arthris
 */
public class RoundButton {
		private final double moneyLeft;
		private final String moneyLeftS;
		private Text balanceText = new Text();
		private Button button = new Button();
		private VBox vbox = new VBox(20);
		
		private final String css = this.getClass().getResource("style/RoundButton.css").toExternalForm();
		private final String ROUND_BUTTON = "round-button";
		
		public RoundButton(double moneyLeft) {
			this.moneyLeft = moneyLeft;
			System.out.println("From .java" + moneyLeft);
			this.moneyLeftS = String.format("%.2f", this.moneyLeft);
		
			this.button.getStyleClass().add(ROUND_BUTTON);
			this.button.getStylesheets().add(css);
		}

		public Button active() {
			this.balanceText.setText("Balance " + this.moneyLeftS);
			this.balanceText.setFont(Font.font("FreesiaUPC", 25));
			this.balanceText.setFill(Color.WHITE);
			this.balanceText.setWrappingWidth(100);
			this.balanceText.setTextAlignment(TextAlignment.CENTER);
			this.balanceText.setLineSpacing(30);
			this.vbox.setAlignment(Pos.CENTER);
			vbox.getChildren().addAll(this.balanceText);
			this.button.setGraphic(this.vbox);
			return this.button;
		} 
		public Button getBtn() {
			return this.button;
		}

}
