package com.oders.processor.domains;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserInformation {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int infoId;
    private String address;
    private String phoneNumber;
    private String zipCode;
    private boolean isEmpty;

    @OneToOne(mappedBy = "userInformation")
    private User user;

}
