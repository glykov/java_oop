import java.util.ArrayList;
import java.util.List;

public class GoodsApp {
    public static void main(String[] args) {
        Goods g1 = new Goods.GoodsBuilder().productId(1).name("cooler")
                .build();
        Goods g2 = new Goods.GoodsBuilder().productId(2).name("cpu")
                .manufacturer("AMD").price(3000.0).count(2).build();
        Goods g3 = new Goods.GoodsBuilder().productId(3).name("gpu")
                .manufacturer("NVidia").description("RTX 3060").count(1).build();

        List<Goods> goods = new ArrayList<>();
        goods.add(g1);
        goods.add(g2);
        goods.add(g3);

        for (var g : goods) {
            System.out.println(g);
        }
    }
}
