package org.tec.ce.DataStructures.BTree;

public class BTree<Key extends Comparable<Key>> {
    // max children per B-tree node = order-1
    // (must be even and greater than 2)
    private int order;

    private Node root;       // root of the B-tree
    private int height;      // height of the B-tree
    private int n;           // number of key-value pairs in the B-tree

    // helper B-tree node data type
    private static final class Node {
        private int m;                             // number of children
        private Entry[] children;   // the array of children

        // create a node with k children
        private Node(int k, int order) {
            m = k;
            children = new Entry[order];
        }
    }

    // internal nodes: only use key and next
    // external nodes: only use key and value
    private static class Entry {
        private Comparable key;
        private Node next;     // helper field to iterate over array entries

        public Entry(Comparable key, Node next) {
            this.key = key;
            this.next = next;
        }
    }

    /**
     * Initializes an empty B-tree.
     */
    public BTree(int order) {
        root = new Node(0, order);
        this.order = order;
    }

    /**
     * Returns true if this symbol table is empty.
     *
     * @return {@code true} if this symbol table is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     *
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return n;
    }

    /**
     * Returns the height of this B-tree (for debugging).
     *
     * @return the height of this B-tree
     */
    public int height() {
        return height;
    }

    /**
     * Inserts the key-value pair into the symbol table, overwriting the old value
     * with the new value if the key is already in the symbol table.
     * If the value is {@code null}, this effectively deletes the key from the symbol table.
     *
     * @param key the key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(Key key) {
        if (key == null) throw new IllegalArgumentException("argument key to put() is null");
        Node u = insert(root, key, height);
        n++;
        if (u == null) return;

        // need to split root
        Node t = new Node(2, order);
        t.children[0] = new Entry(root.children[0].key, root);
        t.children[1] = new Entry(u.children[0].key, u);
        root = t;
        height++;
    }

    private Node insert(Node h, Key key, int ht) {
        int j;
        Entry t = new Entry(key, null);

        // external node
        if (ht == 0) {
            for (j = 0; j < h.m; j++) {
                if (less(key, h.children[j].key)) break;
            }
        }

        // internal node
        else {
            for (j = 0; j < h.m; j++) {
                if ((j + 1 == h.m) || less(key, h.children[j + 1].key)) {
                    Node u = insert(h.children[j++].next, key, ht - 1);
                    if (u == null) return null;
                    t.key = u.children[0].key;
                    t.next = u;
                    break;
                }
            }
        }

        for (int i = h.m; i > j; i--)
            h.children[i] = h.children[i - 1];
        h.children[j] = t;
        h.m++;
        if (h.m < order) return null;
        else return split(h);
    }

    // split node in half
    private Node split(Node h) {
        Node t = new Node(order / 2, order);
        h.m = order / 2;
        for (int j = 0; j < order / 2; j++)
            t.children[j] = h.children[order / 2 + j];
        return t;
    }

    /**
     * Returns a string representation of this B-tree (for debugging).
     *
     * @return a string representation of this B-tree.
     */
    public String toString() {
        return toString(root, height, "") + "\n";
    }

    private String toString(Node h, int ht, String indent) {
        StringBuilder s = new StringBuilder();
        Entry[] children = h.children;

        if (ht == 0) {
            for (int j = 0; j < h.m; j++) {
                s.append(indent + children[j].key + "\n");
            }
        } else {
            for (int j = 0; j < h.m; j++) {
                if (j > 0) s.append(indent + "(" + ")\n");
                s.append(toString(children[j].next, ht - 1, indent + "     "));
            }
        }
        return s.toString();
    }


    // comparison functions - make Comparable instead of Key to avoid casts
    private boolean less(Comparable k1, Comparable k2) {
        return k1.compareTo(k2) < 0;
    }

    private boolean eq(Comparable k1, Comparable k2) {
        return k1.compareTo(k2) == 0;
    }
}