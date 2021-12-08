package lab3;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Soldier soldier1 = new Soldier.Builder().withSurname("Prustypa").withName("Taras").withMiddleName("Stepanovuch").withAge(20).callDate("26.05.21").build();
        Soldier soldier2 = new Soldier.Builder().withSurname("Slusar").withName("Mukola").withMiddleName("Olegovuch").withAge(23).callDate("22.05.20").build();
        Soldier soldier3 = new Soldier.Builder().withSurname("Lutvunyk").withName("Ivan").withMiddleName("Mukolaevuch").withAge(26).callDate("07.09.20").build();
        Soldier soldier4 = new Soldier.Builder().withSurname("Bien").withName("Olexandre").withMiddleName("Muhaulovuch").withAge(22).callDate("26.11.19").build();
        Soldier soldier5 = new Soldier.Builder().withSurname("Cherenchyk").withName("Rostuslav").withMiddleName("Andriuovuch").withAge(20).callDate("11.10.20").build();
        

        List<Soldier> soldiers = new ArrayList<Soldier>();
        soldiers.add(soldier1);
        soldiers.add(soldier2);
        soldiers.add(soldier3);
        soldiers.add(soldier4);
        soldiers.add(soldier5);

        MilitaryBase militarybase = new MilitaryBase.Builder().withMilitaryName("A3290").withMilitaryList(soldiers).build();

        String sorted = new String();
        sorted = "";
        for (var an : militarybase.sortBySurnames()) {
            sorted += an.toString() + "\n";
        }
        System.out.println(sorted + "\n");

        String sortedStream = new String();
        sortedStream = "";
        for (var an : militarybase.sortBySurnamesStream()) {
            sortedStream += an.toString() + "\n";
        }
        System.out.println(sortedStream + "\n");

        String filtered = new String();
        filtered = "";
        for (var an : militarybase.filter(soldiers, "Olexandre")  ) {
            filtered += an.toString() + "\n";
        }
        System.out.println(filtered + "\n");

        String filteredStream = new String();
        filteredStream = "";
        for (var an : militarybase.filterStream(soldiers, "Mukola")) {
            filteredStream += an.toString() + "\n";
        }
        System.out.println(filteredStream + "\n");

        String find = new String();
        find = "";
        for (var an : militarybase.getmilitaryListOfAge(20)) {
            find += an.toString() + "\n";
        }
        System.out.println(find + "\n");

        String findStream = new String();
        findStream = "";
        for (var an : militarybase.getmilitaryListOfAgeStream(23)) {
            findStream += an.toString() + "\n";
        }
        System.out.println(findStream + "\n");
    }
}
