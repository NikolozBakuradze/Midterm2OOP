import java.io.Serializable;
import java.util.Objects;

public class Crop implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private double price;
    private int quantity;

    public Crop(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return String.format("Crop: %s, Price: $%.2f, Quantity: %d", name, price, quantity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Crop crop = (Crop) o;
        return Double.compare(crop.price, price) == 0 &&
                quantity == crop.quantity &&
                Objects.equals(name, crop.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, quantity);
    }
}
