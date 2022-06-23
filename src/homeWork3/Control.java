package homeWork3;

public class Control {
    private static void checkLogin(User user) throws WrongLoginException, WrongPasswordException {
        boolean b = user.getPassword().equals(user.getConfirmPassword());

        if (user.getLogin().matches("[a-zA-Z\\d_]+") && (user.getLogin().length() <= 20)) {
            System.out.println("login верно");
        } else {
            throw new WrongLoginException();
        }

        if (user.getPassword().matches("[a-zA-Z\\d_]+") && user.getPassword().length() <= 20) {
            System.out.println("password верно");
        } else {
            throw new WrongPasswordException();
        }

        if (b) {
            System.out.println("confirmPassword верно");
        } else {
            throw new WrongPasswordException();
        }
    }

    public static boolean dataUserLogin(User user) {
        try {
            checkLogin(user);
        } catch (WrongLoginException e) {
            e.printStackTrace();
            return false;
        } catch (WrongPasswordException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
