package test.java;

import main.java.BubbleSort;
import main.java.SalesRepresentative;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BubbleSortTest {
    private BubbleSort bubble;
    private SalesRepresentative representative1;
    private SalesRepresentative representative2;
    private SalesRepresentative representative3;
    private SalesRepresentative representative4;
    private final SalesRepresentative[] representatives = new SalesRepresentative[4];

    @BeforeEach
    void set_up() {
        bubble = new BubbleSort();
        representative1 = new SalesRepresentative(10, 100);
        representative2 = new SalesRepresentative(10, 200);
        representative3 = new SalesRepresentative(10, 50);
        representative4 = new SalesRepresentative(10, 300);

        representatives[0] = representative1;
        representatives[1] = representative2;
        representatives[2] = representative3;
        representatives[3] = representative4;
    }

    @Test
    @DisplayName("test sort")
    void sort() {
        SalesRepresentative[] expected = {representative4, representative2, representative1, representative3};
        SalesRepresentative[] actual = bubble.sort(representatives);

        assertNotNull(actual);

        assertEquals(Arrays.toString(expected), Arrays.toString(actual));

        assertEquals(expected[0].getRevenueGenerated(), actual[0].getRevenueGenerated());

        assertEquals(expected[3].getRevenueGenerated(), actual[3].getRevenueGenerated());
    }

    @Test
    @DisplayName("test reverse")
    void reverse() {
        SalesRepresentative[] sortedRepresentatives = bubble.sort(representatives);
        SalesRepresentative[] expected = {representative3, representative1, representative2, representative4};
        SalesRepresentative[] actual = bubble.reverse(sortedRepresentatives);

        assertNotNull(actual);

        assertEquals(Arrays.toString(expected), Arrays.toString(actual));

        assertEquals(expected[0].getRevenueGenerated(), actual[0].getRevenueGenerated());

        assertEquals(expected[3].getRevenueGenerated(), actual[3].getRevenueGenerated());
    }
}