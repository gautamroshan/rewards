package com.customer_rewards.rewards.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    int id;

    @Column
    String name;

    @JsonIgnore
    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Transactions> transactions;

    @Transient
    int firstRewards;

    @Transient
    int secondRewards;

    @Transient
    int thirdRewards;

    public int getTotalRewardAmount() {
        return totalRewardAmount;
    }

    public void setTotalRewardAmount(int totalRewardAmount) {
        this.totalRewardAmount = totalRewardAmount;
    }

    @Transient
    int totalRewardAmount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transactions> transactions) {
        this.transactions = transactions;
    }

    public int getFirstRewards() {
        return firstRewards;
    }

    public void setFirstRewards(int firstRewards) {
        this.firstRewards = firstRewards;
    }

    public int getSecondRewards() {
        return secondRewards;
    }

    public void setSecondRewards(int secondRewards) {
        this.secondRewards = secondRewards;
    }

    public int getThirdRewards() {
        return thirdRewards;
    }

    public void setThirdRewards(int thirdRewards) {
        this.thirdRewards = thirdRewards;
    }
}
