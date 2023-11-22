package symulacja.cities;

import java.util.List;

public class Resources {
    public int foodRes = 0 ;
    public int armyRes = 0;
    public int cityQuantity = 0;

    public int getFoodRes() {
        return foodRes;
    }

    public void setFoodRes(List<Integer>ff,int c) {
        this.foodRes += ff.get(c);
    }

    public int getArmyRes() {
        return armyRes;
    }

    public void setArmyRes(List<Integer>af,int c) {
        this.armyRes += af.get(c);
    }

    public int getCityQuantity() {
        return cityQuantity;
    }

    public void setCityQuantity(int q) {
        this.cityQuantity += q;
    }
    public void lossArmyRes(List<Integer>af,int c){
        this.armyRes -= af.get(c);
    }
    public void lossFoodRes(List<Integer>ff,int c) {
        this.foodRes -= ff.get(c);
    }
}
