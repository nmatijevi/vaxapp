package hr.java.matijevic.vaxapp.user;

import hr.java.matijevic.vaxapp.authority.Authority;

import java.util.Set;

public class UserDTO {

    private long id;

    private String username;

    private String first_name;

    private String last_name;

    private Set<String> authorities;

    public UserDTO(long id, String username, String first_name, String last_name, Set<String> authorities) {
        this.id = id;
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.authorities = authorities;
    }

    public UserDTO() {
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }
}
