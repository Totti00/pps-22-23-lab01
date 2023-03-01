package lab01.tdd.step3;

import lab01.tdd.ClassList;

import java.util.Optional;
import java.util.function.Predicate;

public interface FilteredList extends ClassList {

    /**
     * It's finds and returns the next element that satisfies a given condition.
     * If no such element is found the method should return an empty Optional
     * @param condition to test the list element
     * @return next element or empty Optional
     */
    Optional<Integer> filteredNext(Predicate<Integer> condition);
}
