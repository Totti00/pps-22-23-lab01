package lab01.tdd.step2;

import lab01.tdd.ClassListImpl;

import java.util.*;

public class IteratorListImpl extends ClassListImpl implements IteratorList {

    private List<Integer> list = super.list;
    int next;

    @Override
    public Iterator<Integer> forwardIterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return !isEmpty();
            }

            @Override
            public Integer next() {
                if (isEmpty()) {
                    throw new EmptyStackException();
                } else if (size() == next) {
                    next = 0;
                }
                return list.get(next++);
            }
        };
    }

    @Override
    public Iterator<Integer> backwardIterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return !isEmpty();
            }

            @Override
            public Integer next() {
                if (isEmpty()) {
                    throw new EmptyStackException();
                } else if (next == 0) {
                    next = size();
                }
                return list.get(--next);
            }
        };
    }

    @Override
    public void reset() {
        this.next = 0;
    }
}
