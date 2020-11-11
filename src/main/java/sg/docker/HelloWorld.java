package sg.docker;
import org.joda.time.LocalTime;
/**
 * HelloWorld uses Joda Time’s LocalTime class to get and print the current time.
 */
public class HelloWorld {
    public static void main(String[] args) {
        LocalTime currentTime = new LocalTime();
        System.out.println("The current local time is: " + currentTime);

        Greeter greeter = new Greeter();
        System.out.println(greeter.sayHello());
    }
}