package labs2;

import java.util.regex.Pattern;

public class BicycleBuilder {
    private int id = 1;
    private String made = "";
    private int p = 0;
    private int g = 0;
    private int s = 0;
    private Bicycle.Type type = Bicycle.Type.CITY;
    public static final String MADE_PATTERN = "^[A-Z].{0,100}$";

    public BicycleBuilder buildMade(String made) {
        if (!Pattern.matches("^[A-Z].{0,100}$", made)) {
            throw new IllegalArgumentException("Too long for country name");
        }
        this.made = made;
        return this;
    }

    public BicycleBuilder buildType(Bicycle.Type type) {
        this.type = type;
        return this;
    }

    public BicycleBuilder buildMake(String m) {
        this.made = m;
        return this;
    }

    public BicycleBuilder buildPrice(int p) {
        this.p = p;
        return this;
    }

    public BicycleBuilder buildGear(int g) {
        this.g = g;
        return this;
    }

    public BicycleBuilder buildSpeed(int s) {
        this.s = s;
        return this;
    }

    public BicycleBuilder buildID(int id) {
        this.id = id;
        return this;
    }

    public Bicycle build() {
        Bicycle b = new Bicycle();
        b.setMade(this.made);
        b.setPrice(this.p);
        b.setGear(this.g);
        b.setSpeed(this.s);
        b.setType(this.type);
        b.setId(this.id);
        return b;
    }

    public BicycleBuilder fromString(String input) {
        this.buildMade(REG.getRegexGroup((String)input, (String)"made: ^[A-Z].{0,100}$;"));
        this.buildPrice(Integer.parseInt(REG.getRegexGroup((String)input, (String)"price: (\\d*[\\.,]\\d*)")));
        this.buildGear(Integer.parseInt(REG.getRegexGroup((String)input, (String)"gear: (\\d*[\\.,]\\d*)")));
        this.buildSpeed(Integer.parseInt(REG.getRegexGroup((String)input, (String)"speed: (\\d*[\\.,]\\d*)")));
        this.buildType(Bicycle.Type.valueOf((String)REG.getRegexGroup((String)input, (String)"type: ([A-Z]+);")));
        return this;
    }
}

