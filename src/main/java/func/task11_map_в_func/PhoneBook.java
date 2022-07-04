package func.task11_map_в_func;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

class PhoneBook {
    private final Map<String, Collection<PhoneNumber>> nameToPhoneNumbersMap = new HashMap<>();

    // methods
    void addNewPhoneNumbers (String name, Collection<PhoneNumber> phoneNumbers) {
        nameToPhoneNumbersMap.merge(name, phoneNumbers, ((phoneNumbers1, phoneNumbers2) -> {
            phoneNumbers1.addAll(phoneNumbers2);
            return phoneNumbers1;
        }));

        /* или такой вариант */
//        nameToPhoneNumbersMap.computeIfPresent(name, (k, v) -> {
//            v.addAll(phoneNumbers);
//            return v;
//        });
//        nameToPhoneNumbersMap.computeIfAbsent(name, key -> phoneNumbers);
    }

    void printPhoneBook () {
        nameToPhoneNumbersMap.forEach((k, v) -> {
            StringBuilder sb = new StringBuilder();
            v.forEach(value -> {
                sb.append(value.getType());
                sb.append(": ");
                sb.append(value.getNumber());
                sb.append("\n");
            });
            System.out.print(k + "\n" + sb);
        });
    }
}
