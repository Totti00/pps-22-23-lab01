package lab01.tdd.step3;

import java.util.Optional;
import java.util.function.Predicate;

public class FilteredListImpl implements FilteredList {
    @Override
    public void add(int element) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Optional<Integer> filteredNext(Predicate<Integer> condition) {
        return Optional.empty();
    }

    @Override
    public void reset() {

    }
}
