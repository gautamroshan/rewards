package com.customer_rewards.rewards.service;

import com.customer_rewards.rewards.model.Customer;
import com.customer_rewards.rewards.model.Transactions;
import com.customer_rewards.rewards.repo.RewardRepository;
import com.customer_rewards.rewards.utils.RewardsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class RewardServiceImpl implements RewardService{

    @Autowired
    RewardRepository rewardRepository;

    @Autowired
    RewardsUtils rewardsUtils;


    @Override
    public List<Customer> rewardsForAll() {
        List<Customer> customers = rewardRepository.findAll();
        if(customers != null) {
            for( Customer c: customers){
                Set<Transactions> transactions = c.getTransactions();
                rewardsPerMonth(transactions, c);
            }
        }
        return customers;
    }

    @Override
    public Customer rewardById(Integer customerId) {
        Customer customer = rewardRepository.findById(customerId).orElse(null);
        if(customer != null){
            Set<Transactions> transactions = customer.getTransactions();
            rewardsPerMonth(transactions, customer);
        }
        return customer;
    }

    private void rewardsPerMonth(Set<Transactions> transactions, Customer customer) {
        LocalDate today = LocalDate.now();
        for(Transactions transaction: transactions){
            int month = transaction.getCreationDate().getMonth() + 1;
            int year = transaction.getCreationDate().getYear() + 1900;

            if ((today.getYear() == year) && (today.getMonth().getValue() == month))
                customer.setThirdRewards(customer.getThirdRewards()
                        + rewardsUtils.rewardAmountPerTransaction(transaction.getTransactionAmount()));

            else if ((today.minusMonths(1).getYear() == year)
                    && (today.minusMonths(1).getMonth().getValue() == month))
                customer.setSecondRewards(customer.getSecondRewards()
                        + rewardsUtils.rewardAmountPerTransaction(transaction.getTransactionAmount()));
            else if ((today.minusMonths(2).getYear() == year)
                    && (today.minusMonths(2).getMonth().getValue() == month))
                customer.setFirstRewards(customer.getFirstRewards()
                        + rewardsUtils.rewardAmountPerTransaction(transaction.getTransactionAmount()));        }
    }
}
