package com.ikemo3.lifegame.cell;

public interface Cell {
    /**
     * 次の世代のセルを返す
     *
     * @param aroundCells 周りのセル群
     * @return 次の世代のセル
     */
    Cell next(Cells aroundCells);

    /**
     * 生きているかどうかを返す
     *
     * @return true: 生きている、false: 死んでいる
     */
    boolean isAlive();
}
