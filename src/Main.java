
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {

            int n = 0;
            int High = 0;
            int Lov = 0;

            // Введення розміру масиву
            while (true) {
                System.out.println("Введіть n:");
                if (scan.hasNextInt()) {
                    n = scan.nextInt();
                    if (n > 0) break;
                    else System.out.println("Розмір масиву повинен бути додатнім.");
                } else {
                    System.out.println("Помилка: введене значення не є числом. Спробуйте ще раз.");
                    scan.next(); // Очищення неправильного вводу
                }
            }

            // Введення максимального значення
            while (true) {
                System.out.print("Введіть максимальне значення = ");
                if (scan.hasNextInt()) {
                    High = scan.nextInt();
                    break;
                } else {
                    System.out.println("Помилка: введене значення не є числом. Спробуйте ще раз.");
                    scan.next(); // Очищення неправильного вводу
                }
            }

            // Введення мінімального значення
            while (true) {
                System.out.print("Введіть мінімальне значення = ");
                if (scan.hasNextInt()) {
                    Lov = scan.nextInt();
                    if (Lov > High) {
                        System.out.println("Помилка: мінімальне значення не повинно бути більшим за максимальне.");
                    } else {
                        break;
                    }
                } else {
                    System.out.println("Помилка: введене значення не є числом. Спробуйте ще раз.");
                    scan.next(); // Очищення неправильного вводу
                }
            }

            // Генерація масиву
            int[] mas = readArray(n, High, Lov);

            // Обчислення результатів
            int maxAbsIndex = findMaxAbsIndex(mas);
            int productAfterFirstPositive = productAfterFirstPositive(mas);

            // Виведення елементів масиву
            printArray(mas);

            // Виведення результатів
            System.out.println("Номер максимального за модулем елемента: " + maxAbsIndex);
            System.out.println("Добуток елементів після першого додатного: " + productAfterFirstPositive);

            // Продовження або завершення
            System.out.println("Чи бажаєте ви продовжити?");
            String esno = scan.next();
            if (esno.equalsIgnoreCase("так")) {
                continue;
            } else if (esno.equalsIgnoreCase("ні")) {
                break;
            } else {
                System.out.println("Помилка: дайте відповідь 'так' або 'ні'.");
                esno = scan.next();
                if (esno.equalsIgnoreCase("ні")) {
                    break;
                }
            }
        }
    }

    // Генерація масиву випадкових чисел
    public static int[] readArray(int n, int High, int Lov) {
        Random r = new Random();
        int[] mas = new int[n];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = r.nextInt(High - Lov + 1) + Lov;
        }
        return mas;
    }

    // Виведення елементів масиву
    public static void printArray(int[] mas) {
        System.out.print("Масив: ");
        for (int i = 0; i < mas.length; i++) {
            System.out.print(mas[i] + "\t");
        }
        System.out.println();
    }

    // Знаходження індексу максимального за модулем елемента
    public static int findMaxAbsIndex(int[] mas) {
        int maxAbsIndex = 0; // Індекс максимального за модулем елемента
        for (int i = 1; i < mas.length; i++) {
            if (Math.abs(mas[i]) > Math.abs(mas[maxAbsIndex])) {
                maxAbsIndex = i;
            }
        }
        return maxAbsIndex;
    }

    // Обчислення добутку елементів після першого додатного
    public static int productAfterFirstPositive(int[] mas) {
        int product = 1;
        boolean foundPositive = false;

        for (int i = 0; i < mas.length; i++) {
            if (foundPositive) {
                product *= mas[i];
            } else if (mas[i] > 0) {
                foundPositive = true;
            }
        }

        // Якщо не знайдено додатних елементів, повертаємо 0
        return foundPositive ? product : 0;
    }
}