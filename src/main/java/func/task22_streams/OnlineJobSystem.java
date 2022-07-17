package func.task22_streams;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Sample Input:
 * Google|3
 * Java Developer|Google|3
 * Senior Java Developer|Google|7
 * Super Java Developer|CryptoStartup|3
 * Junior Java Developer|Google|1
 *
 * Sample Output:
 * 2
 */
public class OnlineJobSystem {
    public static long calculateNumberOfVacancies (ApplicantRequest request, Collection<JobDescription> jobs) {

        return jobs.stream().filter(jobDescription -> jobDescription.getCompany().equals(request.getCompany())).filter(
            jobDescription -> jobDescription.getRequiredExperienceYears() <= request.getExperienceYears()).count();
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        ApplicantRequest request = Optional.of(scanner.nextLine()).map(inputLine -> {
            String[] parts = inputLine.split("\\|");
            return new ApplicantRequest(parts[0], Integer.parseInt(parts[1]));
        }).get();

        List<JobDescription> jobs = Stream.iterate(1, i -> scanner.hasNextLine(), i -> i + 1)
                                          .map(i -> scanner.nextLine())
                                          .map(inputLine -> {
                                              String[] parts = inputLine.split("\\|");
                                              return new JobDescription(parts[0], parts[1], Integer.parseInt(parts[2]));
                                          })
                                          .collect(Collectors.toList());

        System.out.println(calculateNumberOfVacancies(request, jobs));
    }
}
