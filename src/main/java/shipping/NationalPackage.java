package shipping;

public class NationalPackage implements Transportable{

    private int weight;
    private boolean isBreakable;
    private final int SHIPPING_COST = 1000;
    private final int MULTIPLICATOR = 2;

    public NationalPackage(int weight, boolean isBreakable) {
        this.weight = weight;
        this.isBreakable = isBreakable;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public boolean isBreakable() {
        return isBreakable;
    }

    @Override
    public int calculateShippingPrice() {
        return isBreakable ? SHIPPING_COST * MULTIPLICATOR : SHIPPING_COST;
    }
}