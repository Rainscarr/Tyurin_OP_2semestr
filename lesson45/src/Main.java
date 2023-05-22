import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество лет: ");
        int arabicYear = scanner.nextInt();
        scanner.close();

        String romanYear = convertToRoman(arabicYear);

        System.out.println("Римское представление: " + romanYear);
    }

    private static String convertToRoman(int year) {
        if (year <= 0 || year >= 10000) {
            throw new IllegalArgumentException("Недопустимое значение года: " + year);
        }
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] units = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        StringBuilder roman = new StringBuilder();

        roman.append(thousands[year / 1000]); 
        roman.append(hundreds[(year % 1000) / 100]);
        roman.append(tens[(year % 100) / 10]);
        roman.append(units[year % 10]);

        return roman.toString();
    }
}
