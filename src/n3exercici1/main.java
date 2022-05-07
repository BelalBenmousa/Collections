package n3exercici1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class main {
    public static void main(String[] args) {
        Month gener = new Month("Gener");
        Month febrer = new Month("Febrer");
        Month  mars = new Month("Març");
        Month abril = new Month("Abril");
        Month maig = new Month("Maig");
        Month juny = new Month("Juny");
        Month juliol = new Month("Juliol");
        Month septembre = new Month("Septembre");
        Month octubre = new Month("Octubre");
        Month novembre = new Month("Novembre");
        Month desembre = new Month("Desembre");
        ArrayList<Month> months = new ArrayList<>(Arrays.asList(gener,febrer,mars,abril,maig,juny,juliol,septembre,octubre,novembre,desembre));
        System.out.println("***********Llista avanç d'afegir Agost*********");
        months.forEach(System.out::println);
        Month agost = new Month("Agost");
        System.out.println("*************Llista després d'afegir Agost*************");
        months.add(7, agost);
        months.forEach(System.out::println);
        System.out.println("*************Llista Afegint valors duplicats*************");
        months.add(gener);
        months.add(gener);
        months.add(novembre);
        months.forEach(System.out::println);
        HashSet<Month> monthHashSet = new HashSet<>(months);
        monthHashSet.add(gener);
        monthHashSet.add(gener);
        monthHashSet.add(novembre);
        System.out.println("**************Hashset sense valors duplicats**************");
        monthHashSet.forEach(System.out::println);
    }
}
