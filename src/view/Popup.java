package view;

import java.util.ArrayList;
import java.util.List;

import com.javahelps.jpa.GameRecord;
import com.javahelps.jpa.GameRecordDataBaseManager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.*;

public class Popup {
	
//public static TableView table = new TableView();  

public static void display(ViewLogic vl)
{
	TableView table = new TableView();  
Stage popupwindow=new Stage();

List<GameRecord> list = GameRecordDataBaseManager.readAll(vl.currentLevelName);

// Now add observability by wrapping it with ObservableList.
ObservableList<GameRecord> data = FXCollections.observableList(list);



table.setEditable(false);

TableColumn user_name = new TableColumn("User Name");
user_name.setMinWidth(100);
user_name.setCellValueFactory(
        new PropertyValueFactory<GameRecord, String>("userName"));

TableColumn level_name = new TableColumn("Level");
level_name.setMinWidth(100);
level_name.setCellValueFactory(
        new PropertyValueFactory<GameRecord, String>("levelName"));

TableColumn steps_number = new TableColumn("steps");
steps_number.setMinWidth(200);
steps_number.setCellValueFactory(
        new PropertyValueFactory<GameRecord, String>("steps"));

TableColumn timer = new TableColumn("Timer");
timer.setMinWidth(200);
timer.setCellValueFactory(
        new PropertyValueFactory<GameRecord, String>("timer"));

table.setItems(data);
table.getColumns().addAll(user_name, level_name, steps_number,timer);


table.setRowFactory( tv -> {
    TableRow<GameRecord> row = new TableRow<>();
    row.setOnMouseClicked(event -> {
        if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
            GameRecord rowData = row.getItem();
            Popup.displayUserData(rowData.getUserName());

        }
    });
    return row ;
});

popupwindow.initModality(Modality.APPLICATION_MODAL);
popupwindow.setTitle("This is a pop up window" + vl.msgTmp);



final TextField name = new TextField();
name.setPromptText("Search...");
name.setPrefColumnCount(10);
     
Button button1= new Button("Submit");
     
     
button1.setOnAction(e -> {

	List<GameRecord> list2 = GameRecordDataBaseManager.readAllByToken(name.getText());
    data.clear();
	// Now add observability by wrapping it with ObservableList.
	data.addAll(list2);
table.setItems(data);

});
     
HBox hb = new HBox();
hb.getChildren().addAll(name, button1);
hb.setSpacing(10);     

//VBox layout= new VBox(10);
     
      
//layout.getChildren().addAll(label1, button1,table);
      
hb.setAlignment(Pos.CENTER);



      /*
Label label1= new Label("Pop up window now displayed");
      
     
Button button1= new Button("Close this pop up window");
     
     
button1.setOnAction(e -> popupwindow.close());
     
*/     

VBox layout= new VBox(10);
     
      
layout.getChildren().addAll(hb, button1,table);
      
layout.setAlignment(Pos.CENTER);
      
Scene scene1= new Scene(layout, 400, 400);
      
popupwindow.setScene(scene1);
      
popupwindow.showAndWait();
       
}
 public static void displayUserData(String userName) {
	 TableView table = new TableView();  
	 Stage popupwindow=new Stage();

	 List<GameRecord> list = GameRecordDataBaseManager.readAllByUserName(userName);

	 // Now add observability by wrapping it with ObservableList.
	 ObservableList<GameRecord> data = FXCollections.observableList(list);



	 table.setEditable(false);

	 TableColumn user_name = new TableColumn("User Name");
	 user_name.setMinWidth(100);
	 user_name.setCellValueFactory(
	         new PropertyValueFactory<GameRecord, String>("userName"));

	 TableColumn level_name = new TableColumn("Level");
	 level_name.setMinWidth(100);
	 level_name.setCellValueFactory(
	         new PropertyValueFactory<GameRecord, String>("levelName"));

	 TableColumn steps_number = new TableColumn("steps");
	 steps_number.setMinWidth(200);
	 steps_number.setCellValueFactory(
	         new PropertyValueFactory<GameRecord, String>("steps"));

	 TableColumn timer = new TableColumn("Timer");
	 timer.setMinWidth(200);
	 timer.setCellValueFactory(
	         new PropertyValueFactory<GameRecord, String>("timer"));

	 table.setItems(data);
	 table.getColumns().addAll(user_name, level_name, steps_number,timer);


/*	 table.setRowFactory( tv -> {
	     TableRow<GameRecord> row = new TableRow<>();
	     row.setOnMouseClicked(event -> {
	         if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
	             GameRecord rowData = row.getItem();
	             Popup.displayUserData(rowData.getUserName());

	         }
	     });
	     return row ;
	 });*/

	 popupwindow.initModality(Modality.APPLICATION_MODAL);
	 popupwindow.setTitle("User " + userName);
	       
	       
	 Label label1= new Label("Pop up window now displayed");
	       
	      
	 Button button1= new Button("Close this pop up window");
	      
	      
	 button1.setOnAction(e -> popupwindow.close());
	      
	      

	 VBox layout= new VBox(10);
	      
	       
	 layout.getChildren().addAll(label1, button1,table);
	       
	 layout.setAlignment(Pos.CENTER);
	       
	 Scene scene1= new Scene(layout, 400, 400);
	       
	 popupwindow.setScene(scene1);
	       
	 popupwindow.showAndWait();
	  	

} 


public static void DisplayUserDetailsPopUp(int steps, String levelName, double timer){

//GameRecordDataBaseManager.create(GameRecord., currentLevelName, steps, (double)((timerEnd – timerStart)/1000))
	  
	Stage popupwindow=new Stage();

	
	popupwindow.initModality(Modality.APPLICATION_MODAL);
	popupwindow.setTitle("User Details Submission");
	      
	      
	
	
	Label label1= new Label("Please Enter Your Name:");
	
	final TextField name = new TextField();
	name.setPromptText("Enter your first name.");
	name.setPrefColumnCount(10);
	     
	Button button1= new Button("Submit");
	     
	     
	button1.setOnAction(e -> {
		GameRecordDataBaseManager.create(name.getText(), levelName, steps, timer);
		popupwindow.close();});
	     
	HBox hb = new HBox();
	hb.getChildren().addAll(label1, name, button1);
	hb.setSpacing(10);     

	//VBox layout= new VBox(10);
	     
	      
	//layout.getChildren().addAll(label1, button1,table);
	      
	hb.setAlignment(Pos.CENTER);
	      
	Scene scene1= new Scene(hb, 400, 200);
	      
	popupwindow.setScene(scene1);
	      
	popupwindow.showAndWait();
	
}
}