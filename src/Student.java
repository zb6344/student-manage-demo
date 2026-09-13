public class Student {
    private String name;
    private int age;
    private String id;

    public Student(String name, String id, int age){
        this.age = age;
        this.id = id;
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

    @Override
    public String toString(){
        return "姓名是" + name + "年龄是" + age + "学号是" + id ;
    }
}
