package shipping;

public interface Transportable {

    final String COUNTRY = "Hungary";

    int getWeight();
    boolean isBreakable();
    int calculateShippingPrice();
    default String getDestinationCountry() {
        return COUNTRY;
    }
}
