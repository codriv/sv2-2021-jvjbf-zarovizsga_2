package shipping;

import java.util.*;

public class ShippingService {

    private List<Transportable> packages = new ArrayList<>();

    public List<Transportable> getPackages() {
        return packages;
    }

    public void addPackage(Transportable transportable) {
        packages.add(transportable);
    }

    public List<Transportable> collectItemsByBreakableAndWeight(boolean breakable, int weight) {
        return packages.stream().filter(tr -> tr.isBreakable() == breakable).filter(tr -> tr.getWeight() >= weight).toList();
    }

    public Map<String, Integer> collectTransportableByCountry(){
        Map<String, Integer> statistic = new HashMap<>();
        for (Transportable tr: packages) {
            String country = tr.getDestinationCountry();
            if (!statistic.containsKey(country)) {
                statistic.put(country, 1);
            } else {
                statistic.put(country, statistic.get(country) + 1);
            }
        }
        return statistic;
    }

    public List<Transportable> sortInternationalPackagesByDistance() {
        return packages.stream().filter(tr -> tr instanceof InternationalPackage).sorted(Comparator.comparing(tr -> ((InternationalPackage)tr).getDistance())).toList();
    }
}
