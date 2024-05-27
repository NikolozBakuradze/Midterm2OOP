import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AgriculturalCompany {
    private List<Crop> cropList;

    public AgriculturalCompany() {
        cropList = new ArrayList<>();
    }

    public void addCrop(Crop crop) {
        cropList.add(crop);
    }

    public void removeCrop(Crop crop) {
        cropList.remove(crop);
    }

    public List<Crop> getCropList() {
        return cropList;
    }

    public void displayCropList() {
        if (cropList.isEmpty()) {
            System.out.println("The crop list is empty.");
        } else {
            System.out.println("List of crops in the agricultural company:");
            for (Crop crop : cropList) {
                System.out.println(crop);
            }
        }
    }

    public void saveState(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                if (!file.createNewFile()) {
                    System.out.println("Error creating file: " + fileName);
                    return;
                }
            } catch (IOException e) {
                System.out.println("Error creating file: " + e.getMessage());
                return;
            }
        }

        if (!file.canWrite()) {
            System.out.println("Error: No write permission for file " + fileName);
            return;
        }

        try (FileWriter fileWriter = new FileWriter(fileName)) {
            for (Crop crop : cropList) {
                fileWriter.write(crop.getName() + "," + crop.getPrice() + "," + crop.getQuantity() + "\n");
            }
            System.out.println("State saved successfully to " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving state: " + e.getMessage());
        }
    }

    public void restoreState(String fileName) {
        File file = new File(fileName);
        if (!file.exists() || !file.canRead()) {
            System.out.println("File not found or cannot be read: " + fileName);
            return;
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            cropList.clear(); // Clear the existing crop list
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    try {
                        String name = parts[0];
                        double price = Double.parseDouble(parts[1]);
                        int quantity = Integer.parseInt(parts[2]);
                        cropList.add(new Crop(name, price, quantity));
                    } catch (NumberFormatException e) {
                        System.out.println("Error parsing number in line: " + line);
                    }
                } else {
                    System.out.println("Invalid data format in file: " + line);
                }
            }
            System.out.println("State restored successfully from " + fileName);
        } catch (IOException e) {
            System.out.println("Error restoring state: " + e.getMessage());
        }
    }
}
