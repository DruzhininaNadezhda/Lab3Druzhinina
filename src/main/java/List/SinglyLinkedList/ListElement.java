package List.SinglyLinkedList;

public class ListElement {
    //Делаем класс, описание каждой "клетки" в листе
    //данные
    char data;
    //ссылка на следующую клетку
    ListElement next;
    //ссылка клетку перед
    ListElement previous;

    public ListElement(char data, ListElement next) {
        this.data = data;
        this.next = next;
    }

    public ListElement(ListElement previous, char data, ListElement next) {
        this(data, next);
        this.previous = previous;
    }
}
