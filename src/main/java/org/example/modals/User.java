package org.example.modals;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private final String id;
    private final String name;
    private final String email;
    private final String mobile;


    public User(String id) {
        this.id = id;
        this.name = null;
        this.email = null;
        this.mobile = null;
    }

}
