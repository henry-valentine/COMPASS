package slra.gui;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import slra.util.ResourceLoader;

public class Help {

	public Help() {
		//Create Label and load help text //
		Label helpLabel = new Label();
		String helpText = ResourceLoader.loadText("res/help.txt");
		Background darkGreyBr = new Background(new BackgroundFill(Color.DARKGREY, null, null));
		
		helpLabel.setText(helpText);
		helpLabel.setWrapText(true);
		helpLabel.setPrefWidth(381);
		helpLabel.setBackground(darkGreyBr);
		
		// Create Help Box and Scroll Bar //-
		VBox root = new VBox();
		Scene helpScene = new Scene(root, 400, 200);
		ScrollPane sp = new ScrollPane();
		
		sp.setBackground(darkGreyBr);
		sp.setContent(helpLabel);
		
		sp.setHbarPolicy(ScrollBarPolicy.NEVER);
		sp.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		
		sp.setPrefHeight(400);
		
		root.getChildren().add(sp);
		root.setBackground(darkGreyBr);
		
		//Create new Scene and Stage and Display Help Information
		Stage helpStage = new Stage();
		helpStage.setScene(helpScene);
		helpStage.sizeToScene();
		helpStage.setTitle("Help");
		helpStage.setResizable(false);
		helpStage.getIcons().add(new Image("file:res/images/SatLogo.png"));
		helpStage.show();
	}
}
