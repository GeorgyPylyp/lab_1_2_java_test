import java.util.Scanner;
import java.util.Random;

public class Main_2 {

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

            // Обчислення максимального та мінімального елементів
            int[] minMax = findMinMax(mas);

            // Виведення елементів масиву
            printArray(mas);

            // Виведення результатів
            System.out.println("Максимальний елемент: " + minMax[1]);
            System.out.println("Мінімальний елемент: " + minMax[0]);

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

    // Пошук максимального та мінімального елементів
    public static int[] findMinMax(int[] mas) {
        int min = mas[0];
        int max = mas[0];

        for (int i = 1; i < mas.length; i++) {
            if (mas[i] < min) {
                min = mas[i];
            }
            if (mas[i] > max) {
                max = mas[i];
            }
        }

        return new int[]{min, max};
    }
}
