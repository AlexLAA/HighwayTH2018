package allureExample;

import io.qameta.allure.*;
import io.qameta.allure.model.Label;
import io.qameta.allure.model.Parameter;
import io.qameta.allure.model.TestResult;
import lesson11.BrowserFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * Created by lolik on 2/26/18.
 */
@Epic("Lesson Allure")
@Feature("Allure Report Tests")
public class TestAllure extends BrowserFactory  {

    @Test(description = "TEST runIT")
    @Description("Some detailed test description")
    @Story("Passed test")
    @Story("Passed test story 2")
    public void runIt(){
        Allure.addLabels(new Label().withName("epic").withValue("JACK PARAM1"));

        Parameter parameter = new Parameter();
        parameter.setName("MY PARAM");
        parameter.setValue("MY VALUE");
        Consumer<TestResult> paramsConsumer = testResult1 -> testResult1.setParameters(Arrays.asList(parameter));

        Consumer<TestResult> name = testResult1 -> testResult1.setName("MY OPT NAME");

        Allure.getLifecycle().updateTestCase(paramsConsumer);
        Allure.getLifecycle().updateTestCase(name);
        print("JACK");
        print("SPARROW");
        Assert.assertTrue(true);
    }


    @Test
    @Description("This is a testing Failed")
    @Story("Failed test")
    public void failed(){
        driver.get("https://google.com");
        saveScreenshot();
        System.out.println("JACK");
        Assert.assertTrue(true);
    }


    @Test
    @Story("Param test story")
    @Parameters({"name"})
    public void paramTest(@Optional("LOLIK")String name){
        System.out.println(name);
    }


    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot() {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }


    @Step
    public void print(String s){
        System.out.println(s);
    }
}
