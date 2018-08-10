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

/**
 *
 * @author vijani
 */
public class CleaningAgent extends Agent {

    @Override
    protected void activate() {
        createGroupIfAbsent(Global.COMMUNITY, Global.GROUP);
        requestRole(Global.COMMUNITY, Global.GROUP, Global.ROLE_CLEANING);
    }

    @Override
    protected void live() {
        while (true) {
            ObjectMessage objectMessage;
            objectMessage = (ObjectMessage) nextMessage();
            if (objectMessage != null) {
                System.out.println(objectMessage.getContent().toString());
                Order order1 = (Order) objectMessage.getContent();
                order1.isCleaned = true;
                order1.setComment("Ingredients are ready to process.");
                pause(1000);
                Message message = new ObjectMessage(order1);
                sendMessage(Global.COMMUNITY, Global.GROUP, Global.ROLE_PROCESSING, objectMessage);

            }
            pause(1000);
        }
    }

}
