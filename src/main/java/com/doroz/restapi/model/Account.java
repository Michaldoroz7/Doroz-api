package com.doroz.restapi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id")
    private Long id;

    @OneToOne()
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    @JsonManagedReference
    private Client client;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subscription_id")
    @JsonManagedReference
    private Subscription subscriptionId;


}

