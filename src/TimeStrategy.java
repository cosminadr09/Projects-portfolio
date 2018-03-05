import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class TimeStrategy {

	String s = new String(" ");

	public void addTask(List<Server> servers, Task t) {

		// returneaza serverul cu waitingtime minim
		if (!servers.isEmpty()) {
			int minServerPeriod = servers.get(0).getWaitingPeriod().get();
			int index = 0;
			for (int k = 0; k < servers.size(); k++) {
				int currentServerPeriod = servers.get(k).getWaitingPeriod()
						.get();
				System.out.println("CurrentServerWaitingPer: "
						+ currentServerPeriod);
				if (currentServerPeriod < minServerPeriod) {
					minServerPeriod = currentServerPeriod;
					index = k;
				}
			}
			servers.get(index).addTask(t);
			s = t.toString() + "\n";
			//System.out.println("String s : " + s);
			System.out.println("Task added on server " + index + "\n");
			if (index == 0) {
				TrySimulationManager.frame.textArea0.insert(s, 0);
				//System.out.println("index 0");
			} else if (index == 1) {
				TrySimulationManager.frame.textArea1.insert(s, 0);
			} else if (index == 2) {
				TrySimulationManager.frame.textArea2.insert(s, 0);
			}
			TrySimulationManager.frame.getContentPane().repaint();

		} else {
			System.out.println("List of servers is empty!");
		}

	}

}
