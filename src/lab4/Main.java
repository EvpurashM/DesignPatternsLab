package lab4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Лабораторна робота №4: Лямбда вирази ---");

        // 1. Відфільтрувати непарні числа [cite: 27]
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        System.out.println("1. Непарні числа: " + filterOddNumbers(numbers1));

        // 2. Знайти середнє зі списку дійсних значень [cite: 28]
        List<Double> doubles = Arrays.asList(1.5, 2.5, 3.5, 4.5);
        System.out.println("2. Середнє значення: " + calculateAverage(doubles));

        // 3. Сортування списку рядків в алфавітному порядку [cite: 29]
        List<String> words3 = Arrays.asList("Яблуко", "Банан", "Апельсин", "Вишня");
        System.out.println("3. За алфавітом: " + sortAlphabetically(words3));

        // 4. Обчислення суми всіх парних чисел [cite: 30]
        List<Integer> numbers4 = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println("4. Сума парних чисел: " + sumOfEvenNumbers(numbers4));

        // 5. Обчислити факторіал заданого числа [cite: 31]
        int n = 5;
        System.out.println("5. Факторіал числа " + n + ": " + calculateFactorial(n));

        // 6. Розрахувати множення та підсумовування [cite: 32]
        List<Integer> numbers6 = Arrays.asList(2, 3, 4);
        long[] sumAndProduct = multiplyAndSum(numbers6);
        System.out.println("6. Сума: " + sumAndProduct[0] + ", Добуток: " + sumAndProduct[1]);

        // 7. Розрахувати квадрат кожного числа [cite: 33]
        List<Integer> numbers7 = Arrays.asList(1, 2, 3, 4);
        System.out.println("7. Квадрати чисел: " + calculateSquares(numbers7));

        // 8. Сортування рядків на основі їх довжини [cite: 33]
        List<String> words8 = Arrays.asList("Кіт", "Собака", "Слон", "Їжак");
        System.out.println("8. За довжиною: " + sortByLength(words8));

        // 9. Підрахувати кількість слів у реченні [cite: 34]
        String sentence = "Привіт світ це тест лямбда виразів";
        System.out.println("9. Кількість слів у реченні: " + countWords(sentence));

        // 10. Знайти перший непорожній рядок [cite: 35]
        List<String> words10 = Arrays.asList("", "   ", "Перший непорожній", "Другий");
        System.out.println("10. Перший непорожній: " + findFirstNonEmpty(words10));

        // 11. Перевірити, чи всі рядки починаються з великої літери [cite: 36]
        List<String> words11 = Arrays.asList("Київ", "Львів", "Одеса");
        System.out.println("11. Всі з великої літери? " + checkAllStartWithCapital(words11));

        // 12. Знайти друге за величиною число [cite: 37]
        List<Integer> numbers12 = Arrays.asList(10, 20, 30, 20, 5);
        System.out.println("12. Друге за величиною: " + findSecondLargest(numbers12));

        // 13. Знайти найбільше парне число [cite: 37]
        List<Integer> numbers13 = Arrays.asList(3, 7, 8, 12, 5, 12);
        System.out.println("13. Найбільше парне: " + findLargestEven(numbers13));
    }

    // --- МЕТОДИ ДЛЯ КОЖНОГО ЗАВДАННЯ ---

    // 1. Відфільтрувати непарні числа [cite: 27]
    public static List<Integer> filterOddNumbers(List<Integer> list) {
        return list.stream().filter(num -> num % 2 != 0).collect(Collectors.toList());
    }

    // 2. Середнє дійсних значень [cite: 28]
    public static double calculateAverage(List<Double> list) {
        return list.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    // 3. Сортування рядків за алфавітом [cite: 29]
    public static List<String> sortAlphabetically(List<String> list) {
        return list.stream().sorted().collect(Collectors.toList());
    }

    // 4. Сума парних чисел [cite: 30]
    public static int sumOfEvenNumbers(List<Integer> list) {
        return list.stream().filter(num -> num % 2 == 0).mapToInt(Integer::intValue).sum();
    }

    // 5. Факторіал [cite: 31]
    public static long calculateFactorial(int n) {
        if (n < 0) return 0;
        return LongStream.rangeClosed(1, n).reduce(1, (a, b) -> a * b);
    }

    // 6. Множення та підсумовування [cite: 32]
    public static long[] multiplyAndSum(List<Integer> list) {
        long sum = list.stream().mapToLong(Integer::longValue).sum();
        long product = list.stream().mapToLong(Integer::longValue).reduce(1, (a, b) -> a * b);
        return new long[]{sum, product}; // Повертаємо масив з двох елементів
    }

    // 7. Квадрат кожного числа [cite: 33]
    public static List<Integer> calculateSquares(List<Integer> list) {
        return list.stream().map(num -> num * num).collect(Collectors.toList());
    }

    // 8. Сортування за довжиною [cite: 33]
    public static List<String> sortByLength(List<String> list) {
        return list.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
    }

    // 9. Кількість слів у реченні [cite: 34]
    public static long countWords(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) return 0;
        return Arrays.stream(sentence.trim().split("\\s+")).count();
    }

    // 10. Перший непорожній рядок [cite: 35]
    public static String findFirstNonEmpty(List<String> list) {
        return list.stream().filter(s -> s != null && !s.trim().isEmpty()).findFirst().orElse("Не знайдено");
    }

    // 11. Чи всі починаються з великої [cite: 36]
    public static boolean checkAllStartWithCapital(List<String> list) {
        return list.stream().allMatch(s -> s != null && !s.isEmpty() && Character.isUpperCase(s.charAt(0)));
    }

    // 12. Друге за величиною число [cite: 37]
    public static Integer findSecondLargest(List<Integer> list) {
        return list.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(null);
    }

    // 13. Найбільше парне число [cite: 37]
    public static Integer findLargestEven(List<Integer> list) {
        return list.stream().filter(num -> num % 2 == 0).max(Integer::compareTo).orElse(null);
    }
}