package n3exercici3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RankingFile implements Ranking{
    private static String FILENAME = "src/n3exercici3/ranking.txt";

    @Override
    public void createFile() {
        try {

            File myFile = new File(FILENAME);

            if (myFile.createNewFile()){
                System.out.println("Fichero creado");
            }

        } catch (IOException e) {
            System.out.println("Ha habido un error al crear el fichero");
        }
    }

    @Override
    public void updateRanking(String username, int score) {
        FileWriter escritura = null;
        try {
            escritura = new FileWriter(FILENAME, true);
            escritura.write(username + "="+score+"\n");
            escritura.close();

        } catch (IOException e) {
            System.out.println("Ha habido un error en la escritura");
        }
    }

    @Override
    public void showRanking() {
        try {

            HashMap<String, Integer> map = new HashMap<String, Integer>();

            String line;
            BufferedReader reader = new BufferedReader(new FileReader(FILENAME));
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length >= 2) {
                    String username = parts[0];
                    Integer wins = Integer.valueOf(parts[1]);
                    if(map.containsKey(username)) {
                        Integer victorias = map.get(username);
                        map.put(username, victorias+1);
                    } else {
                        map.put(username, wins);
                    }
                } else {
                    System.out.println("ignoring line: " + line);
                }
            }
            System.out.println("-RANKING-");
            System.out.println();
            System.out.println();
            System.out.println("Usuario"+"\t"+"Victorias");
            Map<String, Integer> hm1 = sortByValue(map);
            for (Map.Entry<String, Integer> en : hm1.entrySet()) {
                System.out.println(en.getKey() +"\t"+ en.getValue());
            }

            reader.close();
        }catch(IOException e){
            System.out.println("Ha habido un error en la lectura");
        }
    }

        public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> map)
    {

        List<Map.Entry<String, Integer> > list =
                new LinkedList<Map.Entry<String, Integer> >(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());

            }
        });

        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());

        }
        return temp;
    }
}
