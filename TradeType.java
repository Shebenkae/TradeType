package sber;


public enum TradeType{
    FX_SPOT{
        @Override
        public  TradeType createTrade(int price){
            this.price = price;
            return FX_SPOT;
        };

    },
    BOND{
        @Override
        public TradeType createTrade(int price){
            return BOND;
        };

    },
    COMMODITY_SPOT{
        @Override
        public TradeType createTrade(int price){
            return COMMODITY_SPOT;
        };

    },
    IR_SWAP{
        @Override
        TradeType createTrade(int price) {
            return IR_SWAP;
        }
    };
    int price;
    public void setPrice(int price){
        this.price = price;
    }


    abstract TradeType createTrade(int price);
}
