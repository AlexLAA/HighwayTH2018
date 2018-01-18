package lesson4;

/**
 * Created by lolik on 27.12.2017.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Akinator {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://ru.akinator.com/");
        driver.findElement(By.xpath("//a[@class='rouge'][contains(text(),'Играть')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='elokence_sitebundle_identification_age']")).sendKeys("32");
        driver.findElement(By.xpath("//input[@value='Играть']")).click();

        Scanner scanner = new Scanner(System.in);
        int choice;
        int choice1;
        int choice2;
        boolean present;

        do {
            try {
                driver.findElement(By.xpath("//div[@id='questionNo']/span"));
                present = true;
            } catch (NoSuchElementException e) {
                present = false;
            }
            if (present) {
                Thread.sleep(2000);
                System.out.println("Номер вопроса " + driver.findElement(By.xpath("//div[@id='questionNo']/span")).getText());
                System.out.println(driver.findElement(By.xpath("//div[@id='bulle-inner']")).getText());

                System.out.println("1 - " + driver.findElement(By.xpath("//a[@id='reponse1']")).getText());
                System.out.println("2 - " + driver.findElement(By.xpath("//a[@id='reponse2']")).getText());
                System.out.println("3 - " + driver.findElement(By.xpath("//a[@id='reponse3']")).getText());
                System.out.println("4 - " + driver.findElement(By.xpath("//a[@id='reponse4']")).getText());
                System.out.println("5 - " + driver.findElement(By.xpath("//a[@id='reponse5']")).getText());
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        driver.findElement(By.xpath("//a[@id='reponse1']")).click();
                        break;
                    case 2:
                        driver.findElement(By.xpath("//a[@id='reponse2']")).click();
                        break;
                    case 3:
                        driver.findElement(By.xpath("//a[@id='reponse3']")).click();
                        break;
                    case 4:
                        driver.findElement(By.xpath("//a[@id='reponse4']")).click();
                        break;
                    case 5:
                        driver.findElement(By.xpath("//a[@id='reponse5']")).click();
                        break;
                }
            } else {
                System.out.println(driver.findElement(By.xpath("//div[@id='infos-perso-title']/p")).getText());
                System.out.println(driver.findElement(By.xpath("//div[@id='infos-perso-title']/h2[@id='perso']")).getText());
                System.out.println(driver.findElement(By.xpath("//div[@id='infos-perso-content']/p[@id='description']")).getText());
                System.out.println("Угадал?\n1-Да\n2-Нет");
                choice1 = scanner.nextInt();
                if (choice1 == 1) {
                    driver.findElement(By.xpath("//a[@id='yesLink']")).click();
                    System.out.println(driver.findElement(By.xpath("//div[@id='bulle-inner']")).getText());
                    System.out.println("Конец игры");
                } else {
                    driver.findElement(By.xpath("//a[@id='noLink']")).click();
                    System.out.println(driver.findElement(By.xpath("//h2[@id='perso']")).getText());
                    System.out.println("1-Да\n2-Нет");
                    choice2 = scanner.nextInt();
                    if (choice2 == 1) {
                        driver.findElement(By.xpath("//a[@id='yesLink']")).click();
                        System.out.println(driver.findElement(By.xpath("//div[@id='bulle-inner']")).getText());
                    } else {
                        System.out.println("Конец игры");
                    }
                }

            }
        } while (true);


        // driver.quit();
    }
}