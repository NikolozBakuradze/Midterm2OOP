public class Main {
    public static void main(String[] args) {
        // Create an agricultural company
        AgriculturalCompany agriCompany = new AgriculturalCompany();

        // Add crops to the company's crop list
        agriCompany.addCrop(new Crop("Wheat", 10.5, 100));
        agriCompany.addCrop(new Crop("Corn", 8.75, 200));
        agriCompany.addCrop(new Crop("Rice", 12.0, 150));

        // Display the list of crops
        agriCompany.displayCropList();

        // Save the state to a CSV file
        agriCompany.saveState("state.csv");

        // Remove a crop
        Crop corn = new Crop("Corn", 8.75, 200);
        agriCompany.removeCrop(corn);

        // Display the updated list of crops
        System.out.println("\nList of crops after removing Corn:");
        agriCompany.displayCropList();

        // Restore the state from the CSV file
        agriCompany.restoreState("state.csv");

        // Display the restored list of crops
        System.out.println("\nList of crops after restoring state:");
        agriCompany.displayCropList();
    }
}