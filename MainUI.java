import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class MainUI extends Application{

	private ArrayList<Integer> numbers=new ArrayList<>();
	@Override
	public void start(Stage stage) throws Exception {
		VBox tp =new VBox();
		HBox titleVBox=new HBox();
		Label TITLE=new Label("COMBINERX");
		TITLE.setTextFill(Color.WHITE);
		TITLE.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 20));
		titleVBox.setPadding(new Insets(10));
		titleVBox.setAlignment(Pos.TOP_CENTER);
		titleVBox.setStyle("-fx-background-insets: -10;-fx-background-color:#007bcd");
		
		titleVBox.getChildren().add(TITLE);
		tp.getChildren().add(titleVBox);
		CheckBox Double=new CheckBox("DOUBLE");
		CheckBox Triple=new CheckBox("TRIPLE");
		CheckBox Multiple=new CheckBox("MULTIPLE");
		Double.setWrapText(true);
		Double.setFont(Font.font("Arial", FontWeight.BOLD, 12));
		Double.setTextFill(Color.WHITE);

		Triple.setWrapText(true);
		Triple.setFont(Font.font("Arial", FontWeight.BOLD, 12));
		Triple.setTextFill(Color.WHITE);
		
		Multiple.setWrapText(true);
		Multiple.setFont(Font.font("Arial", FontWeight.BOLD, 12));
		Multiple.setTextFill(Color.WHITE);
		
		VBox filters=new VBox();
		filters.setSpacing(12);
		filters.setAlignment(Pos.CENTER_LEFT);
		filters.getChildren().addAll(Double,Triple,Multiple);
		filters.setStyle("-fx-background-color:darkslategray");
		
		HBox Menu=new HBox();
		VBox numbersLayout=new VBox();
		HBox checkboxesHbox=new HBox();
		HBox numbersH=new HBox();
		ArrayList<CheckBox>boxes=new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			CheckBox c=new CheckBox(i+"");
			boxes.add(c);
			c.setWrapText(true);
			c.setFont(Font.font("Arial", FontWeight.BOLD, 12));
			c.setTextFill(Color.DARKSLATEGRAY);
			Label l=new Label(i+"");
			l.setWrapText(true);
			l.setFont(Font.font("Arial", FontWeight.BOLD, 18));
			l.setTextFill(Color.WHITE);
			l.setPadding(new Insets(12));
			l.setAlignment(Pos.TOP_RIGHT);
			l.setContentDisplay(ContentDisplay.LEFT);
			numbersH.getChildren().add(l);
			checkboxesHbox.getChildren().add(c);
			c.setOnMouseClicked(e->{
				System.out.println(c.isSelected());
				String s=c.getText();
				int n=Integer.parseInt(s);
				
				if(c.isSelected()) {
					numbers.add(Integer.valueOf(n));					
				}
				else
					if(numbers.contains(n)) {
						numbers.remove(Integer.valueOf(n));
					}
				System.out.println(numbers.toString());
			});
		}
		
		checkboxesHbox.setSpacing(10);
		checkboxesHbox.setAlignment(Pos.TOP_CENTER);
		numbersH.setSpacing(3);
		
		numbersH.setAlignment(Pos.TOP_CENTER);
		
		numbersLayout.setStyle("-fx-background-color:darkslategray");
		
		numbersLayout.getChildren().add(numbersH);
		numbersLayout.getChildren().add(checkboxesHbox);
		
		numbersLayout.setPadding(new Insets(10));
		VBox buttonLayout=new VBox();
		Button combine=new Button("COMBINE");
		combine.setAlignment(Pos.CENTER);
		final String IDLE_BUTTON_STYLE = "-fx-background-color:white; -fx-border-radius: 10 10 10 10;-fx-background-radius: 50 50 50 50;-fx-background-color: white;";
		final String HOVERED_BUTTON_STYLE = "-fx-background-color:white; -fx-border-radius: 10 10 10 10;-fx-background-radius: 50 50 50 50;-fx-background-color: -fx-shadow-highlight-color, -fx-outer-border, -fx-inner-border, -fx-body-color;";

		combine.setFont(Font.font("Arial",FontWeight.SEMI_BOLD, 13));
		combine.setPrefWidth(100);
		combine.setStyle(IDLE_BUTTON_STYLE);
		combine.setOnMouseEntered(e -> combine.setStyle(HOVERED_BUTTON_STYLE));
		combine.setOnMouseExited(e -> combine.setStyle(IDLE_BUTTON_STYLE));
		buttonLayout.getChildren().add(combine);
		buttonLayout.setAlignment(Pos.CENTER);
		buttonLayout.setStyle("-fx-background-color:darkslategray");
		buttonLayout.setPadding(new Insets(5));
		Menu.getChildren().addAll(filters,numbersLayout,buttonLayout);

		tp.getChildren().add(Menu);
		
		HBox picksLABELS=new HBox();
		Label pick1lbl=new Label("Pick 2");
		Label pick2lbl=new Label("Pick 3");
		Label pick3lbl=new Label("Pick 4");
		
		pick1lbl.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		pick1lbl.setTextFill(Color.WHITE);
		pick2lbl.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		pick2lbl.setTextFill(Color.WHITE);

		pick3lbl.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		pick3lbl.setTextFill(Color.WHITE);
		picksLABELS.getChildren().add(pick1lbl);
		picksLABELS.getChildren().add(pick2lbl);
		picksLABELS.getChildren().add(pick3lbl);
	picksLABELS.setSpacing(150);
	picksLABELS.setAlignment(Pos.CENTER);
		tp.getChildren().add(picksLABELS);
		HBox picks=new HBox();
		HBox picksSize=new HBox();
		
		TextArea textAreap1=new TextArea();
		textAreap1.setScaleShape(true);
		textAreap1.setWrapText(true);
		picks.getChildren().add(textAreap1);
		TextArea textAreap2=new TextArea();
		textAreap2.setScaleShape(true);
		textAreap2.setWrapText(true);
		picks.getChildren().add(textAreap2);
		TextArea textAreap3=new TextArea();
		textAreap3.setScaleShape(true);
		textAreap3.setWrapText(true);
		
		textAreap1.setPrefHeight(420);
		textAreap2.setPrefHeight(420);
		textAreap3.setPrefHeight(420);
		
		picks.getChildren().add(textAreap3);
		picks.setSpacing(10);
		tp.getChildren().add(picks);

		
		Label textAreap1L=new Label();
		textAreap1L.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 20));
		picksSize.getChildren().add(textAreap1L);
		Label textAreap2L=new Label();
		picksSize.getChildren().add(textAreap2L);
		Label textAreap3L=new Label();
		
textAreap1L.setTextFill(Color.WHITE);
textAreap2L.setTextFill(Color.WHITE);

textAreap3L.setTextFill(Color.WHITE);

textAreap2L.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 20));
		textAreap3L.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 20));
		
		picksSize.getChildren().add(textAreap3L);
		picksSize.setSpacing(20);
		picksSize.setAlignment(Pos.CENTER);
		tp.getChildren().add(picksSize);

		combine.setOnAction(e->{
			int[] numberx=new int[numbers.size()];
			for (int i = 0; i < numberx.length; i++) {
				numberx[i]=numbers.get(i);
			}
			String s2="";
			String s3="";
			String s4="";
			if(!Double.isSelected()&&!Triple.isSelected()&&!Multiple.isSelected()) {
				s2=GetAllPermutations.GET(2,numberx,1);
				s3=GetAllPermutations.GET(3,numberx,1);
			
				s4=GetAllPermutations.GET(4,numberx,1);
			
			}
			else if(Double.isSelected()) {
				s2=GetAllPermutations.GET(2,numberx,2);
				s3=GetAllPermutations.GET(3,numberx,2);
				s4=GetAllPermutations.GET(4,numberx,2);
				if(Triple.isSelected()) {
					s2=GetAllPermutations.GET(2,numberx,2);
					s3=GetAllPermutations.GET(3,numberx,3);
					s4=GetAllPermutations.GET(4,numberx,3);
				}
			
			}
			else if(Triple.isSelected()) {
				s2=GetAllPermutations.GET(2,numberx,1);
				s3=GetAllPermutations.GET(3,numberx,3);
				s4=GetAllPermutations.GET(4,numberx,3);
				if(Double.isSelected()) {
					s2=GetAllPermutations.GET(2,numberx,2);
					s3=GetAllPermutations.GET(3,numberx,3);
					s4=GetAllPermutations.GET(4,numberx,3);
				}
			
			}
			else if(Multiple.isSelected()) {
				s2=GetAllPermutations.GET(2,numberx,2);
				s3=GetAllPermutations.GET(3,numberx,3);
				s4=GetAllPermutations.GET(4,numberx,numberx.length);
			}
			
			
			
			textAreap1.setText(s2);
			textAreap2.setText(s3);
			textAreap3.setText(s4);
			textAreap1L.setText(s2.split("\n").length+" combinations.");
			textAreap2L.setText(s3.split("\n").length+" combinations.");
			textAreap3L.setText(s4.split("\n").length+" combinations.");

			for (CheckBox checkBox : boxes) {
				checkBox.setSelected(false);
			}
			numbers=new ArrayList<>();
			Double.setSelected(false);
			Triple.setSelected(false);
			Multiple.setSelected(false);
			
		});
		tp.setPadding(new Insets(10));
		tp.setSpacing(10);
		Scene scene =new Scene(tp,600,600);
		stage.setScene(scene);
		tp.setStyle("-fx-background-color:black;");
		stage.setResizable(false);
		stage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}

}

