package com.customer_rewards.rewards.service;

import com.customer_rewards.rewards.model.Customer;

import java.util.List;

public interface RewardService {
    List<Customer> rewardsForAll();
    Customer rewardById(Integer customerId);
}
