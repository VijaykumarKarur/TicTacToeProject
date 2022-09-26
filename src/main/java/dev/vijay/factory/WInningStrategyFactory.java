package dev.vijay.factory;

import dev.vijay.constant.PropertyConstants;
import dev.vijay.strategy.IWinningStrategy;
import dev.vijay.strategy.WinnigStrategyDefault;

public class WInningStrategyFactory {
    public static IWinningStrategy getWinningStrategy(String WINNING_STRATEGY){
        if(WINNING_STRATEGY.equalsIgnoreCase(PropertyConstants.DEFAULT)){
            return new WinnigStrategyDefault();
        }
        return null;
    }
}
