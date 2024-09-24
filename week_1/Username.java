import java.util.Scanner;

public class Username {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in); // Чтение ввода с клавиатуры с помощью Scanner
        
        System.out.print("Введите ваше имя: "); // Ввод имени
        String username = scanner.nextLine();

        System.out.println("Привет, " + username + "!"); // Вывод "Привет, имя!"

        scanner.close(); // Закрываем Scanner
    }
}