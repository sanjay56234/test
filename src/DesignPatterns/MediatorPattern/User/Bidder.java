package DesignPatterns.MediatorPattern.User;

import DesignPatterns.MediatorPattern.Auction.Auction;
import DesignPatterns.MediatorPattern.Auction.AuctionMediator;

public class Bidder implements User{

    String name;
    AuctionMediator auction;

    public Bidder(AuctionMediator auction, String name){
        this.name=name;
        this.auction = auction;
    }

    @Override
    public void addBid(int amt) {
        this.auction.makeBid(this, amt);
    }

    @Override
    public void getNotification(int amt) {
        System.out.println(String.format("Bidder : %s get notification of bid : %s", this.name, amt));
    }

    @Override
    public String getName() {
        return this.name;
    }
}
