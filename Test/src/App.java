import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) {

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("Test\\src\\Sample.txt"));
            String line = reader.readLine();

            for (int i = 0; line != null; i++) {
                line = reader.readLine();

                if(i==0)
                {
                   continue;
                }
                else
                {
                    if(line!=null){
                    Student current = new Student(line);
                    System.out.println(current.getName() + '\t' + current.getStudentNumber() + '\t' + current.calculateGPA() + '\t' + current.calculateGrade() + '\n');
                    }//Student name, Student number, Student 
                    //Activities mark, Oral/Practical mark, Midterm exam mark and Final exam mark
                    //line[0] ->>stu name , line[1] ->> stu code , line[2] -> max deg
                    
                }
                
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
