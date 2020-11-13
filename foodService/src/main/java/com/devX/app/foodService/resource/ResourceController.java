package com.devX.app.foodService.resource;

import com.devX.app.foodService.model.Item;
import com.devX.app.foodService.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

// The data to the UI is accessed from getCatalog rest endpoint.
// The data in the DB is maintained by the addCatalog rest endpoint.

//REST Endpoints
/**
 * Schema - foodCatalog , Table - fooditems
 * rest/getCatalog        - All the foodItems from DataBase
 * rest/addCatalog        - Adds items to DataBase
 * rest/delete/{itemName} - Delete the item from the DataBase
 * rest/modifyCatalog     - Updates item
 * **/

/**
 * Todo
 * Add Eureka Client, Server
 *
 * **/


@RestController
@RequestMapping(value = "/rest")
public class ResourceController {
    @Autowired
    FoodRepository foodRepository;

    @GetMapping(value = "/getCatalog")
    public List<Item> getItem(){
        return foodRepository.findAll();
    }

    @PostMapping(value = "/addCatalog")
    public List<Item> addItem(@RequestBody final Item item){
        foodRepository.save(item);
        return foodRepository.findAll();
    }

    /*@PostMapping(value = "/addItem")
    public Item add(@RequestBody final Item item){
        foodRepository.save(item);
        return item;
    }*/

    @Transactional
    @PostMapping(value = "/delete/{itemName}")
    public List<Item> deleteItem(@PathVariable("itemName") final String name){
        foodRepository.deleteByName(name);
        return foodRepository.findAll();
    }

    @PostMapping(value = "/modifyCatalog")
    public List<Item> modifyItem(@RequestBody final Item item){
        Item modify = foodRepository.findById(item.getId()).get();

        modify.setName(item.getName());
        modify.setCategory(item.getCategory());
        modify.setLabel(item.getLabel());
        modify.setPrice(item.getPrice());
        modify.setImage(item.getImage());

        foodRepository.save(modify);
        return foodRepository.findAll();
    }

    //find by category
    @GetMapping(value = "/findBy/{name}")
    public  List<Item> findCategory(@PathVariable("name") final String category){
        return foodRepository.findByCategory(category);
    }

}
