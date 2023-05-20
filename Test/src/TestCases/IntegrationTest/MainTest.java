package TestCases.IntegrationTest;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Main.Student;
import Main.Subject;
import Main.fileIO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Main.App;

import static org.junit.Assert.assertEquals;

public class MainTest {
    
    @Test
    public void test1() throws IOException {
        var x = new String[]{"Test\\src\\TestFiles\\Integration\\testMain1.txt"};

        App.main(x);

        String subName = "Networks Course", subCode = "CSE333";
        String subFM = "100";
        String s1_name = "mark ashraf", s2_name = "samir";
        String s1_num = "12345678", s2_num = "87654321";
        int s1_am = 10, s2_am = 9;
        int s1_pm = 10, s2_pm = 8;
        int s1_mt = 20, s2_mt = 18;
        int s1_fm = 60, s2_fm = 55;

        BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
        String line = "x";
        String actualSubName = null, actualMaxMark = null;


        for (int i = 0; line != null; i++) {
            line = reader.readLine();
            String actualName = "";
            String actualCode = "";
            String actualGPA = "";
            String actualGrade = "";
            if (i == 0) {
                actualSubName = line.substring(line.indexOf(':') + 2, line.indexOf("Max mark") - 1);
                actualMaxMark = line.substring(line.lastIndexOf(':') + 2);
                assertEquals(subName, actualSubName);
                assertEquals(subFM, actualMaxMark);

            } else if (i == 1) {
                assertEquals("Student name Student number GPA Grade", line);
            } else if (i == 2) {
                String[] current = line.split(" ");
                for (String s : current) {
                    if (Character.isAlphabetic(s.charAt(0))) {
                        actualName += s;
                        actualName += " ";
                    } else break;
                }
                actualName = actualName.substring(0, actualName.length() - 1);
                actualCode = line.substring(line.indexOf(actualName) + actualName.length() + 1, line.indexOf(actualName) + actualName.length() + 9);
                actualGPA += line.substring(line.indexOf(actualCode) + actualCode.length() + 1, line.lastIndexOf(' '));
                actualGrade += line.substring(line.lastIndexOf(' ') + 1);

                assertEquals(s1_name, actualName);
                assertEquals(s1_num, actualCode);
                int sum = s1_am + s1_mt + s1_fm + s1_pm;
                Assertions.assertEquals(Student.calculateGPA(sum), Double.parseDouble(actualGPA), 0);
                assertEquals(Student.calculateGrade(sum), actualGrade);
            } else if (i == 3) {
                String[] current = line.split(" ");
                for (String s : current) {
                    if (Character.isAlphabetic(s.charAt(0))) actualName += s + " ";
                    else break;
                }
                actualName = actualName.substring(0, actualName.length() - 1);
                actualCode = line.substring(line.indexOf(actualName) + actualName.length() + 1, line.indexOf(actualName) + actualName.length() + 9);
                actualGPA += line.substring(line.indexOf(actualCode) + actualCode.length() + 1, line.lastIndexOf(' '));
                actualGrade += line.substring(line.lastIndexOf(' ') + 1);

                assertEquals(s2_name, actualName);
                assertEquals(s2_num, actualCode);
                int sum = s2_am + s2_mt + s2_fm + s2_pm;
                Assertions.assertEquals(Student.calculateGPA(sum), Double.parseDouble(actualGPA), 0);
                assertEquals(Student.calculateGrade(sum), actualGrade);
            }
        }
        reader.close();

    }

    @Test
    public void test2() throws FileNotFoundException{
        App.main(null);

        
    }
}
