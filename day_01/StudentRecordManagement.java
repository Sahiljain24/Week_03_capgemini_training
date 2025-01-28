
// create a class Student with rollNumber, name, age, grade, next, prev
class Student {
    String rollNumber;
    String name;
    int age;
    char grade;
    Student next, prev;

    Student(String rollNumber, String name, int age, char grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}
// create a class StudentNode with head
class StudentNode {
    private Student head;

    StudentNode() {
        this.head = null;
    }

    // addBegning
    void addBegning(Student s1) {

        Student newStu = new Student(s1.rollNumber, s1.name, s1.age, s1.grade);
        if (head == null) {
            head = newStu;
        } else {
            newStu.next = head;
            head = newStu;
        }
    }
    // addEnding
    void addEnding(Student s1) {
        Student newStu = new Student(s1.rollNumber, s1.name, s1.age, s1.grade);
        if (head == null) {
            head = newStu;
        } else {
            Student curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newStu;
        }
    }

    // print all students record
    void atPosition(int pos, Student s1) {
        Student newStu = new Student(s1.rollNumber, s1.name, s1.age, s1.grade);
        if (pos == 0) {
            addBegning(s1);
            return;
        }

        Student curr = head;
        pos = pos - 1;
        while (pos-- > 1) {
            if (curr != null) {
                curr = curr.next;
            }
        }
        if (curr == null) {
            System.out.println("please give position in range of students : ");
        } else {
            Student temp = curr.next;
            curr.next = newStu;
            newStu.next = temp;
        }
    }

    // search student record by rollNumber
    void search(String rollNumber) {
        Student curr = head;
        while (curr != null) {
            if (curr.rollNumber.equals(rollNumber)) {
                System.out.println("rollNumber: " + curr.rollNumber + "\n" + " name: " + curr.name+"is present in the list");
                return;
            }
            curr = curr.next;
        }
        System.out.println("Student not found");
    }

    // update student grade by rollNumber
    void updateGrade(String rollNumber, char grade) {
        Student curr = head;
        while (curr != null) {
            if (curr.rollNumber.equals(rollNumber)) {
                curr.grade = grade;
                return;
            }
            curr = curr.next;
        }
        System.out.println("Student not found");
    }


    // display all students record
    void dispaly() {
        Student curr = head;

        while (curr != null) {
            System.out.println("rollNumber: " + curr.rollNumber + "\n" + " name: " + curr.name + "\n" + " age: "
                    + curr.age + "\n" + " grade: " + curr.grade);

            System.out.println("-------------------------------------------------------------------------");
            curr = curr.next;
        }
    }

    // delete student record by rollNumber
    void delete(String rollNumber) {
        Student curr=head;

        if(curr.rollNumber.equals(rollNumber)){

            head=curr.next;
            return;
        }
        while(curr.next!=null){
            if(curr.next.rollNumber.equals(rollNumber)){
                curr.next=curr.next.next;
                return;
            }
            curr=curr.next;
        }
    }
}
class StudentRecordManagement {
    public static void main(String[] args) {
        StudentNode sn = new StudentNode();
        Student s1 = new Student("10", "Arnav", 23, 'd');
        Student s2 = new Student("10", "Neha", 21, 'c');
        Student s3 = new Student("1011", "Sahil", 22, 'd');
        Student s4 = new Student("10", "Adarsh", 26, 'a');
        Student s5 = new Student("10", "Om", 18, 'b');
        sn.addBegning(s1);
        sn.addBegning(s2);
        sn.addEnding(s3);
        sn.search("1011");
        sn.dispaly();
        sn.addBegning(s4);
        sn.updateGrade("10", 'e');
        sn.atPosition(2, s5);
        sn.dispaly();
        // System.out.println("-------------------------");
        sn.delete("10");
        sn.dispaly();
    }

}
