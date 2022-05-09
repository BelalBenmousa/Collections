package n3exercici3;

//Donat el fitxer countrties.txt que conté països i capitals. El programa ha de llegir el fitxer i guardar les dades en un HashMap<String, String>. El programa demana el nom de l’usuari, i després ha de mostrar un país de forma aleatòria, guardat en el HashMap. Es tracta de què l’usuari ha d’escriure el nom de la capital del país en qüestió. Si l’encerta se li suma un punt a l’usuari. Aquesta acció es repeteix 10 vegades. Un cop demanades les capitals de 10 països de forma aleatòria, llavors s’ha de guardar en un fitxer anomenat classificacio.txt, el nom de l’usuari i la seva puntuació.

public class main {
    public static void main(String[] args) {
        RankingFile rankingFile = new RankingFile();
        rankingFile.createFile();
        CountriresGame countriresGame = new CountriresGame();
        countriresGame.gameStart();
        rankingFile.showRanking();
    }

}



