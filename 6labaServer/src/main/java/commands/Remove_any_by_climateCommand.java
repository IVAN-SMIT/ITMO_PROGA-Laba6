package commands;

import City.*;
import auxiliary.Command;

import java.util.Iterator;
import java.util.Stack;

/**
 * Удаляет из коллекции один элемент, значение поля climate которого эквивалентно заданному (задается вручную)
 */

public class Remove_any_by_climateCommand implements Command {
    public  String run(String argument,Stack<City> cityCollection ) throws Exception {

        Climate climate = null;

        try{
             climate = Climate.getEnumByName(argument);

        }catch (Exception e){
            e.printStackTrace();
            return "Введены неверные данные! Попробуйте снова. (начните с remove_any_by_climate)";
        }
        Iterator<City> iterator = cityCollection.iterator();
            int count = 0;
            int fin = cityCollection.size();
            String result ="";
        while (iterator.hasNext()) {
            count = count + 1;
            City element = iterator.next();
            if (element.getClimate().toString().equals(climate.toString())) {
                iterator.remove();
                count = count + 1;
                result = result + "\nУдален элемент:\n " + element + "\n  со значением поля Climate: " + climate+"\n" +"Введите 'save' чтобы сохранить изменения";

            } else  if (count == fin | count == 0) {
                result = ("Элементы со значением " + climate + " отсутсвуют!");
            }
        }
        return result.toString();
    }
}
