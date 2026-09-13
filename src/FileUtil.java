import java.io.*;
import java.util.ArrayList;

public class FileUtil {
    public static final String FILE_PATH = "students.txt";

    public static void save(ArrayList<Student> students) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Student student : students) {
                bw.write(student.getId() + "," + student.getName() + "," + student.getAge());
                bw.newLine();
            }
            System.out.println("数据保存成功");
        }
        catch (IOException e){
            System.out.println("数据保存失败" + e.getMessage());
        }
    }

    public static ArrayList<Student> load() {
        ArrayList<Student> list = new ArrayList<>();
        File file = new File(FILE_PATH);

        if(!file.exists())  return list;

        try(BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null){
                String[] parts = line.split(",");
                String id = parts[0];
                String name = parts[1];
                int age = Integer.parseInt(parts[2]);
                list.add(new Student(name, id, age));
            }
            System.out.println("已加载" + list.size() + "条数据");
        }
        catch (IOException e){
            System.out.println("数据加载失败" + e.getMessage());
        }
        return list;
    }
}
