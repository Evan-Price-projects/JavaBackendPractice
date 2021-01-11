import java.util.LinkedList;
import java.util.List;

public class Node<T extends Comparable<T>> {
    public T elem;
    public Node<T> parent;
    public LinkedList<Node<T>> children;

    public Node(T elem, LinkedList<Node<T>> children, Node<T> parent) {
        this.elem = elem;
        this.parent = parent;
        this.children = children;
    }

    public Node() {
        this.elem = null;
        this.parent = null;
        this.children = new LinkedList<Node<T>>();
    }

    public LinkedList<Node<T>> getChildren() {
        return children;
    }

    public T getValue() {
        return elem;
    }

    public T getElem() {
        return elem;
    }

    public Node<T> getParent() {
        return parent;
    }
}