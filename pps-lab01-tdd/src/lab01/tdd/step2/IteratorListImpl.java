package lab01.tdd.step2;

import java.util.*;

public class IteratorListImpl implements IteratorList {

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
        return this.list.size() == 0;
    }

    @Override
    public Iterator<Integer> forwardIterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return !list.isEmpty();
            }

            @Override
            public Integer next() {
                if (list.isEmpty()) {
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
                return !list.isEmpty();
            }

            @Override
            public Integer next() {
                if (list.isEmpty()) {
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
