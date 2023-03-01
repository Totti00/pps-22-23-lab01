package lab01.tdd.step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class FilteredListImpl implements FilteredList {

    private final List<Integer> list = new ArrayList<>();
    int next;

    @Override
    public void add(int element) {
        this.list.add(element);
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Optional<Integer> filteredNext(Predicate<Integer> condition) {
        Optional<Integer> value = list.stream().filter(condition).findFirst();
        if (value.isEmpty()){
            return Optional.empty();
        }
        return value;
    }
}
