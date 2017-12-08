package lesson2;

import java.sql.Timestamp;

/**
 * Created by lolik on 07.12.2017.
 */
public class TimestampExample {

    public static void main(String[] args) {

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        // JAVA default TS in milliseconds - check TS https://www.epochconverter.com/
        System.out.println(timestamp.getTime());

    }
}
