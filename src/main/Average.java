package main;

import java.util.Arrays;
import java.util.List;

public class Average {

    public Integer getAverage(int[]array) {
        Integer average = (int) Arrays
                .stream(array)
                .summaryStatistics()
                .getAverage();
       return average;
   }
}

