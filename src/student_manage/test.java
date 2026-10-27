package student_manage;
import java.util.List;
import java.util.Scanner;

public class test {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("====学生管理系统====");
            System.out.println("1. 添加学生信息");
            System.out.println("2. 查询学生信息");
            System.out.println("3. 删除学生信息");
            System.out.println("4. 修改学生信息");
            System.out.println("5. 显示全部学生信息");
            System.out.println("0. 退出系统");
            System.out.println("====================");
            System.out.println("请输入你的选择：");


            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    showStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    showAll();
                    break;
                case 0:
                    System.out.println("再见！");
                    return;
                default:
                    System.out.println("输入错误，请重新输入");
            }

        }
    }

    static void addStudent() {
        System.out.println("请输入学号：");
        String id = sc.nextLine();
        Student exist = DBStudentUtil.findById(id);
        if (exist != null) {
            System.out.println("学号已存在，请重新输入");
            return;
        }
        System.out.println("请输入姓名：");
        String name = sc.nextLine();
        System.out.println("请输入年龄：");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("请输入性别：");
        String gender = sc.nextLine();
        System.out.println("请输入手机号：");
        String phone = sc.nextLine();

        Student s = new Student(name, id, age);
        s.setGender(gender);
        s.setPhone(phone);
        boolean ok = DBStudentUtil.addStudent(s);
        System.out.println(ok ? "添加成功\n" : "添加失败\n");
    }

    static void showStudent() {
        System.out.println("请输入要查询的学生学号：");
        String id = sc.nextLine();
        Student s = DBStudentUtil.findById(id);
        if (s != null) {
            System.out.println("找到：" + s);
        } else {
            System.out.println("未找到该学生");
        }
    }

    static void showAll() {
        List<Student> list = DBStudentUtil.findAll();
        if (list.isEmpty()) {
            System.out.println("没有学生信息");
            return;
        }
        System.out.println("显示全部学生信息：\n");
        for (Student s : list) {
            System.out.println(s);
        }
        System.out.println("总人数为 " + list.size());
    }

    static void updateStudent() {
        System.out.println("请输入要修改的学生学号：");
        String id = sc.nextLine();
        Student exist = DBStudentUtil.findById(id);
        if (exist == null) {
            System.out.println("该学号不存在！");
            return;
        }
        System.out.println("原有信息：" + exist);
        System.out.println("请输入新姓名：");
        String name = sc.nextLine();
        System.out.println("请输入新年龄：");
        int age = Integer.parseInt(sc.nextLine());
        System.out.println("请输入新性别：");
        String gender = sc.nextLine();
        System.out.println("请输入新手机号：");
        String phone = sc.nextLine();

        Student s = new Student(name, id, age);
        s.setGender(gender);
        s.setPhone(phone);
        boolean ok = DBStudentUtil.updateStudent(s);
        System.out.println(ok ? "✅ 修改成功" : "❌ 修改失败");
    }

    static void deleteStudent() {
        System.out.println("请输入要删除的学生学号：");
        String id = sc.nextLine();
        boolean ok = DBStudentUtil.deleteById(id);
        System.out.println(ok ? "删除成功" : "未找到该学生");
    }
}
