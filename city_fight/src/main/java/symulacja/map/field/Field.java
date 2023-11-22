package symulacja.map.field;

import java.util.List;
import java.util.Random;
/**jest to interface na bazie ktorego powstaja kolejne parametry pol*/
public interface Field {
    Random rand = new Random() ;
    /**metoda odpowiedzialna wygenerowanie wartosci danego parametru dla kolejnych pol*/
    void addField(int x, List<Integer> fld);
    /**metoda odpowiedzialna wyswietlenie wartosci danego parametru dla kolejnych pol*/
    default void showField(int y, List<Integer> fld){

    }

}
