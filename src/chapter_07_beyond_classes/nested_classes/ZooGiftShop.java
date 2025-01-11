package chapter_07_beyond_classes.nested_classes;

/**
 * Nested Classes
 * --------------
 * Anonymous Class:
 * Is a specialized form of a local class that does not have a name.
 */
public class ZooGiftShop {
    abstract class SaleTodayOnly {
        abstract int dollarsOff();
    }

    interface SaleTomorrow {
        int dollarsOff();
        int day();
    }

    public int admission(int basePrice) {
        SaleTodayOnly sale = new SaleTodayOnly() {
            @Override
            int dollarsOff() {
                return 3;
            }
        };

        SaleTomorrow saleTomorrow = new SaleTomorrow() {
            @Override
            public int dollarsOff() {
                return 4;
            }

            @Override
            public int day() {
                return 0;
            }
        };

        return basePrice - sale.dollarsOff() - saleTomorrow.dollarsOff();
    }

    public static void main(String[] args) {
        ZooGiftShop zooGiftShop = new ZooGiftShop();
        System.out.println(zooGiftShop.admission(9));
    }
}
