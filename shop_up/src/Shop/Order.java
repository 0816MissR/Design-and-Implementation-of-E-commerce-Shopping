package Shop;

public class Order {//结算
    public static void showPay() {//显示购物车中的商品
        double willPay = 0;
        System.out.println("	            您的订单   ");
        System.out.println("----------------------------------");
        System.out.println("商品编号"+"	"+"商品名"+"	"+"商品单价"+"	* "+"购买数量");
        System.out.println("----------------------------------");

        for(int i = 0;i < 10;i++) {
            if( ShoppingCart.payNum[i] != 0) {

                // 当需要存储订单数据时
                String orderData = Goods.getGoodsID()[i] +"   " + Goods.getGoodsName()[i] + "   " + Goods.getGoodsPrice()[i] + "    "+ "*" + ShoppingCart.payNum[i];
                OrderFileWriter.writeOrderToFile(orderData);

                System.out.println(Goods.getGoodsID()[i]+"	"+Goods.getGoodsName()[i]+"	"+Goods.getGoodsPrice()[i]+"	 "+ShoppingCart.payNum[i]);
            }
            willPay = willPay + (ShoppingCart.payNum[i] * Goods.getGoodsPrice()[i]);
        }
        System.out.println("----------------------------------");
        System.out.println("	实 际 应 付 :  "+String.format("%.2f", willPay));
        System.out.println("----------------------------------");
        String orderData = "总价为："+" "+String.format("%.2f", willPay);
        OrderFileWriter.writeOrderToFile(orderData);
    }

    //删除订单中指定商品
    public static void deleteOrder(int goodsID) {
        for(int i = 0; i < 10; i++) {
            if(Goods.getGoodsID()[i] == goodsID) {
                ShoppingCart.payNum[i] = 0;
                System.out.println("商品 " + Goods.getGoodsName()[i] + " 已从订单中移除。");
                return;
            }
        }
        System.out.println("订单中未找到该商品编号。");
    }
}