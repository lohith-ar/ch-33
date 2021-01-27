import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Task33 {
    static int noofrecords = 0;

    static int[] price;
    static float[] rating;
    static String[] data;
    static String[] data1;

    public static void main(String[] args) throws IOException {
        String l = "";
        FileReader f;
        try {
            f = new FileReader("flipkart_product_sample.csv");
            BufferedReader br = new BufferedReader(f);
            while ((l = br.readLine()) != null) {
                noofrecords++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        price = new int[100];
        rating = new float[100];
        data = new String[100];

        Task33.readFromFile();
        // Task33.sortingOnPrice(price, data);
        Task33.sortingOnRating(rating, data);
    }




    static void readFromFile() {
        String l = "";
        int i = 0;

        FileReader f;
        try {
            f = new FileReader("data.csv");
            BufferedReader br = new BufferedReader(f);
            l = br.readLine();
            String tempString = "";
            while ((l = br.readLine()) != null) {

                data[i] = l;
                tempString = l.replaceAll("No rating available", "0");
                String temp1[] = tempString.split(",");
                price[i] = Integer.parseInt(temp1[4]);
                rating[i] = Float.parseFloat(temp1[6]);
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception io) {
            io.printStackTrace();
        }
    }

    static void sortingOnPrice(int[] arr, String[] data) {
        int j = 0;
        data1 = new String[100];

        for (j = 0; j < 100 - 1; j++) {
            data1[j] = data[j];
        }

        long startTime = System.currentTimeMillis();
        QuickSort.quickSort(arr, 0, arr.length - 1);
        long endTime = System.currentTimeMillis();
        System.out.println("******************\nTime taken for Quick sorting to run is: " + (endTime - startTime)
                + "\n********************\n");

        try {
            FileWriter fw = new FileWriter("OutputDataOnSortPrice.csv");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("pid,product_name,brand,product_url,retail_price,discounted_price,product_rating\n");
            for (int i = 0; i < 100 - 1; i++) {
                bw.write(data1[i] + "\n");

                // l++;
            }
            bw.close();
        } catch (FileNotFoundException f) {
            f.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    static void sortingOnRating(float[] arr, String[] data) {
        data1 = new String[100];
        int j = 0;

        for (j = 0; j < 100 - 1; j++) {
            data1[j] = data[j];
        }
      QuickSort.quickSort1(arr, 0, arr.length-1);
        try {
            FileWriter fw = new FileWriter("OutputDataOnSortRatings.csv");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("pid,product_name,brand,product_url,retail_price,discounted_price,product_rating\n");
            for (int i = 0; i < 100 - 1; i++) {
                bw.write(data1[i] + "\n");
            }
            bw.close();
        } catch (FileNotFoundException f) {
            f.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }

    }

}
