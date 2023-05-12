
import java.util.*;

public class BST<K extends Comparable<K>, V> implements Iterable<K> {
    private Node root;
    private int size;

    private class Node {
        private K key;
        private V value;
        private Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(K key, V value) {
        if (root == null) {
            root = new Node(key, value);
            size++;
        } else {
            root = put2(root, key, value);
        }
    }

    private Node put2(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }

        int result = key.compareTo(node.key);
        if (result < 0) {
            node.left = put2(node.left, key, value);
        } else if (result > 0) {
            node.right = put2(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    public V get(K key) {
        Node node = getNode(root, key);
        return (node == null) ? null : node.value;
    }

    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }

        int result = key.compareTo(node.key);
        if (result < 0) {
            return getNode(node.left, key);
        } else if (result > 0) {
            return getNode(node.right, key);
        } else {
            return node;
        }
    }

    public void delete(K key) {
        root = delete2(root, key);
    }

    private Node delete2(Node node, K key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete2(node.left, key);
        } else if (cmp > 0) {
            node.right = delete2(node.right, key);
        } else {
            if (node.right == null) {
                return node.left;
            }
            if (node.left == null) {
                return node.right;
            }
            Node t = node;
            node = min(t.right);
            node.right = deleteMin(t.right);
            node.left = t.left;
        }
        return node;
    }
    private Node min(Node node){
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    private Node deleteMin(Node node){
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        return node;
    }



    public int size() {
        return size;
    }



    @Override
    public Iterator<K> iterator() {
        return new InOrderIterator(root);
    }

    private class InOrderIterator implements Iterator<K> {
        private Stack<Node> stack;

        public InOrderIterator(Node root) {
            stack = new Stack<>();
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public K next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Node node = stack.pop();
            K key = node.key;
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            return key;
        }
    }

}



