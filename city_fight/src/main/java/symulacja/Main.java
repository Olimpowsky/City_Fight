package symulacja;

import symulacja.cities.City;
import symulacja.cities.Resources;
import symulacja.map.Map1;
import symulacja.map.field.ArmyField;
import symulacja.map.field.FoodField;
import symulacja.map.mapSize;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        mapSize mapsize = new mapSize();
        boolean con = true;
        while (con) {
            System.out.println("Wybierz wielkość mapy");
            System.out.println("1. Mała mapa 8x8");
            System.out.println("2. Średnia mapa 10x10");
            System.out.println("3. Duża mapa 12x12");
            Scanner scanner = new Scanner(System.in);
            int userChoice = scanner.nextInt();
            switch (userChoice) {
                case 1 -> mapsize.setSmallmapsize();
                case 2 -> mapsize.setMediummapsize();
                case 3 -> mapsize.setBigmapsize();
            }
            Map1 map1 = new Map1();
            FoodField foodfield = new FoodField();
            ArmyField armyfield = new ArmyField();
            char[][] worldmap1;
            worldmap1 = new char[mapsize.getMapsize()][mapsize.getMapsize()];
            map1.createMap(worldmap1);
            map1.showMap(worldmap1);
            List<Integer> foodfields = new ArrayList<>();
            List<Integer> armyfields = new ArrayList<>();
            System.out.println(" ");
            System.out.println("Wygenerowano zasoby jedzenia:");
            foodfield.addField(mapsize.getMapsize(), foodfields);
            foodfield.showField(mapsize.getMapsize(), foodfields);
            System.out.println(" ");
            System.out.println("Wygenerowano zasoby armii:");
            armyfield.addField(mapsize.getMapsize(), armyfields);
            armyfield.showField(mapsize.getMapsize(), armyfields);
            int i;
            int j;
            Random rand = new Random();
            Resources resourcesA = new Resources();
            Resources resourcesB = new Resources();
            City cityA = new City();
            City cityB = new City();
            cityA.setCitysym('A');
            cityB.setCitysym('B');
            i = rand.nextInt(mapsize.getMapsize());
            j = rand.nextInt(mapsize.getMapsize());
            int p;
            System.out.println("Współrzędne startowe pierwszego miasta x: " + i + " y:" + j);
            resourcesA.setFoodRes(foodfields, i * mapsize.getMapsize() + j);
            resourcesA.setArmyRes(armyfields, i * mapsize.getMapsize() + j);
            resourcesA.setCityQuantity(1);
            worldmap1[i][j] = cityA.getCitysym();
            boolean Start = true;
            while (Start) {
                i = rand.nextInt(mapsize.getMapsize());
                j = rand.nextInt(mapsize.getMapsize());
                if (worldmap1[i][j] == 'X') {
                    System.out.println("Współrzędne startowe drugiego miasta x: " + i + " y:" + j);
                    worldmap1[i][j] = cityB.getCitysym();
                    resourcesB.setFoodRes(foodfields, i * mapsize.getMapsize() + j);
                    resourcesB.setArmyRes(armyfields, i * mapsize.getMapsize() + j);
                    resourcesB.setCityQuantity(1);
                    Start = false;
                }
            }
            int q = 0;
            map1.showMap(worldmap1);
            boolean tury = false ;
            System.out.println("Wybierz sposób działania");
            System.out.println("1. Chcę wyświetlić wszystkie tury i od razu uzyskać wynik końcowy działania symulacji (zalecane dla mapy 10x10 i 12x12)");
            System.out.println("2. Chcę wyświetlić kolejne 10 tur działania symulacji i mieć możliwość przerwania działania symulacji po każdych kolejnych 10 turach");
            int userChoice2 = scanner.nextInt();
            switch (userChoice2) {
                case 1 -> System.out.println(" ");
                case 2 -> tury = true ;
            }
            boolean sym = true;
            while (sym) {
                if (resourcesA.getFoodRes() >= (2* mapsize.getMapsize())) {
                    for (int k = 0; k < 2; k++) {
                        if(resourcesB.getCityQuantity()<=0){
                            break ;}
                        i = rand.nextInt(mapsize.getMapsize());
                        j = rand.nextInt(mapsize.getMapsize());
                        if (worldmap1[i][j] == cityA.getCitysym()) {
                            k--;
                        } else {
                            if (worldmap1[i][j] == 'X') {
                                worldmap1[i][j] = cityA.getCitysym();
                                resourcesA.setFoodRes(foodfields, i * mapsize.getMapsize() + j);
                                resourcesA.setArmyRes(armyfields, i * mapsize.getMapsize() + j);
                                resourcesA.setCityQuantity(1);
                            } else {
                                if (resourcesA.getArmyRes() <= (5* mapsize.getMapsize())) {
                                    p = rand.nextInt(10);
                                    if (p < 4) {
                                        worldmap1[i][j] = cityA.getCitysym();
                                        resourcesA.setFoodRes(foodfields, i * mapsize.getMapsize() + j);
                                        resourcesA.setArmyRes(armyfields, i * mapsize.getMapsize() + j);
                                        resourcesA.setCityQuantity(1);
                                        resourcesB.lossFoodRes(foodfields, i * mapsize.getMapsize() + j);
                                        resourcesB.lossArmyRes(armyfields, i * mapsize.getMapsize() + j);
                                        resourcesB.setCityQuantity(-1);
                                    }
                                }
                                else {
                                    p = rand.nextInt(10);
                                    if (p < 6) {
                                        worldmap1[i][j] = cityA.getCitysym();
                                        resourcesA.setFoodRes(foodfields, i * mapsize.getMapsize() + j);
                                        resourcesA.setArmyRes(armyfields, i * mapsize.getMapsize() + j);
                                        resourcesA.setCityQuantity(1);
                                        resourcesB.lossFoodRes(foodfields, i * mapsize.getMapsize() + j);
                                        resourcesB.lossArmyRes(armyfields, i * mapsize.getMapsize() + j);
                                        resourcesB.setCityQuantity(-1);
                                    }
                                }
                            }
                        }
                    }
                }
                else {
                    for (int k = 0; k < 1; k++) {
                        i = rand.nextInt(mapsize.getMapsize());
                        j = rand.nextInt(mapsize.getMapsize());
                        if (worldmap1[i][j] == cityA.getCitysym()) {
                            k--;
                        } else {
                            if (worldmap1[i][j] == 'X') {
                                worldmap1[i][j] = cityA.getCitysym();
                                resourcesA.setFoodRes(foodfields, i * mapsize.getMapsize() + j);
                                resourcesA.setArmyRes(armyfields, i * mapsize.getMapsize() + j);
                                resourcesA.setCityQuantity(1);
                            }
                            else {
                                if (resourcesA.getArmyRes() <= (5* mapsize.getMapsize())) {
                                    p = rand.nextInt(10);
                                    if (p < 4) {
                                        worldmap1[i][j] = cityA.getCitysym();
                                        resourcesA.setFoodRes(foodfields, i * mapsize.getMapsize() + j);
                                        resourcesA.setArmyRes(armyfields, i * mapsize.getMapsize() + j);
                                        resourcesA.setCityQuantity(1);
                                        resourcesB.lossFoodRes(foodfields, i * mapsize.getMapsize() + j);
                                        resourcesB.lossArmyRes(armyfields, i * mapsize.getMapsize() + j);
                                        resourcesB.setCityQuantity(-1);
                                    }
                                }
                                else {
                                    p = rand.nextInt(10);
                                    if (p < 6) {
                                        worldmap1[i][j] = cityA.getCitysym();
                                        resourcesA.setFoodRes(foodfields, i * mapsize.getMapsize() + j);
                                        resourcesA.setArmyRes(armyfields, i * mapsize.getMapsize() + j);
                                        resourcesA.setCityQuantity(1);
                                        resourcesB.lossFoodRes(foodfields, i * mapsize.getMapsize() + j);
                                        resourcesB.lossArmyRes(armyfields, i * mapsize.getMapsize() + j);
                                        resourcesB.setCityQuantity(-1);
                                    }
                                }


                            }
                        }
                    }

                }
                if (resourcesB.getCityQuantity() == 0) {
                    System.out.println("Miasto B przestało istnieć");
                    map1.showMap(worldmap1);
                    sym = false ;
                    break ;
                }
                System.out.println("Dane miasta:" + cityA.getCitysym() + "    " +  resourcesA.getFoodRes() + ": jednostek jedzenia" + "    " + resourcesA.getArmyRes() + ": jednostek armii");
                System.out.println("Dane miasta:" + cityB.getCitysym() + "    " +  resourcesB.getFoodRes() + ": jednostek jedzenia" + "    " + resourcesB.getArmyRes() + ": jednostek armii");
                map1.showMap(worldmap1);
                System.out.println(" ");
                // przerwa
                if (resourcesB.getFoodRes() >= (2* mapsize.getMapsize())) {
                    for (int k = 0; k < 2; k++) {
                        if(resourcesA.getCityQuantity()<=0){
                            break ;
                        }
                        i = rand.nextInt(mapsize.getMapsize());
                        j = rand.nextInt(mapsize.getMapsize());
                        if (worldmap1[i][j] == cityB.getCitysym()) {
                            k--;
                        }
                        else {
                            if (worldmap1[i][j] == 'X') {
                                worldmap1[i][j] = cityB.getCitysym();
                                resourcesB.setFoodRes(foodfields, i * mapsize.getMapsize() + j);
                                resourcesB.setArmyRes(armyfields, i * mapsize.getMapsize() + j);
                                resourcesB.setCityQuantity(1);
                            }
                            else {
                                if (resourcesB.getArmyRes() <= (5* mapsize.getMapsize())) {
                                    p = rand.nextInt(10);
                                    if (p < 4) {
                                        worldmap1[i][j] = cityB.getCitysym();
                                        resourcesB.setFoodRes(foodfields, i * mapsize.getMapsize() + j);
                                        resourcesB.setArmyRes(armyfields, i * mapsize.getMapsize() + j);
                                        resourcesB.setCityQuantity(1);
                                        resourcesA.lossFoodRes(foodfields, i * mapsize.getMapsize() + j);
                                        resourcesA.lossArmyRes(armyfields, i * mapsize.getMapsize() + j);
                                        resourcesA.setCityQuantity(-1);
                                    }
                                }
                                else {
                                    p = rand.nextInt(10);
                                    if (p < 6) {
                                        worldmap1[i][j] = cityB.getCitysym();
                                        resourcesB.setFoodRes(foodfields, i * mapsize.getMapsize() + j);
                                        resourcesB.setArmyRes(armyfields, i * mapsize.getMapsize() + j);
                                        resourcesB.setCityQuantity(1);
                                        resourcesA.lossFoodRes(foodfields, i * mapsize.getMapsize() + j);
                                        resourcesA.lossArmyRes(armyfields, i * mapsize.getMapsize() + j);
                                        resourcesA.setCityQuantity(-1);
                                    }
                                }

                            }
                        }
                    }
                }
                else {
                    for (int k = 0; k < 1; k++) {
                        i = rand.nextInt(mapsize.getMapsize());
                        j = rand.nextInt(mapsize.getMapsize());
                        if (worldmap1[i][j] == cityB.getCitysym()) {
                            k--;
                        }
                        else {
                            if (worldmap1[i][j] == 'X') {
                                worldmap1[i][j] = cityB.getCitysym();
                                resourcesB.setFoodRes(foodfields, i * mapsize.getMapsize() + j);
                                resourcesB.setArmyRes(armyfields, i * mapsize.getMapsize() + j);
                                resourcesB.setCityQuantity(1);
                            }
                            else {
                                if (resourcesB.getArmyRes() <= (5* mapsize.getMapsize())) {
                                    p = rand.nextInt(10);
                                    if (p < 4) {
                                        worldmap1[i][j] = cityB.getCitysym();
                                        resourcesB.setFoodRes(foodfields, i * mapsize.getMapsize() + j);
                                        resourcesB.setArmyRes(armyfields, i * mapsize.getMapsize() + j);
                                        resourcesB.setCityQuantity(1);
                                        resourcesA.lossFoodRes(foodfields, i * mapsize.getMapsize() + j);
                                        resourcesA.lossArmyRes(armyfields, i * mapsize.getMapsize() + j);
                                        resourcesA.setCityQuantity(-1);
                                    }
                                }
                                else {
                                    p = rand.nextInt(10);
                                    if (p < 6) {
                                        worldmap1[i][j] = cityB.getCitysym();
                                        resourcesB.setFoodRes(foodfields, i * mapsize.getMapsize() + j);
                                        resourcesB.setArmyRes(armyfields, i * mapsize.getMapsize() + j);
                                        resourcesB.setCityQuantity(1);
                                        resourcesA.lossFoodRes(foodfields, i * mapsize.getMapsize() + j);
                                        resourcesA.lossArmyRes(armyfields, i * mapsize.getMapsize() + j);
                                        resourcesA.setCityQuantity(-1);
                                    }
                                }

                            }
                        }
                    }
                }
                if (resourcesA.getCityQuantity() <= 0) {
                    System.out.println("Miasto A przestało istnieć");
                    map1.showMap(worldmap1);
                    sym = false;
                }
                System.out.println("Dane miasta:" + cityA.getCitysym() + "    " +  resourcesA.getFoodRes() + ": jednostek jedzenia" + "    " + resourcesA.getArmyRes() + ": jednostek armii");
                System.out.println("Dane miasta:" + cityB.getCitysym() + "    " + resourcesB.getFoodRes() + ": jednostek jedzenia" + "    " + resourcesB.getArmyRes() + ": jednostek armii");
                map1.showMap(worldmap1);
                System.out.println(" ");


                if (q == 10 && sym && tury) {
                    System.out.println("1. Chcę wyświetlić kolejne 10 tur ?");
                    System.out.println("2. Przerwij");
                    Scanner scansym = new Scanner(System.in);
                    int userChoicesym = scansym.nextInt();
                    switch (userChoicesym) {
                        case 1 -> q=-1 ;
                        case 2 -> sym = false;
                    }
                }
               q ++ ;
            }
            System.out.println("Czy chcesz powtórzyć symulację?");
            System.out.println("1. Tak");
            System.out.println("2. Nie");
            Scanner scancon = new Scanner(System.in);
            int userChoiceCon = scancon.nextInt();
            switch (userChoiceCon) {
                case 1 -> System.out.println(" ");
                case 2 -> con = false;
            }

        }

    }
}

