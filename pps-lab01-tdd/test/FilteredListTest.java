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
        assertTrue(this.list.isEmpty());
    }

    @Test
    void testCanBeAddElements() {
        int oldSize = this.list.size();
        initializeList();
        assertEquals(oldSize + 3, this.list.size());
    }

    @Test
    void testFilteredNext() {
        initializeList();
        assertFalse(this.list.isEmpty());
        assertEquals(Optional.of(2), list.filteredNext(i  -> i == 2));
    }

    @Test
    void testFailureFilteredNext() {
        initializeList();
        assertFalse(this.list.isEmpty());
        assertEquals(Optional.empty(), list.filteredNext(i  -> i == 3));
    }
}