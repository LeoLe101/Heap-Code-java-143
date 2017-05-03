package cs143;

import java.util.ArrayList;

public final class Heap<E extends Comparable<E>> {

    private ArrayList<E> list;

    /**
     * Create a default heap
     */
    public Heap() {
        this.list = new ArrayList<>();
    }

    /**
     * Create a heap from an array of objects
     *
     * @param objects elements to add to the heap
     */
    public Heap(E[] objects) {
        this.list = new ArrayList<>();
        for (E object : objects) {
            add(object);
        }
    }

    /**
     * Add a new object into the heap
     *
     * @param newObject object to add to the heap
     */
    public void add(E newObject) {
        list.add(newObject); // Append to the heap
        int currentIndex = list.size() - 1; // The index of the last node

        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            // Swap if the current object is greater than its parent
            if (list.get(currentIndex).compareTo(
                    list.get(parentIndex)) > 0) {
                E temp = list.get(currentIndex);
                list.set(currentIndex, list.get(parentIndex));
                list.set(parentIndex, temp);
            } else {
                break; // the tree is a heap now
            }
            currentIndex = parentIndex;
        }
    }

    /**
     * Remove the root from the heap
     *
     * @return the element removed
     */
    public E remove() {
        if (list.isEmpty()) {
            return null;
        }
        E removedObject = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);
        boolean done = true;
        int curr = 0;
        int leftChild = 2 * curr + 1;
        int rightChild = 2 * curr + 2;
        while (!done) {
            if (list.get(leftChild).compareTo(list.get(rightChild)) < 0) {
                if (list.get(curr).compareTo(list.get(rightChild)) < 0) {
                    swap(list.get(curr), list.get(rightChild));
                    curr = rightChild;
                }
            } else if (list.get(rightChild).compareTo(list.get(leftChild)) <= 0){
                if (list.get(curr).compareTo(list.get(leftChild)) < 0) {
                    swap(list.get(curr), list.get(leftChild));
                    curr = leftChild;
                }
            } else {
                done = false;
            }
        }
        return removedObject;
    }

    public void swap(E curr, E child) {
        E temp = curr;
        curr = child;
        child = temp;
    }

    /**
     * Get the number of nodes in the tree
     *
     * @return the number of elements
     */
    public int getSize() {
        return list.size();
    }

    @Override
    public String toString() {
        return "Heap{" + "list=" + list + '}';
    }
    
    
}
