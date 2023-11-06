package Thread;

class LoginData {
    String name;
    static final String password = "123456";
    LoginData(String name){
        this.name = name;
    }
    static boolean valid(String str){
        return str.equals(password);
    }
}