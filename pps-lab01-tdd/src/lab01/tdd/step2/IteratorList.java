package lab01.tdd.step2;

import lab01.tdd.ClassList;

import java.util.Iterator;

/**
 * Represents a list of integers, with a built-in iterator that is bidirectional and circular.
 * Example: with a list like {1,2,3}, the first call of next() returns 1, the second call returns 2,
 * the third returns 3, the fourth returns 1, and so on. Call to previous() goes in the other way.
 */
public interface IteratorList extends ClassList {

    /**
     * Provides the next element of the list, as given by the built-in iterator.
     * @return the next element of the list, or an empty optional if the list is empty
     */
    Iterator<Integer> forwardIterator();

    /**
     * Provides the previous element of the list. Its behaviour is dual of the next() method.
     * @return the previous element into the list
     */
    Iterator<Integer> backwardIterator();

    /**
     * Reset the position of current element back to the first one of the list.
     * Note the first one is the first added to the list.
     */
    void reset();
}
