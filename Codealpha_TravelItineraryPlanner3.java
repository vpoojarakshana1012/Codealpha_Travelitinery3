import java.util.ArrayList;
import java.util.Scanner;

public class TravelItineraryPlanner {

    // Destination class to hold travel destination details
    static class Destination {
        String name;
        String arrivalDate;
        String departureDate;
        String activities;
        double budgetEstimate;

        public Destination(String name, String arrivalDate, String departureDate, String activities, double budgetEstimate) {
            this.name = name;
            this.arrivalDate = arrivalDate;
            this.departureDate = departureDate;
            this.activities = activities;
            this.budgetEstimate = budgetEstimate;
        }

        public void displayDetails() {
            System.out.println("\nDestination: " + name);
            System.out.println("Arrival Date: " + arrivalDate);
            System.out.println("Departure Date: " + departureDate);
            System.out.println("Activities: " + activities);
            System.out.println("Budget Estimate: $" + budgetEstimate);
        }

        // Mock weather details for destination (simulated weather data)
        public void displayWeatherInfo() {
            System.out.println("\nWeather Information for " + name + ":");
            System.out.println("Weather: Sunny");
            System.out.println("Temperature: 25°C (77°F)");
        }

        // Mock map URL (simulating a map link to the destination)
        public void displayMapInfo() {
            System.out.println("\nMap for " + name + ":");
            System.out.println("URL: https://www.google.com/maps?q=" + name);
        }
    }

    // Travel itinerary manager to handle the list of destinations and plan
    static class ItineraryManager {
        ArrayList<Destination> destinations;
        double totalBudget;

        public ItineraryManager() {
            destinations = new ArrayList<>();
            totalBudget = 0;
        }

        // Add a destination to the itinerary
        public void addDestination(Destination destination) {
            destinations.add(destination);
            totalBudget += destination.budgetEstimate;
        }

        // Display all destinations and the complete itinerary
        public void displayItinerary() {
            System.out.println("\n--- Travel Itinerary ---");
            for (Destination destination : destinations) {
                destination.displayDetails();
                destination.displayWeatherInfo();
                destination.displayMapInfo();
                System.out.println("-----------------------------------");
            }
            System.out.println("Total Budget Estimate: $" + totalBudget);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ItineraryManager itineraryManager = new ItineraryManager();

        System.out.println("Welcome to the Travel Itinerary Planner!");

        boolean addingDestinations = true;

        while (addingDestinations) {
            // Get user input for a destination
            System.out.print("\nEnter the destination name: ");
            String name = scanner.nextLine();

            System.out.print("Enter the arrival date (YYYY-MM-DD): ");
            String arrivalDate = scanner.nextLine();

            System.out.print("Enter the departure date (YYYY-MM-DD): ");
            String departureDate = scanner.nextLine();

            System.out.print("Enter activities for this destination: ");
            String activities = scanner.nextLine();

            System.out.print("Enter the estimated budget for this destination: $");
            double budgetEstimate = scanner.nextDouble();
            scanner.nextLine();  // Consume the newline character

            // Create a new destination and add it to the itinerary
            Destination destination = new Destination(name, arrivalDate, departureDate, activities, budgetEstimate);
            itineraryManager.addDestination(destination);

            // Ask if the user wants to add another destination
            System.out.print("\nDo you want to add another destination? (yes/no): ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("no")) {
                addingDestinations = false;
            }
        }

        // Display the full itinerary
        itineraryManager.displayItinerary();

        scanner.close();
    }
}