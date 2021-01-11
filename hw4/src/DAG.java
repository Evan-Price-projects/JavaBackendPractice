import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class DAG<T extends Comparable<T>> {
    private Node<T> sentinel;

    public DAG() {
        this.sentinel = null;
    }

    public Node<T> getSentinel() {
        return sentinel;
    }

    /* in order to add/insert a new data type in the graph, we need to
     pass the new_data and its parent.  We have several scenarios to consider:
             1-    If the parent is null:
                1.1-  if new_data does not exist, add new_data as a child of the sentinel.
                1.2-  if new_data exists, return.
             2-    If the parent is not null:
                2.1-  if new_data does not exist, add new_data as a child to the parent, and the parent becomes parent of new_data.
                2.2-  if new_data exists, add it as a child to parent, but do not override the parent of new_data, since it has a parent already.*/
    public void add(T parent, T new_data) {
        if (parent == null) { // the new parent is null
            if (this.sentinel != null) {
                for (Node<T> childNode : this.sentinel.children) {
                    if (childNode.elem == new_data) {
                        return; // new_data exists, return
                    }
                }
            } else {
                this.sentinel = new Node<T>();
            }

            Node newNode = new Node<>(new_data, new LinkedList<Node<T>>(), this.sentinel);
            this.sentinel.children.add(newNode); // new_data does not exist, add new_data as a child of the sentinel
        } else { // the new parent is not null
            Node<T> new_Node = find(new_data);
            Node<T> parentNode = find(parent);

            if (parentNode == null) {
                return; //unable to find parent node (the requirements do not seem to account for this)
            }
            if (new_Node != null && new_Node.parent == parentNode) {
                return; // the new data is already in the dataset and the parent already has the element (the requirements does not seem to account for this)
            } else {
                if (new_Node == null) {
                    new_Node = new Node<>(new_data, new LinkedList<Node<T>>(), parentNode); // new_data does not exist, the parent becomes parent of new_data
                } else {
                    // new_data exists do not override the parent of new_data, since it has a parent already
                }
                parentNode.children.add(new_Node); // add new_data as a child to parent
            }
        }
    }

    /* if data does not exist, just return. If it exist, remove it. You need also to
       remove its subtree, i.e., remove any child as long as node saving data is an ancestor. NOTE: assume we
       have two nodes, x and y, where x has y as a child, and y has x as a parent
       ; in this case, x and all ot its
       ancestors are also ancestors of y. However, if x has y as a child, but y has another parent, x and its
       ancestors ARE NOT ancestors of y.*/
    public void remove(T data) {
        Node<T> removeNode = find(data);
        Node<T> parentNode = removeNode.parent;
        if (removeNode == null) {
            return;//if data does not exist, just return
        } else {
            parentNode.children.remove(removeNode);//If it exist, remove it
        }
    }

    /*  this methods looks up data in the DAG. A depth
         first search DFS would do for this method. Note that you need to avoid re
         visiting the same node if a node is a child of several
         nodes. You could leverage the parent edge such that you visit a child of a node x iff x is a parent of the
         child.*/
    public boolean search(T data) {
        Node<T> startNode = this.sentinel;
        return searchRecursive(data, startNode);
    }

    private boolean searchRecursive(T data, Node<T> currentNode) {
        if (currentNode.elem == data) {
            return true;
        } else {
            for (Node<T> childNode : currentNode.children) {
                Node<T> foundNode = findNodeRecursive(data, childNode);
                if (foundNode != null) {
                    return true;
                }
            }
        }
        return false;
    }

    /*  this methods looks up data in
        the DAG and return a reference to the
        node containing data is it exists; otherwise, return null. Note that this method is protected.*/
    protected Node<T> find(T data) {
        return findNodeRecursive(data, sentinel);
    }

    private Node<T> findNodeRecursive(T data, Node<T> currentNode) {

        if (currentNode.elem == data) {
            return currentNode;
        } else {
            for (Node<T> childNode : currentNode.children) {
                Node<T> foundNode = findNodeRecursive(data, childNode);
                if (foundNode != null) {
                    return foundNode;
                }
            }
        }
        return null;
    }

    public ArrayList<Pair<T, T>> getEdgesArray() {

        //// In here I assume that getChildren() will return ArrayList. If you implementation
        ///     returns a linkedList, you need to change ArrayList in the next line to LinkedList;
        ////     and if your getChildren() returns other types of List, just change it to that
        LinkedList<Node<T>> graph_nodes = new LinkedList<>();
        graph_nodes.addAll(this.sentinel.getChildren());

        for (int i = 0; i < graph_nodes.size(); i++) {
            if (graph_nodes.get(i).getChildren().size() != 0)
                graph_nodes.addAll(graph_nodes.get(i).getChildren());
        }

        //Add the nodes to a set to eliminate duplications
        Set<Node<T>> graph_set = new HashSet<Node<T>>();
        for (Node<T> someNode : graph_nodes) {
            graph_set.add(someNode);
        }

        //now, visit the nodes in the graph_set and add their edges to the array list edgeArray
        ArrayList<Pair<T, T>> edgeArray = new ArrayList<>();
        for (Node<T> n : graph_set) {
            if (n.getParent() == this.sentinel)
                edgeArray.add(new Pair(n.getElem(), null));//adding parent edge
            else edgeArray.add(new Pair(n.getElem(), n.getParent().getElem()));
            for (Node<T> c : n.getChildren())
                edgeArray.add(new Pair(n.getElem(), c.getElem()));
        }

        return edgeArray;
    }
}
