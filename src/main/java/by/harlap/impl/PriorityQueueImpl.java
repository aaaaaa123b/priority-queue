package by.harlap.impl;

import by.harlap.PriorityQueue;

import java.util.Arrays;
import java.util.Comparator;

public class PriorityQueueImpl<T> implements PriorityQueue<T> {

    private static final int DEFAULT_CAPACITY = 8;
    private T[] heap;
    int size = 0;
    private final Comparator<T> comparator;

    @SuppressWarnings("unchecked")
    public PriorityQueueImpl() {
        this((Comparator<T>) Comparator.naturalOrder());
    }

    @SuppressWarnings("unchecked")
    public PriorityQueueImpl(Comparator<T> comparator) {
        this.comparator = comparator;
        heap = (T[]) new Object[DEFAULT_CAPACITY];
    }

    private void swap(int i, int j) {
        T temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void siftDown(int i) {
        int left;
        int right;
        int smallest;

        while (true) {

            left = 2 * i + 1;
            right = 2 * i + 2;
            smallest = i;

            if (left < size && comparator.compare(heap[left], heap[smallest]) < 0) {
                smallest = left;
            }

            if (right < size && comparator.compare(heap[right], heap[smallest]) < 0) {
                smallest = right;
            }

            if (smallest != i) {
                swap(i, smallest);
                i = smallest;
            } else {
                break;
            }
        }
    }

    private void siftUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (comparator.compare(heap[index], heap[parentIndex]) < 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    public void add(T key) {
        if (!Comparable.class.isAssignableFrom(key.getClass())) {
            throw new IllegalArgumentException("Item you've added must implement Comparable interface");
        }
        if (size >= heap.length) {
            resizeHeap();
        }
        heap[size] = key;
        siftUp(size);
        size++;
    }


    public T poll() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        T root = heap[0];
        heap[0] = heap[size - 1];
        size--;
        siftDown(0);
        return root;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }
        return heap[0];
    }

    private void resizeHeap() {
        heap = Arrays.copyOf(heap, heap.length * 2);
    }

    public boolean isEmpty() {
        return size == 0;
    }

}


