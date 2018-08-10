/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vijani.agents;

import com.vijani.model.Order;
import com.vijani.util.Global;
import madkit.kernel.Agent;
import madkit.kernel.Message;
import madkit.message.ObjectMessage;
import madkit.message.StringMessage;
import multiagentfactory.MultiAgentFactory;

/**
 *
 * @author vijani
 */
public class OrderAgent extends Agent {

    @Override
    protected void activate() {
        createGroupIfAbsent(Global.COMMUNITY, Global.GROUP);
        requestRole(Global.COMMUNITY, Global.GROUP, Global.ROLE_ADMIN);
    }

    @Override
    protected void live() {
        while (true) {
            if (!MultiAgentFactory.orderList.isEmpty()) {
                Order newOrder = MultiAgentFactory.orderList.get(0);
               
                Message message = new ObjectMessage(newOrder);
                sendMessage(Global.COMMUNITY, Global.GROUP, Global.ROLE_STOCK, message);
                if (message.getReceiver() != null) {
                    MultiAgentFactory.orderList.remove(newOrder); 
                }
            }
            ObjectMessage objectMessage;
            objectMessage = (ObjectMessage) nextMessage();
            if (objectMessage != null) {
                System.out.println(objectMessage.getContent());
                Order order1 = (Order) objectMessage.getContent();
                if(order1.stockChecked == true){
                    Message message2 = new ObjectMessage(order1);
                    sendMessage(Global.COMMUNITY, Global.GROUP, Global.ROLE_CLEANING, message2);
                }
            }
            pause(1000);                
        }
    }

    @Override
    public void destroyRole(String community, String group, String role) {
        super.destroyRole(community, group, role); 
    }

}
