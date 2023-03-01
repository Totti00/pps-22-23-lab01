package lab01.tdd.step1;

import lab01.tdd.ClassListImpl;

import java.util.*;

public class CircularListImpl extends ClassListImpl implements CircularList {

    private List<Integer> list = super.list;
    int next;

    @Override
    public Optional<Integer> next() {
        if (this.next == size()) {
            this.next = 0;
        }
        return Optional.ofNullable(this.list.get(next++));
    }

    @Override
    public Optional<Integer> previous() {
        if (this.next == 0) {
            this.next = size();
        }
        return Optional.ofNullable(this.list.get(--next));
    }

    @Override
    public void reset() {
        this.next = 0;
    }
}
