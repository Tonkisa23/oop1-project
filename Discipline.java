package bg.tu_varna.sit.a1.f22621643;

public class Discipline {
    private String name;
    private DisciplineType type;

    public Discipline(String name, DisciplineType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DisciplineType getType() {
        return type;
    }

    public void setType(DisciplineType type) {
        this.type = type;
    }
}
