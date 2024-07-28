package test.java;

import main.java.BubbleSort;
import main.java.SalesRepresentative;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BubbleSortTest {
    private BubbleSort bubble;
    private SalesRepresentative representative1;
    private SalesRepresentative representative2;
    private SalesRepresentative representative3;
    private SalesRepresentative representative4;

    @BeforeEach
    void set_up() {
        bubble = new BubbleSort();
        representative1 = new SalesRepresentative(10, 100);
        representative2 = new SalesRepresentative(10, 200);
        representative3 = new SalesRepresentative(10, 50);
        representative4 = new SalesRepresentative(10, 300);
    }

    @Test
    @DisplayName("test sort")
    void sort() {
        SalesRepresentative[] representatives = {representative1, representative2, representative3, representative4};
        SalesRepresentative[] sortedRepresentatives = {representative4, representative2, representative1, representative3};

        assertEquals(Arrays.toString(sortedRepresentatives), Arrays.toString(bubble.sort(representatives)));
    }

    @Test
    @DisplayName("test reverse")
    void reverse() {
        SalesRepresentative[] sortedRepresentatives = {representative4, representative2, representative1, representative3};
        SalesRepresentative[] reverseSortedRepresentatives = {representative3, representative1, representative2, representative4};

        assertEquals(Arrays.toString(reverseSortedRepresentatives), Arrays.toString(bubble.reverse(sortedRepresentatives)));
    }
}