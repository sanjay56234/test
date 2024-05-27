package DesignPatterns.MediatorPattern.Auction;

import DesignPatterns.MediatorPattern.User.Bidder;

import java.util.List;

public interface AuctionMediator {
    public void addBidder(Bidder bidder);

    public void makeBid(Bidder bidder,int amt);
}
