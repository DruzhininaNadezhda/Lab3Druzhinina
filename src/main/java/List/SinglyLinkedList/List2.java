package List.SinglyLinkedList;
import java.util.ArrayList;
import java.util.Objects;

public class List2 implements Interface {
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
        return tail != null ? tail.data : head.data;
    }

    @Override
    public char getEndDelete() {
        char g = getEnd();
        delete(g);
        return g;
    }

    @Override
    public void delete(char data) {
        //проверка на пустоту
        if (head != null) {
            // данные в голове
            ListElement node = head;
            //цикл
            while (node.next!= null) {
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
            int n =(char) 1;
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
    public void addArrayFirst (char [] chars) {
        for (int i = (chars.length-1); (i+1) > 0; i--) {
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
    public void addArrayEnd (char [] chars) {
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
    public void addListEnd (List2 list, List2 list2) {
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
    public void addListFirst (List2 list, List2 list2) {
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
    public void addCollectionFirst (List2 list, ArrayList <Character> list7) {
        for (int i = (list7.size()-1); (i+1) > 0; i--) {
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
    public void addCollectionEnd (List2 list, ArrayList <Character> list7) {
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
    public static void main(String[] args) {
       char [] chars = new char[] {'1','2','3'};
        ArrayList <Character> list3 = new ArrayList <Character> ();
        list3.add('s');
        list3.add('f');
        List2 list = new List2();
        list.addEnd('l');
        list.addFirst('a');
        list.addFirst('v');
        list.addFirst('a');
        list.addEnd('a');
        list.addFirst('j');
        list.addEnd('b');
        List2 list2 = new List2();
        list2.addEnd('l');
        list2.addFirst('a');
        list2.addFirst('v');
        list2.addFirst('a');
        list2.addEnd('a');
        list2.addFirst('j');
        list2.addEnd('b');
        //System.out.println(list.getEnd());
        //System.out.println(list.getFirst());
        //System.out.println(list.getFirstDelete());
        //System.out.println(list.getEndDelete());
        //list.delete('a');
        //System.out.println(list.yesOrNo('a'));
        //list.encrypt();
        //list.emptyList();
        //list.addArrayEnd(chars);
        System.out.println(list2);
        System.out.println(list3);
        list2.addCollectionEnd(list2, list3);
        //list.encryptBack();
        //System.out.println(list2);
        //System.out.println(list.backToString());
        //list.addListFirst(list, list2);
        System.out.println(list2);
        //System.out.println(list.backToString());
        //System.out.println(list2);
    }
}
