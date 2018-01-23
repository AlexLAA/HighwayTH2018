package lesson8;

/**
 * Created by lolik on 22.01.2018.
 */
public class UserMain {
    public static void main(String[] args) {

        User user1 = new User();
        User user2 = new User();

        User.profession = "Slut";


        System.out.println("User class: "+User.profession);
        System.out.println("User 1: " + user1.profession);
        System.out.println("USer 2: "+ user2.profession);


    }
}
