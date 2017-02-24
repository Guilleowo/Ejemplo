package modelo.BEAN; 

public class BeanUsuario {
 
    private String usuid;
    private String usulogin;
    private String usupassword;

    public BeanUsuario(String usuid, String usulogin, String usupassword) {
        this.usuid = usuid;
        this.usulogin = usulogin;
        this.usupassword = usupassword;
    }

    public String getUsuid() {
        return usuid;
    }

    public void setUsuid(String usuid) {
        this.usuid = usuid;
    }

    public String getUsulogin() {
        return usulogin;
    }

    public void setUsulogin(String usulogin) {
        this.usulogin = usulogin;
    }

    public String getUsupassword() {
        return usupassword;
    }

    public void setUsupassword(String usupassword) {
        this.usupassword = usupassword;
    }

}
