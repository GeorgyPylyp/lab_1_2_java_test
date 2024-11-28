import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Main2Test {

    @Test
    void testFindMinMax() {
        // Тест 1: масив з позитивними числами
        int[] array1 = {3, 7, 1, 9, 4};
        int[] expected1 = {1, 9}; // Мінімум: 1, Максимум: 9
        assertArrayEquals(expected1, Main_2.findMinMax(array1), "Тест 1 провалено");

        // Тест 2: масив з від'ємними числами
        int[] array2 = {-5, -1, -7, -3};
        int[] expected2 = {-7, -1}; // Мінімум: -7, Максимум: -1
        assertArrayEquals(expected2, Main_2.findMinMax(array2), "Тест 2 провалено");

        // Тест 3: змішані позитивні та від'ємні числа
        int[] array3 = {-10, 0, 5, -2, 8};
        int[] expected3 = {-10, 8}; // Мінімум: -10, Максимум: 8
        assertArrayEquals(expected3, Main_2.findMinMax(array3), "Тест 3 провалено");

        // Тест 4: всі елементи однакові
        int[] array4 = {5, 5, 5, 5};
        int[] expected4 = {5, 5}; // Мінімум: 5, Максимум: 5
        assertArrayEquals(expected4, Main_2.findMinMax(array4), "Тест 4 провалено");

        // Тест 5: масив з одним елементом
        int[] array5 = {42};
        int[] expected5 = {42, 42}; // Мінімум: 42, Максимум: 42
        assertArrayEquals(expected5, Main_2.findMinMax(array5), "Тест 5 провалено");
    }
}
