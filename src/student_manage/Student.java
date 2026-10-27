package student_manage;

public class Student {
    private String name;
    private int age;
    private String id;
    private String gender;
    private String phone;

    public Student() {
    }

    public Student(String name, String id, int age, String gender, String phone) {
        this.age = age;
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
    }

    public Student (String name, String id,int age){
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }
    @Override
    public String toString() {
        return "该学生的姓名：" + name + "  年龄：" + age + "  学号：" + id + "  性别：" + gender + "  手机号：" + phone;
    }
}