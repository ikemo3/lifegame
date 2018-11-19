package com.ikemo3.lifegame.cell;

import java.util.List;

public interface Cell {
    /**
     * 次の世代のセルを返す
     *
     * @param aroundCell 周りのセルのリスト
     * @return 次の世代のセル
     */
    Cell next(List<Cell> aroundCell);

    /**
     * 生きているかどうかを返す
     *
     * @return true: 生きている、false: 死んでいる
     */
    boolean isAlive();
}
