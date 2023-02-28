import lab01.tdd.step2.IteratorList;
import lab01.tdd.step2.IteratorListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class IteratorListTest {

    public static final int NUMBER_OF_ATTEMPS = 300;
    public static final int FIRST_ELEMENT_OF_LIST = 0;
    public static final int LAST_ELEMENT_OF_LIST = 2;
    private IteratorList list;
    private Iterator<Integer> iterator;

    @BeforeEach
    void setUp() {
        this.list = new IteratorListImpl();
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
        assertEquals(oldSize + list.size(), this.list.size());
    }

    @Test
    void testFarwardIterator() {
        iterator = this.list.forwardIterator();
        assertThrows(EmptyStackException.class, () -> iterator.next());
        initializeList();
        assertEquals(FIRST_ELEMENT_OF_LIST, iterator.next());
        iterator.next();
        assertEquals(LAST_ELEMENT_OF_LIST, iterator.next());
    }

    @Test
    void testBackwardIterator() {
        iterator = this.list.backwardIterator();
        assertThrows(EmptyStackException.class, () -> iterator.next());
        initializeList();
        assertEquals(LAST_ELEMENT_OF_LIST, iterator.next());
        iterator.next();
        assertEquals(FIRST_ELEMENT_OF_LIST, iterator.next());
    }

    @Test
    void testFarwardIteratorMultipleTimes() {
        iterator = this.list.forwardIterator();
        initializeList();
        for (int i = 0; i < NUMBER_OF_ATTEMPS; i++) {
            iterator.next();
        }
        assertEquals(FIRST_ELEMENT_OF_LIST, iterator.next());
    }

    @Test
    void testBackwardIteratorMultipleTimes() {
        iterator = this.list.backwardIterator();
        initializeList();
        for (int i = 0; i < NUMBER_OF_ATTEMPS; i++) {
            iterator.next();
        }
        assertEquals(LAST_ELEMENT_OF_LIST, iterator.next());
    }
}