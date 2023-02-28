import lab01.tdd.step3.*;
import org.junit.jupiter.api.*;

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

}