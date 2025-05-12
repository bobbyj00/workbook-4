import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class EmployeeTest {
    private Employee employee;

    @Before
    public void setUp() {
        employee = new Employee("E001", "John Doe", "Front Desk", 20.0);
    }

    @Test
    public void testPunchTimeCardCalculatesTimeCorrectly() {
        employee.punchTimeCard(9.0); // punch in
        employee.punchTimeCard(17.0); // punch out (8 hrs)
        assertEquals(8.0, employee.getRegularHours(), 0.001);
        assertEquals(0.0, employee.getOvertimeHours(), 0.001);
        assertEquals(160.0, employee.getTotalPay(), 0.001);
    }

    @Test
    public void testOvertimeIsCalculatedCorrectly() {
        employee.punchTimeCard(8.0); // in
        employee.punchTimeCard(20.0); // out (12 hrs)
        employee.punchTimeCard(8.0); // in again
        employee.punchTimeCard(20.0); // out (12 more hrs)
        assertEquals(24.0, employee.getRegularHours(), 0.001);
        assertEquals(0.0, employee.getOvertimeHours(), 0.001);

        employee.punchTimeCard(8.0);
        employee.punchTimeCard(20.0); // another 12 hrs, total now 36
        employee.punchTimeCard(8.0);
        employee.punchTimeCard(20.0); // another 12 hrs, total now 48 => 8 OT
        assertEquals(40.0, employee.getRegularHours(), 0.001);
        assertEquals(8.0, employee.getOvertimeHours(), 0.001);
        assertEquals((40 * 20.0) + (8 * 30.0), employee.getTotalPay(), 0.001);
    }
}
