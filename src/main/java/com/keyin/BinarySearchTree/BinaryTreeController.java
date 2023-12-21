package com.keyin.BinarySearchTree;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class BinaryTreeController {
    @Autowired
    private BinaryTreeService binaryTreeService;

    @GetMapping("/enter-numbers")
    public String displayEnterNumbersPage(){
        return "enter-numbers";
    }

    @PostMapping("/process-numbers")
    public ResponseEntity<String> processNumbers(@RequestParam("numbers") String numbers){
        String treeStructure = binaryTreeService.buildTree(numbers);
        binaryTreeService.saveTree(numbers, treeStructure);
        return ResponseEntity.ok(treeStructure);
    }

    @GetMapping("/previous-trees")
    public ResponseEntity<List<Tree>> getPreviousTrees() {
        List<Tree> previousTrees = binaryTreeService.getAllTrees();
        return ResponseEntity.ok(previousTrees);
    }
}
