
import main.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MyTests {
    private Average average;
    private Comparison comparison;
    private GetSize getSize;
    private CreateArray createArray;
    private Start start;


    @BeforeEach
    void setUp() {
        average = new Average();
        comparison = new Comparison();
        getSize = new GetSize();
        createArray = new CreateArray();
        start = new Start();
    }

    @Test
    void averagePositiveTest() {
        int[] array = {3, 3, 3};
        assertEquals(average.getAverage(array), 3);
    }


    @Test
    void comparisonMoreTest() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        comparison.getComparison(5, 3);

        assertEquals("Первый список имеет большее среднее значение", output.toString());
        System.setOut(null);
    }

    @Test
    void comparisonLessTest() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        comparison.getComparison(3, 5);

        assertEquals("Второй список имеет большее среднее значение", output.toString());
        System.setOut(null);
    }

    @Test
    void comparisonEqualTest() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        comparison.getComparison(3, 3);

        assertEquals("Средние значения равны", output.toString());
        System.setOut(null);
    }


    @Test
    void getSizeTest() {
        int size = getSize.getSize();

        assertTrue(size >= 1 && size <= 10, "Результат getSize() не в диапазоне [1, 10]");
    }

    @Test
    void InputArrayTest() {
        GetSize getSize1 = mock(GetSize.class);

        when(getSize1.getSize()).thenReturn(5); // Замените 5 на желаемое значение
        int[] resultArray = createArray.inputArray(getSize1.getSize());

        assertNotNull(resultArray, "Массив не должен быть null");
        assertEquals(5, resultArray.length, "Длина массива должна быть равна 5");
        for (int value : resultArray) {
            assertTrue(value >= 0 && value < 20, "Значения в массиве должны быть в диапазоне [0, 20)");
        }
    }

    @Test
    void startTest() {
        CreateArray createArrayMock = mock(CreateArray.class);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        when(createArrayMock.inputArray(3)).thenReturn(new int[]{3, 3, 3})
                .thenReturn(new int[]{2, 2, 2});
        int firstAverage = average.getAverage(createArrayMock.inputArray(3));
        int secondAverage = average.getAverage(createArrayMock.inputArray(3));
        start.start(firstAverage, secondAverage);


        assertEquals("Первый список имеет большее среднее значение", outputStream.toString().trim());
    }

    @Test
    void averageTest() {
        CreateArray createArrayMock = mock(CreateArray.class);
        GetSize getSizeMock = mock(GetSize.class);
        start.setCreateArray(createArrayMock);
        start.setGetSize(getSizeMock);

        when(getSizeMock.getSize()).thenReturn(3);
        when(createArrayMock.inputArray(3)).thenReturn(new int[]{2, 2, 2});

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        int result = start.average();


        String consoleOutput = outputStream.toString().trim();
        assertTrue(consoleOutput.contains(Arrays.toString(new int[]{2, 2, 2})));

        assertEquals(2, result);
    }
    @Test
    void mainTest(){
        Start startMock = mock(Start.class);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        when(startMock.average()).thenReturn(15)
                                .thenReturn(15);
        start.start(startMock.average(),startMock.average());

        assertEquals("Средние значения равны", outputStream.toString().trim());
    }
}
