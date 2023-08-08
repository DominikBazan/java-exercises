public class Bakery {

    private String name;

    public Bakery(String bakeryName) {
        this.name = bakeryName;
    }

    public Cake createVanillaCake() {
        return new Vanilla();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
