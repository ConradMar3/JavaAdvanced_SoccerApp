package soccer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;

// NOTE
// this is a data structure course exercise from university.

public class SoccerLeague implements Serializable {

  public static void main(String[] args) throws FileNotFoundException, IOException {

    RandomAccessFile st = new RandomAccessFile("student", "rw");

    Student[] std = new Student[20];

    int tempam = 12001;
    for (int i = 0; i <= 19; i++) {
      st.writeInt(tempam);
      st.writeChars("               "); // must be 15 space
      st.writeChars("               "); // must be 15 space
      st.writeInt(0);
      st.writeInt(0);

      tempam++;
    }

    st.close();

    int i = 0;
    while (i < 20) {

      System.out.println("");
      System.out.println("||>------->MENU OPTIONS<--------||");
      System.out.println("|-->Write Student to file  ->1");
      System.out.println("|-->Delete Student from file  ->2");
      System.out.println("|-->Show a Student's details ->3");
      System.out.println("|-->Update absences of a Student  ->4");
      System.out.println("|-->Write grade of a Student ->5");
      System.out.println("|-->EXIT program  ->6");
      System.out.println("|-->EXtra submenu  ->7");

      int choice = UserInput.getInteger();
      if (choice == 1) {

        System.out.println("|-->Give num for Student between(12001-12020)");
        int num = UserInput.getInteger();

        if (num < 12001 || num > 12020) {
          throw new StudentNumberOutOfBounds(
              "Num of a Student must be between bounds(12001-12020)!");
        }

        System.out.println("|-->Give Students name");
        String name = UserInput.getString();
        System.out.println("|-->Give Students lastname");
        String lastname = UserInput.getString();

        std[i] = new Student(num, name, lastname);

        st = new RandomAccessFile("student", "rw");

        int pos = 72 * (num - 12001);

        st.seek(pos);
        st.skipBytes(4);
        // st.write(am);
        st.writeChars(std[i].getFirstName());
        st.writeChars(std[i].getLastName());
        st.writeInt(0);
        st.writeFloat(0);
        st.close();

        i++;

      } else if (choice == 2) {
        System.out.println("|-->Give num for Student for delete between(12001-12020)");
        int num = UserInput.getInteger();

        st = new RandomAccessFile("student", "rw");
        int pos = 72 * (num - 12001);
        st.seek(pos);

        st.skipBytes(4);
        st.writeChars("               ");
        st.writeChars("               ");
        st.writeInt(0);
        st.writeFloat(0);
        st.close();

      } else if (choice == 3) {

        RandomAccessFile data = new RandomAccessFile("student", "r");

        System.out.println("Give num for Student to show details");
        int num = UserInput.getInteger();

        if (num < 12001 || num > 12020) {
          throw new StudentNumberOutOfBounds(
              "Num of a Student must be between bounds(12001-12020)!");
        }

        int pos = 72 * (num - 12001);

        data.seek(pos);

        int number = 0;
        String name = "";
        String lastName = "";
        int absences = 0;
        int grade = 0;

        number = data.readInt();

        for (int x = 0; x < 15; x++) {
          name += data.readChar();
        }
        for (int x = 0; x < 15; x++) {
          lastName += data.readChar();
        }
      }
    }
  }
}
