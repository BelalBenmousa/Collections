package n3exercici2;

import java.util.*;

public class main {
    public static void main(String[] args) {
        List<Integer> primeraLLista = new ArrayList<>();
        for(int i = 0; i<10; i++){
            primeraLLista.add(i);
        }
        System.out.println("Primera llista sense invertir");
        primeraLLista.forEach(System.out::println);

        System.out.println("Segona llista invertint numeros");
        List<Integer> segonaLLista = new ArrayList<>(primeraLLista);
        Collections.reverse(segonaLLista);
        ListIterator it = segonaLLista.listIterator();

        while(it.hasNext())
            System.out.println(it.next());
    }
}
