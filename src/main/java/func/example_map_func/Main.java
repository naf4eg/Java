package func.example_map_func;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
    public static void main (String[] args) {
        //        forEachMapExample();
        //        replaceMapExample();
       // mergeMapExample();
        computeMapExample();
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
        Map<String, String> phoneBook = new HashMap<>(Map.of(
            "Tom Hunter", "0131 128 8144",
            "Layla Graham", "0702 7296 3035",
            "Michael Butler", "0035 0938 2100"
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

    private static void computeMapExample() {
        Map<String, Integer> companyToNumberOfEmployeesMap = new HashMap<>();
        companyToNumberOfEmployeesMap.put("Goods Inc", 550);
        companyToNumberOfEmployeesMap.put("BestDevStudio", 1200);
        companyToNumberOfEmployeesMap.put("Ggl", 1000000);

        System.out.println("--------------------------");

        companyToNumberOfEmployeesMap.forEach((company, countEmployee) -> System.out.printf(
            "Company: %s | Count Employee: %s\n",
            company,
            countEmployee
        ));

        companyToNumberOfEmployeesMap.compute("Ggl", (company, employees) -> (int) (employees * 0.8));

        System.out.println("--------------------------");

        companyToNumberOfEmployeesMap.forEach((company, countEmployee) -> System.out.printf(
            "Company: %s | Count Employee: %s\n",
            company,
            countEmployee
        ));

        System.out.println("--------------------------");

        /* Когда не нашлось нужного ключа в мап, то будет исключение, тогда делаем проверку */
        companyToNumberOfEmployeesMap.compute("Unknown",
            (company, employees) -> Objects.nonNull(employees) ? (int) (employees * 0.8) : 0);

        companyToNumberOfEmployeesMap.forEach((company, countEmployee) -> System.out.printf(
            "Company: %s | Count Employee: %s\n",
            company,
            countEmployee
        ));

        System.out.println("--------------------------");

        /* вычислить если отстутствует */
        companyToNumberOfEmployeesMap.computeIfAbsent("NewCompany", value -> 40);

        companyToNumberOfEmployeesMap.forEach((company, countEmployee) -> System.out.printf(
            "Company: %s | Count Employee: %s\n",
            company,
            countEmployee
        ));

        System.out.println("--------------------------");

        /* вычислить если отстутствует. Вычисления не происходят если ключ уже есть */
        companyToNumberOfEmployeesMap.computeIfAbsent("NewCompany", value-> {
            System.out.println("вычисляем! - 1");
            return 77;
        });

        companyToNumberOfEmployeesMap.remove("NewCompany");
        System.out.println("--------------------------");
        System.out.println("Удаляем NewCompany");
        System.out.println("--------------------------");

        /* вычислить если отстутствует. Вычисления не происходят если ключ уже есть */
        /* тут вычисления проходят так-как ключа нет в мап */
        companyToNumberOfEmployeesMap.computeIfAbsent("NewCompany", value-> {
            System.out.println("вычисляем! - 2");
            return 77;
        });

        System.out.println("--------------------------");

        companyToNumberOfEmployeesMap.forEach((company, countEmployee) -> System.out.printf(
            "Company: %s | Count Employee: %s\n",
            company,
            countEmployee
        ));
        System.out.println("--------------------------");

        /* вычислить если присутствует такой ключ. Вычисления происходят если ключ уже есть */
        companyToNumberOfEmployeesMap.computeIfPresent("NewCompany", (key, value)-> {
            System.out.println("вычисляем! - 3");
            return 100;
        });

        System.out.println("--------------------------");

        /* тут вычисления проходят так-как ключа нет в мап */
        companyToNumberOfEmployeesMap.forEach((company, countEmployee) -> System.out.printf(
            "Company: %s | Count Employee: %s\n",
            company,
            countEmployee
        ));

        System.out.println("--------------------------");

        /* вычислить если присутствует такой ключ. В данно методе вычисления не происходят */
        companyToNumberOfEmployeesMap.computeIfPresent("Kukuruma", (key, value)-> {
            System.out.println("вычисляем! - 4");
            return 1000;
        });
    }

}
