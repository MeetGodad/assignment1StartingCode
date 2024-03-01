package appDomain;

import java.util.*;
import java.io.*;
import appDomain.SortingAlgorithms.BubbleSort;
import appDomain.SortingAlgorithms.HeapSort;
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

public class AppDriver {

    public static void main(String[] args) {

        shapes.Shape[] shapes;
        String filename = null;
        String comparisonType = "";
        String sortingAlgorithm = "";

        int i = 0;
        while (i < args.length) {
            if (args[i].equalsIgnoreCase("-f")) {
                filename = args[++i];
            } else if (args[i].equalsIgnoreCase("-F")) {
                filename = args[++i];
            } else if (args[i].equalsIgnoreCase("-t")) {
                comparisonType = args[++i];
                if (!comparisonType.equalsIgnoreCase("a") && !comparisonType.equalsIgnoreCase("v")&& !comparisonType.equalsIgnoreCase("h")) {
                    System.err.println("Invalid comparison type");
                    return;
                }
            } else if (args[i].equalsIgnoreCase("-T")) {
                comparisonType = args[++i];
                if (!comparisonType.equalsIgnoreCase("a") && !comparisonType.equalsIgnoreCase("v")&& !comparisonType.equalsIgnoreCase("h")) {
                    System.err.println("Invalid comparison type");
                    return;
                }
            } else if (args[i].equalsIgnoreCase("-s")) {
                sortingAlgorithm = args[++i];
                if (!sortingAlgorithm.equalsIgnoreCase("b") && !sortingAlgorithm.equalsIgnoreCase("s") && !sortingAlgorithm.equalsIgnoreCase("i") && !sortingAlgorithm.equalsIgnoreCase("m") && !sortingAlgorithm.equalsIgnoreCase("q")&& !sortingAlgorithm.equalsIgnoreCase("h")) {
                    System.err.println("Invalid sorting algorithm");
                    return;
                }
            } else if (args[i].equalsIgnoreCase("-S")) {
                sortingAlgorithm = args[++i];
                if (!sortingAlgorithm.equalsIgnoreCase("b") && !sortingAlgorithm.equalsIgnoreCase("s") && !sortingAlgorithm.equalsIgnoreCase("i") && !sortingAlgorithm.equalsIgnoreCase("m") && !sortingAlgorithm.equalsIgnoreCase("q")&& !sortingAlgorithm.equalsIgnoreCase("h")) {
                    System.err.println("Invalid sorting algorithm");
                    return;
                }
            } else {
                System.err.println("Invalid command line argument: " + args[i]);
                return;
            }
            i++;
        }

        if (filename == null) {
            System.err.println("A filename must be provided with the -f or -F argument.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int shapeCount = Integer.parseInt(br.readLine());
            shapes = new shapes.Shape[shapeCount];

            String[] lineParts;
            String shapeType;
            double height, length;
            int index = 0;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }
                lineParts = line.split("\\s+");
                if (lineParts.length > 0) {
                    shapeType = lineParts[0];
                    height = Double.parseDouble(lineParts[1]);

                    switch (shapeType) {
                        case "Cylinder":
                            double radius1 = Double.parseDouble(lineParts[2]);
                            shapes[index] = new Cylinder(height, radius1);
                            break;
                        case "Cone":
                            double radius11 = Double.parseDouble(lineParts[2]);
                            shapes[index] = new Cone(height, radius11);
                            break;
                        case "OctagonalPrism":
                            length = Double.parseDouble(lineParts[2]);
                            shapes[index] = new OctagonalPrism(height, length);
                            break;
                        case "PentagonalPrism":
                            length = Double.parseDouble(lineParts[2]);
                            shapes[index] = new PentagonalPrism(height, length);
                            break;
                        case "SquarePrism":
                            length = Double.parseDouble(lineParts[2]);
                            shapes[index] = new SquarePrism(height, length);
                            break;
                        case "TriangularPrism":
                            length = Double.parseDouble(lineParts[2]);
                            shapes[index] = new TriangularPrism(height, length);
                            break;
                        case "Pyramid":
                            length = Double.parseDouble(lineParts[2]);
                            shapes[index] = new Pyramid(height, length);
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid shape type");
                    }
                    index++;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading data file");
            e.printStackTrace();
            return;
        }

      
        // Sort the array of shapes
        long startTime = System.currentTimeMillis();
        Comparator<shapes.Shape> comparator = ShapeComparator.COMPARE_BY_HEIGHT;
        if (comparisonType.equalsIgnoreCase("a")) {
            comparator = ShapeComparator.COMPARE_BY_BASE_AREA;
        } else if (comparisonType.equalsIgnoreCase("v")) {
            comparator = ShapeComparator.COMPARE_BY_VOLUME;
        }else if (comparisonType.equalsIgnoreCase("h")) {
            comparator = ShapeComparator.COMPARE_BY_HEIGHT;
        }
        switch (sortingAlgorithm) {
            case "b":
                BubbleSort.sort(shapes, comparator);
                break;
            case "s":
                SelectionSort.sort(shapes, comparator);
                break;
            case "i":
                InsertionSort.sort(shapes, comparator);
                break;
            case "m":
                MergeSort.sort(shapes, comparator);
                break;
            case "q":
                QuickSort.sort(shapes, comparator);
                break;
            case "h":
                HeapSort.sort(shapes, comparator);
                break;
            default:
                System.out.println("Invalid sorting algorithm.");
                return;
        }
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Sorting took " + duration + " milliseconds.");

        System.out.println("\nSorted shapes:");

        for (int j = 0; j < shapes.length; j++) {
            if (j == 0 || j == shapes.length - 1 || j % 1000 == 0) {
                System.out.printf("%d. %s%n", j + 1, shapes[j]);
            }
        }
    }
}