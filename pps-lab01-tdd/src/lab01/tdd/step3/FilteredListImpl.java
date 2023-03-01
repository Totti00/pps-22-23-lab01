package lab01.tdd.step3;

import lab01.tdd.ClassListImpl;

import java.util.*;
import java.util.function.Predicate;

public class FilteredListImpl extends ClassListImpl implements FilteredList {

    private final List<Integer> list = super.list;

    @Override
    public Optional<Integer> filteredNext(Predicate<Integer> condition) {
        Optional<Integer> value = list.stream().filter(condition).findFirst();
        if (value.isEmpty()){
            return Optional.empty();
        }
        return value;
    }
}
