package pojo;

public class productnPrices {
    public class prices{
        public String getUs() {
            return us;
        }

        public String getEu() {
            return eu;
        }

        public String getUk() {
            return uk;
        }

        String us;
        String eu;
        String uk;
    }

    private String item;
    private prices price;

    public String getItem() {
        return item;
    }

    public prices getPrice() {
        return price;
    }

}
