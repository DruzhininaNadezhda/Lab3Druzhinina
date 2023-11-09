package List.SinglyLinkedList;

public class ListElement{
    //Делаем класс, описание каждой "клетки" в листе
    //данные
    char data;
    //ссылка на следующую клетку
    ListElement next;
    //ссылка клетку перед
    ListElement previous;
   private char [] data1 = new char[10];

    public char[] getData1() {
        return data1;
    }

    public void setData1(char[] data1, char data) {
        if (data1.length > 10){
            data1 = new char[]{data};
        } for (int i = 0; i < data1.length; i++) {
            if (data1[i] == 0) {
                data1[i] = data;
            }
        }
    }

    public ListElement(char data, ListElement next) {
        this.data = data;
        this.next = next;
    }

    public ListElement(ListElement previous, char data, ListElement next) {
        this(data, next);
        this.previous = previous;
    }
    public ListElement (char [] data1, ListElement next){
        setData1(data1,data);
        this.next = next;
    }
    public char print() {
        return data;
    }
}
