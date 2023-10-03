package main;

import java.util.*;

public class GetSize {
//    private Scanner scanner;
//
//
//    public GetSize(){
//        scanner = new Scanner(System.in);
//
//    }

    public int getSize() {
        return (int) (1 + Math.random() * 10);
    }

//    public int getSize() {
//        System.out.print("Введите размер массива: ");
//        String size = scanner.next();
//        if (Objects.equals(size, "0") || !size.matches("[-+]?\\d+")) {
//            try {
//                throw new NoSuchElementException("Введены не цифры или 0");
//            } catch (NullPointerException e) {
//                throw new NoSuchElementException("Введены не цифры или 0");
//            }
//        }
//        return Integer.parseInt(size);
//    }
}
