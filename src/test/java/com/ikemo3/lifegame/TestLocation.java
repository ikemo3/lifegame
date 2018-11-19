package com.ikemo3.lifegame;

import com.ikemo3.lifegame.grid.RectangleLocation;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public final class TestLocation {
    @Test
    public void testAroundList() {
        RectangleLocation loc = new RectangleLocation(1, 1);
        List<RectangleLocation> aroundList = loc.aroundList();
        assertThat(aroundList).hasSize(8);
    }
}
