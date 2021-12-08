package lab3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MilitaryBase {
    private String name;
    private List<Soldier> militaryList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Soldier> getMilitaryList() {
        return militaryList;
    }

    public void setMilitaryList(List<Soldier> militaryList) {
        this.militaryList = militaryList;
    }

    public static class Builder{
        private MilitaryBase newBase;

        public Builder() {
            newBase = new MilitaryBase();
        }

        public Builder withMilitaryName(String name){
            newBase.name = name;
            return this;
        }

        public Builder withMilitaryList(List<Soldier> list){
            newBase.militaryList = list;
            return this;
        }

        public MilitaryBase build(){
            return newBase;
        }
    }

    public static List<Soldier> filter(List<Soldier> list, String name){

        for(int i = list.size()-1; i >=0 ;i--){
            if(list.get(i).getName() == name) {
                list.remove(i);
            }
        }
        return list;
    }

    public List<Soldier> sortBySurnames() {
        militaryList.sort(new SoldierComparator());
        return militaryList;
    }

    public List<Soldier> sortBySurnamesStream() {
        return militaryList.stream().sorted(new SoldierComparator()).toList();
    }

    public List<Soldier> filterStream(List<Soldier> list, String name) {
        return list.stream().filter(a -> a.getName() != name).toList();
    }

    public List<Soldier> getmilitaryListOfAge(int age) {
        List<Soldier> res = new ArrayList<Soldier>();
        for (var anm : militaryList) {
            if (anm.getAge() == age) {
                res.add(anm);
            }
        }
        return res;
    }

    public List<Soldier> getmilitaryListOfAgeStream(int Age) {
        return militaryList.stream().filter(a->a.age == Age).toList();
    }

    @Override
    public String toString() {
        return "MilitaryBase{" +
                "name='" + name + '\'' +
                ", militaryList=" + militaryList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MilitaryBase that = (MilitaryBase) o;
        return name.equals(that.name) && militaryList.equals(that.militaryList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, militaryList);
    }
}
