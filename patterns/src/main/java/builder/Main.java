package builder;

class Cargo {
    private String type;
    private int quantity;

    public Cargo(String type, int quantity) {
        this.type = type;
        this.quantity = quantity;
    }


    public String getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "type='" + type + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}

interface CargoBuilder {
    CargoBuilder setType(String type);

    CargoBuilder setQuantity(int quantity);

    Cargo build();
}

class CargoBuilderImpl implements CargoBuilder {
    private String type;
    private int quantity;

    @Override
    public CargoBuilder setType(String type) {
        this.type = type;
        return this;
    }

    @Override
    public CargoBuilder setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    @Override
    public Cargo build() {
        return new Cargo(type, quantity);
    }
}

public class Main {
    public static void main(String[] args) {
        CargoBuilder cargoBuilder = new CargoBuilderImpl();

        Cargo cargo1 = cargoBuilder.setType("Electronics").setQuantity(50).build();
        Cargo cargo2 = cargoBuilder.setType("Clothing").setQuantity(100).build();

        System.out.println("Cargo 1: " + cargo1);
        System.out.println("Cargo 2: " + cargo2);
    }
}

