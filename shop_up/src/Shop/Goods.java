package Shop;


import java.util.Scanner;

public class Goods {//商品

    private static int[] goodsID = new int[100];
    private static String[] goodsName =new String[100];
    private static double[] goodsPrice = new double[100];

    public static void showGoods() {
        System.out.println("商品编号	商品名	商品价格");
        for(int i = 0;i < 10;i++) {
            System.out.println(goodsID[i]+"	"+goodsName[i]+"	"+goodsPrice[i]);
        }
    }

    public static void searchGoods() {
        @SuppressWarnings("resource")

        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("请输入商品编号:");
            int Search = sc.nextInt();
            for(int i = 0;i < 10;i++) {
                if(Search == goodsID[i]) {
                    System.out.print("商品已找到 : \r\n");
                    System.out.println("商品编号	商品名	商品价格");
                    System.out.println(goodsID[i]+"	"+goodsName[i]+"	"+goodsPrice[i]);
                    return;//商品找到
                }
            }

            System.out.println("商品没找到，请重新查找！ \r\n");

        }

    }

    public static void list() {
        for(int i = 0;i<10;i++) {
            goodsID[i] = i;
            switch (i) {
                case 0:
                    goodsName[i] = "帽子" ;
                    goodsPrice[i] = 58.60 ;
                    break;
                case 1:
                    goodsName[i] = "咖啡" ;
                    goodsPrice[i] = 89.00 ;
                    break;
                case 2:
                    goodsName[i] = "化妆镜" ;
                    goodsPrice[i] = 49.00 ;
                    break;
                case 3:
                    goodsName[i] = "耳机" ;
                    goodsPrice[i] = 228.00 ;
                    break;
                case 4:
                    goodsName[i] = "东北玉米";
                    goodsPrice[i] = 12.00;
                    break;
                case 5:
                    goodsName[i] = "水杯";
                    goodsPrice[i] = 42.90;
                    break;
                case 6:
                    goodsName[i] = "铁观音";
                    goodsPrice[i] =  119.00 ;
                    break;
                case 7:
                    goodsName[i] = "水果糖" ;
                    goodsPrice[i] = 15.60 ;
                    break;
                case 8:
                    goodsName[i] = "苹果";
                    goodsPrice[i] = 41.90 ;
                    break;
                case 9:
                    goodsName[i] = "五香瓜子";
                    goodsPrice[i] = 23.80 ;
                    break;
            }
        }

    }

    public static int[] getGoodsID() {
        return goodsID;
    }

    public static void setGoodsID(int[] goodsID) {
        Goods.goodsID = goodsID;
    }

    public static String[] getGoodsName() {
        return goodsName;
    }

    public static void setGoodsName(String[] goodsName) {
        Goods.goodsName = goodsName;
    }

    public static double[] getGoodsPrice() {
        return goodsPrice;
    }

    public static void setGoodsPrice(double[] goodsPrice) {
        Goods.goodsPrice = goodsPrice;
    }


}