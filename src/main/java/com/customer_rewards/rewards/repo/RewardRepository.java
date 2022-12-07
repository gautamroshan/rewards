package com.customer_rewards.rewards.repo;

import com.customer_rewards.rewards.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RewardRepository extends JpaRepository<Customer, Integer> {
}
