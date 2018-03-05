import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JFrame;

public class TrySimulationManager implements Runnable {

	public static UISimulation frame;
	public int timeLimit = frame.timpMaxim;
	public int maxProcessingTime = 10;
	public int minProcessingTime = 2;
	public int numberOfServers = frame.nrServere;
	public int numberOfClients = frame.nrClienti;
	private List<Task> generatedTasks = new CopyOnWriteArrayList<Task>();
	private Scheduler scheduler;

	public TrySimulationManager() {
		scheduler = new Scheduler(frame.nrServere, frame.nrClienti);

		generateNRandomTasks();

	}

	private void generateNRandomTasks() {

		Random random = new Random();

		for (int i = 0; i < numberOfClients; i++) {
			Task t = new Task(
					random.nextInt(timeLimit),
					random.nextInt(maxProcessingTime - minProcessingTime + 1) + 1);
			// random.nextInt(max-min+1)+min
			generatedTasks.add(t);
		}
		Collections.sort(generatedTasks, new Comparator<Task>() {

			@Override
			public int compare(Task t1, Task t2) {
				// TODO Auto-generated method stub
				return t1.getArrivalTime() - t2.getArrivalTime();
			}

		});

		for (Task t : generatedTasks) {
			System.out.println(t.toString());
		}

	}

	@Override
	public void run() {

		int currentTime = 0;
		while (currentTime < timeLimit) {

			for (Task t : generatedTasks) {
				if (t.getArrivalTime() == currentTime) {
					scheduler.dispatchTask(t);
					generatedTasks.remove(t);
				}
			}

			currentTime++;
			System.out.println("current time: " + currentTime);
			try {
				Random random = new Random();
				int waiting = random.nextInt(5 - 1) + 1;

				Thread.sleep(1000 * waiting);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	/*	while(!generatedTasks.isEmpty()){
			//continui sa afisez
			currentTime++;
			System.out.println("current time: " + currentTime);
			for (Task t : generatedTasks){
				scheduler.dispatchTask(t);
				generatedTasks.remove(t);
			}
		}*/

	}

	public static void main(String[] args) {

		try {
			frame = new UISimulation();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
