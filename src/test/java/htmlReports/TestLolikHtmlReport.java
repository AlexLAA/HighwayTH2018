package htmlReports;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lolik on 3/1/18.
 */
public class TestLolikHtmlReport {

    List<InfoHelper> results = new ArrayList<>();

    @Test
    public void azaza() throws IOException {
        results.add(new InfoHelper("Test Name 1", "Error 1"));
        results.add(new InfoHelper("Test Name 2", "Error 2"));
        results.add(new InfoHelper("Test Name 3", "Error 3"));
        results.add(new InfoHelper("Test Name 4", "Error 4"));
        results.add(new InfoHelper("Test Name 5", "Error 5"));
        File file = new LolikHtmlReport(results).generateFile();
        FileUtils.copyFile(file , new File("/Users/lolik/testData/report.html"));
    }


 /*   public double sum(List<? extends Number> list){
        double result = 0.0;
        for (Number number : list) {
            result += number.doubleValue();
        }
        return result;
    }*/


    public class InfoHelper{

        public InfoHelper(){

        }

        public InfoHelper(String title, String error){
            this.title = title;
            this.error = error;
        }
        public String title;
        public String error;
    }
}
