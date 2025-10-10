package appDomain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.time.Duration;
import java.time.Instant;

import shapes.*;
import sorter.AbstractSorter;
import utilities.StringUtils;

/**
 * <p>
 * This application driver code is designed to be used as a basis for the
 * Complexity and Sorting assignment that will be developed in the CPRG304
 * F2025 class at SAIT. The implementors of this applications will be required
 * to add all the correct functionality.
 * </p>
 */
public class AppDriver {
	/**
	 * The main method is the entry point of the application.
	 * 
	 * @param args The input to control the execution of the application.
	 */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Usage: java -jar AppDriver.jar -f<filename> -a<algorithm> -p<property>");
			return;
		}

		MainInput mainInput;
		try {
			mainInput = parseArgs(args);
		} catch (IllegalArgumentException e) {
			System.err.println("Error parsing arguments: " + e.getMessage());
			return;
		}

		Shape[] shapes = resolveShapesFromFile(mainInput.getFileName());
		if (shapes == null) {
			System.err.println("Error resolving shapes from file: " + mainInput.getFileName());
			return;
		}

		AbstractSorter<Shape> sorter;
		try {
			sorter = resolveSorter(mainInput.getSortingAlgorithmType());
		} catch (IllegalArgumentException e) {
			System.err.println("Error resolving sorter: " + e.getMessage());
			return;
		}

		try {
			Instant start = Instant.now();
			sortShapes(shapes, sorter, mainInput.getSortingProperty());
			Instant end = Instant.now();
			Duration duration = Duration.between(start, end);

			printShapes(shapes, mainInput.getSortingProperty());
			System.out.println(
					mainInput.getSortingAlgorithmName() + " run time was: " + duration.toMillis() + " milliseconds");
		} catch (IllegalArgumentException e) {
			System.err.println("Error sorting shapes: " + e.getMessage());
			return;
		}

	}

	private static Shape[] resolveShapesFromFile(String fileName) {
		File inputFile = new File("res/" + fileName);

		try (Scanner input = new Scanner(inputFile)) {
			if (!input.hasNextLine()) {
				System.err.println("文件为空：" + fileName);
				return null;
			}

			int count = Integer.parseInt(input.nextLine().trim());
			Shape[] shapes = new Shape[count];

			int i = 0;
			while (input.hasNextLine()) {
				String line = input.nextLine().trim();
				Shape shape = Shape.parse(line);
				shapes[i++] = shape;
			}

			return shapes;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	private static MainInput parseArgs(String[] args) {
		MainInput mainInput = new MainInput();

		for (int i = 0; i < args.length; i++) {
			switch (args[i]) {
				case "-f":
					mainInput.setFileName(args[i++].substring(2));
					break;
				case "-a":
					mainInput.setSortingAlgorithmType(args[i++].substring(2));
					break;
				case "-p":
					mainInput.setSortingProperty(args[i++].substring(2));
					break;
				default:
					throw new IllegalArgumentException("Unknown argument: " + args[i]);
			}
		}

		return mainInput;
	}

	private static AbstractSorter<Shape> resolveSorter(String sortingAlgorithmType) {
		switch (sortingAlgorithmType) {
			case "b":
				return new sorter.BubbleSorter<Shape>();
			case "s":
				return new sorter.SelectionSorter<Shape>();
			case "i":
				return new sorter.InsertionSorter<Shape>();
			case "q":
				return new sorter.QuickSorter<Shape>();
			case "m":
				return new sorter.MergeSorter<Shape>();
			case "z":
				return new sorter.HeapSorter<Shape>();
			default:
				throw new IllegalArgumentException("Unknown sorting algorithm type: " + sortingAlgorithmType);
		}
	}

	private static void sortShapes(Shape[] shapes, AbstractSorter<Shape> sorter, String sortingProperty) {
		switch (sortingProperty) {
			case "a":
				sorter.sort(shapes, new BaseAreaComparator());
				break;
			case "h":
				sorter.sort(shapes, new HeightComparator());
				break;
			case "v":
				sorter.sort(shapes, new VolumeComparator());
				break;
			default:
				throw new IllegalArgumentException("Unknown sorting property: " + sortingProperty);
		}
	}

	private static void printShapes(Shape[] shapes, String property) {
		for (int i = 0; i < shapes.length; i++) {

			Class<?> clazz = shapes[i].getClass();
			System.out.println(
					StringUtils.padRight((i + 1) + "-th element: ", 50, ' ')
							+ StringUtils.padLeft(clazz.getName(), 30, ' ') + "          "
							+ shapes[i].getProperty(property));
		}
	}

}
