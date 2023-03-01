package lab01.tdd;

import java.util.ArrayList;
import java.util.List;

public class ClassListImpl implements ClassList {

    protected final List<Integer> list = new ArrayList<>();

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
}
