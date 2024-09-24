import java.util.Scanner;

public class Dodecaedr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        
        System.out.print("Введите длину ребра додекаэдра: "); 
        double a = scanner.nextDouble();

        scanner.close(); 

        System.out.printf("Объём додекаэдра: %.4f\n", ((15 + 7 * Math.sqrt(5)) / 4) * Math.pow(a, 3)); 
    }
}