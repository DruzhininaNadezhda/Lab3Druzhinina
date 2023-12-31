package List.SinglyLinkedList;


import java.util.Iterator;
import java.util.Objects;

public class LinkedList  implements Interface {
    private ListElement head;
    private ListElement tail;

    @Override
    public void addFirst(char data) {
        //проверка на пустоту и создание нового списка с головой из заданого элемента
        ListElement a = new ListElement(data, null);
        if (head == null) {
            head = tail = a;
        } else {
            // голова делает шаг назад
            a.next = head;
            // данные становятся на место головы
            head = a;
        }
    }

    @Override
    public char getFirst() {
        return head != null ? head.data : 0;
    }

    @Override
    public char getFirstDelete() {
        char g = getFirst();
        if (head != null) {
            // данные в голове
            if (head.data == g) {
                head = head.next;
            }
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
        //проверка на пустоту и создание нового списка с головой из заданого элемента
        ListElement a = new ListElement(data, null);
        if (tail == null) {
            head = tail = a;
        } else {
            tail.next = a;
            tail = a;
        }
    }

    @Override
    public char getEnd() {
        return tail != null ? tail.data : head.data;
    }

    @Override
    public char getEndDelete() {
        char g = getEnd();
        if (head != null) {
            // данные в голове
            ListElement node = head;
            //цикл
            while (node.next != null) {
                if (node.next.data == g) {
                }
                if (node.next == tail) {
                    tail = node;
                    node.next = null;
                    continue;
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
                }
                //соответствие значений
                if (node.next.data == data) {
                    //если это последние значение
                    if (node.next == tail) {
                        tail = node;
                        continue;
                    }
                    // значение не последние
                    node.next = node.next.next;
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

    public void encrypt() {
        if (head != null) {
            ListElement node = head;
            int n = 1;
            //цикл
            while (node != null) {
                node.data = (char) (node.data + n);
                // шаг цикла
                node = node.next;
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

    @Override
    public Iterator <Character>  iterator() {
        return new MyIterator(head);
    }

    private class MyIterator implements Iterator {
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
        LinkedList list = new LinkedList();
        //list.addEnd('l');
        list.addFirst('v');
        list.addFirst('a');
        //list.addFirst('j');
        list.addEnd('a');
        list.addFirst('j');
        //list.addEnd('b');
        System.out.println(list);
        //System.out.println(list.getFirstDelete());
        //System.out.println(list.getEndDelete());
        //list.delete('a');
        //System.out.println(list.yesOrNo('b'));
        //System.out.println(list);
        //list.encrypt();
        //list.emptyList();
        //System.out.println(list);
        //System.out.println(list.tail.print());
        for (Object d : list) {
            System.out.println(d);
        }
        System.out.println("\t");
        for (Object d : list) {
            if (list.yesOrNo('v')) {
                list.delete((Character) d);
                System.out.println(2);}

            }System.out.println(list);
        }
    }
