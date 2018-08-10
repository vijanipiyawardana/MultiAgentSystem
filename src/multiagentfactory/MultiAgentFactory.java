/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiagentfactory;


import com.vijani.agents.CleaningAgent;
import com.vijani.agents.OrderAgent;
import com.vijani.agents.PackingAgent;
import com.vijani.agents.ProcessingAgent;
import com.vijani.agents.StockAgent;
import com.vijani.model.Order;
import java.util.ArrayList;
import java.util.Date;
import madkit.kernel.Madkit;

/**
 *
 * @author vijani
 */
public class MultiAgentFactory {
    public static ArrayList<Order> orderList = new ArrayList<Order>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Order order1 = new Order("Order001", new Date(), 100, "Apple Juice");
        orderList.add(order1);
         args = new String[]{"--launchAgents",
              OrderAgent.class.getName() + ",false,1;"
            + StockAgent.class.getName() + ",false,1;"
            + CleaningAgent.class.getName() + ",false,1;"
            + ProcessingAgent.class.getName() + ",false,1;"
            + PackingAgent.class.getName() + ",false,1;"
         };
      
        Madkit.main(args);
    }
    
}
