package com.company;



import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main extends Application {
public static final int SPACING=10;
    List<Barca>  barche=new ArrayList<>();

Button btnNext=new Button(">");
Button btnPrev=new Button("<");
Button sort=new Button("id");
Text txt=new Text();
int current=0;
enum Ordinamento{ID,ANNO}
Ordinamento ordinamento=Ordinamento.ID;

     public Main() {
        barche.add(new Motoscafo("M1", 5, Barca.Motori.BENZINA, 2020, 2020, 20000));
        barche.add(new Motoscafo("M2", 6, Barca.Motori.DIESEL, 2023, 2024, 30000));
        barche.add(new Motoscafo("M3", 4, Barca.Motori.IBRIDO, 2022, 2024, 35000));

        barche.add(new AVela("U1", 15, Barca.Motori.BENZINA, 2023, 2023, 10000));
        barche.add(new AVela("U2", 14, Barca.Motori.IBRIDO, 2019, 2019, 10000));
        barche.add(new AVela("U3", 16, Barca.Motori.DIESEL, 2021, 2022, 18000));

        barche.add(new Regata("S1", 12, Barca.Motori.BENZINA, 2020, 2021, 26000,
                "Spinnaker"));
        barche.add(new Regata("S2", 13, Barca.Motori.BENZINA, 2020, 2020, 35000,
              "Randa con stecche"));
        barche.add(new Regata("S3", 12, Barca.Motori.BENZINA, 2018, 2019, 40000,
                "Spinnaker ,Vele in fibra di carbonio"));

    }

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
         BorderPane root= new BorderPane();
     VBox left=new VBox(btnPrev);
     left.setAlignment(Pos.CENTER);
     left.setPadding((new Insets(SPACING)));
     root.setLeft(left);
btnPrev.setOnAction(new EventHandler<ActionEvent>(){
@Override
public void handle(ActionEvent actionEvent){

current--;
update();
}


});
VBox right=new VBox(btnNext);
right.setAlignment(Pos.CENTER);
right.setPadding(new Insets(SPACING));
root.setRight(right);
btnNext.setOnAction(new EventHandler<ActionEvent>(){
    @Override
    public  void handle(ActionEvent actionEvent){

    current++;
    update();
        }

});
HBox top=new HBox(sort);
top.setAlignment(Pos.CENTER);
top.setPadding(new Insets(SPACING));
root.setTop(top);
sort.setOnAction(new EventHandler<ActionEvent>(){
    @Override
    public  void handle(ActionEvent actionEvent){
switch(ordinamento){
case ID:
    ordinamento=Ordinamento.ID;
    sort.setText("Anno");
    barche.sort(new ComparatorByYear());
    break;

case ANNO:
    ordinamento=Ordinamento.ANNO;
    sort.setText("Id");
    barche.sort(null);
}
    current=0;
    update();
        }

});
HBox center= new HBox(txt);
center.setAlignment(Pos.CENTER);
center.setPadding(new Insets(SPACING));
root.setCenter(center);



  primaryStage.setTitle("Marina");
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.show();

        Collections.sort(barche);
        current = 0;
        update();
    }

  public  void update(){
         btnPrev.setDisable(current<=0);
         btnNext.setDisable(current>barche.size()-2);

  txt.setText(barche.get(current).toString());


     }



}
