/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    List<Integer> arr;
    int currIndex;

    public NestedIterator(List<NestedInteger> nestedList) {
        arr = new ArrayList<>();
        currIndex = 0;
        push(nestedList);

    }

    @Override
    public Integer next() {
        return arr.get(currIndex++);

    }

    @Override
    public boolean hasNext() {
        if (currIndex >= arr.size()) {
            return false;
        }
        return true;

    }

    void push(List<NestedInteger> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isInteger()) {
                arr.add(list.get(i).getInteger());
            } else {
                push(list.get(i).getList());
            }
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */