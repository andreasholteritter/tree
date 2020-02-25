package no.ritter.tree;

import no.ritter.tree.service.TreeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TreeApplication {

	private TreeService treeService;

	public static void main(String[] args) {
		SpringApplication.run(TreeApplication.class, args);
	}

}
