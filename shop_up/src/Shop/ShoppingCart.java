package Shop;

public class ShoppingCart {//查看购物车
    public static int[] payNum = new int[100];//购买数量
    public static int addGoods(int needGoods,int needAddNum) {//增加商品

        if(needGoods > 9 || needGoods < 0) {
            System.out.println("对不起！您输入的商品编号有误，请重新输入！");
        }
        for(int i = 0;i < 10;i++) {
            if(i == needGoods) {
                payNum[i] = needAddNum;
                System.out.println("商品编号"+"	"+"商品名"+"	"+"商品单价"+"	  "+"购买数量");
                System.out.println(Goods.getGoodsID()[i]+"	"+Goods.getGoodsName()[i]+"	"+Goods.getGoodsPrice()[i]+"	* "+ShoppingCart.payNum[i]);
                return 1;
            }
        }
        return 0;
    }

    public static void showCart() {//显示购物车
        double cartPay=0;//购物车商品总价
        System.out.println("———————————— 您的购物车 ————————————");
        System.out.print("商品编号"+"	"+"商品名"+"	"+"商品单价"+"	  "+"购买数量\r\n");

        for(int i = 0;i < 10;i++) {
            if( ShoppingCart.payNum[i] != 0) {
                System.out.println(Goods.getGoodsID()[i]+"	"+Goods.getGoodsName()[i]+"	"+Goods.getGoodsPrice()[i]+"	* "+ShoppingCart.payNum[i]);
            }
            cartPay = cartPay + (ShoppingCart.payNum[i] * Goods.getGoodsPrice()[i]);
        }
        System.out.println();
        System.out.println("您的账单估算 :  "+String.format("%.2f", cartPay));
    }

    public static int deleteGoods(int goodsID) {//删除商品
        if(goodsID < 0 || goodsID >= Goods.getGoodsID().length) {
            System.out.println("商品编号不存在");
            return 0;
        }

        payNum[goodsID] = 0;

        System.out.println("已成功删除商品：" + Goods.getGoodsName()[goodsID]);
        return 1;
    }

}