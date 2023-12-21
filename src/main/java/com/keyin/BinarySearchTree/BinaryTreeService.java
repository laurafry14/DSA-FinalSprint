package com.keyin.BinarySearchTree;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class BinaryTreeService {
    @Autowired
    private BinaryTreeRepository binaryTreeRepository;

    public String buildTree(String numbers){
        BinarySearchTree BST = new BinarySearchTree();

        String[] numArray = numbers.split(",");
        for (String numString : numArray) {
            int num = Integer.parseInt(numString.trim());
            BST.insert(num);
        }

        return convertTreeToJson(BST.root);
    }

    private String convertTreeToJson(BinaryNode root){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(root);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "Error creating JSON tree.";
        }
    }

    public void saveTree(String inputNumbers, String treeStructure){
        Tree tree = new Tree();
        tree.setInputNumbers(inputNumbers);
        tree.setTreeStructure(treeStructure);
        binaryTreeRepository.save(tree);
    }

    public List<Tree> getAllTrees() {
        return binaryTreeRepository.findAll();
    }
}
