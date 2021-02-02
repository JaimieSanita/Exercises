package com.techelevator.services;

import java.util.Scanner;

public class ConsoleService {

  private Scanner scanner;

  public ConsoleService() {
    scanner = new Scanner(System.in);
  }

  public int printMainMenu() {
    int menuSelection;
    System.out.println("");
    System.out.println("Welcome to Tech Elevator Cocktails. Please make a selection: ");
    System.out.println("1: List Cocktails");
    System.out.println("2: Show details about a specific cocktail");
    System.out.println("0: Exit");
    System.out.println("");
    System.out.print("Please choose an option: ");
    // ensures no InputMisMatchException is thrown
    if (scanner.hasNextInt()) {
      menuSelection = scanner.nextInt();
      scanner.nextLine();
    } else {
      System.out.println("Please choose a valid menu option...");
      menuSelection = 999;
    }
    return menuSelection;
  }

  /*
  public int promptForHotel(Hotel[] hotels, String action) {
    int menuSelection;
    System.out.println("--------------------------------------------");
    System.out.println("Hotels");
    System.out.println("--------------------------------------------");
    for (Hotel hotel : hotels) {
      System.out.println(hotel.getId() + ": " + hotel.getName());
    }
    System.out.println("");
    System.out.print("Please enter a hotel id to " + action + ": ");
    // ensures no InputMisMatchException is thrown
    if (scanner.hasNextInt()) {
      menuSelection = scanner.nextInt();
      scanner.nextLine();
    } else {
      menuSelection = 999;
    }
    return menuSelection;
  }
  */

/*  public void printHotels(Hotel[] hotels) {
    System.out.println("--------------------------------------------");
    System.out.println("Hotels");
    System.out.println("--------------------------------------------");
    for (Hotel hotel : hotels) {
      System.out.println(hotel.getId() + ": " + hotel.getName());
    }
  }
*/
  
  /*
  public void printHotel(Hotel hotel) {
    System.out.println(hotel.toString());
  }
*/
  public void next() {
    System.out.println("\nPress Enter to continue...");
    scanner.nextLine();
  }

  public void exit() {
    scanner.close();
    System.exit(0);
  }

  public void printError(String errorMessage) {
    System.err.println(errorMessage);
  }
  public String promptForLogin() {
    String credentials = "";
    System.out.println("Enter username,password");
    credentials = scanner.nextLine();
    return credentials;
  }

}
