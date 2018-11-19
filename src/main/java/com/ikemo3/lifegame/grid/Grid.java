package com.ikemo3.lifegame.grid;

import com.ikemo3.lifegame.Location;
import com.ikemo3.lifegame.cell.Cell;

import java.util.Iterator;
import java.util.List;
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
    Optional<Cell> getCell(Location location);

    /**
     * セルよりロケーションを取得
     *
     * @param cell セル
     * @return ロケーション
     */
    Location getLocation(Cell cell);

    /**
     * 周りのセルのリストを取得
     *
     * @param cell セル
     * @return 周りのセルのリスト
     */
    List<Cell> aroundCells(Cell cell);

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
    Grid withNextCells(List<Cell> nextCells);
}
