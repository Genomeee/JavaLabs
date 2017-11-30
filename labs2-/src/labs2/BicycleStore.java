package labs2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="BicycleStore")
public class BicycleStore {
    private String name;
    private List<Bicycle> bicycles;
    private int id;

    public String toString() {
        return "BicycleStore [name=" + this.name + ", bicycles=" + this.bicycles + ", id=" + this.id + "]";
    }

    BicycleStore(String name, List<Bicycle> bicycles, int id) {
        this.setName(name);
        this.setBicycles(bicycles);
        this.setId(id);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    BicycleStore() {
        this.bicycles = new ArrayList<Bicycle>();
        this.name = "BicycleStore";
        this.id = 0;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Bicycle> getBicycles() {
        return this.bicycles;
    }

    public void setBicycles(List<Bicycle> bicycles) {
        this.bicycles = bicycles;
    }

    public Bicycle getBicycles(int i) {
        return this.bicycles.get(i);
    }

    public boolean addBicycles(Bicycle bicycle) {
        return this.bicycles.add(bicycle);
    }

    public boolean removeBicycle(Bicycle bicycle) {
        return this.bicycles.remove((Object)bicycle);
    }

    private List<Bicycle> filter(Predicate<Bicycle> criteria) {
        return this.bicycles.stream().filter(criteria).collect(Collectors.toList());
    }

    public List<Bicycle> inType(Bicycle.Type type) {
        return this.filter(x -> x.getType() == type);
    }

    public List<Bicycle> inPrice(int price) {
        return this.filter(x -> x.getPrice() == price);
    }

    public List<Bicycle> inGear(int gear) {
        return this.filter(x -> x.getGear() == gear);
    }

    public List<Bicycle> inSpeed(int speed) {
        return this.filter(x -> x.getSpeed() == speed);
    }

    public List<Bicycle> inPriceCategory(int left, int right) throws IllegalArgumentException {
        if (left < 0 || left > right) {
            throw new IllegalArgumentException("left must be >= 0 and left < right");
        }
        return this.filter(x -> x.getPrice() >= left && x.getPrice() <= right);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BicycleStore)) {
            return false;
        }
        BicycleStore storage = (BicycleStore)o;
        return this.bicycles != null ? this.bicycles.equals(storage.bicycles) : storage.bicycles == null;
    }

    public int hashCode() {
        return this.bicycles != null ? this.bicycles.hashCode() : 0;
    }
}