package cl.globallogic.demo.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.Calendar;

@Entity
@Table(name="usuarios")
public class usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("email")
    @Column(nullable = false, unique = true)
    @Email
    private String email;
    @JsonProperty("password")
    @Pattern(regexp = "^(?=.*[0-9]{2})(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$")
    private String password;
    @JsonProperty("phones")
    @Embedded
    private phones phones;
    @JsonProperty("creacion")
    @Column(updatable = false)
    @CreationTimestamp
    private Calendar creacion;
    @CreationTimestamp
    @JsonProperty("modificado")
    private Calendar modificado;
    @JsonProperty("activo")
    private String activo;
    private long serialVersionUID = -5290198995172316155L;

    public usuarios (){
        super();
    }

    public usuarios (String name, String email, String password, String phones) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phones = new phones();
    }

    @PrePersist
    public void onPersist() {
        creacion = Calendar.getInstance();
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

    public Calendar getCreacion (){
        return creacion;
    }
    public void setCreacion(Calendar creacion){
        this.creacion=creacion;
    }

    public Calendar getModificado (){
        return modificado;
    }
    public void setModificado(Calendar modificado){
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
    public Long getSerialVersionUID () {
        return serialVersionUID;
    }
    public void setSerialVersionUID (long serialVersionUID) {
        this.serialVersionUID=serialVersionUID;
    }
}
