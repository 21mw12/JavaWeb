package connection;

import com.MW.entity.Student;
import com.MW.util.ConnectMySQL;
import org.junit.jupiter.api.Test;

public class ConnectionTest {
    @Test
    public void selectTest() {
        ConnectMySQL.doSqlWork(mapper -> {
            mapper.selectStudent().forEach(student -> {
                System.out.println(student.getSid() + "  " + student.getName() + "  " + student.getSex() + "  " + student.getGrade());
            });
        });
    }

    @Test
    public void selectByIdTest() {
        ConnectMySQL.doSqlWork(mapper -> {
            System.out.println(mapper.selectStudentById(4));
        });
    }

    @Test
    public void selectBorrowTest() {
        ConnectMySQL.doSqlWork(mapper -> {
            mapper.selectBorrow().forEach(borrow -> {
                System.out.println(borrow.getId() + " " + borrow.getStudent().getName() + " " + borrow.getBook().getTitle());
            });
        });
    }

    @Test
    public void InsertTest() {
        Student student = new Student("明明", "男", 2021);
        ConnectMySQL.doSqlWork(mapper -> {
            mapper.InsStudent(student);
        });
    }

    @Test
    public void DeleteTest() {
        ConnectMySQL.doSqlWork(mapper -> {
            mapper.DelBook(5);
        });
    }

}
