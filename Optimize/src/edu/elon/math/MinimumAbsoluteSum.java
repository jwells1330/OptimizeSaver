package edu.elon.math;

import java.util.ArrayList;

public class MinimumAbsoluteSum extends Function {

	/**
	   * Default constructor to set initial input point to (0, 0)
	   */
	  public MinimumAbsoluteSum() {
	    this(new double[] { -100, 100, -100, 100, -100, 100, -100, 100, -100, 100, -100, 100 });
	  }
	  
	  /**
	   * Constructor that initializes starting design point from values
	   * passed in as an array of double.
	   * 
	   * @param inputs double[] array of values to set initial design
	   *        point.
	   */
	  public MinimumAbsoluteSum(double[] inputs) {
	    ArrayList<Double> values = new ArrayList<Double>();
	    for (double d : inputs) {
	      values.add(new Double(d));
	    }
	    this.setInputValues(values);
	    this.setInputNames(createDefaultInputNames());
	    this.setMinimize(true);
	    this.setTitle("MinimumAbsoluteSum");
	  }

	  /**
	   * Constructor initializes initial input point to ArrayList
	   * <Double> passed in as a parameter
	   * 
	   * @param inputValues ArrayList<Double> representing values for
	   *        initial design point.
	   */
	  public MinimumAbsoluteSum(ArrayList<Double> inputValues) {
	    this(inputValues, createDefaultInputNames());
	  }
	
	/**
	   * Initializes the names of each input along with its initial value
	   * from the parameters.
	   * 
	   * @param inputValues ArrayList<Double> representing values of
	   *        initial design point.
	   * @param inputNames ArrayList<String> representing names of each
	   *        input parameter
	   */
	  public MinimumAbsoluteSum(ArrayList<Double> inputValues, ArrayList<String> inputNames) {
	    this.setInputValues(inputValues);
	    this.setInputNames(inputNames);
	    this.setMinimize(true);
	    this.setTitle("MinimumAbsoluteSum");
	  }
	
	/**
	   * Provides a default set of names for input parameters and is used
	   * if user does not supply any.
	   * 
	   * @return ArrayList<String> representing input parameter names.
	   */
	  private static ArrayList<String> createDefaultInputNames() {
	    ArrayList<String> names = new ArrayList<String>();
	    names.add("Value1");
	    names.add("Value2");
	    names.add("Value3");
	    names.add("Value4");
	    names.add("Value5");
	    names.add("Value6");
	    names.add("Value7");
	    names.add("Value8");
	    names.add("Value9");
	    names.add("Value10");
	    return names;
	  }
	  
	  
	  /**
	   * Evaluates the function from the current set of input values.
	   * 
	   * @return Double instance of function value
	   */
	  @Override
	  public Double evaluate() {
		double sum = 0;
		for(int i = 0; i < 10; i++){
			double s = Math.abs(getInputValues().get(i).doubleValue());
			sum = sum + s;
		}
		 this.setOutput(new Double(sum));
		 return this.getOutput();
		  
//	    double x1 = getInputValues().get(0).doubleValue();
//	    double y1 = getInputValues().get(1).doubleValue();
//	    double[] cost = { 7.9, 25, 13.1, 17.4, 19.5, 13, 17.8, 8.0, 9.2, 6.3, 42.0, 6.6 };
//	    double[] quantity = { 19, 2, 9, 4, 5, 6, 3, 11, 14, 17, 1, 20 };
//	    double lsq = 0.0;
//	    for (int i = 0; i < cost.length; i++) {
//	      lsq = lsq + Math.pow(cost[i] - x1 * Math.pow(quantity[i], y1), 2);
//	    }
//	    this.setOutput(new Double(lsq));
//	    return this.getOutput();
	  }
}
