package symulacja.map;
/**klasa odpowiedzialna za "wygenerowanie mapy" i wyswietlanie stanu mapy w danej chwili*/
public class Map1 {
    /**metoda odpowiedzialna za wyswietlanie mapy*/
    public void showMap(char[][] mapa){
        for (char[] chars : mapa) {
            for (int j = 0; j < mapa.length; j++) {
                System.out.print(chars[j]);
            }
            System.out.println(" ");
        }
    }
    /**metoda odpowiedzialna za przypisanie kazdemu z pol wartosci neutralnej X(wygenerowanie mapy w stanie pierwotnym)*/
    public void createMap(char[][] mapa){
        for(int i = 0 ; i < mapa.length; i++){
            for(int j = 0 ; j<mapa.length;j++){
                mapa[i][j]='X';
            }
        }
    }
}
