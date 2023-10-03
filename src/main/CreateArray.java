package main;

import java.util.Arrays;
import java.util.Random;

public class CreateArray {
    private GetSize getSize;

    public CreateArray() {
        getSize = new GetSize();
    }

    public int[] inputArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = new Random().nextInt(20);
        }

        return array;
    }
}