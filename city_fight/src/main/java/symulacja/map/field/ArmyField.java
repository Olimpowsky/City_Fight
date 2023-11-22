package symulacja.map.field;
import java.util.Iterator;
import java.util.List;
/**klasa utworzona na podstawie interface Field odpowiadajaca za parametr armii*/
public class ArmyField implements Field{
    @Override
    public void addField(int x, List<Integer> fld) {
        for(int i = 0 ; i<x;i++){
            for(int j = 0; j<x;j++){
                fld.add(rand.nextInt(4));
            }
        }
    }

    @Override
    public void showField(int y, List<Integer> fld) {
        Iterator<Integer> fldIterator = fld.iterator();
        while(fldIterator.hasNext()){
            for (int i = 0; i<y;i++){
                System.out.print(fldIterator.next());
            }
            System.out.println(" ");
        }
    }
}
