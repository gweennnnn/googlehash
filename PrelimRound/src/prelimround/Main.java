package prelimround;

public class Main {

	public static void main(String[] args) {
		Simulation sim = new Simulation();
		
		ProcessFile processFile = new ProcessFile("mother_of_all_warehouses.in");
		processFile.getFile(sim);
		
		//System.out.println(sim.products);
	}

}
