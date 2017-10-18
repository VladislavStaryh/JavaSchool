package exceptionHandling_05;

import java.net.ConnectException;
import java.rmi.server.ServerNotActiveException;
import java.util.Scanner;

public class Client {
    private Terminal terminal = new Terminal();
    void work() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите операцию:");
            System.out.println("1 - Ввести пин-код");
            System.out.println("2 - Проверить состояние счёта");
            System.out.println("3 - Положить деньги");
            System.out.println("4 - Снять деньги");
            System.out.println("5 - Завершить работу с терминалом");
            System.out.print("> ");

            int operation = scanner.nextInt();

            try {
                if (operation == 1) {
                    terminal.validatePin(scanner.next());
                }
                if (operation == 2) {
                    System.out.println("Состояние Вашего счёта: " + terminal.checkAccount() + " рублей");
                }
                if (operation == 3) {
                    terminal.putCash(scanner.nextFloat());
                }
                if (operation == 4) {
                    terminal.getCash(scanner.nextFloat());
                }
                if (operation == 5) {
                    break;
                }
            } catch (IllegalArgumentException | ServerNotActiveException | SecurityException | ConnectException e) {
                System.out.println(e.getMessage());

            }
        }
    }
}
