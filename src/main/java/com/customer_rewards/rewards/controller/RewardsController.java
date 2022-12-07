package com.customer_rewards.rewards.controller;

import com.customer_rewards.rewards.model.Customer;
import com.customer_rewards.rewards.service.RewardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rewards")
public class RewardsController {
    Logger logger = LoggerFactory.getLogger(RewardsController.class);
    @Autowired
    private RewardService rewardsService;

    @GetMapping
    public ResponseEntity<Object> getCustomerRewards(){
        List<Customer> customers = rewardsService.rewardsForAll();
        if(customers.isEmpty() || customers.size() == 0){
            logger.error("Customer list is empty!");
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping(value = "/{customerId}")
    public ResponseEntity<Customer> getCustomerRewardById(@PathVariable Integer customerId){
        Customer customer = rewardsService.rewardById(customerId);
        if(customer == null){
            logger.error("Customer with Id " + customerId + " does not exist!");
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
}
