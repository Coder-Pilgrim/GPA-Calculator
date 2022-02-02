import java.util.Locale;
import java.util.Scanner;

public class gpa_calculator {
    private static final Scanner sc = new Scanner(System.in).useLocale(Locale.US);
    private static double totalQualityPointsCumulative = 0.0;
    private static int totalCumulativeCredits = 0;
    public static void main(String[] args) {
        System.out.println("Welcome to the GPA Calculator!");
        System.out.println("Select Options: \n1. Calculate GPA\n2. Exit");
        switch (getOption()) {
            case 1:
                calculateTermGPA();
                break;
            case 2:
                System.out.println("Thank you for using the GPA Calculator!");
                break;
            default:
                System.out.println("Invalid option!");
                break;
        }

    }
    public static int getOption() {
        return sc.nextInt();
    }


    public static void calculateTermGPA() {
        int credit, lesson, totalCredits = 0;
        String letterGrade;
        double totalQualityPoints = 0.0;

        System.out.println("Enter number of lessons: ");
        lesson = sc.nextInt();

        for (int i = 0; i < lesson; i++) {
            System.out.println("Enter credit of lesson " + (i + 1) + ": ");
            credit = sc.nextInt();
            System.out.println("Enter the letter grade of lesson " + (i + 1) + ": (A, A-, B+, B, B-, C+, C, C-, D+, D, D-, F)");
            sc.nextLine();
            letterGrade = sc.nextLine().toUpperCase();
            totalCredits += credit;
            totalCumulativeCredits += credit;
            calculateQualityPoints(credit, letterGrade);
            totalQualityPointsCumulative += calculateQualityPoints(credit, letterGrade);
            totalQualityPoints += calculateQualityPoints(credit, letterGrade);
        }


        System.out.printf("\nTerm GPA: %.2f", (totalQualityPoints / totalCredits));
        System.out.printf("\nCumulative GPA: %.2f", (totalQualityPointsCumulative / totalCumulativeCredits ));
        System.out.println("\nAdd another term? (Y/N)");

        String option = sc.nextLine();
        if (option.equalsIgnoreCase("y")) {
            calculateTermGPA();
        }
        else if (option.equalsIgnoreCase("n")) {
            System.out.println("Thank you for using the GPA Calculator!");
        }
        else {
            System.out.println("Invalid option!");
        }
    }
    public static double calculateQualityPoints(int credit, String letterGrade) {
        double qualityPoints = 0.0;
        switch (letterGrade) {
            case "A":
                qualityPoints += 4 * credit;
                break;
            case "A-":
                qualityPoints += 3.67 * credit;
                break;
            case "B+":
                qualityPoints += 3.33 * credit;
                break;
            case "B":
                qualityPoints += 3 * credit;
                break;
            case "B-":
                qualityPoints += 2.67 * credit;
                break;
            case "C+":
                qualityPoints += 2.33 * credit;
                break;
            case "C":
                qualityPoints += 2 * credit;
                break;
            case "C-":
                qualityPoints += 1.67 * credit;
                break;
            case "D+":
                qualityPoints += 1.33 * credit;
                break;
            case "D":
                qualityPoints += credit;
                break;
            case "D-":
                qualityPoints += 0.67 * credit;
                break;
            case "F":
                qualityPoints += 0;
                break;
            default:
                System.out.println("Invalid letter grade!");
                break;
        }
        return qualityPoints;
    }
}
