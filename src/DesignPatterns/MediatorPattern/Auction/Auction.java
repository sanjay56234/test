package DesignPatterns.MediatorPattern.Auction;

import DesignPatterns.MediatorPattern.User.Bidder;

import java.util.ArrayList;
import java.util.List;

public class Auction implements AuctionMediator{
    List<Bidder> bidderList;

    public Auction(){
        this.bidderList = new ArrayList<>();
    }
    @Override
    public void addBidder(Bidder bidder) {
        bidderList.add(bidder);
    }

    @Override
    public void makeBid(Bidder bidder, int amt) {
        for (Bidder bidder1 : bidderList){
            if(!bidder1.getName().equals(bidder.getName())){
                bidder1.getNotification(amt);
            }
        }
    }
}
