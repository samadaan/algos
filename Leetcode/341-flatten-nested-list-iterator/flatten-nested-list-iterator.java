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

    private Deque<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new ArrayDeque<>();
        // Push elements in reverse to keep the first element on top
        prepareStack(nestedList);

    }

    @Override
    public Integer next() {
        // hasNext() guarantees the top of the stack is an integer
        return stack.pop().getInteger();

    }

    @Override
    public boolean hasNext() {
        // Process the stack until the top element is an integer
        while (!stack.isEmpty()) {
            NestedInteger curr = stack.peek();
            if (curr.isInteger()) {
                return true;
            }
            
            // If it's a list, unpack it
            stack.pop();
            prepareStack(curr.getList());
        }
        return false;

    }

    private void prepareStack(List<NestedInteger> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            stack.push(list.get(i));
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */