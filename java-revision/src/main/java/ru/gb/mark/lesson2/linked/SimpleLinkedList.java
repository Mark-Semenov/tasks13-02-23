package ru.gb.mark.lesson2.linked;

import lombok.Data;

import java.util.*;


@Data
public class SimpleLinkedList<E> implements List<E> {

    private Node<E> first;
    private Node<E> current;
    private int size;
    private int cursor;


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        Node<E> node = first;

        if (Objects.isNull(first)) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (node.getItem().equals(o)) {
                return true;
            } else {
                node = node.next;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new BoxItr<>();
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        for (int i = 0; i < size; i++) {
            arr[i] = get(i);
        }
        return arr;
    }



    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {

        Node<E> newNode = new Node<>(e);

        if (Objects.nonNull(current)) {
            current.setNext(newNode);
            newNode.setPrev(current);
        }

        if (Objects.isNull(first)) {
            first = newNode;
        }

        current = newNode;

        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {

        if (!contains(o)) return false;
        if (removeFirst(o)) return true;


        Node<E> node = first;
        Node<E> prev;
        Node<E> next;


        while (true) {

            if (node.getItem().equals(o)) {
                next = node.next;
                prev = node.prev;

                if (Objects.nonNull(next)) {
                    prev.next = next;
                    next.prev = prev;
                }

                node.next = null;
                node.prev = null;

                size--;
                return true;
            } else {
                node = node.next;
            }
        }

    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        remove(getNodeByIdx(index).getItem());
        return null;
    }

    private boolean removeFirst(Object o) {

        Node<E> node;

        if (first.getItem().equals(o)) {

            if (Objects.isNull(first.next)) {
                first = null;
                size = 0;
            } else {
                node = first.next;
                first.next = null;
                first = node;
            }
            size--;
            return true;
        }
        return false;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(
                    String.format("Size: %d, Index: %d", size, index)
            );
        }

    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        Node<E> node = first;
        Node<E> temp;
        while (Objects.nonNull(node.next)) {
            temp = node.next;
            node.next = null;
            node.prev = null;
            node.item = null;
            node = temp;
        }
        node.prev = null;
        node.item = null;
        first = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return getNodeByIdx(index).getItem();
    }

    @Override
    public E set(int index, E element) {

        checkIndex(index);

        if (Objects.isNull(first)) {
            add(element);
            return first.getItem();
        }

        Node<E> node = getNodeByIdx(index);
        node.setItem(element);

        return node.getItem();
    }

    @Override
    public void add(int index, E element) {
        checkIndex(index);
        Node<E> newNode = new Node<>(element);

        if (Objects.isNull(first)) {
            add(element);
        } else {
            Node<E> node = getNodeByIdx(index);
            Node<E> prev = node.prev;
            prev.next = newNode;
            newNode.prev = prev;
            newNode.next = node;
            node.prev = newNode;
            size++;
        }

    }


    private Node<E> getNodeByIdx(int index) {
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }


    @Data
    private class BoxItr<T> implements Iterator<T> {

        private int cursor;

        @Override
        public boolean hasNext() {

            if (cursor >= size()) {
                cursor = 0;
                return false;
            }

            return true;
        }

        @Override
        @SuppressWarnings("unchecked")
        public T next() {
            return (T) get(cursor++);
        }

    }

    @Data
    private static class Node<E> {
        private E item;
        private Node<E> next;
        private Node<E> prev;

        public Node(E item) {
            this.item = item;
        }

    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Collection [");
        for (int i = 0; i < size; i++) {
            if (i != size - 1) {
                sb.append(get(i)).append(", ");
            } else {
                sb.append(get(i));
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
