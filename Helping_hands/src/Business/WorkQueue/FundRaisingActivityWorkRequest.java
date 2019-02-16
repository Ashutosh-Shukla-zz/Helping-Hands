/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author shukl
 */
public class FundRaisingActivityWorkRequest extends WorkRequest {

    private int moneyNeeded;

    private int moneyGot;

    public int getMoneyGot() {
        return moneyGot;
    }

    public void setMoneyGot(int moneyGot) {
        this.moneyGot = moneyGot;
    }

    public int getMoneyNeeded() {
        return moneyNeeded;
    }

    public void setMoneyNeeded(int moneyNeeded) {
        this.moneyNeeded = moneyNeeded;
    }

}
