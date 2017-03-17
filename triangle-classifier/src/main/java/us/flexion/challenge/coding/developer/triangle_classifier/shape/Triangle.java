package us.flexion.challenge.coding.developer.triangle_classifier.shape;

import java.util.ArrayList;
import java.util.Arrays;

public class Triangle extends Shape {

	private TriangleClassificationEnum triangleClassificationEnum;

	public Triangle() {

		super();
		this.triangleClassificationEnum = null;
		this.shapeSides = null;
	}

	public Triangle(Double sideLengthA, Double sideLengthB, Double sideLengthC) {

		super();
		shapeSides = new ArrayList<ShapeSide>();
		shapeSides.add(new ShapeSide(sideLengthA));
		shapeSides.add(new ShapeSide(sideLengthB));
		shapeSides.add(new ShapeSide(sideLengthC));
	}

	public TriangleClassificationEnum getTriangleClassificationEnum() {
		return triangleClassificationEnum;
	}

	public void setTriangleClassificationEnum(TriangleClassificationEnum triangleClassificationEnum) {
		this.triangleClassificationEnum = triangleClassificationEnum;
	}
}
