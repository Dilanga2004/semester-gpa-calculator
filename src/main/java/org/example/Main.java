import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);



        int subjectCount;

        while (true) {
            System.out.print("Enter number of subjects (1–10): ");

            if (!sc.hasNextInt()) {
                System.out.println("Please enter a whole number.");
                sc.next();
                continue;
            }

            subjectCount = sc.nextInt();

            if (subjectCount < 1 || subjectCount > 10) {
                System.out.println("Subject count must be between 1 and 10.");
                continue;
            }

            break;
        }
        double totalmarks=0;
        double totalCredit=0;
        double totalWeightedPoints=0;

        String[] subjectNames = new String[subjectCount];
        double[] subjectMarks = new double[subjectCount];
        double[] subjectCredits = new double[subjectCount];
        String[] subjectGrades = new String[subjectCount];
        double[] subjectGradePoints = new double[subjectCount];

        for(int i=0;i<subjectCount;i++) {
            System.out.println("\nSubject " + (i + 1));

            sc.nextLine();

            String subjectName;

            while (true) {
                System.out.print("Enter subject name: ");
                subjectName = sc.nextLine().trim();

                if (subjectName.isEmpty()) {
                    System.out.println("Subject name cannot be empty.");
                    continue;
                }

                break;
            }
            double marks;

            while (true) {
                System.out.print("Enter marks (0–100): ");

                if (!sc.hasNextDouble()) {
                    System.out.println("Invalid input. Please enter a number.");
                    sc.next();
                    continue;
                }

                marks = sc.nextDouble();

                if (!Double.isFinite(marks) || marks < 0 || marks > 100) {
                    System.out.println("Marks must be between 0 and 100.");
                    continue;
                }

                break;
            }
          double credit;
            while (true) {
                System.out.print("Enter credits: ");

                if (!sc.hasNextDouble()) {
                    System.out.println("Please enter a number.");
                    sc.next();
                    continue;
                }

                credit = sc.nextDouble();

                if (!Double.isFinite(credit) || credit <= 0) {
                    System.out.println("Credits must be a finite number greater than zero.");
                    continue;
                }

                break;
            }


            String grade;
            double greadePoint;

            if(marks>=95){
                grade = "A+";
                greadePoint=4.0;
            } else if (marks>=75) {
                grade = "A";
                greadePoint=4.0;

            } else if (marks>=70) {
                grade = "A-";
                greadePoint=3.7;

            } else if (marks>=65) {
                grade = "B+";
                greadePoint=3.3;

            } else if (marks>=60) {
                grade = "B";
                greadePoint=3.0;
            } else if (marks>=55) {
                grade = "B-";
                greadePoint=2.7;
            } else if (marks>=50) {
                grade = "C+";
                greadePoint=2.3;
            } else if (marks>=45) {
                grade = "C";
                greadePoint=2.0;
            } else if (marks>=40) {
                grade = "D";
                greadePoint=1.0;
            }else {
                grade = "F";
                greadePoint=0.0;
            }
            double weightedPoints=greadePoint*credit;
            subjectNames[i] = subjectName;
            subjectMarks[i] = marks;
            subjectCredits[i] = credit;
            subjectGrades[i] = grade;
            subjectGradePoints[i] = greadePoint;

            totalmarks+=marks;
            totalCredit+=credit;
            totalWeightedPoints+=weightedPoints;
            System.out.println("subject: "+subjectName);
            System.out.println("Grade: "+grade);
            System.out.println("Grede points: "+greadePoint);
            System.out.println("weighted points: "+weightedPoints);
        }
        double averagemarks = totalmarks / subjectCount;
        double gpa = totalWeightedPoints / totalCredit;

        System.out.println("\n---------------- Subject Results ----------------");

        System.out.printf(
                "%-25s %8s %8s %8s %8s%n",
                "Subject", "Marks", "Credits", "Grade", "Points"
        );

        for (int i = 0; i < subjectCount; i++) {
            System.out.printf(
                    "%-25s %8.2f %8.1f %8s %8.1f%n",
                    subjectNames[i],
                    subjectMarks[i],
                    subjectCredits[i],
                    subjectGrades[i],
                    subjectGradePoints[i]
            );
        }

        System.out.println("\n------Semester Results------");
        System.out.printf("Marks average: %.2f%n", averagemarks);
        System.out.printf("Total credits: %.1f%n", totalCredit);
        System.out.printf("Semester GPA (practice scale): %.2f%n", gpa);


    }


}