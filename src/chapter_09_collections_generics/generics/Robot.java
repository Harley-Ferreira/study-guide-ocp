package chapter_09_collections_generics.generics;

public class Robot {
    private String type;

    public Robot(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Robot type = '" + type + '\'';
    }

    public static void main(String[] args) {
        Robot robot = new Robot("Scara");
        Crate<Robot> robotCrate = new Crate<>();
        robotCrate.packCrate(robot);
        System.out.println(robotCrate.lookInCrate());
    }
}
