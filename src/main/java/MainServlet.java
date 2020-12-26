import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class MainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        Double age = Double.parseDouble(request.getParameter("age"));
        String phone = request.getParameter("phone");
        LocalDate dateOfBirthday;

        String dd = request.getParameter("dateOfBirthday");
        System.out.println(dd);

        DateTimeFormatter f = DateTimeFormatter.ofPattern( "yyyy-MM-dd" ) ;
        dateOfBirthday = LocalDate.parse( dd , f ) ;


        Double salary = Double.parseDouble(request.getParameter("salary"));
        System.out.println("name: "+ name + "age: " + age + "phone: " + phone +
                "dateOfBirthday: " +dateOfBirthday + "salary: "+ salary);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_user?serverTimezone=UTC", "root", "98919092");
            String query = "insert into users(name,age,phone,dateOfBirthday,salary) values(?,?,?,?,?);";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,name);
            preparedStatement.setDouble(2, age);
            preparedStatement.setString(3, phone);
            preparedStatement.setDate(4, Date.valueOf(dateOfBirthday));
            preparedStatement.setDouble(5, salary);
            preparedStatement.executeUpdate();

            preparedStatement.close();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        printMainPage(request,response);
    }

    //формирование основной страницы
    protected void printMainPage(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        request.setAttribute("say","Hello user");
        request.setAttribute("users",dbselect());
        request.getRequestDispatcher("page.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        printMainPage(request,response);
    }

    //метод для селекта всех юзеров с бд
    protected ArrayList<User> dbselect() {
        ArrayList<User> listUsers= new ArrayList<User>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_user?serverTimezone=UTC", "root", "98919092");
            String query = "select id,name,age,phone,dateOfBirthday,salary from users";
            Statement st = connection.createStatement();

            ResultSet resultSet = st.executeQuery(query);
            int cnt = 0;

            DateTimeFormatter f = DateTimeFormatter.ofPattern( "yyyy-MM-dd" ) ;
            while(resultSet.next()){
                cnt++;
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getDouble("age"));
                user.setPhone(resultSet.getString("phone"));
                user.setDateOfBirthday(LocalDate.parse(resultSet.getString("dateOfBirthday"),f));
                user.setSalary(resultSet.getDouble("salary"));
                System.out.println(user);
                listUsers.add(user);
            }
            st.close();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listUsers;
    }
}
