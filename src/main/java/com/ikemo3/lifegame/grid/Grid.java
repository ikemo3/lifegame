package com.ikemo3.lifegame.grid;

import com.ikemo3.lifegame.cell.Cell;
import com.ikemo3.lifegame.cell.Cells;

import java.util.Optional;

/**
 * 格子
 */
public interface Grid {
    /**
     * ロケーションよりセルを取得
     *
     * @param location ロケーション
     * @return セル(Optional)
     */
    Optional<Cell> getCell(Location location);

    /**
     * セルよりロケーションを取得
     *
     * @param cell セル
     * @return ロケーション
     */
    Location getLocation(Cell cell);

    /**
     * 周りのセル群を取得
     *
     * @param cell セル
     * @return 周りのセル群
     */
    Cells aroundCells(Cell cell);

    /**
     * 次の世代のGridを返す
     *
     * @return 次の世代のGrid
     */
    Grid next();
}
