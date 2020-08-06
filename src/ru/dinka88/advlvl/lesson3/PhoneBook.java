package ru.dinka88.advlvl.lesson3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {

    Map<String, List <Long>> phoneBook = new HashMap<>();

    public void add ( String lastName, Long phone){

        if (phoneBook.containsKey(lastName)==false){
            List<Long> phones = new ArrayList<>();
            phones.add(phone);
            phoneBook.put(lastName,phones);
        }else {
            List<Long> phones = phoneBook.get(lastName);
            phones.add(phone);
        }
    }


    @Override
    public String toString() {
        return phoneBook.toString();
    }

//    public void add(Long phone, String lastName) {
//        phoneBook.put(phone, lastName);
//    }
//
//    public List<Long> get(String lastName) {
//        List<Long> phoneNumber = new ArrayList<>();
//        for (Map.Entry<Long, String> entry : phoneBook.entrySet()) {
//            Long phone = entry.getKey();
//            if (entry.getValue().equals(lastName)) {
//                phoneNumber.add(phone);
//            }
//        }
//        return phoneNumber;
//
//    }


}
