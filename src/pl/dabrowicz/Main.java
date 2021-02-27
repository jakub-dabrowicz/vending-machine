package pl.dabrowicz;

import java.util.ArrayList;
import java.util.Collection;

public class Main {

    public static void main(String[] args) {
        Collection<Task> tasks = new ArrayList<>();

        tasks.add(new Machine());

        for (Task task : tasks) {
            task.run();
        }
    }
}

