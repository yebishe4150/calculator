import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        try {
            System.out.println(calc(input));
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        scanner.close();
    }

    public static String calc(String input) throws Exception {
        String[] parts = input.split(" ");
        if (parts.length != 3) {
            throw new Exception("Неверный формат ввода");
        }

        int num1;
        int num2;
        String operator = parts[1];

        try {
            num1 = Integer.parseInt(parts[0]);
            num2 = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            throw new Exception("Неправильные числа");
        }

        if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
            throw new Exception("Числа должны быть от 1 до 10 включительно");
        }

        int result;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    throw new Exception("Деление на ноль");
                }
                result = num1 / num2;
                break;
            default:
                throw new Exception("Неверный оператор");
        }

        return String.valueOf(result);
    }
}
