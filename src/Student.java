public class Student {
    
    private String name;
    private int ogrenciNo;
    public Student next;

    public Student(String name) {
        super();
        this.name = name;
        this.ogrenciNo = ++CircularLinkedList.ogrCounter;
    }
    public String getName(){
        return name;
    }
}