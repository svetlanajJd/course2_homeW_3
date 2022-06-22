package homeWork3;

public class User {

    private static String login;
    private static String password;
    private static String confirmPassword;

    public User(String login, String password, String confirmPassword) {
        this.login = login;
        this.password = password;
        this.confirmPassword = confirmPassword;
        if (login.matches("[a-z,0-9,_]+")) {
            System.out.println("допустимые символы в логине");
        } else {
            System.out.println("в логин введен недопустимый символ");
        }
        if (password.matches("[a-z,0-9,_]+")) {
            System.out.println("допустимые символы в пароле");
        } else {
            System.out.println("в пароль введен недопустимый символ");
        }
        if (password.length() >= 20) {
            System.out.println("количество символов в пароле превышает допустимое значение");
        }
    }

    public static String getLogin() {
        return login;
    }

    public static String getPassword() {
        return password;
    }

    public static String getConfirmPassword() {
        return confirmPassword;
    }

    public static boolean dataUserLogin(String login, String password, String confirmPassword) {
        boolean b = login.length() <= 20;
        return b;
    }

    public static boolean dataUserPassword(String login, String password, String confirmPassword) {
        boolean b1 = password.equals(confirmPassword);
        return b1;
    }

    public static void checkLogin(String login, String password, String confirmPassword) {
        User loginPasswordConfirmPassword = new User(login, password, confirmPassword);
        try {
            check(loginPasswordConfirmPassword);
        } catch (WrongLoginException e) {
            System.out.println("количество символов в логине превышает допустимое значение");
        } catch (WrongPasswordException e) {
            System.out.println("пароли должны совпадать");
        }
    }

    public static class WrongLoginException extends Exception {
        public WrongLoginException() {
            super();
        }
    }

    public static class WrongPasswordException extends Exception {
        public WrongPasswordException() {
            super();
        }
    }

    public static void check(User loginPasswordConfirmPassword) throws WrongLoginException, WrongPasswordException {
        if ((dataUserLogin(login, password, confirmPassword)) == false) {
            throw new WrongLoginException();
        }
        if ((dataUserPassword(login, password, confirmPassword)) == false) {
            throw new WrongPasswordException();
        }
    }
}