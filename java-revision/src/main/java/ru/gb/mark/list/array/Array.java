package ru.gb.mark.list.array;

import lombok.Data;

import java.util.*;

@Data
public class Array<E> implements List<E> {

    private E element;
    private final int DEFAULT_SIZE = 5;
    private int pos = 0;
    private int cursor = 0;
    private Object[] box;


    public Array(int size) {
        this.box = new Object[size];
    }

    public Array() {
        box = new Object[DEFAULT_SIZE];
    }

    @Override
    public int size() {
        return getNonNullArray().length;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        return Arrays.asList(box).contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return new BoxItr<>();
    }


    @Override
    public Object[] toArray() {
        setBox(getNonNullArray());
        return box;
    }

    private int resizeArray() {
        return box.length + (box.length >> 1);
    }


    @Override
    public synchronized boolean add(E o) {

        this.element = o;

        if (pos >= box.length) {
            box = Arrays.copyOf(box, resizeArray() + 1);
        }

        this.box[pos] = o;
        pos++;

        return true;
    }


    @Override
    @SuppressWarnings("unchecked")
    public synchronized void add(int index, E element) {
        this.element = element;

        if (Objects.nonNull(box[index])) {
            add((E) box[index]);
        }

        if (contains(null)) {
            setBox(toArray());
        }
        box[index] = element;

    }


    @Override
    public boolean remove(Object o) {

        int idx = indexOf(o);

        if (idx >= 0) {
            remove(idx);
        } else return false;

        return true;
    }


    @Override
    @SuppressWarnings("unchecked")
    public synchronized E remove(int index) {
        Objects.checkIndex(index, box.length);
        Object o = box[index];
        cursor = index;
        box[index] = null;

        if (index > 0 && index < box.length) {
            cursor--;
        }
        return (E) o;
    }


    private Object[] getNonNullArray() {
        return Arrays.stream(box)
                .filter(Objects::nonNull)
                .toArray();
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {
        box = new Object[DEFAULT_SIZE];
    }

    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        Objects.checkIndex(index, box.length);
        return (E) box[index];
    }

    @Override
    public E set(int index, Object element) {
        Objects.checkIndex(index, box.length);
        box[index] = element;
        return get(index);
    }


    @Override
    public int indexOf(Object o) {
        int idx = -1;
        for (int i = 0; i < box.length; i++) {
            if (Objects.nonNull(get(i)) && get(i).equals(o)) {
                return i;
            }
        }

        return idx;
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
    @SuppressWarnings("unchecked")
    public List<E> subList(int fromIndex, int toIndex) {
        if (toIndex > box.length) {
            toIndex = box.length - 1;
        }
        List<E> arr = new Array<>(box.length - (toIndex - fromIndex + 1));
        for (int i = fromIndex; i <= toIndex; i++) {
            arr.add((E) box[i]);
        }
        return arr;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object[] toArray(Object[] a) {
        box = a;
        return getNonNullArray();
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }


    @Data
    private class BoxItr<T> implements Iterator<T> {

        private int cursor;
        private Object[] box;

        public BoxItr() {
            box = toArray();
        }

        @Override
        public boolean hasNext() {

            if (cursor >= box.length) {
                cursor = 0;
                return false;
            }

            return true;
        }

        @Override
        @SuppressWarnings("unchecked")
        public T next() {
            return (T) box[cursor++];
        }

    }
}
