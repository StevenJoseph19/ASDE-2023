public class Login {

    private String loginId;

    private String password;

    private char role;

    public Login() {

    }

    public Login(String loginId, String password, char role) {
        this.loginId = loginId;
        this.password = password;
        this.role = role;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char getRole() {
        return role;
    }

    public void setRole(char role) {
        this.role = role;
    }
}
