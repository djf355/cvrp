
public class PopulationEvolutionService {

	private static double mutationRate = 0.0025;
	
	public static Population evolvePopulation(Population population) {
		Population nextGenPopulation = new Population(population.size());
		population.setChromosone(0, population.getFittest());
		for(int i = 1; i < population.size(); i++) {
			Chromosone father = selection(population);
			Chromosone mother = selection(population);
			nextGenPopulation.setChromosone(i, crossOver(father, mother));
		}
		
		for(int i = 1; i < population.size(); i++) {
			mutate(nextGenPopulation.getChromosone(i));
		}
		return nextGenPopulation;
	}
	
	// Todo: PMX cross over
	public static Chromosone crossOver(Chromosone father, Chromosone mother) {
		Chromosone offspring = new Chromosone();
		for(int i = 0; i < Chromosone.length(); i++) {
			if(Math.random() < 0.5) {
				offspring.setGene(i, father.getGene(i));
			} else {
				offspring.setGene(i, mother.getGene(i));
			}
		}		
		return offspring;
	}
	
	// Todo: 2-swap mutation
	public static void mutate(Chromosone chromosone) {
		for(int i = 0; i < Chromosone.length(); i++) {
			if(Math.random() < mutationRate) {
				chromosone.randomlySetGene(i);
			}
		}
	}
	
	public static Chromosone selection(Population population) {
		Population tournament = new Population(population.size());
		for(int i = 0; i < population.size(); i++) {
			tournament.setChromosone(i, population.getChromosone( (int) Math.random() * population.size()));
		}
		return tournament.getFittest();
	}
}
