
public class Chromosone {

	private int[] chromosone;
	private static final int length = 500;
	
	public Chromosone() {
		chromosone = new int[length];
		for(int i = 0; i < length; i++) {
			this.randomlySetGene(i);
		}
	}
	
//--------------------------------- SETTERS AND GETTERS --------------------------//

	public int getGene(int index) {
		return chromosone[index];
	}

	public void setGene(int index, int value) {
		chromosone[index] = value;
	}
	
	public void randomlySetGene(int index) {
		if(Math.random() < 0.5) {
			chromosone[index] = 0;
		} else {
			chromosone[index] = 1;
		}
	}
	
	public static int length() {
		return length;
	}
	
//-----------------  -------- FITNESS RELATED FUNCTION ----------------------------//
	
	public int getFitness() {
		int fitness = 0;
		for(int i = 0; i < chromosone.length; i++) {
			if(chromosone[i] == 1) {
				fitness++;
			}
		}
		return fitness;
	}
	
	public static int maxTheoreticalFitness() {
		return length;
	}
	
	public static int targetFitness() {
		return maxTheoreticalFitness();
	}
	
//------------------------------ STRING REPRESENTATION ------------------------------//

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < length; i++) {
			builder.append(chromosone[i]);
		}
		return builder.toString();
	}
	
}
