package Shop;

import javax.swing.*;
import java.awt.*;

public class ShoppingCartGUI extends JFrame {
    private JTextArea cartTextArea;

    public ShoppingCartGUI() {
        setTitle("购物车");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        cartTextArea = new JTextArea(10, 30);
        cartTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(cartTextArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton refreshButton = new JButton("刷新购物车");
        refreshButton.addActionListener(e -> refreshCart());
        panel.add(refreshButton, BorderLayout.SOUTH);

        add(panel);
    }

    public void refreshCart() {
        // 获取购物车数据并显示在文本区域中
        StringBuilder cartInfo = new StringBuilder();
        cartInfo.append("您的购物车：\n");
        for (int i = 0; i < 10; i++) {
            if (ShoppingCart.payNum[i] > 0) {
                cartInfo.append(Goods.getGoodsID()[i]).append("   ")
                        .append(Goods.getGoodsName()[i]).append("   ")
                        .append(Goods.getGoodsPrice()[i]).append("   * ")
                        .append(ShoppingCart.payNum[i]).append("\n");
            }
        }
        double cartTotal = calculateCartTotal();
        cartInfo.append("\n总价：").append(String.format("%.2f", cartTotal));
        cartTextArea.setText(cartInfo.toString());
    }

    private double calculateCartTotal() {
        double total = 0;
        for (int i = 0; i < 10; i++) {
            total += Goods.getGoodsPrice()[i] * ShoppingCart.payNum[i];
        }
        return total;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ShoppingCartGUI shoppingCartGUI = new ShoppingCartGUI();
            shoppingCartGUI.setVisible(true);
        });
    }
}
