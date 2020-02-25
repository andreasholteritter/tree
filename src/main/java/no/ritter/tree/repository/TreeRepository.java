package no.ritter.tree.repository;

import no.ritter.tree.entity.Tree;
import org.springframework.data.repository.CrudRepository;

public interface TreeRepository extends CrudRepository<Tree, Integer> {}