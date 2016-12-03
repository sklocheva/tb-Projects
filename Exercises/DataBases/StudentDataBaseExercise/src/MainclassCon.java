import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainclassCon {

	static String url = "jdbc:postgresql://localhost:5432/student_applications?user=postgres&password=VMware1!";

	public static void main(String[] args) {

		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");

		} catch (java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}
		try {
			con = DriverManager.getConnection(url);
			System.out.println("Got Connection.");
			con.setAutoCommit(false);
			stmt = con.createStatement();
			String sql = "INSERT INTO STUDENTS (SID, NAME, AVG) VALUES (555, 'Sophia', 4.20);";
			stmt.executeUpdate(sql);
			sql = "INSERT INTO APPLICATIONS (SID, UNAME, UPROV, ACCPD) VALUES (555, 'SU', 'Sofia', 0);";
			stmt.executeUpdate(sql);
			sql = "UPDATE APPLICATIONS SET ACCPD=1 WHERE SID=555;";
			stmt.executeUpdate(sql);

			ResultSet rs = stmt.executeQuery("select count(*) as AcceptedStudentCount "
					+ "from applications where accpd=1 and uname='SU' and uprov = 'Sofia';");
			while (rs.next()) {
				int countAccepted = rs.getInt("AcceptedStudentCount");

				System.out.println("Accepted Student = " + countAccepted);
				System.out.println();
			}

			rs = stmt.executeQuery("select count(*) as NOTAccpdStudentCount "
					+ "from applications where accpd=0 and uname='SU' and uprov = 'Sofia';");
			while (rs.next()) {
				int countAccepted = rs.getInt("NOTAccpdStudentCount");

				System.out.println("Number of students that are not exepted = " + countAccepted);
				System.out.println();
			}

			stmt.close();
			con.close();

		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		System.out.println("Records created successfully");
	}

}
