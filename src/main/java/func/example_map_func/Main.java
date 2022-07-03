package func.example_map_func;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
        //        forEachMapExample();
        //        replaceMapExample();
       // mergeMapExample();
    }

    private static void forEachMapExample () {
        Map<String, String> phoneBook = Map.of("Tom Hunter",
            "0131 128 8144",
            "Layla Graham",
            "07027296303",
            "Michael Butler",
            "+44(0)1035 093821"
        );

        phoneBook.forEach((name, phone) -> System.out.printf("Name: %s, Phone: %s\n", name, phone));
        System.out.println("--------------------------");
        phoneBook.keySet().forEach(System.out::println);
        System.out.println("--------------------------");
        phoneBook.entrySet().forEach(entry -> System.out.printf(
            "Name: %s, Phone: %s\n",
            entry.getKey(),
            entry.getValue()
        ));
    }

    private static void replaceMapExample () {
        Map<String, String> phoneBook = new HashMap<>(Map.of("Tom Hunter",
            "0131 128 8144",
            "Layla Graham",
            "0702 7296 3035",
            "Michael Butler",
            "0035 0938 2100"
        ));

        phoneBook.replaceAll((name, phone) -> "1 " + phone);
        System.out.println("--------------------------");
        phoneBook.forEach((name, phone) -> System.out.printf("Name: %s, Phone: %s\n", name, phone));
    }

    private static void mergeMapExample () {
        Map<String, Integer> companyToNumberOfEmployeesMap = new HashMap<>();

        companyToNumberOfEmployeesMap.put("Goods Inc", 550);
        companyToNumberOfEmployeesMap.put("BestDevStudio", 1200);
        companyToNumberOfEmployeesMap.put("Ggl", 1000000);

        companyToNumberOfEmployeesMap.merge("Goods Inc", 50, Integer::sum); // adding 50
        companyToNumberOfEmployeesMap.merge("Healthy Eating", 100, Integer::sum); // a new company
        companyToNumberOfEmployeesMap.merge("Healthy Eating", 55, (a, b) -> a + (b * 2));

        System.out.println("--------------------------");
        companyToNumberOfEmployeesMap.forEach((company, countEmployee) -> System.out.printf(
            "Company: %s | Count Employee: %s\n",
            company,
            countEmployee
        ));
    }

}
