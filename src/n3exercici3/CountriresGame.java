package n3exercici3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class CountriresGame {
    final static String filePath
            = "src/n3exercici3/countries.txt";
    public static Scanner sc = new Scanner(System.in);
    RankingFile rankingFile;

    public void gameStart() {
        rankingFile = new RankingFile();
        Map<String, String> mapFromFile
                = HashMapFromTextFile();
//        System.out.println("Country : Capital");
//        for (Map.Entry<String, String> entry :
//                mapFromFile.entrySet()) {
//            System.out.println(entry.getKey() + " : "
//                    + entry.getValue());
//        }
        String name = userCredentials();
        System.out.println("Hola " + name);
        String country = randomCountry(mapFromFile);

//        print per veure el país avanç d'entrar
//        System.out.println(country);
        comprobarEncertades(country, name, mapFromFile);
    }


    public void comprobarEncertades(String country, String name, Map<String, String> randomCountry ){
        int countacertadas = 0;
        for(int i = 0; i<2; i++) {
//            System.out.println("country inside comprobarEncertades --> " +country);
            if (checkUserInputCountry(country)) {
                System.out.println("Has adivinado");
                countacertadas++;
                System.out.println("Molt bè el país era "+ country);
//
            } else {System.out.println("Has fallat");
                System.out.println("El país era "+ country);
            }

            country = randomCountry(randomCountry);
        }
        if(countacertadas >= 1 ){
            rankingFile.updateRanking(name, countacertadas);
        }
    }

    //    llegeix un fitxer
    public  Map<String, String> HashMapFromTextFile()
    {

        Map<String, String> map
                = new HashMap<String, String>();
        BufferedReader br = null;

        try {

            File file = new File(filePath);
            br = new BufferedReader(new FileReader(file));

            String line = null;
            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",");
                String name = parts[0].trim();
                String number = parts[1].trim();

                if (!name.equals("") && !number.equals(""))
                    map.put(name, number);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {

            if (br != null) {
                try {
                    br.close();
                }
                catch (Exception e) {
                }
            }
        }

        return map;
    }
    //Genera un pais y la seva capital
    public  String randomCountry(Map<String, String> countries) {
        Random generator = new Random();
        Object[] values = countries.entrySet().toArray();
        Object randomValue = values[generator.nextInt(values.length)];
        StringBuilder sb = new StringBuilder(randomValue.toString());
        String country = sb.toString();
        String[] splitcountry = country.split("=");
        country = splitcountry[0];
//        System.out.println("country variable = "+ country);
//        System.out.println("country variable = "+ country);
//        System.out.println(randomCountry);
        return country;
    }
    //Usuari credentials
    public  String userCredentials(){
        System.out.println("Introdueix el teu nom d'usuari per poder jugar: ");
        String name = sc.nextLine();
        return name;
    }
    //comprobar si la capital introduida es la mateixa
    public boolean checkUserInputCountry(Object country){
        System.out.println("Introdueix la capital: ");
        String name = sc.nextLine();
//        System.out.println("name -> "+name);
//        System.out.println("Country es "+country.toString());
        return name.equalsIgnoreCase(country.toString());
    }

}
