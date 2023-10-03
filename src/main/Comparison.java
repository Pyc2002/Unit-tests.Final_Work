package main;

public class Comparison {
    public void getComparison(int averageFirst, int averageSecond) {
        if (averageFirst > averageSecond) {
            System.out.print("Первый список имеет большее среднее значение");
        } else if (averageFirst < averageSecond) {
            System.out.print("Второй список имеет большее среднее значение");
        }else System.out.print("Средние значения равны");
    }

}
