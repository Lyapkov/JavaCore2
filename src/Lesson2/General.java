package Lesson2;

public class General {

    public static void main(String[] args){
        String[][] arr1 = {{"3", "4", "5", "1"}, {"6", "12", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}};
        String[][] arr2 = {{"3", "5", "1"}, {"6", "12", "1", "df"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}};
        String[][] arr3 = {{"3", "4", "5", "1"}, {"6", "12", "1", "df"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}};

        try {
            System.out.println(parseArray(arr1));
            System.out.println(parseArray(arr2));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e);
        }

        try {
            System.out.println(parseArray(arr3));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e);
        }
    }

    private static int parseArray(String[][] array) throws MyArraySizeException {
        if (array.length != 4)
            throw new MyArraySizeException("Двумерный массив должен быть размером 4x4!");
        else
            for (int i = 0; i < array.length; i++){
                if (array[i].length != 4)
                    throw new MyArraySizeException("Двумерный массив должен быть размером 4x4!");
            }
        int sum = 0;
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e){
                    throw new MyArrayDataException(i, j);
                }

            }
        }
        return sum;
    }
}
