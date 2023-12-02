package List.SinglyLinkedList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class DoubleLinkedList implements Interface {
    private ListElement head;
    private ListElement tail;

    @Override
    public void addFirst(char data) {
        ListElement first = new ListElement(null, data, null);
        //проверка на пустоту и создание нового списка с головой из заданого элемента
        if (head == null) {
            head = tail = first;
        } else {
            head.previous = first;
            first.next = head;
            head = first;
        }
    }

    @Override
    public char getFirst() {
        return head != null ? head.data : 0;
    }

    @Override
    public char getFirstDelete() {
        char g = getFirst();
        if (head.next == null) {
            head = null;
        } else {
            head.next.previous = null;
            head = head.next;
        }
        return g;
    }

    @Override
    public void emptyList() {
        if (head == null) {
            System.out.println("Список пуст");
        }
        System.out.println("Список не пустой");
    }


    @Override
    public void addEnd(char data) {
        ListElement first = new ListElement(null, data, null);
        //проверка на пустоту и создание нового списка с головой из заданого элемента
        if (head == null) {
            head = tail = first;
        } else {
            tail.next = first;
            first.previous = tail;
            tail = first;
        }

    }

    @Override
    public char getEnd() {
        return head != null ? tail.data : 0;
    }

    @Override
    public char getEndDelete() {
        char g = getEnd();
        if (head != null) {
            ListElement node = head;
            while (node.next != null) {

                if (node.next.data == g) {
                    if (node.next == tail) {
                        tail = node;
                        node.next = null;
                        continue;
                    }
                }
                node = node.next;
            }
        }
        return g;
    }

    @Override
    public void delete(char data) {
        //проверка на пустоту
        if (head != null) {
            // данные в голове
            ListElement node = head;
            //цикл
            while (node.next != null) {
                //значение в голове
                if (head.data == data) {
                    head = head.next;
                    head.previous = null;
                }
                //соответствие значений
                if (node.next.data == data) {

                    //если это последние значение
                    if (node.next == tail) {
                        tail = node;
                        node.next = null;
                        continue;
                    }
                    // значение не последние

                    node.next = node.next.next;
                    node.next.previous = node;
                    continue;
                    // значение не совпало, просто завершается  IF и продолжается цикл
                }
                // шаг цикла
                node = node.next;
            }

        }
    }

    @Override
    public boolean yesOrNo(char data) {
        boolean g = false;
        if (head != null) {
            // данные в голове
            ListElement node = head;
            //цикл
            while (node != null) {
                //соответствие значений
                if (node.data == data) {
                    g = true;
                    break;
                }
                // шаг цикла
                node = node.next;
            }
        }
        return g;
    }

    @Override
    public void encrypt() {
        if (head != null) {
            ListElement node = head;
            int n = 1;
            //цикл
            while (node.next != null) {
                node.data = (char) (node.data + n);
                // шаг цикла
                node = node.next;
            }
        }
    }

    public void encryptBack() {
        if (head != null) {
            ListElement node = tail;
            int n = (char) 1;
            //цикл
            while (node.previous != null) {
                node.data = (char) (node.data + n);
                // шаг цикла
                node = node.previous;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        ListElement node = head;
        while (node != null) {
            sb.append(node.data);
            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public String backToString() {
        StringBuilder sb = new StringBuilder("[");
        ListElement temp = tail;
        while (temp != null) {
            sb.append(temp.data);
            temp = temp.previous;
        }
        sb.append("]");
        return sb.toString();
    }

    public void addArrayFirst(char[] chars) {
        for (int i = (chars.length - 1); (i + 1) > 0; i--) {
            ListElement first = new ListElement(null, chars[i], null);
            //проверка на пустоту и создание нового списка с головой из заданого элемента
            if (head == null) {
                head = tail = first;
            } else {
                head.previous = first;
                first.next = head;
                head = first;
            }
        }
    }

    public void addArrayEnd(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            ListElement first = new ListElement(null, chars[i], null);
            //проверка на пустоту и создание нового списка с головой из заданого элемента
            if (head == null) {
                head = tail = first;
            } else {
                tail.next = first;
                first.previous = tail;
                tail = first;
            }
        }
    }

    public void addListEnd(DoubleLinkedList list, DoubleLinkedList list2) {
        for (ListElement i = list2.head; i != null; i = i.next) {
            ListElement first = new ListElement(null, i.data, null);
            //проверка на пустоту и создание нового списка с головой из заданого элемента
            if (head == null) {
                head = tail = first;
            } else {
                tail.next = first;
                first.previous = tail;
                tail = first;
            }
            list2.head = null;
        }
    }

    public void addListFirst(DoubleLinkedList list, DoubleLinkedList list2) {
        for (ListElement i = list2.tail; i != null; i = i.previous) {
            ListElement first = new ListElement(null, i.data, null);
            //проверка на пустоту и создание нового списка с головой из заданого элемента
            if (head == null) {
                head = tail = first;
            } else {
                head.previous = first;
                first.next = head;
                head = first;
            }
            list2.head = null;
        }
    }

    public void addCollectionFirst(DoubleLinkedList list, ArrayList<Character> list7) {
        for (int i = (list7.size() - 1); (i + 1) > 0; i--) {
            ListElement first = new ListElement(null, list7.get(i), null);
            //проверка на пустоту и создание нового списка с головой из заданого элемента
            if (head == null) {
                head = tail = first;
            } else {
                head.previous = first;
                first.next = head;
                head = first;
            }
        }
    }

    public void addCollectionEnd(DoubleLinkedList list, ArrayList<Character> list7) {
        for (int i = 0; i < list7.size(); i++) {
            ListElement first = new ListElement(null, list7.get(i), null);
            //проверка на пустоту и создание нового списка с головой из заданого элемента
            if (head == null) {
                head = tail = first;
            } else {
                tail.next = first;
                first.previous = tail;
                tail = first;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoubleLinkedList that = (DoubleLinkedList) o;
        return Objects.equals(head, that.head) && Objects.equals(tail, that.tail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, tail);
    }

    @Override
    public Iterator iterator() {
        return new DoubleLinkedList.MyIterator(head);
    }

    private class MyIterator implements Iterator<Character> {
        ListElement head;
        ListElement current;

        public MyIterator(ListElement head) {
            this.head = head;
        }

        @Override
        public boolean hasNext() {
            current = current == null ? head : current.next;
            return current != null;
        }

        @Override
        public Character next() {
            return current != null ? current.data : null;
        }
    }

    public static void main(String[] args) {
        char[] chars = new char[]{'1', '2', '3'};
        ArrayList<Character> list3 = new ArrayList<Character>();
        list3.add('s');
        list3.add('f');
        DoubleLinkedList list = new DoubleLinkedList();
        list.addEnd('l');
        list.addFirst('a');
        list.addFirst('v');
        list.addFirst('a');
        list.addEnd('a');
        list.addFirst('j');
        list.addEnd('b');
        for (Object d : list) {
            if (list.yesOrNo('a')) {
                System.out.println(d);
                break;
            }
        }
    }
}
