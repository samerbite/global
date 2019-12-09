package cl.globallogic.demo.model;

import javax.persistence.Embeddable;

@Embeddable
public class phones {

    private String number;
    private String citycode;
    private String contrycode;

    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public String getCitycode() {
        return citycode;
    }
    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }
    public String getContrycode() {
        return contrycode;
    }
    public void setContrycode(String contrycode) {
        this.contrycode = contrycode;
    }

    public phones(String number, String citycode, String contrycode) {
        super();
        this.number = number;
        this.citycode = citycode;
        this.contrycode = contrycode;
    }
    public phones() {
        super();
    }
}
