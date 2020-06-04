package ru.dinka88.lesson7;

public class Mane {
    public static void main(String[] args) {
        Cat cat1= new Cat("Barsik",20);
        Cat cat2= new Cat("Myrzik",40);
        Cat cat3= new Cat("Tigr",50);
        Cat cat4= new Cat("Pushok",25);
        Cat cat5= new Cat("Musia",15);
        Plate plate= new Plate(100);
        Cat [] arrCat= {cat1,cat2,cat3,cat4,cat5};
         for (int i=0;i<arrCat.length;i++){
             arrCat[i].eat(plate);
             arrCat[i].infoSatiety();
         }
         plate.infoBalance();




//        plate1.info();
//        cat1.eat(plate1);
//        cat1.infoSatiety();
//        plate1.infoBalance();
//        plate1.addFood();


    }
}
