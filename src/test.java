import java.util.ArrayList;
import java.util.Scanner;

public class test {
    static ArrayList<Student> students;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        students = FileUtil.load();

        while (true){
            System.out.println("====学生管理系统====\n");
            System.out.println("1. 添加学生信息");
            System.out.println("2. 显示学生信息");
            System.out.println("3. 删除学生信息");
            System.out.println("4. 显示全部学生信息");
            System.out.println("0. 退出系统");
            System.out.println("================");
            System.out.println("请输入你的选择：");

            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1 : addStudent(); break;
                case 2 : showStudent(); break;
                case 3 : deleteStudent(); break;
                case 4 : showAll(); break;
                case 0 :
                    FileUtil.save(students);
                    System.out.println("再见！");
                    return;
                default:
                    System.out.println("输入错误，请重新输入");
            }
        }
    }

    static void addStudent(){
        System.out.println("请输入学号：");
        String id = sc.nextLine();

        for(Student student : students){
            if(student.getId().equals(id)){
                System.out.println("学号已存在，请重新输入");
                return;
            }
        }

        System.out.println("请输入姓名：");
        String name = sc.nextLine();

        System.out.println("请输入年龄：");
        int age = sc.nextInt();
        sc.nextLine();

        students.add(new Student(name, id, age));
        System.out.println("添加成功\n");
    }

    static void showStudent(){
        System.out.println("请输入要查询的学生学号：");
        String id = sc.nextLine();

        for (Student s : students){
            if(s.getId().equals(id)){
                System.out.println("找到" + s);
                return;
            }
        }
        System.out.println("未找到该学生");
    }

    static void showAll(){
        if(students.isEmpty()){
            System.out.println("没有学生信息");
            return;
        }
        System.out.println("显示全部学生信息：\n");
        System.out.println("===============");
        for (Student s : students){
            System.out.println(s);
        }
        System.out.println("总人数为" + students.size());
    }

    static void deleteStudent(){
        System.out.println("请输入要删除的学生学号：");
        String id = sc.nextLine();

        for (int i = students.size() - 1; i >= 0; i--) {
            if (students.get(i).getId().equals(id)) {
                students.remove(i);
                System.out.println("删除成功");
                return;
            }
        }
        System.out.println("未找到该学生");
    }
}
