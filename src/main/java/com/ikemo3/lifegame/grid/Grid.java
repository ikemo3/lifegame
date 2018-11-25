package com.ikemo3.lifegame.grid;

import com.ikemo3.lifegame.cell.Cell;
import com.ikemo3.lifegame.cell.Cells;

import java.util.Optional;
import java.util.stream.Stream;

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
    Optional<Cell> getCell(RectangleLocation location);

    /**
     * セルよりロケーションを取得
     *
     * @param cell セル
     * @return ロケーション
     */
    RectangleLocation getLocation(Cell cell);

    /**
     * 周りのセルのリストを取得
     *
     * @param cell セル
     * @return 周りのセル群
     */
    Cells aroundCells(Cell cell);

    /**
     * セルのストリームを返す
     *
     * @return セルのストリーム
     */
    Stream<Cell> stream();

    /**
     * 次の世代のセルのリストより、新しいGridオブジェクトを作成
     *
     * @param nextCells 次の世代のセルのリスト
     * @return 新しいGridオブジェクト
     */
    Grid withNextCells(Cells nextCells);
}
