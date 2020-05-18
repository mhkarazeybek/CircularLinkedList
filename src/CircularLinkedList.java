public class CircularLinkedList {
    public static int ogrCounter = 0;

    static Student head, tail;
    public static void main(String[] args) {
        Student students[] = {new Student("Gökhan"), 
        new Student("Abdulkerim"), 
        new Student("Mehmet Faruk"), 
        new Student("Muhammed Hüseyin"),
        new Student("Mustafa"),
        new Student("Sena"),
        new Student("Zehra Şevval"),
        new Student("Bilge Sena") };
        

        for (Student student : students)
            setStudent2LinkedList(student);

        //döngü ile erişim
        // Student temp = head ;
        // do{
        //     System.out.println(temp.getName());
        //     temp = temp.next ;
        // }while(temp != head);

        //Fonksiyonlar erişim
        accessLinkedListWithFunc(head);
                
        System.out.println("-----------------Sona Ekleme---------------------");
        addStudent2End(new Student("Sinem"));
        accessLinkedListWithFunc(head);

        System.out.println("-----------------Başa Ekleme---------------------");
        addStudent2Begin(new Student("Ferman"));
        accessLinkedListWithFunc(head);

        System.out.println("-----------------Başa Ekleme2---------------------");
        addStudent2Begin2(new Student("Miss Fortune"));
        accessLinkedListWithFunc(head);

        System.out.println("-----------------Başa Ekleme3---------------------");
        addStudent2Begin3(new Student("Öykü"));
        accessLinkedListWithFunc(head);

        System.out.println("-----------------Araya Ekleme---------------------");
        addStudent2Between("Mehmet Faruk",new Student("Master Yi"));
        accessLinkedListWithFunc(head);

        System.out.println("-----------------Başdan Silme---------------------");
        removeStudent2Begin();
        accessLinkedListWithFunc(head);

        System.out.println("-----------------Sondan Silme---------------------");
        removeStudent2End();
        accessLinkedListWithFunc(head);

        System.out.println("-----------------Aradan Silme---------------------");
        removeStudent2Between("Master Yi");
        accessLinkedListWithFunc(head);

    }

    public static void accessLinkedListWithFunc(Student student){
        if(student==tail){
            System.out.println(student.getName());
            return;
        }
        System.out.println(student.getName());
        accessLinkedListWithFunc(student.next);
    }

    public static void setStudent2LinkedList(Student student){
        if(head == null){
            head = student;
        }else {
            tail.next=student;
        }
        tail = student;
        tail.next=head;
    }

    public static void addStudent2End(Student student){
        tail.next=student;
        tail=student;
        tail.next=head;
    }

	public static void addStudent2Begin(Student student) {
		student.next = head;
		tail.next = student;
		head = student;
	}

	public static void addStudent2Begin2(Student student) {
        head  =  student;
        head.next = tail.next;
        tail.next=head;    
    }
    public static void addStudent2Begin3(Student student){
        student.next=tail.next;
        head=student;
        tail.next=head;
    }

    public static void addStudent2Between(String name, Student student){
        Student temp = head;
        while(!temp.getName().equals(name))
            temp = temp.next;

        student.next = temp.next;
        temp.next = student;
    }

	public static void removeStudent2Begin() {
	    head = head.next;
		tail.next = head;
    }

    public static void removeStudent2End(){
        Student temp = head;
        while(temp.next != tail)
            temp=temp.next;
        temp.next=head;
        tail=temp;
    }

    public static void removeStudent2Between(String name){
        Student temp = head;
        while(!temp.next.getName().equals(name)){
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }
}   