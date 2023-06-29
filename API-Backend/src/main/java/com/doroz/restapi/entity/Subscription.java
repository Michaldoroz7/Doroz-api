package com.doroz.restapi.entity;


import com.doroz.restapi.service.SubscriptionType;
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
@Table(name = "subscription")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "subscription_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private SubscriptionType subType;
    private String startDate;
    private String endDate;

    @ManyToOne
    @JoinColumn(name = "resource_id")
    private Resource resource;

}