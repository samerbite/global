package cl.globallogic.demo.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.sql.Date;

@Entity
@Table(name="usuarios")
public class usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("email")
    @Email
    private String email;
    @JsonProperty("password")
    private String password;
    @JsonProperty("phones")
    @Embedded
    private phones phones;
    @JsonProperty("creacion")
    @CreationTimestamp
    private Date creacion;
    @CreationTimestamp
    @JsonProperty("modificado")
    private Date modificado;
    @JsonProperty("activo")
    private String activo;


    private static final long serialVersionUID = -5290198995172316155L;

    public usuarios (){
        super();
    }

    public usuarios (String name, String email, String password, String phones) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phones = new phones();
    }

    public Long getId(){
        return id;
    }
    public void setId(long id){
        this.id=id;
    }

    public String getName (){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getEmail (){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getPassword (){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }

    public phones getPhones (){
        return phones;
    }
    public void setPhones(phones phones){
        this.phones=phones;
    }

    public Date getCreacion (){
        return creacion;
    }
    public void setCreacion(Date creacion){
        this.creacion=creacion;
    }

    public Date getModificado (){
        return modificado;
    }
    public void setModificado(Date modificado){
        this.modificado=modificado;
    }

    public String getActivo (){
        return activo;
    }
    public void setActivo(String activo){
        this.activo=activo;
    }

    public String getNumber (){
        return phones.getNumber();
    }
    public void setNumber(String number) {
        phones.setNumber(number);
    }
    public String getCitycode (){
        return phones.getCitycode();
    }
    public void setCitycode(String citycode) {
        phones.setCitycode(citycode);
    }
    public String getContrycode (){
        return phones.getContrycode();
    }
    public void setContrycode(String contrycode) {
        phones.setContrycode(contrycode);
    }
}
