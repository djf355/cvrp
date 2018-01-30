
public class Population {
	
	private Chromosone[] population;
	private int size;
	
	public Population(int size) {
		this.size = size;
		population = new Chromosone[size];
		for(int i = 0; i < size; i++) {
			population[i] = new Chromosone();
		}
	}
	
//---------------------------------  SETTERS AND GETTERS -------------------------------------------------//

	public Chromosone getChromosone(int index) {
		return population[index];
	}

	public void setChromosone(int index, Chromosone chromosone) {
		population[index] = chromosone;
	}
	
	public int size() {
		return size;
	}
	
//--------------------------------- FITNESS RELATED FUNCTIONS ------------------------------------------------//
	
	public Chromosone getFittest() {
		Chromosone fittest = population[0];
		for(int i = 0 ; i < size; i++) {
			if(population[i].getFitness() > fittest.getFitness()) {
				fittest = population[i];
			}
		}
		return fittest;
	}
	
	public int totalPopulationFitness() {
		int totalFitness = 0;
		for(int i = 0; i < size; i++) {
			totalFitness = totalFitness + population[i].getFitness();
		}
		return totalFitness;
	}
}
