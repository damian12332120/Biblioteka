package BazaNowa;

public class WalidacjaDanych {


    public boolean validateNumber(String  number) {
      return  number.matches("^[0-9]+$");
    }

    public boolean validateFirstName(String firstName) {
        return firstName.matches("[A-Z][a-zA-Z]*");
    }

    public boolean validateLastName(String lastName) {
        return lastName.matches("[a-zA-z]+(['-][a-zA-Z]+)*");
    }

    public boolean validatePhone(String phone) {
        return phone.matches("^[0-9\\-\\+]{9,11}$");
    }

    public boolean validatePassword(String password) {
        return password.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})");
    }

    public boolean validateEmail(String password) {
        return password.matches("^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$");
    }


}

