package lab3;

import java.util.Comparator;

public class SoldierComparator implements Comparator<Soldier> {
    @Override
    public int compare(Soldier o1, Soldier o2) {
        return o1.compareTo(o2);
    }
}
