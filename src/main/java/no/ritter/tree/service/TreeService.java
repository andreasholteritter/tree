package no.ritter.tree.service;

import no.ritter.tree.entity.Tree;
import no.ritter.tree.repository.TreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TreeService implements TreeRepository {

    @Autowired
    private TreeRepository repository;

    @Override
    public <S extends Tree> S save(S entity) {
        return repository.save(entity);
    }

    @Override
    public <S extends Tree> Iterable<S> saveAll(Iterable<S> entities) {
        List<Tree> trees = new ArrayList<Tree>();
        entities.forEach(tree -> trees.add(tree));
        repository.saveAll(trees);
        return null;
    }

    @Override
    public Optional<Tree> findById(Integer id) {
        Tree tree = repository.findById(id).get();
        Optional<Tree> opt = Optional.ofNullable(tree);
        return opt;
    }

    @Override
    public boolean existsById(Integer id) {
        Tree tree = repository.findById(id).get();
        if (tree == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Iterable<Tree> findAll() {
        return repository.findAll();
    }

    @Override
    public Iterable<Tree> findAllById(Iterable<Integer> integers) {
        return repository.findAllById(integers);
    }

    @Override
    public long count() {
        List<Tree> trees = new ArrayList<Tree>();
        repository.findAll().forEach(tree -> trees.add(tree));
        return trees.size();
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(Tree tree) {
        repository.delete(tree);
    }

    @Override
    public void deleteAll(Iterable<? extends Tree> trees) {
        repository.deleteAll(trees);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
