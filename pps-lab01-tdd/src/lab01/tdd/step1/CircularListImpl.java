package lab01.tdd.step1;

import lab01.tdd.step1.CircularList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {

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
