package com.doroz.restapi;


import lombok.*;

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

    @OneToOne(mappedBy = "subscriptionId")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "resource_id")
    private Resource resource;

}