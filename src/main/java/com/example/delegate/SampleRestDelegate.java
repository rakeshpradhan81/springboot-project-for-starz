package com.example.delegate;

import com.example.model.AppRequest;
import com.example.model.Item;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SampleRestDelegate {

    public Double processRequest(AppRequest request) {

        List<Item> items = request.getItem();
           return items.stream().map(i-> {
                double cost = i.getQuantity() * i.getCost();
                if (i.getPromotion()!= 0) {
                    cost = cost * i.getPromotion();
                }
                return cost;
            }).reduce((h,j) -> h+j).get();

    }
}
