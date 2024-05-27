package DesignPatterns.MediatorPattern;

import DesignPatterns.MediatorPattern.Auction.Auction;
import DesignPatterns.MediatorPattern.User.Bidder;

public class Main {
    public static void main(String[] args) {
        Auction auction = new Auction();
        Bidder bidder = new Bidder(auction, "Sanjay");
        Bidder bidder1 = new Bidder(auction,"Shubham");
        Bidder bidder2 = new Bidder(auction, "Rahul");
        auction.addBidder(bidder);
        auction.addBidder(bidder1);
        auction.addBidder(bidder2);

        bidder1.addBid(1000);
        bidder.addBid(1500);
        bidder1.addBid(2000);
    }
}
