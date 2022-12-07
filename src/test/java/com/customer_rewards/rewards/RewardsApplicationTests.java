package com.customer_rewards.rewards;

import com.customer_rewards.rewards.model.Customer;
import com.customer_rewards.rewards.service.RewardService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RewardsApplicationTests {
	@Autowired
	RewardService rewardService;

	@Test
	void contextLoads() {
	}

	@Test
	void testCalculateRewardsforMultipleTransactions(){
		Customer customer = rewardService.rewardById(2);
		if(customer.getId() == 1){
			Assertions.assertEquals(220, customer.getFirstRewards());
		}
	}


}
