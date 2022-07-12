package lesson9;
/**
 * Java Pro. lesson #8
 *
 * @author Igor Cijov
 * @version 05 Jul 2022
 */

import homework8.Cat;

import java.util.Iterator;

public class UseRubberList {
    public static void main(String[] args) {
        RubberList<Cat> rlStr = new RubberList();
        System.out.println(rlStr);
        rlStr.add(new Cat(1, 1));
        rlStr.add(new Cat(2, 2));
        rlStr.add(new Cat(3,3));
        System.out.println(rlStr);
    }
}

class RubberList<E> implements Iterable<E> {

    private int size = 0;

    private Node<E> first;

    private Node<E> last;

    //standart method
    public void add(E value) {
        if (first == null) {
            first = new Node<E>(null, value, null);
        } else if (last == null) {
            last = new Node<E>(first, value, null);
            first.next = last;
        } else {
            Node newLast = new Node<E>(last, value, null);
            last.next = newLast;
            last = newLast;
        }
        size++;
    }

    public boolean remove(int idx) {
        if (idx < size) {
            size--;
            if (idx == 0) {
                if (first.next == null) {
                    first = null;
                    return true;
                }
                Node newFirst = first.next;
                newFirst.prev = null;
                first = newFirst;
                return true;
            } else if (idx == size) {
                Node newLast = last.prev;
                newLast.next = null;
                last = newLast;
            } else {
                int index = 0;
                Node cursor = first;
                while (cursor != null) {
                    if (idx == index) {
                        Node prev = cursor.prev;
                        Node next = cursor.next;
                        prev.next = next;
                        next.prev = prev;
                        cursor.next = null;
                        cursor.prev = null;
                        return true;
                    }
                    cursor = cursor.next;
                    index++;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        Node cursor = first;
        while (cursor != null) {
            sb.append(cursor.item);
            if (cursor.next != null) {
                sb.append(", ");
            }
            cursor = cursor.next;
        }
        return sb.append("]").toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<E> {
        Node<E> cursor = first;

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public E next() {
            E value = cursor.item;
            cursor = cursor.next;
            return value;
        }
    }

    private class Node<E> {
        E item;
        Node next;
        Node prev;

        public Node(Node prev, E item, Node next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
}
