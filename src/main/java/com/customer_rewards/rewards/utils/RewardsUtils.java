package com.customer_rewards.rewards.utils;

import org.springframework.stereotype.Component;

@Component
public class RewardsUtils {
    public int rewardAmountPerTransaction(int amount){
        int rewardsAmount = 0;
        if(amount > 100){
            rewardsAmount = (2 * (amount -100) + 50);
        } else if (amount > 50) {
            rewardsAmount = amount - 50;
        }
        return rewardsAmount;
    }
}
