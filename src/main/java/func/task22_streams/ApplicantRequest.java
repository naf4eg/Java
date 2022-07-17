package func.task22_streams;

public class ApplicantRequest {
    private final String company;
    private final int experienceYears;

    ApplicantRequest(String company, int experienceYears) {
        this.company = company;
        this.experienceYears = experienceYears;
    }

    public String getCompany() {
        return company;
    }

    public int getExperienceYears() {
        return experienceYears;
    }
}
