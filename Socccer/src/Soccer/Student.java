package Soccer;

public class Student {
  // PRIVATE INSTANCE FIELDS
  private int num; // 4 -->bytes
  private String lastName; // 30
  private String firstName; // 30
  private int absences; // 4
  private float grade; // 4
  // total 72 bytes

  public Student() {
    this(0, "", "");
  }

  public Student(int n, String fName, String lName) {
    this.num = n;
    firstName = fName;
    lastName = lName;
    absences = 0;
    grade = 0.0f;
    setFirstName();
    setLastName();
  }

  public int getNum() {
    return num;
  }

  public void setLastName() {

    if (lastName.length() > 15) {
      lastName = lastName.substring(0, 15);
    } else if (lastName.length() < 15) {
      int i = lastName.length();
      while (i != 15) {
        lastName += " ";
        i++;
      }
    }
  }

  public String getLastName() {
    if (lastName.length() > 15) {
      lastName = lastName.substring(0, 15);
    } else if (lastName.length() < 15) {
      int i = lastName.length();
      while (i != 15) {
        lastName += " ";
        i++;
      }
    }
    return lastName;
  }

  public void setFirstName() {
    if (firstName.length() > 15) {
      firstName = firstName.substring(0, 15);
    } else if (firstName.length() < 15) {
      int i = firstName.length();
      while (i != 15) {
        firstName += " ";
        i++;
      }
    }
  }

  public String getFirstName() {

    if (firstName.length() > 15) {
      firstName = firstName.substring(0, 15);
    } else if (firstName.length() < 15) {
      int i = firstName.length();
      while (i != 15) {
        firstName += " ";
        i++;
      }
    }

    return firstName;
  }

  public int getAbsences() {
    return absences;
  }

  public float getGrade() {
    return grade;
  }

  public void setAbsences(int a) {
    absences = a;
  }

  public void setGrade(float g) {
    grade = g;
  }

  @Override
  public String toString() {
    return "Am: "
        + num
        + " FirstName: "
        + firstName
        + " LastName: "
        + lastName
        + " Apousies:"
        + absences
        + " Vathmos: "
        + grade;
  }
}