package lab01.tdd.step3;

import java.util.Optional;
import java.util.function.Predicate;

public interface FilteredList {

    /**
     * Adds an element to the list, namely, after the last inserted one.
     * @param element the element to be added to the list
     */
    void add(final int element);

    /**
     * Provides the current size of the list
     * @return the size of the list
     */
    int size();

    /**
     * Checks if the list is empty
     * @return true if the list is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * It's finds and returns the next element that satisfies a given condition.
     * If no such element is found the method should return an empty Optional
     * @param condition to test the list element
     * @return next element or empty Optional
     */
    Optional<Integer> filteredNext(Predicate<Integer> condition);

    /**
     * Reset the position of current element back to the first one of the list.
     * Note the first one is the first added to the list.
     */
    void reset();
}
