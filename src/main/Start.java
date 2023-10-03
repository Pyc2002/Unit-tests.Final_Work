package main;

import java.util.Arrays;

public class Start {
    private CreateArray createArray;
    private Average average;
    private Comparison comparison;
    private GetSize getSize;

    public Start() {
        createArray = new CreateArray();
        average = new Average();
        comparison = new Comparison();
        getSize = new GetSize();
    }

    public int average() {
        int[] array = createArray.inputArray(getSize.getSize());
        System.out.println(Arrays.toString(array));
        return average.getAverage(array);
    }

    public void start(int firstAverage, int secondAverage) {
        comparison.getComparison(firstAverage, secondAverage);
    }

    public void setCreateArray(CreateArray createArray) {
        this.createArray = createArray;
    }

    public void setGetSize(GetSize getSize) {
        this.getSize = getSize;
    }
}
