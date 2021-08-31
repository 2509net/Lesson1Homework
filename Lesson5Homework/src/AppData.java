import java.io.File;
import java.io.Serializable;

public class AppData implements Serializable {
    private final String[] headers;
    private final int[][] data;

    public AppData(String[] headers, int[][] data) {
        this.headers = headers;
        this.data = data;
    }
public void writeToFile(String path) {
    File file = new File(path);
    writeToFile(file);
}

    @Override
    public String toString() {
        return headersToString() + data.toString();

    }

    private void headersToString() {
        StringBuilder result = new StringBuilder();
        for (String header : headers) {
            StringBuilder append = result.append(header).append(";");


        }

        private String dataToString () {
            StringBuilder result = new StringBuilder();
            for (int[] values : data) {
                StringBuilder resultBuilder = new StringBuilder();
                for (int value : values) {
                    resultBuilder.append(value).append(";");
                }
            }
        }

    }
}
