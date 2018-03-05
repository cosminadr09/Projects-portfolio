import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Server implements Runnable {

	private BlockingQueue<Task> tasks;
	private AtomicInteger waitingPeriod;

	public Server() {
		// initialize queue and waiting period
		tasks = new LinkedBlockingQueue<Task>();
		this.waitingPeriod = new AtomicInteger();
	}

	public void addTask(Task newTask) {
		// add task to queue
		tasks.add(newTask);
		// increment the waitingPeriod
		int procTime = newTask.getProcessingTime();
		this.waitingPeriod.addAndGet(procTime);
		// this.waitingPeriod.incrementAndGet();
		System.out.println(newTask.toString());
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			// take next task from queue
			try {
				Task head = new Task(0, 0);
				while (true) {
					if (!tasks.isEmpty()) {// cat timp serverul nu e gol, ci mai
											// are taskuri
						System.out.println("Current WaitingPeriod = "
								+ this.waitingPeriod);
						// metoda returneaza capul cozii
						head = tasks.peek();// nu sterge capul, doar il
											// returneaza
						//System.out.println("New Head " + head.toString());

						int time = head.getProcessingTime();

						Thread.sleep(time*1000);

						int currentWaitPeriod = this.waitingPeriod.get();
						this.waitingPeriod.set(currentWaitPeriod - time);
						tasks.take();
						TrySimulationManager.frame.textAreaProcesate.insert(
								head.toString() + "\n", 0);
						TrySimulationManager.frame.getContentPane().repaint();
						System.out.println("Taskul a fost procesat!\n");
						System.out
								.println("WaitingPeriod after processing task = "
										+ this.waitingPeriod);
						System.out.println("Taskuri ramase:" + tasks.size() + "\n");

					}

				}

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	// metoda trebuie sincronizata
	// scoatem o copie de taskuri ce se va transmite pe UI ca sa se afiseze
	public synchronized Task[] getTasks() {
		// colectie.toArray
		Task[] array = new Task[tasks.size()];
		// sa fim siguri ca nu intervine alt thread intre task.size si populare
		tasks.toArray(array);// queue devine array cu taskurile ce le contine
								// tasks
		// pe acest array pune-mi elem din tasks(care e o coada, o lista)
		System.out.println("Array: " + Arrays.toString(array));
		return array;
	}

	public void setTasks(BlockingQueue<Task> tasks) {
		this.tasks = tasks;
	}

	public AtomicInteger getWaitingPeriod() {
		return waitingPeriod;
	}

	public void setWaitingPeriod(AtomicInteger waitingPeriod) {
		this.waitingPeriod = waitingPeriod;
	}

	@Override
	public String toString() {
		return "TryServer [getTasks()=" + Arrays.toString(getTasks()) + "]";
	}

}
