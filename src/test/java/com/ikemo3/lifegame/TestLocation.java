package com.ikemo3.lifegame;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public final class TestLocation {
    @Test
    public void testAroundList() {
        Location loc = new Location(1, 1);
        List<Location> aroundList = loc.aroundList();
        assertThat(aroundList).hasSize(8);
    }
}
