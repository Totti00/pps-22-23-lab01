import lab01.tdd.step1.CircularList;
import lab01.tdd.step1.CircularListImpl;
import org.junit.jupiter.api.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    public static final int NUMBER_OF_ATTEMPS = 300;
    private CircularList list;

    @BeforeEach
    void setUp() {
        this.list = new CircularListImpl();
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
    void testNext() {
        initializeList();
        assertEquals(Optional.of(0), this.list.next());
        assertEquals(Optional.of(1), this.list.next());
    }

    @Test
    void testCircularNext() {
        initializeList();
        for (int i = 0; i < NUMBER_OF_ATTEMPS; i++) {
            this.list.next();
        }
        assertEquals(0, this.list.next().get());
    }

    @Test
    void testPrevious() {
        initializeList();
        this.list.next();
        this.list.next();
        assertEquals(1, this.list.previous().get());
    }

    @Test
    void testCircularPrevious() {
        initializeList();
        for (int i = 0; i < NUMBER_OF_ATTEMPS; i++) {
            this.list.previous();
        }
        assertEquals(2, this.list.previous().get());
    }

    @Test
    void testReset() {
        initializeList();
        this.list.next();
        this.list.next();
        this.list.next();
        this.list.previous();
        this.list.reset();
        assertEquals(0, this.list.next().get());
    }

}
