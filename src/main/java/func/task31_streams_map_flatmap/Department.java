package func.task31_streams_map_flatmap;

import java.util.List;

class Department {
    private final String name;
    private final String code;
    private final List<Employee> employees;

    public Department (String name, String code, List<Employee> employees) {
        this.name = name;
        this.code = code;
        this.employees = employees;
    }

    public String getName () {
        return name;
    }

    public String getCode () {
        return code;
    }

    public List<Employee> getEmployees () {
        return employees;
    }
}
