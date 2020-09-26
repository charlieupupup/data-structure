import java.util.Iterator;
import java.util.List;
import java.util.Stack;

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a
    // nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a
    // single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested
    // list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

class NestedIterator implements Iterator<Integer> {
    private Stack<Iterator<NestedInteger>> stack;
    private Iterator<NestedInteger> iter;
    private Integer next;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.stack = new Stack<>();
        this.iter = nestedList.iterator();
        this.next = null;
    }

    @Override
    public Integer next() {
        int res = next;
        next = null;
        return res;
    }

    @Override
    public boolean hasNext() {
        if (next != null) {
            return true;
        }

        while (!stack.isEmpty() || iter.hasNext()) {
            if (!iter.hasNext()) {
                iter = stack.pop();
                continue;
            }

            NestedInteger ni = iter.next();
            if (ni.isInteger()) {
                next = ni.getInteger();
                return true;
            } else {
                stack.push(iter);
                iter = ni.getList().iterator();
            }

        }
        return false;
    }
}