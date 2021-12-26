package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;

import java.awt.*;

public class OrderController{

    //untuk mengelist food yang telah di add pembeli
    private ObservableList<model.Food> orderedFood = FXCollections.observableArrayList();

    //ambil data orderedfood
    public ObservableList<model.Food> getOrderedFood() {
        return orderedFood;
    }

    @FXML
    private Button checkOutButtonClicked;

    @FXML
    //ke method pembayaran bila Check Out di klik
    public void checkOutButtonClicked(){
        //membuat tombol Check Out tidak bisa di klik bila order tidak ada isinya
        //tapi karena masih error, jadi ku bikin invisible
        //harusnya pake button.setDisable(true), cuma bingung gatau gimana pakenya
        checkOutButtonClicked.setVisible(false);
        if(orderedFood != null){
            checkOutButtonClicked.setVisible(true); //kalau ada isinya jadi kelihatan tombolnya
        }
    }
}

