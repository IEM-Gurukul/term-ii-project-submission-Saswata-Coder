[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/pG3gvzt-)
# PCCCS495 – Term II Project

## Project Title
# ONLINE AUCTION SYSTEM


## Problem Statement (max 150 words) 
In general, the traditonal auction system demands the physical presence of the user. With the proposed Online Auction System, the facility to sell items or take part in auctions through the internet will be provided to the user in an efficient manner. 
In the proposed system, the facility to register the users, list the items for auction, conduct the auctions with the facility to track the bids, conclude the auctions with the identification of the winning user, etc., will be provided. 
This project will be an example for the implementation of object-oriented programming techniques, modular programming, etc., along with the usage of various features of the Java programming language.


## Target User
  - Individuals who want to sell items through auctions 
  - Buyers interested in bidding on products online 
  - System administrators who manage auction listings and users


## Core Features
  - User registration and login system 
  - Item listing for auction with starting price and time limit 
  - Real-time bidding on available items 
  - Automatic identification of the highest bidder 
  - Auction timer and automatic auction closing 
  - Bid history tracking for each item 
  - Winner notification after auction completion 
  - Data storage for users, items, and bids
  

## OOP Concepts Used

- Abstraction:  It will define general behaviours like auction operations and user operations.
- Inheritance:  Various types of users like Buyer, Seller, Admin, etc., can be inherited from a parent class 
named User. 
- Polymorphism:  Operations like bidding and viewing item information can be performed.
- Exception Handling:  It will handle exceptions like invalid bids, time expiration of the auction, and 
incorrect user information.


## Proposed Architecture Description

| UI Layer (Swing Interfaces) | ------> | Service Layer (Business Logic) | ------> | Model Layer (Data & Objects) |

1️⃣ UI Layer 
  Files:
    - LoginUI.java
    - AuctionUI.java
  Responsibility:
    - Takes user input (username, bid amount)
    - Displays:
        Item details
        Bid history
        Current user
    - Handles user interaction (buttons, fields)
    
2️⃣ Service Layer (Business Logic Layer)
  File:
    - AuctionService.java
  Responsibility:
    - Manages auction operations
    - Controls:
      Items list
      Auction flow
    - Acts as bridge between UI and Model
    
3️⃣ Model Layer (Core Data Layer)
  Files:
    - User.java 
    - Buyer.java
    - Seller.java
    - Item.java
    - Bid.java
  Responsibility:
    - Represents real-world entities:
        Users
        Items
        Bids
    - Stores data using:
        ArrayList
    - Implements OOP concepts


## How to Run
1️⃣ Clone Repository
git clone [https://github.com/your-username/online-auction-system.git](https://github.com/IEM-Gurukul/term-ii-project-submission-Saswata-Coder)

2️⃣ Open in VS Code
Open folder in VS Code
Install Java Extension Pack

3️⃣ Run the Application
Open Main.java
Right-click → Run
