package com.keyin.BinarySearchTree;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BinaryTreeRepository extends JpaRepository<Tree, Long> {
}
