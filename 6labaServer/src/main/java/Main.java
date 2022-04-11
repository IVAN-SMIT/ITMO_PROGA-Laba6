import City.City;
import auxiliary.Commander;
import auxiliary.IdChecker;
import connection.ServerManager;
import fileManager.FileManager;

import java.lang.reflect.Proxy;
import java.util.Stack;

// вариант 665580


public class Main {
    public static void main(String[] args) throws Exception {

        if (args.length != 1) {
            System.out.println("Пожалуйста, запускайте только с именем файла коллекции!");
        }

        Stack<City> cityCollection = new FileManager().loadCollection(args[0]);
        Commander.setCollection(cityCollection);
        System.out.println("Коллекция загружена");

        while (true) {

            new IdChecker();
            IdChecker.check(cityCollection);

                ServerManager server = new ServerManager(9890);
                server.starting(cityCollection);

            }
        }
    }


