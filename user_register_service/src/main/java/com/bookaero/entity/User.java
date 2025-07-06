package com.bookaero.entity;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User extends PanacheMongoEntity {
    public String fullName;
    public String userName;
    public String email;
    public String mobileNumber;
    public String password;
}
