package htmlReports;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;
import java.util.function.Predicate;

/**
 * Created by lolik on 12.07.17.
 */
public class LolikHtmlReport {

    private Document document;

    public <T> LolikHtmlReport(List<T> list){
      this(list, 14);
    }

    public <T> LolikHtmlReport(Set<T> set){
        this(new ArrayList<T>(set), 14);
    }

    public <T> LolikHtmlReport(Set<T> set, int rowSize){
        this(new ArrayList<T>(set), rowSize);
    }

    public <T> LolikHtmlReport(List<T> list, int rowSize){
        if(list.isEmpty()){
            document = new Document("");
            document.appendText("Empty report");
            return;
        }
        T t = list.get(0);
        if(t instanceof String || t instanceof Number || t instanceof Boolean){
            List<Value> values = new ArrayList<>();
            list.forEach(v -> values.add(new Value(v)));
            try {
                getss(values);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        } else {
            try {
                getss(list);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        this.rowSize = rowSize;
        loadDocument();
        markOddRows();
    }

    public <K, V> LolikHtmlReport(Map<K, V> map, int rowSize){
        List<KeyValue> keyValuePairs = new ArrayList<>();
        for(Map.Entry<K, V> entry : map.entrySet()){
            keyValuePairs.add(new KeyValue(entry.getKey(), entry.getValue()));
        }
        this.rowSize = rowSize;
        try {
            getss(keyValuePairs);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        loadDocument();
        markOddRows();
    }

    public <K, V> LolikHtmlReport(Map<K, V> map){
       this(map, 14);
    }

    public class KeyValue<K, V>{
        public K key;
        public V value;

        public KeyValue(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    public class Value<T>{
        public T value;

        public Value(T value){
            this.value = value;
        }
    }

    private int rowSize = 14;

    public String generate(){
        return document.toString();
    }

    public File generateFile(){
        File temp = null;
        try{
            //create a temp file
            temp = File.createTempFile("lolikReport", ".html");
            //write it
            BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
            bw.write(document.toString());
            bw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        return temp;
    }


    private void markOddRows(){
        Elements select = document.select("table tr");
        for(int i=1;i<select.size();i=i+2){
            select.get(i).attr("style","background-color:lightgrey;");
        }
    }

    private void loadDocument(){
        String example = "<style type=\"text/css\">\n" +
                ".tg  {border-collapse:collapse;border-spacing:0;}\n" +
                ".tg td{font-family:Arial, sans-serif;font-size:"+rowSize+"px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}\n" +
                ".tg th{font-family:Arial, sans-serif;font-size:"+rowSize+"px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}\n" +
                ".tg .tg-baqh{text-align:center;vertical-align:top}\n" +
                "</style>";


        String table = "";
        table += "<tr>";
        for(String name : columns){
            table += "<td><b>"+name.toUpperCase()+"</b></td>";
        }
        table += "</tr>";

        for(Map<String, String> m : mapList){
            table += "<tr>";
            for(String s : columns){
                table += "<td class=\""+s+"\">"+m.get(s)+"</td>";
            }
            table += "</tr>";
        }


        example += "<table id=\"lolikTable\" class=\"tg\">" + table +"</table>";

        document = Jsoup.parse(example);
    }

    private List<Map<String, String>> mapList = new ArrayList<>();
    private Set<String> columns = new LinkedHashSet<>();

    private <T> void getss(List<T> list) throws NoSuchFieldException, IllegalAccessException {
        if(list.isEmpty()){
            return;
        }
        Field[] fields = list.get(0).getClass().getFields();
        for(T t : list) {
            Map<String, String> map = new LinkedHashMap<>();
            for (Field field : fields) {
                if(field.get(t) != null){
                    map.put(field.getName(), field.get(t).toString());
                    columns.add(field.getName());
                }
            }
            mapList.add(map);
        }
        mapList.forEach(stringStringMap -> System.out.println(stringStringMap));
        System.out.println("COLUMNS: "+columns);
    }


    public <T> LolikHtmlReport markColorIf(String color, Predicate<String> predicate, String... parameter){
        if(parameter.length == 1 && parameter[0].equalsIgnoreCase("any")){
            parameter = columns.toArray(parameter);
        }
        for(String param : parameter) {
            if(!columns.contains(param)){
                throw new NullPointerException("NO SUCH PARAMETER IN REPORT: "+param);
            }
            Elements select = document.select("." + param);
            for (Element element : select) {
                if (predicate.test(element.text())) {
                    element.attr("style", "background-color:" + color + ";");
                }
            }
        }
        return this;
    }


    public <T> LolikHtmlReport makeBoldIf(Predicate<String> predicate, String... parameter){
        return setStyleIf("font-weight: bold;", predicate, parameter);
    }

    public <T> LolikHtmlReport setStyleIf(String style, Predicate<String> predicate, String... parameter){
        if(parameter.length == 1 && parameter[0].equalsIgnoreCase("any")){
            parameter = columns.toArray(parameter);
        }
        for(String param : parameter) {
            if(!columns.contains(param)){
                throw new NullPointerException("NO SUCH PARAMETER IN REPORT: "+param);
            }
            Elements select = document.select("." + param);
            for (Element element : select) {
                if (predicate.test(element.html())) {
                    element.attr("style", style);
                }
            }
        }
        return this;
    }

    public <T> LolikHtmlReport addFooterText(String text){
        document.body().appendText(textToHtml(text));
        return this;
    }

    public <T> LolikHtmlReport addHeaderText(String text){
        document.body().before(textToHtml(text));
        return this;
    }

    public String textToHtml(String text){
        return text.replaceAll("\n", "<br>");
    }

    public <T> LolikHtmlReport markColor(String color, String... parameter){
        if(parameter.length == 1 && parameter[0].equalsIgnoreCase("any")){
            parameter = columns.toArray(parameter);
        }
        for(String param : parameter) {
            if(!columns.contains(param)){
                throw new NullPointerException("NO SUCH PARAMETER IN REPORT: "+param);
            }
            Elements select = document.select("." + param);
            for (Element element : select) {
                    element.attr("style", "background-color:" + color + ";");
            }
        }
        return this;
    }

}
