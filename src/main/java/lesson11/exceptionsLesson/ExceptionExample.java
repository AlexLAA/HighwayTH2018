package lesson11.exceptionsLesson;

import java.io.File;
import java.io.IOException;

/**
 * Created by lolik on 01.02.2018.
 */
public class ExceptionExample {


    public static void createFile() throws IOException {
        File file = new File("\\/,sad\\ASD");
        file.createNewFile(); // Метод выбрасывет исключение в случае неправильного пути к файлу
    }

    public static void main(String[] args) throws IOException {
        createFile();
    }
}
