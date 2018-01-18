package lesson7;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by lolik on 28.12.2017.
 */
public class ParametersExample {


    @Test
    @Parameters({"email", "password"})
    public void login(@Optional("azazaza") String email, @Optional("iLoveasdasd")String password){
        System.out.println("EMAIL: "+email);
        System.out.println("PASSWORD: "+password);
    }


}
