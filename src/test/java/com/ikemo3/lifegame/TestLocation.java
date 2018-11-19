package com.ikemo3.lifegame;

import com.ikemo3.lifegame.grid.SquareLocation;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public final class TestLocation {
    @Test
    public void testAroundList() {
        SquareLocation loc = new SquareLocation(1, 1);
        List<SquareLocation> aroundList = loc.aroundList();
        assertThat(aroundList).hasSize(8);
    }
}
