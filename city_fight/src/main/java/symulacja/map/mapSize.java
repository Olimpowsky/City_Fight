package symulacja.map;
/** klasa odpowiedzialna za ustawienie odpowiedniego rozmiaru mapy oraz za przechowywanie informacji o wybranym rozmiarze mapy*/
public class mapSize  {

    private int mapsize ;
    /** metoda odpowiedzialna za ustawienie malego rozmiaru mapy 8x8 (64 pola)*/
    public void setSmallmapsize(){
        mapsize = 8 ;
    }
    /** metoda odpowiedzialna za ustawienie sredniego rozmiaru mapy 10x10 (100 pol)*/
    public void setMediummapsize(){
        mapsize = 10 ;
    }
    /** metoda odpowiedzialna za ustawienie duzego rozmiaru mapy 12x12 (144 pola)*/
    public void setBigmapsize(){
        mapsize = 12 ;
    }
    /** metoda odpowiedzialna za zwracanie wartosci rozmiaru mapy*/
    public int getMapsize(){
        return mapsize ;
    }
}
