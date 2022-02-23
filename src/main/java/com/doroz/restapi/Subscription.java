package com.doroz.restapi;


import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "subscription")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "subscription_id")
    private Long id;
    private Enum<SubscriptionType> subType;
    private String startDate;
    private String endDate;


    @ManyToOne
    @JoinColumn(name = "resource_id")
    private Resource resource;


}
