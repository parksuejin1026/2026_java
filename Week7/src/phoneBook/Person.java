package phoneBook;

public class Person {
	String name, phone, email;

    public Person(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    // 파일 저장 시 구분자(,)를 넣어 저장하기 위함
    @Override
    public String toString() {
        return name + "," + phone + "," + email;
    }
}
