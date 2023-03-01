import lab01.tdd.step3.*;
import org.junit.jupiter.api.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class FilteredListTest {

    private FilteredList list;
    @BeforeEach
    void setUp() {
        this.list = new FilteredListImpl();
    }

    private void initializeList() {
        this.list.add(0);
        this.list.add(1);
        this.list.add(2);
    }

    @Test
    void testIsListEmpty() {
        assertTrue(checkListIsEmpty());
    }

    @Test
    void testCanBeAddElements() {
        int oldSize = this.list.size();
        initializeList();
        assertEquals(oldSize + this.list.size(), this.list.size());
    }

    @Test
    void testFilteredNext() {
        initializeList();
        assertFalse(checkListIsEmpty());
        assertEquals(Optional.of(2), list.filteredNext(i  -> i == 2));
    }

    @Test
    void testFailureFilteredNext() {
        initializeList();
        assertFalse(checkListIsEmpty());
        assertEquals(Optional.empty(), list.filteredNext(i  -> i == 3));
    }

    private boolean checkListIsEmpty() {
        return this.list.isEmpty();
    }
}