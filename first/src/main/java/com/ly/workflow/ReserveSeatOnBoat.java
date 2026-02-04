package com.ly.workflow;

import jakarta.inject.Named;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;


@Named
public class ReserveSeatOnBoat implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {

        String money="0.0";
        String ticketType="Coach";

        money= execution.getVariable("money").toString();
        double doubleMoney=Double.parseDouble(money);
        if (doubleMoney >=10000.00){
            ticketType="First Class";
        } else if (doubleMoney <=5000.00) {
            ticketType="Business Class";
        }
        execution.setVariable("ticketType",ticketType);

    }
}
