import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int attempts = 0;
        int ticket;
        int ticketNumb = 0;
        Random random = new Random();
        String ticketNumbStr;
        Scanner scanner = new Scanner(System.in);

        //Bilieto numerį perduokite komandinėje eilutėje: šešiaženklis numeris
        while (true) {
            System.out.println("Įveskite šešiaženklį bilieto numerį:");
            ticketNumb = scanner.nextInt();
            ticketNumbStr = String.valueOf(ticketNumb);

            //tol kol bus įvestas 6ženklis
            if (ticketNumbStr.length() == 6) {
                break;
            } else {
                System.out.println("Turi būti šešiaženklis numeris.");
            }
        }


        if (isLuckyTicket(ticketNumb)) {
            System.out.println("Įvestas bilietas yra laimingas! "); //veikia su 628745
        } else {
            System.out.println("Įvestas bilietas nėra laimingas, todėl generavau skaičius tol, kol radau pirmą laimingą skaičių.");

            do {
                ticket = random.nextInt(900000) + 100000;
                attempts++;
            } while (!isLuckyTicket(ticket));

            System.out.println("Pirmas laimingas skaičius yra: " + ticket);
            System.out.println("Reikėjo bandymų: " + attempts);
        }
    }

    //Skaičių suma yra lygi paskutinių trijų skaičių sumai
    private static boolean isLuckyTicket(int ticket) {
        String ticketStr = String.valueOf(ticket);

        int firstSum = ticketStr.charAt(0) - '0'
                + ticketStr.charAt(1) - '0'
                + ticketStr.charAt(2) - '0';

        int secondSum = ticketStr.charAt(3) - '0'
                + ticketStr.charAt(4) - '0'
                + ticketStr.charAt(5) - '0';

        if (firstSum != secondSum) {
            return false;
        }

        // ar skaitmenys biliete yra skirtingi
        for (int i = 0; i < ticketStr.length(); i++) {
            for (int j = i + 1; j < ticketStr.length(); j++) {
                if (ticketStr.charAt(i) == ticketStr.charAt(j)) {
                    return false;
                }
            }
        }

        return true;
    }
}
