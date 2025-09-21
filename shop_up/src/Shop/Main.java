package Shop;


import java.util.*;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("————————欢迎来到购物操作系统！————————");

        while(true) {

            System.out.println("    1.商品查询	   2.商品购买");
            System.out.println("    3.查看购物车	   4.订单结算");
            System.out.println();
            System.out.println("	     0.退出");
            System.out.println("请选择您要进行的操作编码：");
            int r=sc.nextInt();
            System.out.println();

            if(r==1){
                // 初始化商品列表
                Goods.list();

                // 显示所有商品
                System.out.println("所有商品信息：");
                Goods.showGoods();
                // 搜索商品
                System.out.println("开始搜索商品：");
                Goods.searchGoods();
                System.out.println();
                System.out.println("——————————————————————————————————");
            }

            //添加商品
            if(r==2){
                // 在用户输入 "#" 时执行显示购物车中的商品及结算方法
                System.out.println("添加商品（输入 '#' 显示购物车中的商品及结算/输入2则开始进行商品添加）：");
                String userInput = sc.next();
                while (!userInput.equals("#")) {

                    // 初始化商品列表
                    Goods.list();

                    // 显示所有商品
                    System.out.println("所有商品信息：");
                    Goods.showGoods();
                    System.out.println();

                    // 添加商品到购物车
                    System.out.println("添加商品到购物车");
                    int needGoods = 0;
                    while(needGoods != -1) {
                        System.out.println("请输入商品编号和商品数量（输入[-1(空格) -1]以结束添加商品）：");
                        needGoods = sc.nextInt();
                        int needAddNum = sc.nextInt();
                        if(needGoods == -1) {
                            break;
                        }
                        ShoppingCart.addGoods(needGoods, needAddNum); // 以商品编号和购买数量为参数添加商品到购物车
                    }
                    System.out.println("");
                    ShoppingCart.showCart();
                    System.out.println("");
                    // 删除商品（商品编号从0开始）
                    System.out.println("删除商品");
                    System.out.println("请输入商品编号(输入-1则跳过删除商品阶段）：");
                    int goodsIDToDelete = sc.nextInt();
                    if(goodsIDToDelete == -1) {
                        break;
                    }
                    int deleteResult = ShoppingCart.deleteGoods(goodsIDToDelete);

                    if(deleteResult == 1) {
                        System.out.println("成功删除商品，请注意更新购物车信息！");
                        System.out.println("");
                        ShoppingCart.showCart();
                        System.out.println("");
                    } else {
                        System.out.println("删除失败，请检查商品编号是否正确！");
                        System.out.println("");
                        ShoppingCart.showCart();
                        System.out.println("");
                    }
                    System.out.println("输入2继续 添加 & 删除商品（输入#则退出 添加&删除 商品阶段）：");
                    userInput = sc.next();
                }

                System.out.println();
                System.out.println("——————————————————————————————————");
            }


            if(r==3){
                ShoppingCart.showCart();

                // 显示购物车图形用户界面
                SwingUtilities.invokeLater(() -> {
                    ShoppingCartGUI shoppingCartGUI = new ShoppingCartGUI();
                    shoppingCartGUI.setVisible(true);
                });
                System.out.println();
                System.out.println("——————————————————————————————————");
            }

            if(r==4){
                Order.showPay();
                // 显示订单结算图形用户界面
                SwingUtilities.invokeLater(() -> {
                    OrderGUI orderGUI = new OrderGUI();
                    orderGUI.setVisible(true);
                });
                System.out.println();
                System.out.println("——————————————————————————————————");
            }

            if(r==0){
                System.out.println("————感谢您的使用，欢迎下次再来！————");
                break;
            }
        }



        // 当需要读取订单数据时
        OrderFileReader.readOrdersFromFile();

//        //删除订单中指定商品
//        System.out.println("删除订单中指定商品");
//        System.out.println("请输入商品编号：");
//        int del = sc.nextInt();
//        Order.deleteOrder(del);

        sc.close();
    }

}
