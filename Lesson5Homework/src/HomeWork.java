import java.nio.file.Path;

public class HomeWork {


    public static void main(String[] args) {
        String[] headers = {"Value 1", "Value 2", "Value 3"};
        int[][] data  = {
                { 100, 200, 123 },
                { 300, 400, 500 }
        };
        AppData appData = new AppData(headers, data);
        String[] otherHeaders = { "First", "Second", "Third"};
        int[][] otherData = {
                { 52, 424, 111 },
                { 76, 2, 321 }
        };
        AppData otherAppData = new AppData(otherHeaders, otherData);

        appData.writeToFile(Path);
        AppData receivedAppData = AppData.readFromFile(Path);
        System.out.println(receivedAppData);
    }


}
