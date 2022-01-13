package notepad;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Dialog;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.TitledPane;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class NotePad extends Application {

    public void start(Stage primaryStage) throws Exception {

        MenuBar bar = new MenuBar();
        TextArea area = new TextArea();

        Menu file = new Menu("File");

        MenuItem newitem = new MenuItem("New");
        newitem.setAccelerator(KeyCombination.keyCombination("Ctrl+n"));

        MenuItem openitem = new MenuItem("Open");
        openitem.setAccelerator(KeyCombination.keyCombination("Ctrl+o"));

FileChooser fileS = new FileChooser();  
        fileS.setTitle("Save Image");  
        //System.out.println(pic.getId());  
         

        MenuItem saveitem = new MenuItem("Save");
        saveitem.setAccelerator(KeyCombination.keyCombination("Ctrl+s"));

FileChooser fileC = new FileChooser();  
        fileC.setTitle("Open File");            

        SeparatorMenuItem separator1 = new SeparatorMenuItem();

        MenuItem exititem = new MenuItem("Exit");
        exititem.setAccelerator(KeyCombination.keyCombination("Ctrl+e"));

        Menu edit = new Menu("Edit");

        MenuItem undoitem = new MenuItem("Undo");
        undoitem.setAccelerator(KeyCombination.keyCombination("Ctrl+n"));

        SeparatorMenuItem separator2 = new SeparatorMenuItem();

        MenuItem cutitem = new MenuItem("Cut");
        cutitem.setAccelerator(KeyCombination.keyCombination("Ctrl+o"));

        MenuItem copyitem = new MenuItem("Copy");
        copyitem.setAccelerator(KeyCombination.keyCombination("Ctrl+s"));

        MenuItem pasteitem = new MenuItem("Paste");
        pasteitem.setAccelerator(KeyCombination.keyCombination("Ctrl+e"));

        MenuItem deleteitem = new MenuItem("Delete");
        deleteitem.setAccelerator(KeyCombination.keyCombination("Ctrl+e"));

        SeparatorMenuItem separator3 = new SeparatorMenuItem();

        MenuItem selectitem = new MenuItem("Select All");
        selectitem.setAccelerator(KeyCombination.keyCombination("Ctrl+e"));

        Menu help = new Menu("Help");
        MenuItem helpitem = new MenuItem("About Notepad");

        Dialog dialog = new Dialog();
        dialog.setTitle("Text Input Dialog");
        dialog.setContentText("Essraa Mohamed Hemdan");

        undoitem.setOnAction(e -> area.undo());
        cutitem.setOnAction(e -> area.cut());
        copyitem.setOnAction(e -> area.copy());
        pasteitem.setOnAction(e -> area.paste());
        deleteitem.setOnAction(e -> area.deleteText(area.getSelection()));
        selectitem.setOnAction(e -> area.selectAll());
        newitem.setOnAction(e -> area.clear());
        exititem.setOnAction(e -> primaryStage.close());
        helpitem.setOnAction(e -> dialog.showAndWait());
        openitem.setOnAction(e -> fileC.showOpenDialog(primaryStage));  
        saveitem.setOnAction(e -> fileS.showSaveDialog(primaryStage));

        file.getItems().addAll(newitem, openitem, saveitem,separator1 , exititem);
        edit.getItems().addAll(undoitem,separator2, cutitem, copyitem, pasteitem, deleteitem ,separator3 ,selectitem);
        help.getItems().addAll(helpitem);

        bar.getMenus().addAll(file, edit, help);

        area.setText("Enter your address here");
        BorderPane Bpane = new BorderPane();
        Bpane.setTop(bar);
        Bpane.setCenter(area);
        Scene Scene = new Scene(Bpane, 300, 400);
        primaryStage.setTitle("Note Pad");
        primaryStage.setScene(Scene);
        primaryStage.show();
    };

    public static void main(String[] args) {
        launch(args);
    }

}
