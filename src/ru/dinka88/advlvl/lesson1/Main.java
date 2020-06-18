package ru.dinka88.advlvl.lesson1;

import ru.dinka88.advlvl.lesson1.q1.Cat;
import ru.dinka88.advlvl.lesson1.q1.Human;
import ru.dinka88.advlvl.lesson1.q1.Robot;
import ru.dinka88.advlvl.lesson1.q2.Passable;
import ru.dinka88.advlvl.lesson1.q2.People;
import ru.dinka88.advlvl.lesson1.q2.Treadmill;
import ru.dinka88.advlvl.lesson1.q2.Wall;

public class Main {
    public static void main(String[] args) {
        People [] peopleArr= new People[6];
        peopleArr [0] = new People("Ira",250,30);
        peopleArr [1] = new People("Egor",220,40);
        peopleArr [2] = new People("Dima",300,26);
        peopleArr [3] = new People("Anna",150,33);
        peopleArr [4] = new People("Ivan",260,44);
        peopleArr [5]= new People("Pasha",310,45);

        Passable [] passablesArr= new Passable[5];
        passablesArr [0]= new Treadmill(180);
        passablesArr [1]= new Wall(30);
        passablesArr [2]= new Treadmill(260);
        passablesArr [3]= new Wall(31);
        passablesArr [4]=new Treadmill(305);

        for (int i=0;i< peopleArr.length;i++){
            for (int j = 0; j < passablesArr.length; j++) {
                if (peopleArr[i].onDistance()==true ) {
                    passablesArr[j].pass(peopleArr[i]);
                }
            }

        }
        for ( int i=0; i< peopleArr.length;i++){
            if (peopleArr[i].onDistance()== true){
                System.out.println(peopleArr[i].name + " выйграл! ");
            }
        }

        Cat cat = new Cat("Murzik");
        cat.jump();
        cat.run();
        Robot robot= new Robot("Dack");
        robot.jump();
        robot.run();
        Human man= new Human("Dima");
        man.jump();
        man.run();
    }


}

