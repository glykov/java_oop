public class Goods {
    private int productId;
    private String name;
    private String manufacturer;
    private String description;
    private double price;
    private int count;

    private Goods(GoodsBuilder builder) {
        this.productId = builder.productId;
        this.name = builder.name;
        this.manufacturer = builder.manufacturer;
        this.description = builder.description;
        this.price = builder.price;
        this.count = builder.count;
    }

    public int getProductId() {
        return productId;
    }

    public int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Product: [").append("product ID = ").append(productId)
                .append(", name = ").append(name).append(", manufacturer = ").append(manufacturer)
                .append(", description = ").append(description).append(", price = ").append(price)
                .append(", count = ").append(count).append("]");
        return builder.toString();
    }

    public static class GoodsBuilder {
        private int productId;
        private String name = "unknown";
        private String manufacturer = "unknown";
        private String description = "none";
        private double price;
        private int count;

        public GoodsBuilder productId(int productId) {
            this.productId = productId;
            return this;
        }

        public GoodsBuilder name(String name) {
            this.name = name;
            return this;
        }

        public GoodsBuilder manufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
            return this;
        }
        public GoodsBuilder description(String description) {
            this.description = description;
            return this;
        }
        public GoodsBuilder price(double price) {
            this.price = price;
            return this;
        }
        public GoodsBuilder count(int count) {
            this.count = count;
            return this;
        }

        public Goods build() {
            return new Goods(this);
        }
    }
}
