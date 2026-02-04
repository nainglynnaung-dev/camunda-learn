package com.ly.workflow;

import jakarta.inject.Named;
import org.camunda.bpm.engine.delegate.BpmnError;
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
        } else if (doubleMoney >=5000.00) {
            ticketType="Business Class";
        } else if (doubleMoney<=10) {
            ticketType="StowAway Class";
            throw new BpmnError("FALL_Overboard","A cheap ticket has lead to a small wave throwing you overboard");

        }
        execution.setVariable("ticketType",ticketType);

    }
}
