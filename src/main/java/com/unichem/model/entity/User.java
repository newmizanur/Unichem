package com.unichem.model.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id", unique = true,
            nullable = false, length = 20)
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    private String id;

    @Column(name = "username", unique = true,
            nullable = false, length = 45)
    private String username;

    @Column(name = "password",
            nullable = false, length = 60)
    private String password;

    @Column(name = "fullname",
            nullable = false, length = 100)
    private String fullName;

    @Column(name = "secretquestion")
    @Size(max = 150)
    private String secretQuestion;

    @Column(name = "secretanswer")
    @Size(max = 150)
    private String secretAnswer;

    @Column(name = "logo")
    @Size(max = 500)
    private String logo;

    @Column(name = "email")
    @Size(max = 20)
    private String email;

    @Column(name = "phone")
    @Size(max = 15)
    private String phone;


    @Column(name = "createdate")
    private Date createDate;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user",cascade = { CascadeType.ALL,CascadeType.PERSIST,CascadeType.MERGE })
    @Column(nullable = false)
    private Set<UserRole> userRole = new HashSet<UserRole>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User() {
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSecretQuestion() {
        return secretQuestion;
    }

    public void setSecretQuestion(String secretQuestion) {
        this.secretQuestion = secretQuestion;
    }

    public String getSecretAnswer() {
        return secretAnswer;
    }

    public void setSecretAnswer(String secretAnswer) {
        this.secretAnswer = secretAnswer;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<UserRole> getUserRole() {
        return userRole;
    }

    public void setUserRole(Set<UserRole> userRole) {
        this.userRole = userRole;
    }
}
