import java.io.IOException;


public class App {
	public static void main(String[] args) {
		
		Population population = new Population(500);
		
		// Evolve our population until we reach an optimum solution
        int generationCount = 0;
        while (population.getFittest().getFitness() < Chromosone.targetFitness()) {
            generationCount++;
            System.out.println("Generation: " + generationCount + " Fittest: " + population.getFittest().getFitness() +
            					" Total Fitness: " + population.totalPopulationFitness());
            population = PopulationEvolutionService.evolvePopulation(population);
        }
        System.out.println("Solution found!");
        System.out.println("Generation: " + generationCount);
        System.out.println("Genes:");
        System.out.println(population.getFittest());
		
		/*
		String[] filename = new String[1];
		filename[0] = "fruitybun250.vrp";
		try {
			CVRPData.begin(filename);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(CVRPData.getDemand(6));
		*/
	}
}
