package func.task22_streams;

public class JobDescription {
    private final String title;
    private final String company;
    private final int requiredExperienceYears;

    JobDescription(String title, String company, int requiredExperienceYears) {
        this.title = title;
        this.company = company;
        this.requiredExperienceYears = requiredExperienceYears;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public int getRequiredExperienceYears() {
        return requiredExperienceYears;
    }
}
