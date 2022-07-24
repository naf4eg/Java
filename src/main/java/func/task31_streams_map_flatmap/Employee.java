package func.task31_streams_map_flatmap;

class Employee {
    private final String name;
    private final Long salary;

    public Employee (String name, Long salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName () {
        return name;
    }

    public Long getSalary () {
        return salary;
    }
}
