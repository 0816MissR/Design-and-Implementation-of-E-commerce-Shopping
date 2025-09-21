package Shop;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderGUI extends JFrame {
    private JTextArea orderTextArea;

    public OrderGUI() {
        setTitle("订单结算");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        orderTextArea = new JTextArea(10, 30);
        orderTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(orderTextArea);
        panel.add(scrollPane);

        JButton generateOrderButton = new JButton("生成订单");
        generateOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateOrder();
            }
        });
        panel.add(generateOrderButton);

        add(panel);
    }

    public void generateOrder() {
        double total = 0;
        StringBuilder orderInfo = new StringBuilder();
        orderInfo.append("您的订单：\n");
        orderInfo.append("----------------------------------\n");
        orderInfo.append("商品编号   商品名   商品单价   * 购买数量\n");
        orderInfo.append("----------------------------------\n");
        for (int i = 0; i < 10; i++) {
            if (ShoppingCart.payNum[i] > 0) {
                double subtotal = Goods.getGoodsPrice()[i] * ShoppingCart.payNum[i];
                orderInfo.append(Goods.getGoodsID()[i]).append("   ")
                        .append(Goods.getGoodsName()[i]).append("   ")
                        .append(Goods.getGoodsPrice()[i]).append("   * ")
                        .append(ShoppingCart.payNum[i]).append("   = ")
                        .append(String.format("%.2f", subtotal)).append("\n");
                total += subtotal;
            }
        }
        orderInfo.append("----------------------------------\n");
        orderInfo.append("总计：").append(String.format("%.2f", total)).append("\n");
        orderTextArea.setText(orderInfo.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            OrderGUI orderGUI = new OrderGUI();
            orderGUI.setVisible(true);
        });
    }
}
