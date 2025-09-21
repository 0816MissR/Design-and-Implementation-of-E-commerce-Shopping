package Shop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class OrderFileReader {
    public static void readOrdersFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("orders.txt"));
            String line;
            System.out.println("所有订单数据：");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                // 如果需要，您可以解析每行数据，并进行进一步处理
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("读取订单数据时发生错误：" + e.getMessage());
        }
    }
}
