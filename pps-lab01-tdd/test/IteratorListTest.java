import lab01.tdd.step2.IteratorList;
import lab01.tdd.step2.IteratorListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class IteratorListTest {

    public static final int NUMBER_OF_ATTEMPS = 300;
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
        assertEquals(oldSize + 3, this.list.size());
    }

    @Test
    void testFarwardIterator() {
        iterator = this.list.forwardIterator();
        assertThrows(EmptyStackException.class, () -> iterator.next());
        initializeList();
        assertEquals(0, iterator.next());
        iterator.next();
        assertEquals(2, iterator.next());
    }

    @Test
    void testBackwardIterator() {
        iterator = this.list.backwardIterator();
        assertThrows(EmptyStackException.class, () -> iterator.next());
        initializeList();
        assertEquals(2, iterator.next());
        iterator.next();
        assertEquals(0, iterator.next());
    }
}