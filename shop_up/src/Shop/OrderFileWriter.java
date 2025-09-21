package Shop;

import java.io.FileWriter;
import java.io.IOException;

public class OrderFileWriter {
    public static void writeOrderToFile(String orderData) {
        try {
            FileWriter writer = new FileWriter("orders.txt", true);  // 将订单数据追加到文件末尾
            writer.write(orderData + "\n");
            writer.close();
            System.out.println("订单数据已写入文件:orders.txt");
        } catch (IOException e) {
            System.err.println("写入订单数据时发生错误：" + e.getMessage());
        }
    }
}
