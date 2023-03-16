import dao.EmployeesDao;
import model.Employees;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeesDao employeesDao = new EmployeesDao();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("+---------------------------+-----------+");
            System.out.println("|  QUẢN LÝ NHÂN VIÊN  | BK123456@v1.0.0  |");
            System.out.println("+---------------------------+-----------+");
            System.out.println("| 1. Thêm nhân viên                     |");
            System.out.println("| 2. Danh sách nhân viên                |");
            System.out.println("| 3. Tìm kiếm nhân viên theo tên        |");
            System.out.println("| 4. Cập nhật thông tin nhân viên       |");
            System.out.println("| 5. Xóa nhân viên theo mã              |");
            System.out.println("| 6. Lọc ra top 5 lương cao nhất        |");
            System.out.println("+---------------------------+-----------+");
            System.out.print("Mời bạn chọn chức năng: ");
            String n = scanner.nextLine();
            switch (n) {
                case "1":
                    System.out.println("+---------------------------+---------+");
                    System.out.println("| Thêm nhân viên | BK123456@v1.0.0    |");
                    System.out.println("+---------------------------+---------+");

                    System.out.println("Nhập thông tin nhân viên");
                    ThemNhanVien(scanner);

                    break;

                case "2":
                    System.out.println("+---------------------------+---------+");
                    System.out.println("|  Danh sách nhân viên  |  BK123456@v1.0.0 |");
                    System.out.println("+---------------------------+---------+");

                    List<Employees> employeesList = employeesDao.getAll();

                    for (Employees e: employeesList) {
                        System.out.println(e.toString());
                    }

                case "3":
                    System.out.println("+---------------------------+---------+");
                    System.out.println("| Tìm kiếm sinh viên | FX123456@v1.0.0 |");
                    System.out.println("+---------------------------+---------+");

                    break;
                case "4":
                    // In ra danh sach
                    System.out.println("+---------------------------+---------+");
                    System.out.println("|  Toan bo danh ba |  FX123456@v1.0.0 |");
                    System.out.println("+---------------------------+---------+");

                    break;
                default:
                    System.exit(0);
            }

        }

    }

    static void ThemNhanVien(Scanner scanner){
        EmployeesDao employeesDao = new EmployeesDao();
        System.out.print("Nhập tên: ");
        String fullName = scanner.nextLine();
        System.out.print("Nhập city: ");
        String city = scanner.nextLine();
        System.out.print("Nhập email: ");
        String email = scanner.nextLine();
        System.out.print("Nhập sđt: ");
        String phone = scanner.nextLine();
        System.out.print("Nhập giơi tính 0 or 1: ");
        int gender = scanner.nextInt();
        System.out.print("Nhập lương: ");
        scanner.nextLine();
        int salary = scanner.nextInt();

        List<Employees> employeesList = employeesDao.getAll();

        boolean checkEmail = false;
        for (int i=0;i< employeesList.size();i++) {
            if(employeesList.get(i).getEmail().equals(email)){
                checkEmail = true;
            }
        }
        if(checkEmail){
            System.out.println("Email đã tồn tại!");
        }else {
            Employees e = new Employees(employeesList.size(), fullName, city, email, phone, gender, salary);
            employeesDao.InsertEmp(e);
        }

    }
}
