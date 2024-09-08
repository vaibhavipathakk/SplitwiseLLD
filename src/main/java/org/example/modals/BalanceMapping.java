package org.example.modals;

import java.util.HashMap;
import java.util.Map;


public class BalanceMapping {

    private final Map<String, Balance> balanceMap;

    public BalanceMapping() {
        this.balanceMap = new HashMap<>();
    }

    public Map<String, Balance> getBalanceMap() {
        return balanceMap;
    }

    public void setBalanceMap(String id, Balance balance) {
        balanceMap.put(id, balance);
    }

    public void updateBalanceMap(BalanceMapping oweUserBalanceMapping) {

        oweUserBalanceMapping.getBalanceMap().forEach((oweUserId, oweBalance) -> {
            if (!this.balanceMap.containsKey(oweUserId)) {
                this.balanceMap.put(oweUserId, oweBalance);
            } else {
                double existingAmount = this.balanceMap.get(oweUserId).getAmount();
                this.balanceMap.get(oweUserId).setAmount(oweBalance.getAmount()+existingAmount);
            }

        });
    }

}
