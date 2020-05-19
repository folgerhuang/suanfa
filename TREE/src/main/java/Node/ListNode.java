package Node;

public class ListNode<T> {
    T key;
    ListNode<T> next;

    public ListNode(T key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return key +
                "->" + next;
    }
}
