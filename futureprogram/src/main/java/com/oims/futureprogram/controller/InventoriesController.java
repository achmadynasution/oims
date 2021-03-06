package com.oims.futureprogram.controller;

import com.oims.futureprogram.model.Inventories;
import com.oims.futureprogram.service.InventoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class InventoriesController {

    @Autowired
    private InventoriesService inventoriesService;

    @GetMapping("/inventories")
    public Page<Inventories> getInventories(Pageable pageable) {
        return inventoriesService.getInventories(pageable);
    }

    @GetMapping("/inventories/{inventoriesId}")
    public Inventories getOneInventories(@PathVariable Long inventoriesId) {
        return inventoriesService.getOneInventories(inventoriesId);
    }

    @GetMapping("/formrequest/{formrequestId}/inventories")
    public List<Inventories> getInventoriesByFormRequestId(@PathVariable Long formrequestId) {
        return inventoriesService.getInventoriesByFormRequestId(formrequestId);
    }

    @PostMapping("/formrequest/{formrequestId}/inventories")
    public Inventories createInventories(@Valid @RequestBody Inventories inventories, @PathVariable Long formrequestId) {
        return inventoriesService.createInventories(inventories, formrequestId);
    }

    @PutMapping("/formrequest/{formrequestId}/inventories/{inventoriesId}")
    public Inventories updateInventories(@PathVariable Long formrequestId, @PathVariable Long inventoriesId, @Valid @RequestBody Inventories inventoriesrequest) {
        return inventoriesService.updateInventories(formrequestId, inventoriesId, inventoriesrequest);
    }

    @DeleteMapping("/formrequest/{formrequestId}/inventories/{inventoriesId}")
    public void deleteInventories(@PathVariable Long formrequestId, @PathVariable Long inventoriesId) {
        inventoriesService.deleteInventories(formrequestId, inventoriesId);
    }

    @DeleteMapping("/inventories/{inventoriesId}")
    public void deleteOneInventories(@PathVariable Long invetoriesId) {
        inventoriesService.deleteOneInventories(invetoriesId);
    }
}
