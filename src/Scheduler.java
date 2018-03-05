import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Scheduler {
	private List<Server> servers;
	private int maxNoServers;
	private int maxTasksPerServer;
	private TimeStrategy strategy = new TimeStrategy();

	public Scheduler(int maxNoServers, int maxTasksPerServer) {

		setMaxNoServers(maxNoServers);
		setMaxTasksPerServer(maxTasksPerServer);
		servers = new ArrayList<Server>(maxNoServers);

		for (int i = 0; i < maxNoServers; i++) {
			Server s = new Server();
			servers.add(s);
			Thread t = new Thread(s);
			t.start();
		}
		System.out.println("No of servers is: " + servers.size());

	}

	public void dispatchTask(Task t) {

		strategy.addTask(servers, t);
	}

	public List<Server> getServers() {
		return servers;
	}

	public int getMaxNoServers() {
		return maxNoServers;
	}

	public void setMaxNoServers(int maxNoServers) {
		this.maxNoServers = maxNoServers;
	}

	public int getMaxTasksPerServer() {
		return maxTasksPerServer;
	}

	public void setMaxTasksPerServer(int maxTasksPerServer) {
		this.maxTasksPerServer = maxTasksPerServer;
	}

}
