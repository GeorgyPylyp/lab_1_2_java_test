import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class MainTest {

    @Test
    public void testReadArray() {
        int n = 5;
        int low = -100;
        int high = 100;

        int[] array = Main.readArray(n, high, low);

        // Перевіряємо довжину масиву
        assertEquals(n, array.length);

        // Перевіряємо, чи всі значення в межах [low, high]
        for (int value : array) {
            assertTrue(value >= low && value <= high, "Element is out of range");
        }
    }

    @Test
    public void testFindMaxAbsIndex() {
        int[] array = { -3, -10, 7, 2, 5 };

        int expectedIndex = 1; // Елемент -10 має найбільший модуль
        assertEquals(expectedIndex, Main.findMaxAbsIndex(array));
    }

    @Test
    public void testProductAfterFirstPositive() {
        // Тест для масиву з додатними елементами
        int[] array = { -3, 4, -2, 3 };
        int expectedProduct = -6; // Добуток елементів після першого додатного: -2 * 3
        assertEquals(expectedProduct, Main.productAfterFirstPositive(array));

        // Тест для масиву без додатних елементів
        array = new int[] { -3, -2, -1 };
        expectedProduct = 0; // Якщо немає додатних елементів, результат 0
        assertEquals(expectedProduct, Main.productAfterFirstPositive(array));

        // Тест для масиву з одним елементом
        array = new int[] { 5 };
        expectedProduct = 1; // Немає елементів після першого додатного
        assertEquals(expectedProduct, Main.productAfterFirstPositive(array));
    }

    @Test
    public void testPrintArray() {
        // Перевіряємо, чи метод виводить масив без помилок
        int[] array = {1, 2, 3};

        // Перевірка візуальна, оскільки `printArray` друкує в консоль
        // Для автоматичного тестування можна захопити вивід за допомогою Stream
        assertDoesNotThrow(() -> Main.printArray(array));
    }
}
