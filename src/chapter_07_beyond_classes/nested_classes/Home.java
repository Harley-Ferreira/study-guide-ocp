package chapter_07_beyond_classes.nested_classes;

/**
 * Nested Classes
 * --------------
 * Inner Class:
 * 1 - Can be declared public, protected, package or private.
 * 2 - Can be marked abstract or final.
 * 3 - Can access members of the outer class including private members.
 */
public class Home {
    private String greeting = "Hi";

    protected class Room {
        public int repeat = 3;
        public void enter() {
            for (int i = 0; i < repeat; i++) {
                greet(greeting);
            }
        }

        private void greet(String message) {
            System.out.println(message);
        }
    }

    private class Kitchen {
        private void getBreakfast() {
            System.out.println("Coffee and Bread");
        }

        public void getDinner() {
            System.out.println("Meat and Rice");
        }
    }

    public void enterRoom() {
        var room = new Room();
        room.enter();
    }

    public void eat() {
        var kitchen = new Kitchen();
        kitchen.getBreakfast();
    }
    public static void main(String[] args) {
        var home = new Home();
        home.enterRoom();
        home.eat();

        // Kitchen kitchen = new Kitchen(); DOES NOT COMPILE
        Kitchen kitchen = home.new Kitchen(); // Create the inner class instance
        // or Kitchen kitchen = home.new Kitchen();
        kitchen.getDinner();

        Room room = new Home().new Room();
        System.out.println(room);
    }

}
