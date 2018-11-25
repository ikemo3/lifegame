package com.ikemo3.lifegame;

import com.ikemo3.lifegame.cell.AliveCell;
import com.ikemo3.lifegame.cell.Cell;
import com.ikemo3.lifegame.cell.Cells;
import com.ikemo3.lifegame.cell.DeadCell;
import com.ikemo3.lifegame.grid.Grid;
import com.ikemo3.lifegame.grid.RectangleGrid;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public final class LifeGame implements Initializable {
    private Generation generation;

    @FXML
    private TextArea textArea;

    private static final Cells BLINKER = Cells.of(
            new DeadCell(), new AliveCell(), new DeadCell(), new DeadCell(),
            new DeadCell(), new AliveCell(), new DeadCell(), new DeadCell(),
            new DeadCell(), new AliveCell(), new DeadCell(), new DeadCell()
    );

    private static final Grid BLINKER_GRID = new RectangleGrid(4, 3, BLINKER);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        generation = new Generation(BLINKER_GRID);

        textArea.setText(generation.toString());
    }

    public void onclick(ActionEvent actionEvent) {
        generation = generation.next();
        textArea.setText(generation.toString());
    }
}
