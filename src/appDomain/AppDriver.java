package appDomain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import appDomain.SortingAlgorithms;
import appDomain.SortingAlgorithms.BubbleSort;
import appDomain.SortingAlgorithms.InsertionSort;
import appDomain.SortingAlgorithms.MergeSort;
import appDomain.SortingAlgorithms.QuickSort;
import appDomain.SortingAlgorithms.SelectionSort;
import shapes.Cone;
import shapes.Cylinder;
import shapes.OctagonalPrism;
import shapes.PentagonalPrism;
import shapes.Pyramid;
import shapes.ShapeComparator;
import shapes.SquarePrism;
import shapes.TriangularPrism;
import shapes.Shape;

public class AppDriver {

    public static void main(String[] args) {
        // Read the data file and create an array of shapes
    	 List<shapes.Shape> shapes = new ArrayList<>();
         try (BufferedReader br = new BufferedReader(new FileReader("./res/shapes1.txt"))) {
        	 String[] line;
             String shapeType;
             double height, length;
             while ((line = br.readLine().split("\\s+")) != null) {
                 shapeType = line[0];
                 height = Double.parseDouble(line[1]);
                 length = Double.parseDouble(line[2]);

                 switch (shapeType) {
                     case "Cylinder":
                         double radius1 = Double.parseDouble(line[2]);
                         shapes.add((Shape) new Cylinder(height, radius1));
                         break;
                     case "Cone":
                    	 double radius11 = Double.parseDouble(line[2]);
                         shapes.add((Shape) new Cone(height, radius11));
                         break;
                     case "OctagonalPrism":
                    	 shapes.add((Shape) new OctagonalPrism(height, length));
                         break;
                     case "PentagonalPrism":
                         shapes.add((Shape) new PentagonalPrism(height, length));
                         break;
                     case "SquarePrism":
                          shapes.add((Shape) new SquarePrism(height, length));
                          break;
                     case "TriangularPrism":
                          shapes.add((Shape) new TriangularPrism(height, length));
                          break;
                     case "Pyramid":
                         shapes.add((Shape) new Pyramid(height, length));
                         break;
                     default:
                         throw new IllegalArgumentException("Invalid shape type");
                 }
             }
        } catch (IOException e) {
            System.err.println("Error reading data file");
            e.printStackTrace();
            return;
        }

        // Parse command line arguments
        String comparisonType = "height";
        String sortingAlgorithm = "bubble";
        if (args.length > 0) {
            if (args[0].equals("-t")) {
                comparisonType = args[1];
                if (!comparisonType.equalsIgnoreCase("height") && !comparisonType.equalsIgnoreCase("baseArea") && !comparisonType.equalsIgnoreCase("volume")) {
                    System.err.println("Invalid comparison type");
                    return;
                }
            }
            if (args[1].equals("-s")) {
                sortingAlgorithm = args[2];
                if (!sortingAlgorithm.equalsIgnoreCase("bubble") && !sortingAlgorithm.equalsIgnoreCase("selection") && !sortingAlgorithm.equalsIgnoreCase("insertion") &&
                        !sortingAlgorithm.equalsIgnoreCase("merge") && !sortingAlgorithm.equalsIgnoreCase("quick")) {
                    System.err.println("Invalid sorting algorithm");
                    return;
                }
            }
        }

        // Sort the array of shapes
        long startTime = System.currentTimeMillis();
        Comparator<shapes.Shape> comparator = ShapeComparator.COMPARE_BY_HEIGHT;
        if (comparisonType.equalsIgnoreCase("baseArea")) {
            comparator = ShapeComparator.COMPARE_BY_BASE_AREA;
        } else if (comparisonType.equalsIgnoreCase("volume")) {
            comparator = ShapeComparator.COMPARE_BY_VOLUME;
        }
        switch (sortingAlgorithm) {
            case "bubble":
                BubbleSort.sort(shapes, comparator);
                break;
            case "selection":
                SelectionSort.sort(shapes, comparator);
                break;
            case "insertion":
                InsertionSort.sort(shapes, comparator);
                break;
            case "merge":
                MergeSort.sort(shapes, comparator);
                break;
            case "quick":
                QuickSort.sort(shapes, comparator);
                break;
            default:
                System.out.println("Invalid sorting algorithm.");
                return;
        }
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Sorting took " + duration + " milliseconds.");
        
        System.out.println("\nSorted shapes:");
        for (int i = 0; i < shapes.size(); i++) {
            if (i == 0 || i == shapes.size() - 1 || i % 1000 == 0) {
                System.out.printf("%d. %s%n", i + 1, shapes.get(i));
            }
        }
    }
}