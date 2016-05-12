package DataScriptGenerator;

import entity.Flight;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import openshift_deploy.DeploymentConfiguration;

public class JsonGenerator {

    static String[] airline = {"AngularJS Airline", "FlightHunter Airline"};
    static String date;
    static int numberOfSeats = 10;
    static String FlightID;
    static int travelTime;
    static String flightNumber;
    static String[] airports = {"CPH", "SXF", "BCN", "STN", "CDG"};
    static Random random = new Random();
    static String from;
    static String to;
    static String toFrom;
    static int day;
    static int month;
    static double price;
    static int lastPrice;
    static int number1;
    static int number2;
    static int number4;
    static String number3;
    static EntityManager em;
    static EntityManagerFactory emf;
    static String tempID;
    static int[] availableSeats = {200, 150, 300, 100};

    public static void generator(int amount) {
        System.out.println("INSERT INTO airlinetest.flight (`flightID`, `flightNumber`, `date`, `numberOfSeats`, `totalPrice`, traveltime, origin, destination)");
        System.out.print("VALUES ");
        for (int i = 1; i < amount; i++) {
            tempID = flightID();
            String[] ft = fromTo();
            System.out.println("('" + firstFour(i)+tempID + "', '" + "FHA" + firstFour(i) + "', '" + makeDate() + "T13:00:00.000Z" + "', " + availableSeats[random.nextInt(4)] + ", " + makePrice(Integer.parseInt(makeDay()), random.nextInt(100) + 1) + ", '" + random.nextInt((250) + 60) + "', '" + ft[0] + "', '" + ft[1] + "'),");
           
        }
    }

    public static String flightID() {
        number2 = random.nextInt(899999) + 100000;
        number4 = random.nextInt(8999990) + 1000000;
        number3 = "-" + number2 + number4;
        //System.out.println(number3);

        return number3;
    }

    public static int setSeats() {
        numberOfSeats = random.nextInt(150) + 1;
        return numberOfSeats;
    }

    public static String firstFour(int n1) {
        if (n1 < 10) {
            return "000" + n1;
        }
        if (n1 < 100) {
            return "00" + n1;
        }
        if (n1 < 1000) {
            return "0" + n1;
        }
        return "" + n1;
    }

    public static String[] fromTo() {
        String[] result = new String[2];
        from = airports[random.nextInt(5)];
        to = airports[random.nextInt(5)];
        if (from.equals(to)) {
            return fromTo();
        } else {
            result[0] = from;
            result[1] = to;
            return result;
        }
    }

    public static int makePrice(int day, int tickets) {
        price = 0.4 * day * tickets;
        lastPrice = (int) Math.round(price);
        return lastPrice;
    }

    public static void travelTime() {
        System.out.println();
    }

    public static String makeMonth() {
        month = random.nextInt(12) + 1;
        if (month < 10) {
            return "0" + month;
        } else {
            return "" + month;
        }
    }

    public static String makeDay() {
        day = random.nextInt(28) + 1;
        if (day < 10) {
            return "0" + day;
        } else {
            return "" + day;
        }
    }

    public static String makeDate() {
        return "2016-" + makeMonth() + "-" + makeDay();
    }

    public static void main(String[] args) {
        generator(10);
    }
}
