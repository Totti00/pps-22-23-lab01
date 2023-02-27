import lab01.tdd.CircularList;
import org.junit.jupiter.api.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList list;

    @BeforeEach
    void setUp() {
        this.list = new CircularListImpl();
    }

    @Test
    void testIsListEmpty() {
        assertTrue(this.list.isEmpty());
    }

    @Test
    void testCanBeAddElements() {
        this.list.add(0);
        this.list.add(1);
        this.list.add(2);
        assertEquals(3, this.list.size());
    }

    @Test
    void testCheckFirstThreeElements() {
        assertEquals(Optional.empty(), this.list.next());
        this.list.add(0);
        this.list.add(1);
        this.list.add(2);
        assertEquals(Optional.of(0), this.list.next());
        assertEquals(Optional.of(1), this.list.next());
        assertEquals(Optional.of(2), this.list.next());
        assertEquals(Optional.of(0), this.list.next());
    }



}
