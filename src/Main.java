import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String directoryPath="src/Created Directory";
        File directory = new File(directoryPath);

        String firstFileAbsolutePath;
        File firstFile = null;

        try {
            directory.mkdir();      //Created a new directory at laptop/PC through JAVA code.
            System.out.println("Directory is successfully created");
            firstFile = new File("src/Created Directory/AvijitPaul_00-30131.txt");  //2. Create a new file with your name and ID.
            firstFileAbsolutePath = firstFile.getAbsolutePath();
            System.out.println("Created File Path = " + firstFileAbsolutePath);  //3. Get file path through Java coding and print at console.
        }catch (Exception e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        //4. Write something on that newly created file.
        writeToFile("Something", firstFile);

        //5. Read from the first file
        String data = readFromFile(firstFile);

        //  -> then write to a new Output file.
        File newFile = new File(directoryPath+"/"+"NewFile.txt");
        writeToFile(data, newFile);

        System.out.println("Thank you.");
    }

    public static void writeToFile (String data, File file) throws IOException {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            fileWriter.write(data);
            System.out.println("Written successfully to File: "+file.getAbsolutePath());
            System.out.println("Data written: "+data);
            fileWriter.close();     //file closed after writing
        }catch (Exception e){
            System.out.println("File couldn't be written at: " + file.getAbsolutePath());
            e.printStackTrace();
        }finally {
            fileWriter.close();
        }
    }

    public static String readFromFile (File file){
        StringBuilder data = new StringBuilder();
        try{
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()){
                data.append(fileScanner.nextLine());
                data.append("\n");
            }
        }catch (FileNotFoundException e){
            System.out.println("File not found at: " + file.getAbsolutePath());
            e.printStackTrace();
        }
        return data.toString();
    }
}