package Lesson2;

public class MyArrayDataException extends NumberFormatException {

    MyArrayDataException(){
        super();
    }

    MyArrayDataException(int i, int j){
        super("Элемент расположенный в ячейке " + i + " " + j + " не парсится в int!");
    }

}
