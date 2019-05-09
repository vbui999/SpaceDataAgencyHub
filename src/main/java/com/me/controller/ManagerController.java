/*
*@author toanb
*@date 16 kwi 2019
**/

/*
 * Show the services for Manager: add/edit/remove products, ad/remove missions.
 */
package com.me.controller;

import java.util.List;
import java.util.Map;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.me.model.Mission;
import com.me.model.Product;
import com.me.repository.MissionRepository;
import com.me.repository.ProductRepository;

@RestController
public class ManagerController {

	@Autowired
	MissionRepository missionRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	/*
	 * MISSION MANAGEMENT
	 */
    @GetMapping("/manager/mission")
    public List<Mission> indexMission(){
        return (List<Mission>) missionRepository.findAll();
    }
    
    //add new mission
    @PostMapping("/manager/mission")
    public Mission addMission(@RequestBody Map<String, String> body){
        int missionId = Integer.parseInt(body.get("missionId")); //optional
        String missionName = body.get("missionName");
        String imageType = body.get("imageType");
        Timestamp startDate = Timestamp.valueOf(body.get("startDate"));
        Timestamp finishDate = Timestamp.valueOf(body.get("finishDate"));
        return missionRepository.save(new Mission(missionId, missionName, imageType, startDate, finishDate));
    }
    
    //edit mission
    @PutMapping("/manager/mission/{id}")
    public Mission editMission(@PathVariable String id, @RequestBody Map<String, String> body){
        int missionId = Integer.parseInt(id);
        // getting mission
        Mission mission = missionRepository.findOne(missionId);
        mission.setMissionName(body.get("missionName"));
        mission.setImageType(body.get("imageType"));
        mission.setStartDate(Timestamp.valueOf(body.get("startDate")));
        mission.setFinishDate(Timestamp.valueOf(body.get("finishDate")));
        return missionRepository.save(mission);
    }
    
    //remove mission
    @DeleteMapping("/manager/mission/{id}")
    public boolean deleteMission(@PathVariable String id){
        int missionId = Integer.parseInt(id);
        missionRepository.delete(missionId);
        return true;
    }
      
    /*
     * PRODUCT MANAGEMENT
     */  
    @GetMapping("/manager/product")
    public List<Product> indexProduct(){
        return (List<Product>) productRepository.findAll();
    }
    
    //add new product
    @PostMapping("/manager/product")
    public Product addProduct(@RequestBody Map<String, String> body){
        int productId = Integer.parseInt(body.get("productId")); //optional
        String missionName = body.get("missionName");
        Timestamp takenDate = Timestamp.valueOf(body.get("takenDate"));
        int footprint = Integer.parseInt(body.get("footprint"));
        float price = Float.parseFloat(body.get("price"));
        String url = body.get("url");
        Product product = new Product(productId, missionName, takenDate, footprint, price, url);
        productRepository.save(product);
        return product;
    }
	
    //remove product
    @DeleteMapping("/manager/product/{id}")
    public boolean deleteProduct(@PathVariable String id){
        int productId = Integer.parseInt(id);
        productRepository.delete(productId);
        return true;
    }
}

